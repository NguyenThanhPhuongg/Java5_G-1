package org.example.demobuoi1.controllers;

import jakarta.validation.Valid;
import org.example.demobuoi1.entity.MauSac;
import org.example.demobuoi1.entity.NhanVien;
import org.example.demobuoi1.repositories.asm1.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepository nvRepo;
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping("index")
    public String listNhanVien(Model model, @RequestParam(value = "page", defaultValue = "0")int page) {
        int pageSize = 2;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<NhanVien> colorPage = nvRepo.findAllPage(pageable);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", colorPage.getTotalPages());
        model.addAttribute("totalItems", colorPage.getTotalElements());
        model.addAttribute("listNhanVien", colorPage.getContent());
        return "nhan_vien/index";
    }
    @GetMapping("create")
    public String create(@ModelAttribute("data") NhanVien nhanVien){
        return "nhan_vien/create";
    }
    @PostMapping("store")
    public String store(Model model, @Valid NhanVien nhanVien, BindingResult validate){
        if(nhanVienRepository.exitByMa(nhanVien.getMaNV())){
            validate.rejectValue("ma" , "ma" , "Da Ton Tai Ma Nay");
        }
        if(validate.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", nhanVien);
            model.addAttribute("errors", errors);
            return "nhan_vien/create";
        }
        nvRepo.add(nhanVien);
        return "redirect:/nhan-vien/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        nvRepo.deleteById(id);
        return "redirect:/nhan-vien/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model, @ModelAttribute("data") NhanVien nv){
        NhanVien nhanVien = nvRepo.findById(id);
        model.addAttribute("data", nhanVien);
        return "nhan_vien/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model, @Valid NhanVien nhanVien, BindingResult validate){
        if(validate.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", nhanVien);
            model.addAttribute("errors", errors);
            return "nhan_vien/create";
        }
        nvRepo.update(nhanVien);
        return "redirect:/nhan-vien/index";
    }
    @PostMapping("/tim-kiem")
    public String timKiem(Model model, @RequestParam(required = false) String valueSearch, @RequestParam(required = false) Integer searchStatus) {
        List<NhanVien> list= nvRepo.findByAll(valueSearch, searchStatus);
        model.addAttribute("listNhanVien", list);
        model.addAttribute("searchStatus", searchStatus);
        model.addAttribute("valueSearch", valueSearch);
        return "nhan_vien/index";

    }
}
