package Dao.entity;

import java.util.Date;

/**
 *
 * @author ooOoo
 */
public class HoaDon {
    private int id;
    private int idKhachHang;
    private String idNguoiDungLap;
    private int idDatPhong;
    private java.util.Date ngayLap = new java.util.Date();
    private double tongTien;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(int id, int idKhachHang, String idNguoiDungLap, int idDatPhong, double tongTien, String trangThai) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNguoiDungLap = idNguoiDungLap;
        this.idDatPhong = idDatPhong;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getIdNguoiDungLap() {
        return idNguoiDungLap;
    }

    public void setIdNguoiDungLap(String idNguoiDungLap) {
        this.idNguoiDungLap = idNguoiDungLap;
    }

    public int getIdDatPhong() {
        return idDatPhong;
    }

    public void setIdDatPhong(int idDatPhong) {
        this.idDatPhong = idDatPhong;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

         public static final String DATE_PATTERN = "HH:mm:ss dd-MM-yyyy";
    
 
}