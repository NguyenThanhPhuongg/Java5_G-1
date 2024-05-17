package org.example.demobuoi1.entity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SanPham {
    private Integer id;
    @NotBlank(message = "Ma khong duoc de trong")
    private String ma;

    @NotBlank(message = "ten khong duoc de trong")
    private String ten;

    @NotNull(message = "trang thai khong duoc de trong")
    @Digits(integer = 1, fraction = 0)
    private int trangThai;

}
