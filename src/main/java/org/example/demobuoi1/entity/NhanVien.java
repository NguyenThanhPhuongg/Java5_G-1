package org.example.demobuoi1.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhanVien {
    private Integer id;
    @NotBlank(message = "ten khong duoc de trong")
    private String ten;
    @NotBlank(message = "ma khong duoc de trong")
    private String maNV;
    @NotBlank(message = "ten dang nhap khong duoc de trong")
    private String tenDangNhap;
    @NotBlank(message = "mat khau khong duoc de trong")
    @Size(min = 5 , max = 8 , message = "mat khau phai lon hon 5 va nho hon 8 ki tu")
    private String matKhau;
    private int trangThai;
}
