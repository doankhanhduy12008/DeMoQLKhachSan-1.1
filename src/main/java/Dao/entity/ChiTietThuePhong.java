package Dao.entity;

import java.util.Date;

/**
 *
 * @author ooOoo
 */
public class ChiTietThuePhong {
    private int idHoaDon;
    private int idPhong;
    private Date thoiGianNhanPhong;
    private Date thoiGianTraPhong;

    public ChiTietThuePhong() {
    }

    public ChiTietThuePhong(int idHoaDon, int idPhong, Date thoiGianNhanPhong, Date thoiGianTraPhong) {
        this.idHoaDon = idHoaDon;
        this.idPhong = idPhong;
        this.thoiGianNhanPhong = thoiGianNhanPhong;
        this.thoiGianTraPhong = thoiGianTraPhong;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public Date getThoiGianNhanPhong() {
        return thoiGianNhanPhong;
    }

    public void setThoiGianNhanPhong(Date thoiGianNhanPhong) {
        this.thoiGianNhanPhong = thoiGianNhanPhong;
    }

    public Date getThoiGianTraPhong() {
        return thoiGianTraPhong;
    }

    public void setThoiGianTraPhong(Date thoiGianTraPhong) {
        this.thoiGianTraPhong = thoiGianTraPhong;
    }
}