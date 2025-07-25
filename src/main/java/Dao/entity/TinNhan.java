package Dao.entity;

import java.util.Date;

public class TinNhan {
    private int id;
    private String nguoiGuiUsername;
    private String noiDungTinNhan;
    private Date thoiGianGui;

    // Constructor mặc định
    public TinNhan() {
    }

    // Constructor với tất cả các trường
    public TinNhan(int id, String nguoiGuiUsername, String noiDungTinNhan, Date thoiGianGui) {
        this.id = id;
        this.nguoiGuiUsername = nguoiGuiUsername;
        this.noiDungTinNhan = noiDungTinNhan;
        this.thoiGianGui = thoiGianGui;
    }

    // Constructor không có ID (thường dùng khi thêm mới tin nhắn)
    public TinNhan(String nguoiGuiUsername, String noiDungTinNhan, Date thoiGianGui) {
        this.nguoiGuiUsername = nguoiGuiUsername;
        this.noiDungTinNhan = noiDungTinNhan;
        this.thoiGianGui = thoiGianGui;
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNguoiGuiUsername() {
        return nguoiGuiUsername;
    }

    public void setNguoiGuiUsername(String nguoiGuiUsername) {
        this.nguoiGuiUsername = nguoiGuiUsername;
    }

    public String getNoiDungTinNhan() {
        return noiDungTinNhan;
    }

    public void setNoiDungTinNhan(String noiDungTinNhan) {
        this.noiDungTinNhan = noiDungTinNhan;
    }

    public Date getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(Date thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    @Override
    public String toString() {
        return "TinNhan{" +
               "id=" + id +
               ", nguoiGuiUsername='" + nguoiGuiUsername + '\'' +
               ", noiDungTinNhan='" + noiDungTinNhan + '\'' +
               ", thoiGianGui=" + thoiGianGui +
               '}';
    }
}