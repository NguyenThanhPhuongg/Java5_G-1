package org.example.demobuoi1.repositories.asm1;

import org.example.demobuoi1.entity.MauSac;
import org.example.demobuoi1.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NhanVienRepository {
    List<NhanVien> list;
    public NhanVienRepository() {
        list = new ArrayList<>();
        list.add(new NhanVien(1, "Nguyễn Văn A","NV01","A","12345",1));
        list.add(new NhanVien(2, "Nguyễn Văn B","NV02","B","12345",0));
        list.add(new NhanVien(3, "Nguyễn Văn C","NV03","C","12345",1));
    }
    public List<NhanVien> findAll() {
        return list;
    }
    public Page<NhanVien> findAllPage(Pageable pageable){
        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();
        int startIndex = pageNumber * pageSize;
        int endIndex = Math.min(startIndex + pageSize, list.size());
        List<NhanVien> pageContent = list.subList(startIndex, endIndex);
        return new PageImpl<>(pageContent, pageable, list.size());
    }
    public void add(NhanVien nhanVien){
        nhanVien.setId(list.size()+1);
        list.add(nhanVien);
    }
    public void deleteById(int id){
        for (int i = 0; i < list.size(); i++) {
            NhanVien nhanVien = list.get(i);
            if (nhanVien.getId() == id) {
                list.remove(i);
                break;
            }
        }
    }
    public NhanVien findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            NhanVien nhanVien = list.get(i);
            if (nhanVien.getId() == id) {
                return nhanVien;
            }
        }
        return null;
    }
    public void update(NhanVien nhanVien) {
        for (int i = 0; i < list.size(); i++) {
            NhanVien nv = list.get(i);
            if (nv.getId() == nhanVien.getId()) {
                list.set(i, nhanVien);
                break;
            }
        }
    }
    public NhanVien findByUsername(String username) {
        for (int i = 0; i < list.size(); i++) {
            NhanVien nhanVien = list.get(i);
            if (nhanVien.getTenDangNhap().equals(username)) {
                return nhanVien;
            }
        }
        return null;
    }
}
