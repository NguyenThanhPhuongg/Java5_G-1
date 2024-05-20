package org.example.demobuoi1.controllers;

import org.example.demobuoi1.entity.KichThuoc;
import org.example.demobuoi1.entity.MauSac;
import org.example.demobuoi1.entity.SanPham;
import org.example.demobuoi1.entity.SanPhamChiTiet;
import org.example.demobuoi1.repositories.asm1.KichThuocRepository;
import org.example.demobuoi1.repositories.asm1.MauSacRepository;
import org.example.demobuoi1.repositories.asm1.SanPhamChiTietRepository;
import org.example.demobuoi1.repositories.asm1.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("san-pham-chi-tiet")
public class SanPhamChiTietController {
    @Autowired
    private SanPhamRepository spRepo;
    @Autowired
    private SanPhamChiTietRepository spctRepo;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private KichThuocRepository kichThuocRepository;

    @GetMapping("index")
    public String listSanPham(Model model, @RequestParam(value = "idSP", required = false)Integer idSP) {
        if (idSP != null) {
            List<SanPham> listSP = spRepo.findAll();
            List<SanPhamChiTiet> listSPCT = (idSP != null) ? spctRepo.findByIdSP(idSP) : spctRepo.findAll();
            List<MauSac> listMau = mauSacRepository.findAll();
            List<KichThuoc> listKichThuoc = kichThuocRepository.findAll();

            Map<Integer, String> productNames = listSP.stream()
                    .collect(Collectors.toMap(SanPham::getId, SanPham::getTen));
            Map<Integer, String> colorNames = listMau.stream()
                    .collect(Collectors.toMap(MauSac::getId, MauSac::getTen));
            Map<Integer, String> sizeNames = listKichThuoc.stream()
                    .collect(Collectors.toMap(KichThuoc::getId, KichThuoc::getTen));

            model.addAttribute("productNames", productNames);
            model.addAttribute("colorNames", colorNames);
            model.addAttribute("sizeNames", sizeNames);
            model.addAttribute("listSanPham", listSP);
            model.addAttribute("listSanPhamChiTiet", listSPCT);
            model.addAttribute("idSP", idSP);

            return "san_pham_chi_tiet/index";
        }else {
            List<SanPham> listSP = spRepo.findAll();
            List<SanPhamChiTiet> listSPCT = spctRepo.findAll();
            List<MauSac> listMau = mauSacRepository.findAll();
            List<KichThuoc> listKichThuoc = kichThuocRepository.findAll();
            Map<Integer, String> productNames = listSP.stream().collect(Collectors.toMap(SanPham::getId, SanPham::getTen));
            Map<Integer, String> colorNames = listMau.stream().collect(Collectors.toMap(MauSac::getId, MauSac::getTen));
            Map<Integer, String> sizeNames = listKichThuoc.stream().collect(Collectors.toMap(KichThuoc::getId, KichThuoc::getTen));
            model.addAttribute("productNames", productNames);
            model.addAttribute("colorNames", colorNames);
            model.addAttribute("sizeNames", sizeNames);
            model.addAttribute("listSanPham", listSP);
            model.addAttribute("listSanPhamChiTiet", listSPCT);
            return "san_pham_chi_tiet/index";
        }

    }
    @GetMapping("create")
    public String create(Model model){
        List<KichThuoc> listKT = kichThuocRepository.findAll();
        List<MauSac> listMS = mauSacRepository.findAll();
        List<SanPham> listSP = spRepo.findAll();
        model.addAttribute("listKichThuoc", listKT);
        model.addAttribute("listMauSac", listMS);
        model.addAttribute("listSanPham", listSP);
        return "san_pham_chi_tiet/create";
    }
    @PostMapping("store")
    public String store(Model model, SanPhamChiTiet sanPhamChiTiet){
        List<KichThuoc> listKT = kichThuocRepository.findAll();
        List<MauSac> listMS = mauSacRepository.findAll();
        List<SanPham> listSP = spRepo.findAll();
        model.addAttribute("listKichThuoc", listKT);
        model.addAttribute("listMauSac", listMS);
        model.addAttribute("listSanPham", listSP);
        this.spctRepo.add(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.spctRepo.deleteById(id);
        return "redirect:/san-pham-chi-tiet/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        SanPhamChiTiet spct = this.spctRepo.findById(id);
        List<KichThuoc> listKT = kichThuocRepository.findAll();
        List<MauSac> listMS = mauSacRepository.findAll();
        List<SanPham> listSP = spRepo.findAll();
        model.addAttribute("listKichThuoc", listKT);
        model.addAttribute("listMauSac", listMS);
        model.addAttribute("listSanPham", listSP);
        model.addAttribute("data", spct);
        return "san_pham_chi_tiet/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model, SanPhamChiTiet sanPhamChiTiet){
        List<KichThuoc> listKT = kichThuocRepository.findAll();
        List<MauSac> listMS = mauSacRepository.findAll();
        List<SanPham> listSP = spRepo.findAll();
        model.addAttribute("listKichThuoc", listKT);
        model.addAttribute("listMauSac", listMS);
        model.addAttribute("listSanPham", listSP);
        this.spctRepo.update(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/index";
    }

}
