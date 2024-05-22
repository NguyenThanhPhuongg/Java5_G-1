package org.example.demobuoi1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HoaDonChiTiet {
    private Integer id;
    private Integer idHD;
    private Integer idSPCT;
    private Integer soLuong;
    private Double donGia;
    private Integer trangThai;
}
