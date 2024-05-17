package org.example.demobuoi1.controllers;

import org.example.demobuoi1.entity.KhachHang;
import org.example.demobuoi1.entity.SanPham;
import org.example.demobuoi1.repositories.asm1.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public String create(){
        return "khach_hang/create";
    }
    @PostMapping("store")
    public String store(KhachHang khachHang){
        khRepo.add(khachHang);
        return "redirect:/khach-hang/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        khRepo.deleteById(id);
        return "redirect:/khach-hang/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        KhachHang kh = khRepo.findById(id);
        model.addAttribute("data", kh);
        return "khach_hang/edit";
    }
    @PostMapping("update/{id}")
    public String update(KhachHang khachHang){
        khRepo.update(khachHang);
        return "redirect:/khach-hang/index";
    }
}
