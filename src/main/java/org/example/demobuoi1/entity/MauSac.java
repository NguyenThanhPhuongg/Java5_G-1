package org.example.demobuoi1.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class MauSac {
    private Integer id;
    @NotBlank(message = "ma khong duoc de trong")
    private String ma;
    @NotBlank(message = "ten khong duoc de trong")
    private String ten;
    private int trangThai;
}
