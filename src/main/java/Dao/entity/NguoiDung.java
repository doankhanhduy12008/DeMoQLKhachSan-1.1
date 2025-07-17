package Dao.entity;

/**
 * Lớp NguoiDung đại diện cho người dùng trong hệ thống.
 * Khóa chính là 'username'.
 * @author ooOoo
 */
public class NguoiDung {
    private String username;
    private String hoVaTen;
    private String matKhau;
    private String vaiTro;
    private String sdt;
    private String anh;
    private boolean trangThai; // Thêm trạng thái

    // Constructor mặc định
    public NguoiDung() {
    }

    // Constructor đầy đủ tham số
    public NguoiDung(String username, String hoVaTen, String matKhau, String vaiTro, String sdt, String anh, boolean trangThai) {
        this.username = username;
        this.hoVaTen = hoVaTen;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.sdt = sdt;
        this.anh = anh;
        this.trangThai = trangThai;
    }

    // Constructor private để sử dụng với Builder
    private NguoiDung(Builder builder) {
        this.username = builder.username;
        this.hoVaTen = builder.hoVaTen;
        this.matKhau = builder.matKhau;
        this.vaiTro = builder.vaiTro;
        this.sdt = builder.sdt;
        this.anh = builder.anh;
        this.trangThai = builder.trangThai;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public String getSdt() {
        return sdt;
    }

    public String getAnh() {
        return anh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    /**
     * Lớp Builder lồng tĩnh để xây dựng đối tượng NguoiDung.
     */
    public static class Builder {
        private String username;
        private String hoVaTen;
        private String matKhau;
        private String vaiTro;
        private String sdt;
        private String anh;
        private boolean trangThai;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder hoVaTen(String hoVaTen) {
            this.hoVaTen = hoVaTen;
            return this;
        }

        public Builder matKhau(String matKhau) {
            this.matKhau = matKhau;
            return this;
        }

        public Builder vaiTro(String vaiTro) {
            this.vaiTro = vaiTro;
            return this;
        }

        public Builder sdt(String sdt) {
            this.sdt = sdt;
            return this;
        }

        public Builder anh(String anh) {
            this.anh = anh;
            return this;
        }

        public Builder trangThai(boolean trangThai) {
            this.trangThai = trangThai;
            return this;
        }

        /**
         * Phương thức build để tạo đối tượng NguoiDung cuối cùng
         */
        public NguoiDung build() {
            return new NguoiDung(this);
        }
    }
}
