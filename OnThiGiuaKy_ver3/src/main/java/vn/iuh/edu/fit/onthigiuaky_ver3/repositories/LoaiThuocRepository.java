package vn.iuh.edu.fit.onthigiuaky_ver3.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.iuh.edu.fit.onthigiuaky_ver3.models.LoaiThuoc;
import vn.iuh.edu.fit.onthigiuaky_ver3.services.LoaiThuocService;

import java.util.List;

public class LoaiThuocRepository implements LoaiThuocService {
    private EntityManager em;
    public LoaiThuocRepository() {
        em = Persistence.createEntityManagerFactory("HuyNguyen").createEntityManager();
    }

    @Override
    public List<LoaiThuoc> getAllLoaiThuoc() {
        String query = "SELECT l FROM LoaiThuoc l";
        return em.createQuery(query, LoaiThuoc.class).getResultList();
    }

    @Override
    public Boolean themLoaiThuoc(LoaiThuoc loaiThuoc) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(loaiThuoc);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
