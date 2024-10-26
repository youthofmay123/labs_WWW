package vn.iuh.edu.fit.onthigiuaky_ver2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class LoaiThuocRepository {
    private EntityManager em;
    public LoaiThuocRepository() {
        em = Persistence.createEntityManagerFactory("HuyNguyen").createEntityManager();
    }

    public static void main(String[] args) {
        LoaiThuocRepository loaiThuocRepository = new LoaiThuocRepository();
    }
}
