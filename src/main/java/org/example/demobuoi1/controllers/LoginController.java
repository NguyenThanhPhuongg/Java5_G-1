package org.example.demobuoi1.controllers;

import jakarta.servlet.http.HttpSession;
import org.example.demobuoi1.dto.NhanVienRequest;
import org.example.demobuoi1.entity.NhanVien;
import org.example.demobuoi1.repositories.asm1.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class LoginController {
    @Autowired
    private NhanVienRepository nvRepo;
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/loginAction")
    public String login(NhanVienRequest nhanVienRequest, Model model , HttpSession session ) {
        NhanVien nhanVien = nvRepo.findByUsername(nhanVienRequest.getUsername());
        if(nhanVien != null){
            if(nhanVien.getMatKhau().equals(nhanVienRequest.getPassword())){
                session.setAttribute("userName" , nhanVien.getTen());
                model.addAttribute("message" , "Login successful");

                return "redirect:/trang-chu";
            }
        }
        model.addAttribute("message", "Login failed");
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userName");
        return "redirect:/login";
    }

}
