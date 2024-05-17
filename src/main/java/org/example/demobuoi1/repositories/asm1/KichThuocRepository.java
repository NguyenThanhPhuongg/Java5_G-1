package org.example.demobuoi1.repositories.asm1;

import org.example.demobuoi1.entity.KichThuoc;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KichThuocRepository {
    List<KichThuoc> list;
    public KichThuocRepository() {
        list = new ArrayList<>();
        list.add(new KichThuoc(1, "KT001","M",0));
        list.add(new KichThuoc(2, "KT002","S",1));
        list.add(new KichThuoc(3, "KT003","XS",1));
        list.add(new KichThuoc(4, "KT004","S",1));
    }
    public List<KichThuoc> findAll() {
        return list;
    }
    public void add(KichThuoc kichThuoc){
        kichThuoc.setId(this.list.size()+1);
        this.list.add(kichThuoc);
    }
    public void deleteById(int id){
        for (int i = 0; i < this.list.size(); i++) {
            KichThuoc kichThuoc = this.list.get(i);
            if (kichThuoc.getId() == id) {
                this.list.remove(i);
                break;
            }
        }
    }
    public KichThuoc findById(int id) {
        for (int i = 0; i < this.list.size(); i++) {
            KichThuoc kichThuoc = this.list.get(i);
            if (kichThuoc.getId() == id) {
                return kichThuoc;
            }
        }
        return null;
    }
    public void update(KichThuoc kichThuoc) {
        for (int i = 0; i < this.list.size(); i++) {
            KichThuoc kt = this.list.get(i);
            if (kt.getId() == kichThuoc.getId()) {
                this.list.set(i, kichThuoc);
                break;
            }
        }
    }

}
