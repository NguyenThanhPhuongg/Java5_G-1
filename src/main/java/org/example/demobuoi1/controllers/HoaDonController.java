package org.example.demobuoi1.controllers;

import lombok.RequiredArgsConstructor;
import org.example.demobuoi1.entity.HoaDon;
import org.example.demobuoi1.entity.KhachHang;
import org.example.demobuoi1.entity.NhanVien;
import org.example.demobuoi1.repositories.asm1.HoaDonRepository;
import org.example.demobuoi1.repositories.asm1.KhachHangRepository;
import org.example.demobuoi1.repositories.asm1.NhanVienRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hoa-don")
public class HoaDonController {
    private final HoaDonRepository hoaDonRepository;
    private final NhanVienRepository nhanVienRepository;
    private final KhachHangRepository khachHangRepository;
    @RequestMapping("/index")
    public String index(Model model) {
        List<HoaDon> listHoaDon = hoaDonRepository.findAll();
        List<NhanVien> listNhanVien = nhanVienRepository.findAll();
        List<KhachHang> listKhachHang = khachHangRepository.findAll();
        Map<Integer, String> tenNhanVien = listNhanVien.stream().collect(Collectors.toMap(NhanVien::getId, NhanVien::getTen));
        Map<Integer, String> tenKhachHang = listKhachHang.stream().collect(Collectors.toMap(KhachHang::getId, KhachHang::getTen));
        model.addAttribute("tenNhanVien", tenNhanVien);
        model.addAttribute("tenKhachHang", tenKhachHang);
        model.addAttribute("listHoaDon",listHoaDon);
        return "hoa_don/index";
    }
}
