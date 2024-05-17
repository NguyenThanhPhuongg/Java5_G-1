package org.example.demobuoi1.controllers;

import org.example.demobuoi1.entity.SanPham;
import org.example.demobuoi1.entity.SanPhamChiTiet;
import org.example.demobuoi1.repositories.asm1.SanPhamChiTietRepository;
import org.example.demobuoi1.repositories.asm1.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("san-pham-chi-tiet")
public class SanPhamChiTietController {
    @Autowired
    private SanPhamRepository spRepo;
    @Autowired
    private SanPhamChiTietRepository spctRepo;

    @GetMapping("index")
    public String listSanPham(Model model, @RequestParam(value = "idSP", required = false) Integer idSP) {
        if (idSP != null) {
            List<SanPham> listSP = spRepo.findAll();
            List<SanPhamChiTiet> listSPCT = spctRepo.findByIdSP(idSP);
            model.addAttribute("listSanPham", listSP);
            model.addAttribute("listSanPhamChiTiet", listSPCT);
        }else {
            List<SanPham> listSP = spRepo.findAll();
            List<SanPhamChiTiet> listSPCT = spctRepo.findAll();
            model.addAttribute("listSanPham", listSP);
            model.addAttribute("listSanPhamChiTiet", listSPCT);
            return "san_pham_chi_tiet/index";
        }
        return "san_pham_chi_tiet/index";
    }


}
