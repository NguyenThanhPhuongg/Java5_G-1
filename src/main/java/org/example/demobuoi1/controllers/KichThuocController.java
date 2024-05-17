package org.example.demobuoi1.controllers;

import org.example.demobuoi1.entity.KichThuoc;
import org.example.demobuoi1.repositories.asm1.KichThuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("kich-thuoc")
public class KichThuocController {
    @Autowired
    private KichThuocRepository ktRepo;
    @GetMapping("index")
    public String listKichThuoc(Model model) {
        List<KichThuoc> list = ktRepo.findAll();
        model.addAttribute("listKichThuoc", list);
        return "kich_thuoc/index";
    }
    @GetMapping("create")
    public String create(){
        return "kich_thuoc/create";
    }
    @PostMapping("store")
    public String store(KichThuoc kichThuoc){
        this.ktRepo.add(kichThuoc);
        return "redirect:/kich-thuoc/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.ktRepo.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        KichThuoc kt = this.ktRepo.findById(id);
        model.addAttribute("data", kt);
        return "kich_thuoc/edit";
    }
    @PostMapping("update/{id}")
    public String update(KichThuoc kichThuoc){
        ktRepo.update(kichThuoc);
        return "redirect:/kich-thuoc/index";
    }
}
