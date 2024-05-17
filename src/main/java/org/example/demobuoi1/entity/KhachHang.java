package org.example.demobuoi1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KhachHang {
    private Integer id;
    private String ten;
    private String sdt;
    private String maKH;
    private int trangThai;
}
