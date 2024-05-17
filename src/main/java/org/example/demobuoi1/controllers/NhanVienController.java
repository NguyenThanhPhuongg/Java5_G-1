package org.example.demobuoi1.controllers;

import org.example.demobuoi1.entity.NhanVien;
import org.example.demobuoi1.repositories.asm1.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepository nvRepo;
    @GetMapping("index")
    public String listNhanVien(Model model) {
        List<NhanVien> list = nvRepo.findAll();
        model.addAttribute("listNhanVien", list);
        return "nhan_vien/index";
    }
    @GetMapping("create")
    public String create(){
        return "nhan_vien/create";
    }
    @PostMapping("store")
    public String store(NhanVien nhanVien){
        nvRepo.add(nhanVien);
        return "redirect:/nhan-vien/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        nvRepo.deleteById(id);
        return "redirect:/nhan-vien/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        NhanVien nhanVien = nvRepo.findById(id);
        model.addAttribute("data", nhanVien);
        return "nhan_vien/edit";
    }
    @PostMapping("update/{id}")
    public String update(NhanVien nhanVien){
        nvRepo.update(nhanVien);
        return "redirect:/nhan-vien/index";
    }
}
