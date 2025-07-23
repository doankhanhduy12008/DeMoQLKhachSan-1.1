package Dao.entity;

import java.util.Date;

/**
 *
 * @author ooOoo
 */
public class ChiTietDichVu {
    private int idHoaDon;
    private int idDichVu;
    private String idNguoiDungThem;
    private int soLuong;
    private double tongTien;
    private Date thoiGian;

    public ChiTietDichVu() {
    }

    public ChiTietDichVu(int idHoaDon, int idDichVu, String idNguoiDungThem, int soLuong, double tongTien, Date thoiGian) {
        this.idHoaDon = idHoaDon;
        this.idDichVu = idDichVu;
        this.idNguoiDungThem = idNguoiDungThem;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.thoiGian = thoiGian;
    }

    
    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(int idDichVu) {
        this.idDichVu = idDichVu;
    }

    public String getIdNguoiDungThem() {
        return idNguoiDungThem;
    }

    public void setIdNguoiDungThem(String idNguoiDungThem) {
        this.idNguoiDungThem = idNguoiDungThem;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    
}