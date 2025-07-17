package Dao.entity;

/**
 *
 * @author ooOoo
 */
public class KhachHang {
    private int id;
    private String hoTen;
    private String sdt;
    private String cmt;

    public KhachHang() {
    }

    public KhachHang(int id, String hoTen, String sdt, String cmt) {
        this.id = id;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.cmt = cmt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }
}