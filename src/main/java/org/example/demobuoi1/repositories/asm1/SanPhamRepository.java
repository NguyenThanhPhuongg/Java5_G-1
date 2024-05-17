package org.example.demobuoi1.repositories.asm1;

import org.example.demobuoi1.entity.SanPham;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Repository
public class SanPhamRepository {
    private List<SanPham> list;
    public SanPhamRepository() {
        this.list = new ArrayList<>();
        list.add(new SanPham(1,"SP001", "Chân váy tenis", 1));
        list.add(new SanPham(2,"SP002", "Váy baby doll", 0));
        list.add(new SanPham(3,"SP003", "Váy hai dây", 1));
        list.add(new SanPham(4,"SP004", "Quần jeans", 0));

    }
    public List<SanPham> findAll() {
        return list;
    }
    public void add(SanPham sanPham){
        sanPham.setId( this.list.size() + 1 );
        this.list.add(sanPham);
    }
    public void deleteById(int id){
        for (int i = 0; i < this.list.size(); i++) {
            SanPham sanPham = this.list.get(i);
            if (sanPham.getId() == id) {
                this.list.remove(i);
                break;
            }
        }
    }

    public SanPham findById(int id) {
        for (int i = 0; i < this.list.size(); i++) {
            SanPham sanPham = this.list.get(i);
            if (sanPham.getId() == id) {
                return sanPham;
            }
        }
        return null;
    }
    public void update(SanPham sanPham) {
        for (int i = 0; i < this.list.size(); i++) {
            SanPham sp = this.list.get(i);
            if (Objects.equals(sp.getId(), sanPham.getId())) {
                this.list.set(i, sanPham);
                break;
            }
        }
    }
}
