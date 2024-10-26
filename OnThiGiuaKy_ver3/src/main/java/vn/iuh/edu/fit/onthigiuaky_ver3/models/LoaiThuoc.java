package vn.iuh.edu.fit.onthigiuaky_ver3.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "LoaiThuoc")
public class LoaiThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLoai;
    private String tenLoai;

    @OneToMany(mappedBy = "loaiThuoc", fetch = FetchType.LAZY)
    private Set<Thuoc> thuoc;

    public LoaiThuoc(String tenLoai, int maLoai) {
        this.tenLoai = tenLoai;
        this.maLoai = maLoai;
    }

    public LoaiThuoc(int maLoai) {
        this.maLoai = maLoai;
    }

    public LoaiThuoc() {

    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public Set<Thuoc> getThuoc() {
        return thuoc;
    }

    public void setThuoc(Set<Thuoc> thuoc) {
        this.thuoc = thuoc;
    }

    @Override
    public String toString() {
        return "LoaiThuoc{" +
                "maLoai=" + maLoai +
                ", tenLoai='" + tenLoai ;
    }
}
