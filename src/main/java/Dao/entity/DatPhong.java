package Dao.entity;

import java.util.Date;

/**
 *
 * @author ooOoo
 */
public class DatPhong {
    private int id;
    private int idKhachHang;
    private int idNguoiDung;
    private Date ngayDat;
    private Date ngayNhanPhongDuKien;
    private Date ngayTraPhongDuKien;
    private String trangThai;
    private String ghiChu;

    public DatPhong() {
    }

    public DatPhong(int id, int idKhachHang, int idNguoiDung, Date ngayDat, Date ngayNhanPhongDuKien, Date ngayTraPhongDuKien, String trangThai, String ghiChu) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNguoiDung = idNguoiDung;
        this.ngayDat = ngayDat;
        this.ngayNhanPhongDuKien = ngayNhanPhongDuKien;
        this.ngayTraPhongDuKien = ngayTraPhongDuKien;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
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

    public int getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(int idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getNgayNhanPhongDuKien() {
        return ngayNhanPhongDuKien;
    }

    public void setNgayNhanPhongDuKien(Date ngayNhanPhongDuKien) {
        this.ngayNhanPhongDuKien = ngayNhanPhongDuKien;
    }

    public Date getNgayTraPhongDuKien() {
        return ngayTraPhongDuKien;
    }

    public void setNgayTraPhongDuKien(Date ngayTraPhongDuKien) {
        this.ngayTraPhongDuKien = ngayTraPhongDuKien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}