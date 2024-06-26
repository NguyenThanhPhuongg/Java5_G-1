package org.example.demobuoi1.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "ten khong duoc de trong")
    private String ten;
    @NotBlank(message = "sdt khong duoc de trong")
    @Size(min = 8 , max = 10 , message = "sdt khong duoc nho hon 8 va lon hon 10 ki tu")
    private String sdt;
    @NotBlank(message = "ma khach hang khong duoc de trong")
    private String maKH;
    private int trangThai;
}
