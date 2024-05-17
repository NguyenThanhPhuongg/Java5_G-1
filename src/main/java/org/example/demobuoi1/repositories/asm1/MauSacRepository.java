package org.example.demobuoi1.repositories.asm1;

import org.example.demobuoi1.entity.MauSac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MauSacRepository {
    List<MauSac> list;
    public MauSacRepository() {
        list = new ArrayList<MauSac>();
        list.add(new MauSac(1,"MS01","Hong",1));
        list.add(new MauSac(2,"MS02","Xanh",1));
        list.add(new MauSac(3,"MS03","Den",0));
    }
    public List<MauSac> findAll() {
        return list;
    }
    public void add(MauSac mauSac){
        mauSac.setId(list.size()+1);
        list.add(mauSac);
    }
    public void deleteById(int id){
        for (int i = 0; i < list.size(); i++) {
            MauSac mauSac = list.get(i);
            if (mauSac.getId() == id) {
                list.remove(i);
                break;
            }
        }
    }
    public MauSac findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            MauSac mauSac = list.get(i);
            if (mauSac.getId() == id) {
                return mauSac;
            }
        }
        return null;
    }
    public void update(MauSac mauSac) {
        for (int i = 0; i < list.size(); i++) {
            MauSac ms = list.get(i);
            if (ms.getId() == mauSac.getId()) {
                list.set(i, mauSac);
                break;
            }
        }
    }
}