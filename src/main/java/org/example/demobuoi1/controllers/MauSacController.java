package org.example.demobuoi1.controllers;

import jakarta.validation.Valid;
import org.example.demobuoi1.entity.MauSac;
import org.example.demobuoi1.repositories.asm1.MauSacRepository;
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
    public String create(@ModelAttribute("data") MauSac mauSac){
        return "mau_sac/create";
    }
    @PostMapping("store")
    public String store(Model model, @Valid  MauSac mauSac, BindingResult validate){
        if(validate.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", mauSac);
            model.addAttribute("errors", errors);
            return "mau_sac/create";
        }
        this.msRepo.add(mauSac);
        return "redirect:/mau-sac/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.msRepo.deleteById(id);
        return "redirect:/mau-sac/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model, @ModelAttribute("data") MauSac ms){
        MauSac mauSac = this.msRepo.findById(id);
        model.addAttribute("data",mauSac);
        return "mau_sac/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model, @Valid MauSac mauSac, BindingResult validate){
        if(validate.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", mauSac);
            model.addAttribute("errors", errors);
            return "mau_sac/update";
        }
        this.msRepo.update(mauSac);
        return "redirect:/mau-sac/index";
    }
}

