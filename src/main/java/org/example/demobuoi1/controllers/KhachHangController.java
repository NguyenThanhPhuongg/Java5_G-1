package org.example.demobuoi1.controllers;

import jakarta.validation.Valid;
import org.example.demobuoi1.entity.KhachHang;
import org.example.demobuoi1.entity.SanPham;
import org.example.demobuoi1.repositories.asm1.KhachHangRepository;
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
@RequestMapping("khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangRepository khRepo;
    @GetMapping("index")
    public String listKhachHang(Model model) {
        List<KhachHang> list = khRepo.findAll();
        model.addAttribute("listKhachHang", list);
        return "khach_hang/index";
    }
    @GetMapping("create")
    public String create(@ModelAttribute("data") KhachHang kh){
        return "khach_hang/create";
    }
    @PostMapping("store")
    public String store(Model model, @Valid KhachHang khachHang, BindingResult validate){
        if(validate.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", khachHang);
            model.addAttribute("errors", errors);
            return "khach_hang/create";
        }
        khRepo.add(khachHang);
        return "redirect:/khach-hang/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        khRepo.deleteById(id);
        return "redirect:/khach-hang/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model, @ModelAttribute("data") KhachHang khachHang){
        KhachHang kh = khRepo.findById(id);
        model.addAttribute("data", kh);
        return "khach_hang/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model, @Valid KhachHang khachHang,BindingResult validate){
        if(validate.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", khachHang);
            model.addAttribute("errors", errors);
            return "khach_hang/edit";
        }
        khRepo.update(khachHang);
        return "redirect:/khach-hang/index";
    }
}
