package org.example.demobuoi1.controllers;

import org.example.demobuoi1.entity.SanPham;
import org.example.demobuoi1.repositories.asm1.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String create() {
        return "san_pham/create";
    }
    @PostMapping("store")
    public String store(SanPham sanPham){
        this.spRepo.add(sanPham);
        return "redirect:/san-pham/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.spRepo.deleteById(id);
        return "redirect:/san-pham/index";
    }
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        SanPham sp = this.spRepo.findById(id);
        model.addAttribute("data", sp);
        return "san_pham/edit";
    }
    @PostMapping("update/{id}")
    public String update(SanPham sanPham){
        spRepo.update(sanPham);
        return "redirect:/san-pham/index";
    }
}
