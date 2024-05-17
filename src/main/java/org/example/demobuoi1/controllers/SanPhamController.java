package org.example.demobuoi1.controllers;

import jakarta.validation.Valid;
import org.example.demobuoi1.entity.SanPham;
import org.example.demobuoi1.repositories.asm1.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamRepository spRepo;
    @GetMapping("index")
    public String listSanPham(Model model) {
        List<SanPham> list = spRepo.findAll();
        model.addAttribute("listSanPham",list);
        return "san_pham/index";
    }

    @RequestMapping("create")
    public String create(@ModelAttribute("data") SanPham sp) {
        return "san_pham/create";
    }
    @PostMapping("store")
    public String store(Model model, @Valid SanPham sanPham, BindingResult validate) {
        //co loi tra ve true k co loi tra ve false
        if(validate.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError e : validate.getFieldErrors()){
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", sanPham);
            model.addAttribute("errors", errors);
            return "san_pham/create";
        }
        this.spRepo.add(sanPham);
        return "redirect:/san-pham/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.spRepo.deleteById(id);
        return "redirect:/san-pham/index";
    }
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model, @ModelAttribute("data") SanPham sp) {
        SanPham sanPham = this.spRepo.findById(id);
        model.addAttribute("data", sanPham);
        return "san_pham/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model, @Valid SanPham sanPham, BindingResult validate){
        if(validate.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError e : validate.getFieldErrors()){
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", sanPham);
            model.addAttribute("errors", errors);
            return "san_pham/edit";
        }
        spRepo.update(sanPham);
        return "redirect:/san-pham/index";
    }
}
