package Dao.entity;

import java.util.Date;

/**
 *
 * @author ooOoo
 */
public class HoaDon {
    private int id;
    private int idKhachHang;
    private int idNguoiDungLap;
    private int idDatPhong;
    private Date ngayLap;
    private double tongTien;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(int id, int idKhachHang, int idNguoiDungLap, int idDatPhong, Date ngayLap, double tongTien, String trangThai) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNguoiDungLap = idNguoiDungLap;
        this.idDatPhong = idDatPhong;
        this.ngayLap = ngayLap;
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

    public int getIdNguoiDungLap() {
        return idNguoiDungLap;
    }

    public void setIdNguoiDungLap(int idNguoiDungLap) {
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
}