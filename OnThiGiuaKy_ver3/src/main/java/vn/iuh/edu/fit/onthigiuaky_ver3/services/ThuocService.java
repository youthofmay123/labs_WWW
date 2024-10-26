package vn.iuh.edu.fit.onthigiuaky_ver3.services;

import vn.iuh.edu.fit.onthigiuaky_ver3.models.Thuoc;

import java.util.List;

public interface ThuocService {
    public List<Thuoc> getAllThuoc();
    public List<Thuoc> findThuocByLoaiThuoc(String loaiThuoc);
    public boolean addThuoc(Thuoc thuoc);
}
