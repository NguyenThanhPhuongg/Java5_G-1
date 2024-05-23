package org.example.demobuoi1.controllers;

import jakarta.validation.Valid;
import org.example.demobuoi1.entity.KichThuoc;
import org.example.demobuoi1.entity.MauSac;
import org.example.demobuoi1.repositories.asm1.KichThuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("kich-thuoc")
public class KichThuocController {
    @Autowired
    private KichThuocRepository ktRepo;
    @Autowired
    private KichThuocRepository kichThuocRepository;

    @GetMapping("index")
    public String listKichThuoc(Model model, @RequestParam(value = "page", defaultValue = "0")int page) {
        int pageSize = 2;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<KichThuoc> colorPage = ktRepo.findAllPage(pageable);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", colorPage.getTotalPages());
        model.addAttribute("totalItems", colorPage.getTotalElements());
        model.addAttribute("listKichThuoc", colorPage.getContent());
        return "kich_thuoc/index";
    }
    @GetMapping("create")
    public String create(@ModelAttribute("data") KichThuoc kichThuoc){
        return "kich_thuoc/create";
    }
    @PostMapping("store")
    public String store(Model model, @Valid KichThuoc kichThuoc, BindingResult validate){
        if(kichThuocRepository.exitByMa(kichThuoc.getMa())){
            validate.rejectValue("ma" , "ma" , "Da Ton Tai Ma Nay");
        }
        if(validate.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", kichThuoc);
            model.addAttribute("errors", errors);
            return "kich_thuoc/create";
        }
        this.ktRepo.add(kichThuoc);
        return "redirect:/kich-thuoc/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.ktRepo.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model, @ModelAttribute("data") KichThuoc kichThuoc) {
        KichThuoc kt = this.ktRepo.findById(id);
        model.addAttribute("data", kt);
        return "kich_thuoc/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model, @Valid KichThuoc kichThuoc, BindingResult validate){
        if(validate.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", kichThuoc);
            model.addAttribute("errors", errors);
            return "kich_thuoc/edit";
        }
        ktRepo.update(kichThuoc);
        return "redirect:/kich-thuoc/index";
    }
    @PostMapping("/tim-kiem")
    public String timKiem(Model model, @RequestParam(required = false) String valueSearch, @RequestParam(required = false) Integer searchStatus) {
        List<KichThuoc> list= ktRepo.findByAll(valueSearch, searchStatus);
        model.addAttribute("listKichThuoc", list);
        model.addAttribute("searchStatus", searchStatus);
        model.addAttribute("valueSearch", valueSearch);
        return "kich_thuoc/index";

    }
}
