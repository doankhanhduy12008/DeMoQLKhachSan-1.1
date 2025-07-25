package Dao.entity;

/**
 *
 * @author ooOoo
 */
public class DichVu {
    private int id;
    private String tenDichVu;
    private double donGia;
    private double giamGia;

    public DichVu() {
    }

    public DichVu(int id, String tenDichVu, double donGia, double giamGia) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }
    
        @Override
    public String toString() {
        return this.tenDichVu; // Hoặc bất kỳ trường nào bạn muốn hiển thị
    }

}