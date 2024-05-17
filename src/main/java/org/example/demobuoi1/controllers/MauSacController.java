package org.example.demobuoi1.controllers;

import org.example.demobuoi1.entity.MauSac;
import org.example.demobuoi1.repositories.asm1.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepository msRepo;
    @GetMapping("index")
    public String listMauSac(Model model){
        List<MauSac> list = msRepo.findAll();
        model.addAttribute("listMauSac",list);
        return "mau_sac/index";
    }
    @GetMapping("create")
    public String create(){
        return "mau_sac/create";
    }
    @PostMapping("store")
    public String store(MauSac mauSac){
        this.msRepo.add(mauSac);
        return "redirect:/mau-sac/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.msRepo.deleteById(id);
        return "redirect:/mau-sac/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        MauSac mauSac = this.msRepo.findById(id);
        model.addAttribute("data",mauSac);
        return "mau_sac/edit";
    }
    @PostMapping("update/{id}")
    public String update(MauSac mauSac){
        this.msRepo.update(mauSac);
        return "redirect:/mau-sac/index";
    }
}

