package org.example.demobuoi1.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class SanPhamChiTiet {
    private Integer id;
    private String maSPCT;
    private Integer idKT;
    private Integer idMS;
    private Integer idSP;
    private int soLuong;
    private double donGia;
    private int trangThai;
}
