package org.example.demobuoi1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class HoaDon {
    private Integer id;
    private Integer idNV;
    private Integer idKH;
    private Date ngayMuaHang;
    private Integer trangThai;
}
