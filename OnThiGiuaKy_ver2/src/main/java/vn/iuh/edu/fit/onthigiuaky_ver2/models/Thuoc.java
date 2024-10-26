package vn.iuh.edu.fit.onthigiuaky_ver2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Thuoc")
public class Thuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maThuoc;
    private String tenThuoc;
    @Column(nullable = false)
    private Double gia;
    @Column(nullable = false)
    private int namSX;

    @ManyToOne
    @JoinColumn(name = "maLoai")
    private LoaiThuoc loaiThuoc;

    public Thuoc(int maThuoc, String tenThuoc, Double gia, int namSX) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.namSX = namSX;
    }

    public Thuoc() {
    }

    public int getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(int maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public LoaiThuoc getLoaiThuoc() {
        return loaiThuoc;
    }

    public void setLoaiThuoc(LoaiThuoc loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }

    @Override
    public String toString() {
        return "Thuoc{" +
                "maThuoc=" + maThuoc +
                ", tenThuoc='" + tenThuoc + '\'' +
                ", gia=" + gia +
                ", namSX=" + namSX +
                ", loaiThuoc=" + loaiThuoc.getTenLoai() +
                '}';
    }
}
