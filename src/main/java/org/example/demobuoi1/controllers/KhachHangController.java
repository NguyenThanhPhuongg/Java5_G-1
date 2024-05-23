package org.example.demobuoi1.controllers;

import jakarta.validation.Valid;
import org.example.demobuoi1.entity.KhachHang;
import org.example.demobuoi1.entity.MauSac;
import org.example.demobuoi1.entity.SanPham;
import org.example.demobuoi1.repositories.asm1.KhachHangRepository;
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
@RequestMapping("khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangRepository khRepo;
    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping("index")
    public String listKhachHang(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        int pageSize = 2;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<KhachHang> customer = khRepo.findAllPage(pageable);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", customer.getTotalPages());
        model.addAttribute("totalItems", customer.getTotalElements());
        model.addAttribute("listKhachHang", customer.getContent());
        return "khach_hang/index";
    }
    @GetMapping("create")
    public String create(@ModelAttribute("data") KhachHang kh){
        return "khach_hang/create";
    }
    @PostMapping("store")
    public String store(Model model, @Valid KhachHang khachHang, BindingResult validate){
        if(khachHangRepository.exitByMa(khachHang.getMaKH())){
            validate.rejectValue("ma" , "ma" , "Da Ton Tai Ma Nay");
        }
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
    @PostMapping("/tim-kiem")
    public String timKiem(Model model, @RequestParam(required = false) String valueSearch, @RequestParam(required = false) Integer searchStatus) {
        List<KhachHang> list= khRepo.findByAll(valueSearch, searchStatus);
        model.addAttribute("listKhachHang", list);
        model.addAttribute("searchStatus", searchStatus);
        model.addAttribute("valueSearch", valueSearch);
        return "khach_hang/index";

    }
}
