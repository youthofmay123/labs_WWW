package vn.iuh.edu.fit.onthigiuaky_ver3.repositories;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;
import vn.iuh.edu.fit.onthigiuaky_ver3.models.Thuoc;
import vn.iuh.edu.fit.onthigiuaky_ver3.services.ThuocService;

import java.util.List;

public class ThuocRepository implements ThuocService {
    EntityManager em;
    public ThuocRepository() {
        em = Persistence.createEntityManagerFactory("HuyNguyen").createEntityManager();
    }

    @Override
    public List<Thuoc> getAllThuoc() {
        String query = "SELECT t FROM Thuoc t";
        return em.createQuery(query, Thuoc.class).getResultList();
    }

    @Override
    public List<Thuoc> findThuocByLoaiThuoc(String tenLoaiThuoc) {
        String query = "SELECT t FROM Thuoc t WHERE t.loaiThuoc.tenLoai = :tenLoaiThuoc";
        return em.createQuery(query, Thuoc.class).setParameter("tenLoaiThuoc",tenLoaiThuoc).getResultList();
    }

    @Override
    public boolean addThuoc(Thuoc thuoc) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(thuoc);
            tx.commit();
            return true;
        }catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // In ra stack trace chi tiết
            return false;
        }

    }

    public static void main(String[] args) {
        ThuocRepository repo = new ThuocRepository();
        repo.findThuocByLoaiThuoc("B").forEach(System.out::println);
    }
}
