package vn.iuh.edu.fit.onthigiuaky_ver3.services;

import vn.iuh.edu.fit.onthigiuaky_ver3.models.LoaiThuoc;

import java.util.List;

public interface LoaiThuocService {
    public List<LoaiThuoc> getAllLoaiThuoc();
    public Boolean themLoaiThuoc(LoaiThuoc loaiThuoc);
}
