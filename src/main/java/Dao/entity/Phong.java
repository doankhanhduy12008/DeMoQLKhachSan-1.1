package Dao.entity;

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
    private double giaTien;
    private double giamGia;
    private String ghiChu;

    public Phong() {
    }

    public Phong(int id, int idLoaiPhong, String soPhong, int tang, String trangThai, double giaTien, double giamGia, String ghiChu) {
        this.id = id;
        this.idLoaiPhong = idLoaiPhong;
        this.soPhong = soPhong;
        this.tang = tang;
        this.trangThai = trangThai;
        this.giaTien = giaTien;
        this.giamGia = giamGia;
        this.ghiChu = ghiChu;
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

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
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
}