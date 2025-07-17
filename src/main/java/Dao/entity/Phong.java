package Dao.entity;

import java.math.BigDecimal;

/**
 *
 * @author ooOoo
 */
public class Phong {
    private int id;
    private int idLoaiPhong;
    private String soPhong;
    private int tang;
    private String trangThai;
    private BigDecimal  giaTien;
    private double giamGia;
    private String ghiChu;

    public Phong() {
    }

    public Phong(int id, int idLoaiPhong, String soPhong, int tang, String trangThai, BigDecimal  giaTien, double giamGia, String ghiChu) {
        this.id = id;
        this.idLoaiPhong = idLoaiPhong;
        this.soPhong = soPhong;
        this.tang = tang;
        this.trangThai = trangThai;
        this.giaTien = giaTien;
        this.giamGia = giamGia;
        this.ghiChu = ghiChu;
    }
    
       private Phong(Builder builder) {
        this.id = builder.id;
        this.idLoaiPhong = builder.idLoaiPhong;
        this.soPhong = builder.soPhong;
        this.tang = builder.tang;
        this.trangThai = builder.trangThai;
        this.giaTien = builder.giaTien;
        this.giamGia = builder.giamGia;
        this.ghiChu = builder.ghiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLoaiPhong() {
        return idLoaiPhong;
    }

    public void setIdLoaiPhong(int idLoaiPhong) {
        this.idLoaiPhong = idLoaiPhong;
    }

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public BigDecimal  getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(BigDecimal  giaTien) {
        this.giaTien = giaTien;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    public static class Builder {
        // Các thuộc tính của Builder tương ứng với lớp Phong
        private int id;
        private int idLoaiPhong;
        private String soPhong;
        private int tang;
        private String trangThai;
        private BigDecimal  giaTien;
        private double giamGia;
        private String ghiChu;

        // Các phương thức "setter" cho builder, trả về chính builder (this)
        // để có thể gọi nối chuỗi (method chaining).
        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder idLoaiPhong(int idLoaiPhong) {
            this.idLoaiPhong = idLoaiPhong;
            return this;
        }

        public Builder soPhong(String soPhong) {
            this.soPhong = soPhong;
            return this;
        }

        public Builder tang(int tang) {
            this.tang = tang;
            return this;
        }

        public Builder trangThai(String trangThai) {
            this.trangThai = trangThai;
            return this;
        }

        public Builder giaTien(BigDecimal  giaTien) {
            this.giaTien = giaTien;
            return this;
        }

        public Builder giamGia(double giamGia) {
            this.giamGia = giamGia;
            return this;
        }

        public Builder ghiChu(String ghiChu) {
            this.ghiChu = ghiChu;
            return this;
        }

        /**
         * Phương thức build() để tạo ra đối tượng Phong cuối cùng từ các thông tin
         * đã được thiết lập trong Builder.
         * @return một thực thể mới của lớp Phong.
         */
        public Phong build() {
            return new Phong(this);
        }
    }
}