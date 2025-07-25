package GDCN.QuanLy;
import Dao.dao.ChiTietThuePhongDao;
import Dao.dao.HoaDonDao;
import Dao.dao.LoaiPhongDao;
import Dao.dao.NguoiDungDao;
import Dao.dao.PhongDao;
import Dao.daoimpl.ChiTietThuePhongDaoImpl;
import Dao.daoimpl.HoaDonDaoImpl;
import Dao.daoimpl.LoaiPhongDaoImpl;
import Dao.daoimpl.NguoiDungDaoImpl;
import Dao.daoimpl.PhongDaoImpl;
import Dao.entity.ChiTietThuePhong;
import Dao.entity.HoaDon;
import Dao.entity.LoaiPhong;
import Dao.entity.NguoiDung;
import Dao.entity.Phong;
import GDCN.TiepTan.TrangChu;
import Util.XAuth;
import Util.XDialog;
import Util.XIcon;
import Util.XStr;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class TrangChuQLJFarme extends javax.swing.JFrame implements TrangChuQLController{
    
    public TrangChuQLJFarme(){
//      setUndecorated(true); // Đặt dòng này lên đầu tiên
        initComponents();
        openFullScreen();
        open();
        pnlChat.setLayout(new java.awt.BorderLayout());
        pnlChat.add(new GDCN.Chat.ChatJPanel()); 
        pnlChat.revalidate();
        pnlChat.repaint();
    }
    
    
    

    int chieungang = 305;
    int chieudai = 712;
    
    private void openFullScreen() {
         // Bỏ viềds (tuỳ chọn)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocationRelativeTo(null); // Đặt giữa, thực ra không quan trọng
    }
    void OpenMenuBar(){
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                Open.setVisible(false);
                for (int i=0; i<chieungang; i++){
                    pnlMenuBar.setSize(i,chieudai);
                    try {
                        //mở từ từ
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    
    void CloseOpenBar(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Open.setVisible(true);
                for (int i=chieungang; i>0; i--){
                    pnlMenuBar.setSize(i,chieudai);
                    try {
                        //mở từ từ
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChonAnh = new javax.swing.JFileChooser();
        cboNVVaitro = new javax.swing.ButtonGroup();
        cboNVTrangThai = new javax.swing.ButtonGroup();
        cboPTrangThai = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Open = new javax.swing.JLabel();
        pnlMenuBar = new javax.swing.JPanel();
        bntDong = new javax.swing.JLabel();
        bntTrangChu = new javax.swing.JLabel();
        bntQLLoaiPhong = new javax.swing.JLabel();
        bntQLPhong = new javax.swing.JLabel();
        bntQLNhanVien = new javax.swing.JLabel();
        bntQLDoanhThu = new javax.swing.JLabel();
        bntQLDichVu = new javax.swing.JLabel();
        btnDoiMK = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JLabel();
        btnTroChuyen = new javax.swing.JLabel();
        NoiDung = new javax.swing.JPanel();
        pnlTrangChu = new javax.swing.JPanel();
        txtTenNV = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Anh = new javax.swing.JLabel();
        bntQLLoaiPhong1 = new javax.swing.JLabel();
        bntQLPhong1 = new javax.swing.JLabel();
        bntQLNhanVien1 = new javax.swing.JLabel();
        bntQLDoanhThu1 = new javax.swing.JLabel();
        bntQLDichVu1 = new javax.swing.JLabel();
        btnTroChuyen1 = new javax.swing.JLabel();
        pnlQLLoaiPhong = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLPID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        bntLPSua = new javax.swing.JButton();
        bntLPXoaPhongLP = new javax.swing.JButton();
        bntLPLamMoi = new javax.swing.JButton();
        bntLPTaoMoi = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtLPLoaiPhong = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtLPTimKiem = new javax.swing.JTextField();
        bntLPTimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiPhong = new javax.swing.JTable();
        bntLPXoaMucChon = new javax.swing.JButton();
        bntLPTimKiem1 = new javax.swing.JButton();
        pnlQLPhong = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPSoPhong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPGiaThue = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaPGhiChu = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtPTang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rdoPPhongTrong = new javax.swing.JRadioButton();
        rdoPPhongDuocThue = new javax.swing.JRadioButton();
        rdoPPhongDonDep = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        cmbPLoaiPhong = new javax.swing.JComboBox<>();
        bntPSua = new javax.swing.JButton();
        bntPXoaPhong = new javax.swing.JButton();
        bntPLamMoi = new javax.swing.JButton();
        bntPTaoMoi = new javax.swing.JButton();
        rdoPPhongSua1 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        txtPTimKiem = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        bntPTimKiem = new javax.swing.JButton();
        bntPXoaMucDaChon = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        pnlQLNhanVien = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        NVAnh = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNVTenDangNhap = new javax.swing.JTextField();
        txtNVMatKhau = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNVHoVaTen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtNVSDT = new javax.swing.JTextField();
        rdoNVQuanLy = new javax.swing.JRadioButton();
        rdoNVTiepTan = new javax.swing.JRadioButton();
        rdoNVDichVu = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        rdoNVHoatDong = new javax.swing.JRadioButton();
        rdoNVTamDung = new javax.swing.JRadioButton();
        bntNVTaoMoi = new javax.swing.JButton();
        bntNVLamMoi = new javax.swing.JButton();
        bntNVXoa = new javax.swing.JButton();
        bntNVSua = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        bntNVTimKiem = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        txtNVTimKiem = new javax.swing.JTextField();
        bntNVXoaMucChon = new javax.swing.JButton();
        pnlQLDoanhThu = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        tabPhong = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDTPhong = new javax.swing.JTable();
        txtDTPTimKiem = new javax.swing.JTextField();
        bntDTPTimKiem = new javax.swing.JButton();
        bntDTPDungTimKiem = new javax.swing.JButton();
        tabDoanhThu = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDTTiepTan = new javax.swing.JTable();
        txtDTTTTimKiem = new javax.swing.JTextField();
        bntDTTTTimKiem = new javax.swing.JButton();
        bntDTTTDungTimKiem = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtDTNgayBatDau = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtDTNgayKetThuc = new javax.swing.JTextField();
        bntDTLoc = new javax.swing.JButton();
        cmbDTLocNgay = new javax.swing.JComboBox<>();
        pnlQLDichVu = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtDVTen = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtDVGia = new javax.swing.JTextField();
        bntDVTaoMoi = new javax.swing.JButton();
        bntDVXoa = new javax.swing.JButton();
        bntDVLamMoi = new javax.swing.JButton();
        bntDVSua = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDV = new javax.swing.JTable();
        bntDVTimKiem = new javax.swing.JButton();
        txtDVTimKiem = new javax.swing.JTextField();
        bntDVXoaMucChon = new javax.swing.JButton();
        bntDVDungTK = new javax.swing.JButton();
        pnlChat = new javax.swing.JPanel();
        TieuDe = new javax.swing.JPanel();
        pnlTDTrangChu = new javax.swing.JPanel();
        txtTrangChu = new javax.swing.JLabel();
        pnlTTQLLoaiPhong = new javax.swing.JPanel();
        txtLoaiPhong = new javax.swing.JLabel();
        pnlTTQLPhong = new javax.swing.JPanel();
        txtPhong = new javax.swing.JLabel();
        pnlTTQLNhanVien = new javax.swing.JPanel();
        txtNhanVien = new javax.swing.JLabel();
        pnlTTQLDoanhThu = new javax.swing.JPanel();
        txtDoanhThu = new javax.swing.JLabel();
        pnlTTQLDichVu = new javax.swing.JPanel();
        txtDichVu = new javax.swing.JLabel();
        pnlTDTroChuyen = new javax.swing.JPanel();
        txtChoChuyen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1201, 700));

        Open.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Open.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mo.png"))); // NOI18N
        Open.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpenMouseClicked(evt);
            }
        });

        pnlMenuBar.setBackground(new java.awt.Color(204, 204, 204));
        pnlMenuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlMenuBar.setMinimumSize(new java.awt.Dimension(305, 0));

        bntDong.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bntDong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dong.png"))); // NOI18N
        bntDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntDongMouseClicked(evt);
            }
        });

        bntTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntTrangChu.setText("Trang Chủ");
        bntTrangChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntTrangChu.setMinimumSize(new java.awt.Dimension(291, 40));
        bntTrangChu.setPreferredSize(new java.awt.Dimension(91, 40));
        bntTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntTrangChuMouseClicked(evt);
            }
        });

        bntQLLoaiPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQLLoaiPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQLLoaiPhong.setText("Quản Lý Loại Phòng");
        bntQLLoaiPhong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQLLoaiPhong.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQLLoaiPhong.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQLLoaiPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQLLoaiPhongMouseClicked(evt);
            }
        });

        bntQLPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQLPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQLPhong.setText("Quản Lý Phòng");
        bntQLPhong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQLPhong.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQLPhong.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQLPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQLPhongMouseClicked(evt);
            }
        });

        bntQLNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQLNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQLNhanVien.setText("Quản Lý Nhân Viên");
        bntQLNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQLNhanVien.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQLNhanVien.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQLNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQLNhanVienMouseClicked(evt);
            }
        });

        bntQLDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQLDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQLDoanhThu.setText("Quản Lý Doanh Thu");
        bntQLDoanhThu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQLDoanhThu.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQLDoanhThu.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQLDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQLDoanhThuMouseClicked(evt);
            }
        });

        bntQLDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQLDichVu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQLDichVu.setText("Quản Lý Dịch Vụ");
        bntQLDichVu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQLDichVu.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQLDichVu.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQLDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQLDichVuMouseClicked(evt);
            }
        });

        btnDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDoiMK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDoiMK.setText("Đổi mật khẩu");
        btnDoiMK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDoiMK.setMinimumSize(new java.awt.Dimension(291, 40));
        btnDoiMK.setPreferredSize(new java.awt.Dimension(91, 40));
        btnDoiMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoiMKMouseClicked(evt);
            }
        });

        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDangXuat.setText("Đăng xuât");
        btnDangXuat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDangXuat.setMinimumSize(new java.awt.Dimension(291, 40));
        btnDangXuat.setPreferredSize(new java.awt.Dimension(70, 40));
        btnDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDangXuatMouseClicked(evt);
            }
        });

        btnTroChuyen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTroChuyen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTroChuyen.setText("Trò Chuyện");
        btnTroChuyen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnTroChuyen.setMinimumSize(new java.awt.Dimension(291, 40));
        btnTroChuyen.setPreferredSize(new java.awt.Dimension(70, 40));
        btnTroChuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTroChuyenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuBarLayout = new javax.swing.GroupLayout(pnlMenuBar);
        pnlMenuBar.setLayout(pnlMenuBarLayout);
        pnlMenuBarLayout.setHorizontalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuBarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bntDong, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntQLLoaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntQLPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntQLNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntQLDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntQLDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTroChuyen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMenuBarLayout.setVerticalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bntDong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQLLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQLPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQLDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQLDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTroChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        NoiDung.setBackground(new java.awt.Color(255, 255, 255));
        NoiDung.setMaximumSize(new java.awt.Dimension(1300, 750));
        NoiDung.setPreferredSize(new java.awt.Dimension(1195, 600));
        NoiDung.setLayout(new java.awt.CardLayout());

        pnlTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        pnlTrangChu.setMaximumSize(new java.awt.Dimension(32767, 640));
        pnlTrangChu.setPreferredSize(new java.awt.Dimension(1181, 640));

        txtTenNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTenNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenNV.setText("Nguyễn Văn Bách");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        Anh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Logo.png"))); // NOI18N
        Anh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        Anh.setPreferredSize(new java.awt.Dimension(200, 250));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(486, Short.MAX_VALUE)
                .addComponent(Anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(Anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bntQLLoaiPhong1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQLLoaiPhong1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQLLoaiPhong1.setText("Quản Lý Loại Phòng");
        bntQLLoaiPhong1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQLLoaiPhong1.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQLLoaiPhong1.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQLLoaiPhong1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQLLoaiPhong1MouseClicked(evt);
            }
        });

        bntQLPhong1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQLPhong1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQLPhong1.setText("Quản Lý Phòng");
        bntQLPhong1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQLPhong1.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQLPhong1.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQLPhong1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQLPhong1MouseClicked(evt);
            }
        });

        bntQLNhanVien1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQLNhanVien1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQLNhanVien1.setText("Quản Lý Nhân Viên");
        bntQLNhanVien1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQLNhanVien1.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQLNhanVien1.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQLNhanVien1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQLNhanVien1MouseClicked(evt);
            }
        });

        bntQLDoanhThu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQLDoanhThu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQLDoanhThu1.setText("Quản Lý Doanh Thu");
        bntQLDoanhThu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQLDoanhThu1.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQLDoanhThu1.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQLDoanhThu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQLDoanhThu1MouseClicked(evt);
            }
        });

        bntQLDichVu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQLDichVu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQLDichVu1.setText("Quản Lý Dịch Vụ");
        bntQLDichVu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQLDichVu1.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQLDichVu1.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQLDichVu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQLDichVu1MouseClicked(evt);
            }
        });

        btnTroChuyen1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTroChuyen1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTroChuyen1.setText("Trò Chuyện");
        btnTroChuyen1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnTroChuyen1.setMinimumSize(new java.awt.Dimension(291, 40));
        btnTroChuyen1.setPreferredSize(new java.awt.Dimension(70, 40));
        btnTroChuyen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTroChuyen1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlTrangChuLayout = new javax.swing.GroupLayout(pnlTrangChu);
        pnlTrangChu.setLayout(pnlTrangChuLayout);
        pnlTrangChuLayout.setHorizontalGroup(
            pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTrangChuLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTrangChuLayout.createSequentialGroup()
                        .addGap(0, 267, Short.MAX_VALUE)
                        .addGroup(pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bntQLPhong1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntQLLoaiPhong1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(bntQLNhanVien1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addGroup(pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTroChuyen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bntQLDoanhThu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bntQLDichVu1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(245, 245, 245))))
        );
        pnlTrangChuLayout.setVerticalGroup(
            pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrangChuLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenNV)
                .addGap(18, 18, 18)
                .addGroup(pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntQLNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTroChuyen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTrangChuLayout.createSequentialGroup()
                        .addComponent(bntQLLoaiPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntQLPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTrangChuLayout.createSequentialGroup()
                        .addComponent(bntQLDoanhThu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntQLDichVu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        NoiDung.add(pnlTrangChu, "card1");

        pnlQLLoaiPhong.setBackground(new java.awt.Color(255, 255, 255));
        pnlQLLoaiPhong.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ID Loại Phòng:");

        txtLPID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtLPID.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Loại Phòng:");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        bntLPSua.setBackground(new java.awt.Color(204, 204, 204));
        bntLPSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntLPSua.setText("Sửa");
        bntLPSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLPSuaActionPerformed(evt);
            }
        });

        bntLPXoaPhongLP.setBackground(new java.awt.Color(204, 204, 204));
        bntLPXoaPhongLP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntLPXoaPhongLP.setText("Xóa Phòng");
        bntLPXoaPhongLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLPXoaPhongLPActionPerformed(evt);
            }
        });

        bntLPLamMoi.setBackground(new java.awt.Color(204, 204, 204));
        bntLPLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntLPLamMoi.setText("Làm Mới");
        bntLPLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLPLamMoiActionPerformed(evt);
            }
        });

        bntLPTaoMoi.setBackground(new java.awt.Color(204, 204, 204));
        bntLPTaoMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntLPTaoMoi.setText("Tạo Mới");
        bntLPTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLPTaoMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntLPSua, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntLPXoaPhongLP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntLPLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntLPTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bntLPSua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(bntLPXoaPhongLP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(bntLPLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(bntLPTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        txtLPLoaiPhong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLPID, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLPLoaiPhong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLPID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLPLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtLPTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        bntLPTimKiem.setBackground(new java.awt.Color(204, 204, 204));
        bntLPTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntLPTimKiem.setText("Tìm Kiếm");
        bntLPTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLPTimKiemActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblLoaiPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Loại Phòng", "Loại Phòng", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiPhong.setFillsViewportHeight(true);
        tblLoaiPhong.setShowGrid(true);
        tblLoaiPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiPhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLoaiPhong);

        bntLPXoaMucChon.setBackground(new java.awt.Color(204, 204, 204));
        bntLPXoaMucChon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntLPXoaMucChon.setText("Xóa Mục Đã Chọn");
        bntLPXoaMucChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLPXoaMucChonActionPerformed(evt);
            }
        });

        bntLPTimKiem1.setBackground(new java.awt.Color(204, 204, 204));
        bntLPTimKiem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntLPTimKiem1.setText("Dừng");
        bntLPTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLPTimKiem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bntLPXoaMucChon, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtLPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntLPTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntLPTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntLPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntLPTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntLPXoaMucChon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlQLLoaiPhongLayout = new javax.swing.GroupLayout(pnlQLLoaiPhong);
        pnlQLLoaiPhong.setLayout(pnlQLLoaiPhongLayout);
        pnlQLLoaiPhongLayout.setHorizontalGroup(
            pnlQLLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlQLLoaiPhongLayout.setVerticalGroup(
            pnlQLLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLLoaiPhongLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        NoiDung.add(pnlQLLoaiPhong, "card2");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Số Phòng:");

        txtPSoPhong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Giá Thuê\\1 Ngày:");

        txtPGiaThue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ghi Chú:");

        txaPGhiChu.setColumns(20);
        txaPGhiChu.setRows(5);
        txaPGhiChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jScrollPane3.setViewportView(txaPGhiChu);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tầng:");

        txtPTang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Trạng Thái:");

        cboPTrangThai.add(rdoPPhongTrong);
        rdoPPhongTrong.setText("Phòng Trống");

        cboPTrangThai.add(rdoPPhongDuocThue);
        rdoPPhongDuocThue.setText("Phòng Sử Dụng");
        rdoPPhongDuocThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPPhongDuocThueActionPerformed(evt);
            }
        });

        cboPTrangThai.add(rdoPPhongDonDep);
        rdoPPhongDonDep.setText("Phòng Đang Dọn Dẹp");
        rdoPPhongDonDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPPhongDonDepActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Loại Phòng:");

        cmbPLoaiPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbPLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Loại Phòng" }));
        cmbPLoaiPhong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cmbPLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPLoaiPhongActionPerformed(evt);
            }
        });

        bntPSua.setBackground(new java.awt.Color(204, 204, 204));
        bntPSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntPSua.setText("Sửa");
        bntPSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPSuaActionPerformed(evt);
            }
        });

        bntPXoaPhong.setBackground(new java.awt.Color(204, 204, 204));
        bntPXoaPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntPXoaPhong.setText("Xóa Phòng");
        bntPXoaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPXoaPhongActionPerformed(evt);
            }
        });

        bntPLamMoi.setBackground(new java.awt.Color(204, 204, 204));
        bntPLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntPLamMoi.setText("Làm Mới");
        bntPLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPLamMoiActionPerformed(evt);
            }
        });

        bntPTaoMoi.setBackground(new java.awt.Color(204, 204, 204));
        bntPTaoMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntPTaoMoi.setText("Tạo Mới");
        bntPTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPTaoMoiActionPerformed(evt);
            }
        });

        cboPTrangThai.add(rdoPPhongSua1);
        rdoPPhongSua1.setText("Phòng Đang Sửa");
        rdoPPhongSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPPhongSua1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPSoPhong)
                    .addComponent(txtPGiaThue)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbPLoaiPhong, 0, 430, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPTang))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(rdoPPhongDonDep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoPPhongSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(rdoPPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoPPhongDuocThue, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntPSua, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntPXoaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntPLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(bntPTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPSoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPTang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbPLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoPPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoPPhongDuocThue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoPPhongDonDep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoPPhongSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntPSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntPXoaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntPLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntPTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        txtPTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jScrollPane4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số Phòng", "Tầng", "Giá Thuê\1 Ngày", "Loại Phòng", "Trạng Thái", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhong.setShowGrid(true);
        tblPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblPhong);

        bntPTimKiem.setBackground(new java.awt.Color(204, 204, 204));
        bntPTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntPTimKiem.setText("Tìm Kiếm");
        bntPTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPTimKiemActionPerformed(evt);
            }
        });

        bntPXoaMucDaChon.setBackground(new java.awt.Color(204, 204, 204));
        bntPXoaMucDaChon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntPXoaMucDaChon.setText("Xóa Mục Đã Chọn");
        bntPXoaMucDaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPXoaMucDaChonActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(bntPXoaMucDaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(txtPTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(bntPXoaMucDaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlQLPhongLayout = new javax.swing.GroupLayout(pnlQLPhong);
        pnlQLPhong.setLayout(pnlQLPhongLayout);
        pnlQLPhongLayout.setHorizontalGroup(
            pnlQLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlQLPhongLayout.setVerticalGroup(
            pnlQLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLPhongLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        NoiDung.add(pnlQLPhong, "card3");

        pnlQLNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        pnlQLNhanVien.setPreferredSize(new java.awt.Dimension(1181, 640));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        NVAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NVAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Logo.png"))); // NOI18N
        NVAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        NVAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NVAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(NVAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(NVAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Tên Đăng Nhập:");

        txtNVTenDangNhap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txtNVMatKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Mật Khẩu:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Vai Trò:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Họ Và Tên:");

        txtNVHoVaTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Số Điện Thoại:");

        txtNVSDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        cboNVVaitro.add(rdoNVQuanLy);
        rdoNVQuanLy.setText("Quản Lý");

        cboNVVaitro.add(rdoNVTiepTan);
        rdoNVTiepTan.setText("Tiếp Tân");
        rdoNVTiepTan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNVTiepTanActionPerformed(evt);
            }
        });

        cboNVVaitro.add(rdoNVDichVu);
        rdoNVDichVu.setText("Dịch Vụ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Trạng Thái:");

        cboNVTrangThai.add(rdoNVHoatDong);
        rdoNVHoatDong.setText("Hoạt Động");

        cboNVTrangThai.add(rdoNVTamDung);
        rdoNVTamDung.setText("Tạm Dừng");
        rdoNVTamDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNVTamDungActionPerformed(evt);
            }
        });

        bntNVTaoMoi.setBackground(new java.awt.Color(204, 204, 204));
        bntNVTaoMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntNVTaoMoi.setText("Tạo Mới");
        bntNVTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNVTaoMoiActionPerformed(evt);
            }
        });

        bntNVLamMoi.setBackground(new java.awt.Color(204, 204, 204));
        bntNVLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntNVLamMoi.setText("Làm Mới");
        bntNVLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNVLamMoiActionPerformed(evt);
            }
        });

        bntNVXoa.setBackground(new java.awt.Color(204, 204, 204));
        bntNVXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntNVXoa.setText("Xóa");
        bntNVXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNVXoaActionPerformed(evt);
            }
        });

        bntNVSua.setBackground(new java.awt.Color(204, 204, 204));
        bntNVSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntNVSua.setText("Sửa");
        bntNVSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNVSuaActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(rdoNVQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(rdoNVTiepTan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(rdoNVDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNVMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                                .addComponent(txtNVTenDangNhap, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNVHoVaTen)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNVSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(rdoNVHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(rdoNVTamDung, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntNVSua, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntNVXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntNVLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(bntNVTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNVTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNVMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNVHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNVSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoNVQuanLy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdoNVTiepTan)
                                        .addComponent(rdoNVDichVu))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdoNVHoatDong)
                                    .addComponent(rdoNVTamDung))))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bntNVSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntNVXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntNVLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntNVTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        bntNVTimKiem.setBackground(new java.awt.Color(204, 204, 204));
        bntNVTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntNVTimKiem.setText("Tìm Kiếm");
        bntNVTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNVTimKiemActionPerformed(evt);
            }
        });

        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên Đăng Nhập", "Họ Và Tên", "Mật Khẩu", "Số Điện Thoại", "Vai Trò", "Trạng Thái", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblNV);

        txtNVTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        bntNVXoaMucChon.setBackground(new java.awt.Color(204, 204, 204));
        bntNVXoaMucChon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntNVXoaMucChon.setText("Xóa Mục Đã Chọn");
        bntNVXoaMucChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNVXoaMucChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 970, Short.MAX_VALUE)
                        .addComponent(bntNVXoaMucChon, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtNVTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bntNVTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntNVTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNVTimKiem))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntNVXoaMucChon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlQLNhanVienLayout = new javax.swing.GroupLayout(pnlQLNhanVien);
        pnlQLNhanVien.setLayout(pnlQLNhanVienLayout);
        pnlQLNhanVienLayout.setHorizontalGroup(
            pnlQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlQLNhanVienLayout.setVerticalGroup(
            pnlQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLNhanVienLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        NoiDung.add(pnlQLNhanVien, "card4");

        pnlQLDoanhThu.setBackground(new java.awt.Color(255, 255, 255));
        pnlQLDoanhThu.setMaximumSize(new java.awt.Dimension(1195, 600));
        pnlQLDoanhThu.setMinimumSize(new java.awt.Dimension(1195, 600));
        pnlQLDoanhThu.setPreferredSize(new java.awt.Dimension(1995, 600));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));

        tabPhong.setBackground(new java.awt.Color(255, 255, 255));
        tabPhong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblDTPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Số Phòng", "Doanh Thu", "Số Ngày Được Thuê"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblDTPhong);

        txtDTPTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        bntDTPTimKiem.setBackground(new java.awt.Color(204, 204, 204));
        bntDTPTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntDTPTimKiem.setText("Tìm Kiếm");
        bntDTPTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDTPTimKiemActionPerformed(evt);
            }
        });

        bntDTPDungTimKiem.setBackground(new java.awt.Color(204, 204, 204));
        bntDTPDungTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntDTPDungTimKiem.setText("Dừng");
        bntDTPDungTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDTPDungTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabPhongLayout = new javax.swing.GroupLayout(tabPhong);
        tabPhong.setLayout(tabPhongLayout);
        tabPhongLayout.setHorizontalGroup(
            tabPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPhongLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(tabPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabPhongLayout.createSequentialGroup()
                        .addComponent(txtDTPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntDTPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntDTPDungTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        tabPhongLayout.setVerticalGroup(
            tabPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabPhongLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(tabPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDTPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDTPTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDTPDungTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane3.addTab("Doanh Thu Theo Phòng", tabPhong);

        tabDoanhThu.setBackground(new java.awt.Color(255, 255, 255));
        tabDoanhThu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblDTTiepTan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên Nhân Viên", "Doanh Thu", "Số Hóa Đơn", "Hóa Đơn Đầu", "Hóa Đơn Cuối"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblDTTiepTan);

        txtDTTTTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        bntDTTTTimKiem.setBackground(new java.awt.Color(204, 204, 204));
        bntDTTTTimKiem.setText("Tìm Kiếm");
        bntDTTTTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDTTTTimKiemActionPerformed(evt);
            }
        });

        bntDTTTDungTimKiem.setBackground(new java.awt.Color(204, 204, 204));
        bntDTTTDungTimKiem.setText("Dừng");
        bntDTTTDungTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDTTTDungTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabDoanhThuLayout = new javax.swing.GroupLayout(tabDoanhThu);
        tabDoanhThu.setLayout(tabDoanhThuLayout);
        tabDoanhThuLayout.setHorizontalGroup(
            tabDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDoanhThuLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(tabDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabDoanhThuLayout.createSequentialGroup()
                        .addComponent(txtDTTTTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntDTTTTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntDTTTDungTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        tabDoanhThuLayout.setVerticalGroup(
            tabDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDoanhThuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(tabDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDTTTTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDTTTTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(bntDTTTDungTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane3.addTab("Doanh Thu Theo Tiếp Tân", tabDoanhThu);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Từ Ngày:");

        txtDTNgayBatDau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Đến Ngày:");

        txtDTNgayKetThuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtDTNgayKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDTNgayKetThucActionPerformed(evt);
            }
        });

        bntDTLoc.setBackground(new java.awt.Color(204, 204, 204));
        bntDTLoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntDTLoc.setText("Lọc");

        cmbDTLocNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hôm Nay", "Tuần Này", "Tháng Này", "Quý Này", "Năm Nay" }));

        javax.swing.GroupLayout pnlQLDoanhThuLayout = new javax.swing.GroupLayout(pnlQLDoanhThu);
        pnlQLDoanhThu.setLayout(pnlQLDoanhThuLayout);
        pnlQLDoanhThuLayout.setHorizontalGroup(
            pnlQLDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLDoanhThuLayout.createSequentialGroup()
                .addGroup(pnlQLDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQLDoanhThuLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlQLDoanhThuLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDTNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDTNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(bntDTLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbDTLocNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(831, Short.MAX_VALUE))
        );
        pnlQLDoanhThuLayout.setVerticalGroup(
            pnlQLDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLDoanhThuLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlQLDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntDTLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlQLDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDTNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbDTLocNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDTNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        NoiDung.add(pnlQLDoanhThu, "card5");

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Tên Dịch Vụ:");

        txtDVTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Giá Tiền");

        txtDVGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        bntDVTaoMoi.setBackground(new java.awt.Color(204, 204, 204));
        bntDVTaoMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntDVTaoMoi.setText("Thêm Mới");
        bntDVTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDVTaoMoiActionPerformed(evt);
            }
        });

        bntDVXoa.setBackground(new java.awt.Color(204, 204, 204));
        bntDVXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntDVXoa.setText("Xóa");
        bntDVXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDVXoaActionPerformed(evt);
            }
        });

        bntDVLamMoi.setBackground(new java.awt.Color(204, 204, 204));
        bntDVLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntDVLamMoi.setText("Làm Mới");
        bntDVLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDVLamMoiActionPerformed(evt);
            }
        });

        bntDVSua.setBackground(new java.awt.Color(204, 204, 204));
        bntDVSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntDVSua.setText("Sửa");
        bntDVSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDVSuaActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDVGia)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(bntDVSua, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntDVLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntDVXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntDVTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDVTen))
                .addGap(71, 71, 71))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDVTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDVGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntDVTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDVXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDVLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDVSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Dịch Vụ", "Tên Dịch Vụ", "Giá Tiền", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDVMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblDV);

        bntDVTimKiem.setBackground(new java.awt.Color(204, 204, 204));
        bntDVTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntDVTimKiem.setText("Tìm Kiếm");
        bntDVTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDVTimKiemActionPerformed(evt);
            }
        });

        txtDVTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        bntDVXoaMucChon.setBackground(new java.awt.Color(204, 204, 204));
        bntDVXoaMucChon.setText("Xóa Các Mục Đã Chọn");
        bntDVXoaMucChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDVXoaMucChonActionPerformed(evt);
            }
        });

        bntDVDungTK.setBackground(new java.awt.Color(204, 204, 204));
        bntDVDungTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntDVDungTK.setText("Dừng");
        bntDVDungTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDVDungTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bntDVXoaMucChon, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(txtDVTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntDVTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntDVDungTK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDVTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDVTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDVDungTK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntDVXoaMucChon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnlQLDichVuLayout = new javax.swing.GroupLayout(pnlQLDichVu);
        pnlQLDichVu.setLayout(pnlQLDichVuLayout);
        pnlQLDichVuLayout.setHorizontalGroup(
            pnlQLDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlQLDichVuLayout.setVerticalGroup(
            pnlQLDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLDichVuLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NoiDung.add(pnlQLDichVu, "card6");

        javax.swing.GroupLayout pnlChatLayout = new javax.swing.GroupLayout(pnlChat);
        pnlChat.setLayout(pnlChatLayout);
        pnlChatLayout.setHorizontalGroup(
            pnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1195, Short.MAX_VALUE)
        );
        pnlChatLayout.setVerticalGroup(
            pnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );

        NoiDung.add(pnlChat, "card8");

        TieuDe.setBackground(new java.awt.Color(255, 255, 255));
        TieuDe.setLayout(new java.awt.CardLayout());

        pnlTDTrangChu.setBackground(new java.awt.Color(204, 204, 204));

        txtTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTrangChu.setText("Trang Chủ");

        javax.swing.GroupLayout pnlTDTrangChuLayout = new javax.swing.GroupLayout(pnlTDTrangChu);
        pnlTDTrangChu.setLayout(pnlTDTrangChuLayout);
        pnlTDTrangChuLayout.setHorizontalGroup(
            pnlTDTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        pnlTDTrangChuLayout.setVerticalGroup(
            pnlTDTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTDTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        TieuDe.add(pnlTDTrangChu, "card2");

        pnlTTQLLoaiPhong.setBackground(new java.awt.Color(204, 204, 204));

        txtLoaiPhong.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtLoaiPhong.setText("Quản Lý Loại Phòng");

        javax.swing.GroupLayout pnlTTQLLoaiPhongLayout = new javax.swing.GroupLayout(pnlTTQLLoaiPhong);
        pnlTTQLLoaiPhong.setLayout(pnlTTQLLoaiPhongLayout);
        pnlTTQLLoaiPhongLayout.setHorizontalGroup(
            pnlTTQLLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLoaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        pnlTTQLLoaiPhongLayout.setVerticalGroup(
            pnlTTQLLoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTQLLoaiPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLoaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        TieuDe.add(pnlTTQLLoaiPhong, "card3");

        pnlTTQLPhong.setBackground(new java.awt.Color(204, 204, 204));

        txtPhong.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtPhong.setText("Quản Lý Phòng");

        javax.swing.GroupLayout pnlTTQLPhongLayout = new javax.swing.GroupLayout(pnlTTQLPhong);
        pnlTTQLPhong.setLayout(pnlTTQLPhongLayout);
        pnlTTQLPhongLayout.setHorizontalGroup(
            pnlTTQLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        pnlTTQLPhongLayout.setVerticalGroup(
            pnlTTQLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTQLPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        TieuDe.add(pnlTTQLPhong, "card4");

        pnlTTQLNhanVien.setBackground(new java.awt.Color(204, 204, 204));

        txtNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtNhanVien.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout pnlTTQLNhanVienLayout = new javax.swing.GroupLayout(pnlTTQLNhanVien);
        pnlTTQLNhanVien.setLayout(pnlTTQLNhanVienLayout);
        pnlTTQLNhanVienLayout.setHorizontalGroup(
            pnlTTQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        pnlTTQLNhanVienLayout.setVerticalGroup(
            pnlTTQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTQLNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        TieuDe.add(pnlTTQLNhanVien, "card7");

        pnlTTQLDoanhThu.setBackground(new java.awt.Color(204, 204, 204));

        txtDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtDoanhThu.setText("Quản Lý Doanh Thu");

        javax.swing.GroupLayout pnlTTQLDoanhThuLayout = new javax.swing.GroupLayout(pnlTTQLDoanhThu);
        pnlTTQLDoanhThu.setLayout(pnlTTQLDoanhThuLayout);
        pnlTTQLDoanhThuLayout.setHorizontalGroup(
            pnlTTQLDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        pnlTTQLDoanhThuLayout.setVerticalGroup(
            pnlTTQLDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTQLDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        TieuDe.add(pnlTTQLDoanhThu, "card5");

        pnlTTQLDichVu.setBackground(new java.awt.Color(204, 204, 204));

        txtDichVu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtDichVu.setText("Quản Lý Dịch Vụ");

        javax.swing.GroupLayout pnlTTQLDichVuLayout = new javax.swing.GroupLayout(pnlTTQLDichVu);
        pnlTTQLDichVu.setLayout(pnlTTQLDichVuLayout);
        pnlTTQLDichVuLayout.setHorizontalGroup(
            pnlTTQLDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        pnlTTQLDichVuLayout.setVerticalGroup(
            pnlTTQLDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTQLDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        TieuDe.add(pnlTTQLDichVu, "card6");

        pnlTDTroChuyen.setBackground(new java.awt.Color(204, 204, 204));

        txtChoChuyen.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtChoChuyen.setText("Trò Chuyện");

        javax.swing.GroupLayout pnlTDTroChuyenLayout = new javax.swing.GroupLayout(pnlTDTroChuyen);
        pnlTDTroChuyen.setLayout(pnlTDTroChuyenLayout);
        pnlTDTroChuyenLayout.setHorizontalGroup(
            pnlTDTroChuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtChoChuyen, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        pnlTDTroChuyenLayout.setVerticalGroup(
            pnlTDTroChuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTDTroChuyenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtChoChuyen, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        TieuDe.add(pnlTDTroChuyen, "card2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlMenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addComponent(NoiDung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Open, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Open))
                .addGap(0, 0, 0)
                .addComponent(NoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpenMouseClicked
        // TODO add your handling code here:
        OpenMenuBar();
    }//GEN-LAST:event_OpenMouseClicked

    private void bntDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntDongMouseClicked
        // TODO add your handling code here:
        CloseOpenBar();
    }//GEN-LAST:event_bntDongMouseClicked

    private void bntTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntTrangChuMouseClicked
        Open.setVisible(true);
        pnlTDTrangChu.setVisible(true);
        pnlTrangChu.setVisible(true);
        pnlTTQLLoaiPhong.setVisible(false);
        pnlQLLoaiPhong.setVisible(false);
        pnlTTQLPhong.setVisible(false);
        pnlQLPhong.setVisible(false);
        pnlTTQLNhanVien.setVisible(false);
        pnlQLNhanVien.setVisible(false);
        pnlTTQLDoanhThu.setVisible(false);
        pnlQLDoanhThu.setVisible(false);
        pnlTTQLDichVu.setVisible(false);
        pnlQLDichVu.setVisible(false);
    }//GEN-LAST:event_bntTrangChuMouseClicked

    private void bntQLLoaiPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLLoaiPhongMouseClicked
        Open.setVisible(true);
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(true);
        pnlQLLoaiPhong.setVisible(true);
        pnlTTQLPhong.setVisible(false);
        pnlQLPhong.setVisible(false);
        pnlTTQLNhanVien.setVisible(false);
        pnlQLNhanVien.setVisible(false);
        pnlTTQLDoanhThu.setVisible(false);
        pnlQLDoanhThu.setVisible(false);
        pnlTTQLDichVu.setVisible(false);
        pnlQLDichVu.setVisible(false);
        this.laytblLoaiphong();
    }//GEN-LAST:event_bntQLLoaiPhongMouseClicked

    private void bntQLPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLPhongMouseClicked
        Open.setVisible(true);
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(false);
        pnlQLLoaiPhong.setVisible(false);
        pnlTTQLPhong.setVisible(true);
        pnlQLPhong.setVisible(true);
        pnlTTQLNhanVien.setVisible(false);
        pnlQLNhanVien.setVisible(false);
        pnlTTQLDoanhThu.setVisible(false);
        pnlQLDoanhThu.setVisible(false);
        pnlTTQLDichVu.setVisible(false);
        pnlQLDichVu.setVisible(false);
        this.laytblPhong();
        this.fillLoaiPhongToCbo();
        this.laytblPhong();
    }//GEN-LAST:event_bntQLPhongMouseClicked

    private void bntQLNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLNhanVienMouseClicked
        Open.setVisible(true);
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(false);
        pnlQLLoaiPhong.setVisible(false);
        pnlTTQLPhong.setVisible(false);
        pnlQLPhong.setVisible(false);
        pnlTTQLNhanVien.setVisible(true);
        pnlQLNhanVien.setVisible(true);
        pnlTTQLDoanhThu.setVisible(false);
        pnlQLDoanhThu.setVisible(false);
        pnlTTQLDichVu.setVisible(false);
        pnlQLDichVu.setVisible(false);
        laytblNhanVien();
    }//GEN-LAST:event_bntQLNhanVienMouseClicked

    private void bntQLDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLDoanhThuMouseClicked
        Open.setVisible(true);
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(false);
        pnlQLLoaiPhong.setVisible(false);
        pnlTTQLPhong.setVisible(false);
        pnlQLPhong.setVisible(false);
        pnlTTQLNhanVien.setVisible(false);
        pnlQLNhanVien.setVisible(false);
        pnlTTQLDoanhThu.setVisible(true);
        pnlQLDoanhThu.setVisible(true);
        pnlTTQLDichVu.setVisible(false);
        pnlQLDichVu.setVisible(false);
        fillTablePhong();
        fillTableDTTiepTan();
    }//GEN-LAST:event_bntQLDoanhThuMouseClicked

    private void bntQLDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLDichVuMouseClicked
        Open.setVisible(true);
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(false);
        pnlQLLoaiPhong.setVisible(false);
        pnlTTQLPhong.setVisible(false);
        pnlQLPhong.setVisible(false);
        pnlTTQLNhanVien.setVisible(false);
        pnlQLNhanVien.setVisible(false);
        pnlTTQLDoanhThu.setVisible(false);
        pnlQLDoanhThu.setVisible(false);
        pnlTTQLDichVu.setVisible(true);
        pnlQLDichVu.setVisible(true);
        laytblDichVu();
    }//GEN-LAST:event_bntQLDichVuMouseClicked

    private void bntLPSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLPSuaActionPerformed
        capNLoaiPhong();
        lamMLoaiPhong();
    }//GEN-LAST:event_bntLPSuaActionPerformed

    private void bntLPTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLPTimKiemActionPerformed
        this.timKiemLoaiPhong();
    }//GEN-LAST:event_bntLPTimKiemActionPerformed

    private void rdoPPhongDuocThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPPhongDuocThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoPPhongDuocThueActionPerformed

    private void rdoPPhongDonDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPPhongDonDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoPPhongDonDepActionPerformed

    private void rdoNVTiepTanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNVTiepTanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNVTiepTanActionPerformed

    private void rdoNVTamDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNVTamDungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNVTamDungActionPerformed

    private void txtDTNgayKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDTNgayKetThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDTNgayKetThucActionPerformed

    private void bntDVTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDVTimKiemActionPerformed
        laytblDichVu();
    }//GEN-LAST:event_bntDVTimKiemActionPerformed

    private void bntLPTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLPTaoMoiActionPerformed
        this.taoLoaiPhong();
    }//GEN-LAST:event_bntLPTaoMoiActionPerformed

    private void tblLoaiPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiPhongMouseClicked
        if (evt.getClickCount() == 2) {
            suaLoaiPhong();
        }
    }//GEN-LAST:event_tblLoaiPhongMouseClicked

    private void bntLPXoaPhongLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLPXoaPhongLPActionPerformed
        xoaLoaiPhong();
    }//GEN-LAST:event_bntLPXoaPhongLPActionPerformed

    private void bntLPLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLPLamMoiActionPerformed
        lamMLoaiPhong();
    }//GEN-LAST:event_bntLPLamMoiActionPerformed

    private void bntLPXoaMucChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLPXoaMucChonActionPerformed
        xoaMDCLoaiPhong();
    }//GEN-LAST:event_bntLPXoaMucChonActionPerformed

    private void bntLPTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLPTimKiem1ActionPerformed
        lamMLoaiPhong();
        laytblLoaiphong();
    }//GEN-LAST:event_bntLPTimKiem1ActionPerformed

    private void rdoPPhongSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPPhongSua1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoPPhongSua1ActionPerformed

    private void bntPSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPSuaActionPerformed
        capNPhong();
    }//GEN-LAST:event_bntPSuaActionPerformed

    private void tblPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongMouseClicked
        if (evt.getClickCount() == 2) {
            suaPhong();
        }
    }//GEN-LAST:event_tblPhongMouseClicked

    private void bntPXoaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPXoaPhongActionPerformed
        xoaPhong();
    }//GEN-LAST:event_bntPXoaPhongActionPerformed

    private void bntPLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPLamMoiActionPerformed
        this.lamMPhong();
    }//GEN-LAST:event_bntPLamMoiActionPerformed

    private void bntPTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPTaoMoiActionPerformed
        taoPhong();
    }//GEN-LAST:event_bntPTaoMoiActionPerformed

    private void bntPTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPTimKiemActionPerformed
        timKiemPhong();
    }//GEN-LAST:event_bntPTimKiemActionPerformed

    private void bntPXoaMucDaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPXoaMucDaChonActionPerformed
        xoaMDCPhong();
    }//GEN-LAST:event_bntPXoaMucDaChonActionPerformed

    private void NVAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NVAnhMouseClicked
        chonAnhNV();
    }//GEN-LAST:event_NVAnhMouseClicked

    private void bntQLLoaiPhong1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLLoaiPhong1MouseClicked
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(true);
        pnlQLLoaiPhong.setVisible(true);
        pnlTTQLPhong.setVisible(false);
        pnlQLPhong.setVisible(false);
        pnlTTQLNhanVien.setVisible(false);
        pnlQLNhanVien.setVisible(false);
        pnlTTQLDoanhThu.setVisible(false);
        pnlQLDoanhThu.setVisible(false);
        pnlTTQLDichVu.setVisible(false);
        pnlQLDichVu.setVisible(false);
        Open.setVisible(true);
        laytblLoaiphong();
    }//GEN-LAST:event_bntQLLoaiPhong1MouseClicked

    private void bntQLPhong1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLPhong1MouseClicked
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(false);
        pnlQLLoaiPhong.setVisible(false);
        pnlTTQLPhong.setVisible(true);
        pnlQLPhong.setVisible(true);
        pnlTTQLNhanVien.setVisible(false);
        pnlQLNhanVien.setVisible(false);
        pnlTTQLDoanhThu.setVisible(false);
        pnlQLDoanhThu.setVisible(false);
        pnlTTQLDichVu.setVisible(false);
        pnlQLDichVu.setVisible(false);
        Open.setVisible(true);
        laytblPhong();
        fillLoaiPhongToCbo();
        laytblPhong();
    }//GEN-LAST:event_bntQLPhong1MouseClicked

    private void bntQLNhanVien1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLNhanVien1MouseClicked
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(false);
        pnlQLLoaiPhong.setVisible(false);
        pnlTTQLPhong.setVisible(false);
        pnlQLPhong.setVisible(false);
        pnlTTQLNhanVien.setVisible(true);
        pnlQLNhanVien.setVisible(true);
        pnlTTQLDoanhThu.setVisible(false);
        pnlQLDoanhThu.setVisible(false);
        pnlTTQLDichVu.setVisible(false);
        pnlQLDichVu.setVisible(false);
        Open.setVisible(true);
        laytblNhanVien();
    }//GEN-LAST:event_bntQLNhanVien1MouseClicked

    private void bntQLDoanhThu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLDoanhThu1MouseClicked
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(false);
        pnlQLLoaiPhong.setVisible(false);
        pnlTTQLPhong.setVisible(false);
        pnlQLPhong.setVisible(false);
        pnlTTQLNhanVien.setVisible(false);
        pnlQLNhanVien.setVisible(false);
        pnlTTQLDoanhThu.setVisible(true);
        pnlQLDoanhThu.setVisible(true);
        pnlTTQLDichVu.setVisible(false);
        pnlQLDichVu.setVisible(false);
        Open.setVisible(true);
        fillTablePhong();
        fillTableDTTiepTan();
    }//GEN-LAST:event_bntQLDoanhThu1MouseClicked

    private void bntQLDichVu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLDichVu1MouseClicked
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(false);
        pnlQLLoaiPhong.setVisible(false);
        pnlTTQLPhong.setVisible(false);
        pnlQLPhong.setVisible(false);
        pnlTTQLNhanVien.setVisible(false);
        pnlQLNhanVien.setVisible(false);
        pnlTTQLDoanhThu.setVisible(false);
        pnlQLDoanhThu.setVisible(false);
        pnlTTQLDichVu.setVisible(true);
        pnlQLDichVu.setVisible(true);
        Open.setVisible(true);
        laytblDichVu();
    }//GEN-LAST:event_bntQLDichVu1MouseClicked


    private void cmbPLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPLoaiPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPLoaiPhongActionPerformed

    private void btnDoiMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMKMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiMKMouseClicked

    private void btnDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangXuatMouseClicked
        DX();
    }//GEN-LAST:event_btnDangXuatMouseClicked

    private void bntNVTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNVTaoMoiActionPerformed
        taoNguoiDung();
    }//GEN-LAST:event_bntNVTaoMoiActionPerformed

    private void bntNVLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNVLamMoiActionPerformed
        lamMNguoiDung();
    }//GEN-LAST:event_bntNVLamMoiActionPerformed

    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked
        if (evt.getClickCount() == 2) { // Kích hoạt khi nhấp đúp
            suaNguoiDung();
        }
    }//GEN-LAST:event_tblNVMouseClicked

    private void bntNVTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNVTimKiemActionPerformed
        timKiemNguoiDung();
    }//GEN-LAST:event_bntNVTimKiemActionPerformed

    private void bntNVXoaMucChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNVXoaMucChonActionPerformed
        xoaMDCNguoiDung();
    }//GEN-LAST:event_bntNVXoaMucChonActionPerformed

    private void bntNVXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNVXoaActionPerformed
        xoaNguoiDung();
    }//GEN-LAST:event_bntNVXoaActionPerformed

    private void bntNVSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNVSuaActionPerformed

        capNguoiDung();
    }//GEN-LAST:event_bntNVSuaActionPerformed

    private void bntDTPTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDTPTimKiemActionPerformed
        // TODO add your handling code here:
        fillTablePhong();
    }//GEN-LAST:event_bntDTPTimKiemActionPerformed

    private void bntDTPDungTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDTPDungTimKiemActionPerformed
        txtDTPTimKiem.setText(""); // Xóa nội dung trong ô tìm kiếm
        fillTablePhong();
    }//GEN-LAST:event_bntDTPDungTimKiemActionPerformed

    private void bntDTTTTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDTTTTimKiemActionPerformed
        // TODO add your handling code here:
        fillTableDTTiepTan();
    }//GEN-LAST:event_bntDTTTTimKiemActionPerformed

    private void bntDTTTDungTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDTTTDungTimKiemActionPerformed
        txtDTTTTimKiem.setText("");
         fillTableDTTiepTan();
    }//GEN-LAST:event_bntDTTTDungTimKiemActionPerformed

    private void bntDVDungTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDVDungTKActionPerformed
        txtDVTimKiem.setText("");
        laytblDichVu();
    }//GEN-LAST:event_bntDVDungTKActionPerformed

    private void bntDVLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDVLamMoiActionPerformed
        lamMDichVu();
    }//GEN-LAST:event_bntDVLamMoiActionPerformed

    private void bntDVTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDVTaoMoiActionPerformed
        taoDichVu();
    }//GEN-LAST:event_bntDVTaoMoiActionPerformed

    private void bntDVSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDVSuaActionPerformed
        capNDichVu();
    }//GEN-LAST:event_bntDVSuaActionPerformed

    private void tblDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDVMouseClicked
        if (evt.getClickCount() == 2) { // Kích hoạt khi nhấp đúp chuột
            int selectedRow = tblDV.getSelectedRow();
            if (selectedRow >= 0) { // Đảm bảo có hàng được chọn
                try {
                    // Lấy đối tượng DichVu từ danh sách 'DichVuitems' dựa trên chỉ số hàng được chọn.
                    // Đảm bảo rằng 'DichVuitems' đã được điền đầy đủ bởi 'laytblDichVu()'.
                    Dao.entity.DichVu selectedService = DichVuitems.get(selectedRow);
                    setFromDV(selectedService); // Điền dữ liệu vào các trường trên form
                    suatblDV(true); // Đặt trạng thái form sang chế độ sửa
                } catch (Exception e) {
                    Util.XDialog.alert("Lỗi khi chọn dịch vụ để sửa: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_tblDVMouseClicked

    private void bntDVXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDVXoaActionPerformed
        xoaDichVu();
    }//GEN-LAST:event_bntDVXoaActionPerformed

    private void bntDVXoaMucChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDVXoaMucChonActionPerformed
         xoaMDCDichVu();
    }//GEN-LAST:event_bntDVXoaMucChonActionPerformed

    private void btnTroChuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTroChuyenMouseClicked
        Open.setVisible(true);
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(false);
        pnlQLLoaiPhong.setVisible(false);
        pnlTTQLPhong.setVisible(false);
        pnlQLPhong.setVisible(false);
        pnlTTQLNhanVien.setVisible(false);
        pnlQLNhanVien.setVisible(false);
        pnlTTQLDoanhThu.setVisible(false);
        pnlQLDoanhThu.setVisible(false);
        pnlTTQLDichVu.setVisible(false);
        pnlQLDichVu.setVisible(false);
        pnlChat.setVisible(true);
        pnlTDTroChuyen.setVisible(true);
    }//GEN-LAST:event_btnTroChuyenMouseClicked

    private void btnTroChuyen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTroChuyen1MouseClicked
        Open.setVisible(true);
        pnlTDTrangChu.setVisible(false);
        pnlTrangChu.setVisible(false);
        pnlTTQLLoaiPhong.setVisible(false);
        pnlQLLoaiPhong.setVisible(false);
        pnlTTQLPhong.setVisible(false);
        pnlQLPhong.setVisible(false);
        pnlTTQLNhanVien.setVisible(false);
        pnlQLNhanVien.setVisible(false);
        pnlTTQLDoanhThu.setVisible(false);
        pnlQLDoanhThu.setVisible(false);
        pnlTTQLDichVu.setVisible(false);
        pnlQLDichVu.setVisible(false);
        pnlChat.setVisible(true);
        pnlTDTroChuyen.setVisible(true);
    }//GEN-LAST:event_btnTroChuyen1MouseClicked


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChuQLJFarme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuQLJFarme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuQLJFarme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuQLJFarme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuQLJFarme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Anh;
    private javax.swing.JFileChooser ChonAnh;
    private javax.swing.JLabel NVAnh;
    private javax.swing.JPanel NoiDung;
    private javax.swing.JLabel Open;
    private javax.swing.JPanel TieuDe;
    private javax.swing.JButton bntDTLoc;
    private javax.swing.JButton bntDTPDungTimKiem;
    private javax.swing.JButton bntDTPTimKiem;
    private javax.swing.JButton bntDTTTDungTimKiem;
    private javax.swing.JButton bntDTTTTimKiem;
    private javax.swing.JButton bntDVDungTK;
    private javax.swing.JButton bntDVLamMoi;
    private javax.swing.JButton bntDVSua;
    private javax.swing.JButton bntDVTaoMoi;
    private javax.swing.JButton bntDVTimKiem;
    private javax.swing.JButton bntDVXoa;
    private javax.swing.JButton bntDVXoaMucChon;
    private javax.swing.JLabel bntDong;
    private javax.swing.JButton bntLPLamMoi;
    private javax.swing.JButton bntLPSua;
    private javax.swing.JButton bntLPTaoMoi;
    private javax.swing.JButton bntLPTimKiem;
    private javax.swing.JButton bntLPTimKiem1;
    private javax.swing.JButton bntLPXoaMucChon;
    private javax.swing.JButton bntLPXoaPhongLP;
    private javax.swing.JButton bntNVLamMoi;
    private javax.swing.JButton bntNVSua;
    private javax.swing.JButton bntNVTaoMoi;
    private javax.swing.JButton bntNVTimKiem;
    private javax.swing.JButton bntNVXoa;
    private javax.swing.JButton bntNVXoaMucChon;
    private javax.swing.JButton bntPLamMoi;
    private javax.swing.JButton bntPSua;
    private javax.swing.JButton bntPTaoMoi;
    private javax.swing.JButton bntPTimKiem;
    private javax.swing.JButton bntPXoaMucDaChon;
    private javax.swing.JButton bntPXoaPhong;
    private javax.swing.JLabel bntQLDichVu;
    private javax.swing.JLabel bntQLDichVu1;
    private javax.swing.JLabel bntQLDoanhThu;
    private javax.swing.JLabel bntQLDoanhThu1;
    private javax.swing.JLabel bntQLLoaiPhong;
    private javax.swing.JLabel bntQLLoaiPhong1;
    private javax.swing.JLabel bntQLNhanVien;
    private javax.swing.JLabel bntQLNhanVien1;
    private javax.swing.JLabel bntQLPhong;
    private javax.swing.JLabel bntQLPhong1;
    private javax.swing.JLabel bntTrangChu;
    private javax.swing.JLabel btnDangXuat;
    private javax.swing.JLabel btnDoiMK;
    private javax.swing.JLabel btnTroChuyen;
    private javax.swing.JLabel btnTroChuyen1;
    private javax.swing.ButtonGroup cboNVTrangThai;
    private javax.swing.ButtonGroup cboNVVaitro;
    private javax.swing.ButtonGroup cboPTrangThai;
    private javax.swing.JComboBox<String> cmbDTLocNgay;
    private javax.swing.JComboBox<String> cmbPLoaiPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JPanel pnlChat;
    private javax.swing.JPanel pnlMenuBar;
    private javax.swing.JPanel pnlQLDichVu;
    private javax.swing.JPanel pnlQLDoanhThu;
    private javax.swing.JPanel pnlQLLoaiPhong;
    private javax.swing.JPanel pnlQLNhanVien;
    private javax.swing.JPanel pnlQLPhong;
    private javax.swing.JPanel pnlTDTrangChu;
    private javax.swing.JPanel pnlTDTroChuyen;
    private javax.swing.JPanel pnlTTQLDichVu;
    private javax.swing.JPanel pnlTTQLDoanhThu;
    private javax.swing.JPanel pnlTTQLLoaiPhong;
    private javax.swing.JPanel pnlTTQLNhanVien;
    private javax.swing.JPanel pnlTTQLPhong;
    private javax.swing.JPanel pnlTrangChu;
    private javax.swing.JRadioButton rdoNVDichVu;
    private javax.swing.JRadioButton rdoNVHoatDong;
    private javax.swing.JRadioButton rdoNVQuanLy;
    private javax.swing.JRadioButton rdoNVTamDung;
    private javax.swing.JRadioButton rdoNVTiepTan;
    private javax.swing.JRadioButton rdoPPhongDonDep;
    private javax.swing.JRadioButton rdoPPhongDuocThue;
    private javax.swing.JRadioButton rdoPPhongSua1;
    private javax.swing.JRadioButton rdoPPhongTrong;
    private javax.swing.JPanel tabDoanhThu;
    private javax.swing.JPanel tabPhong;
    private javax.swing.JTable tblDTPhong;
    private javax.swing.JTable tblDTTiepTan;
    private javax.swing.JTable tblDV;
    private javax.swing.JTable tblLoaiPhong;
    private javax.swing.JTable tblNV;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTextArea txaPGhiChu;
    private javax.swing.JLabel txtChoChuyen;
    private javax.swing.JTextField txtDTNgayBatDau;
    private javax.swing.JTextField txtDTNgayKetThuc;
    private javax.swing.JTextField txtDTPTimKiem;
    private javax.swing.JTextField txtDTTTTimKiem;
    private javax.swing.JTextField txtDVGia;
    private javax.swing.JTextField txtDVTen;
    private javax.swing.JTextField txtDVTimKiem;
    private javax.swing.JLabel txtDichVu;
    private javax.swing.JLabel txtDoanhThu;
    private javax.swing.JTextField txtLPID;
    private javax.swing.JTextField txtLPLoaiPhong;
    private javax.swing.JTextField txtLPTimKiem;
    private javax.swing.JLabel txtLoaiPhong;
    private javax.swing.JTextField txtNVHoVaTen;
    private javax.swing.JTextField txtNVMatKhau;
    private javax.swing.JTextField txtNVSDT;
    private javax.swing.JTextField txtNVTenDangNhap;
    private javax.swing.JTextField txtNVTimKiem;
    private javax.swing.JLabel txtNhanVien;
    private javax.swing.JTextField txtPGiaThue;
    private javax.swing.JTextField txtPSoPhong;
    private javax.swing.JTextField txtPTang;
    private javax.swing.JTextField txtPTimKiem;
    private javax.swing.JLabel txtPhong;
    private javax.swing.JLabel txtTenNV;
    private javax.swing.JLabel txtTrangChu;
    // End of variables declaration//GEN-END:variables
    void open() {
        this.setLocationRelativeTo(null);
        this.setIconImage(XIcon.getIcon("Logo.png").getImage()); // Sử dụng Logo mặc định
        this.setLocationRelativeTo(null);

        // Hiển thị tên và ảnh của người dùng đang đăng nhập nếu có
        if (XAuth.user != null) {
            txtTenNV.setText(XAuth.user.getHoVaTen());
            // Đảm bảo ảnh của người dùng đang đăng nhập cũng được tải đúng cách
            // Giả sử ảnh của user đăng nhập cũng nằm trong folder "images"
            if (XAuth.user.getAnh() != null && !XAuth.user.getAnh().isEmpty()) {
                XIcon.setIcon(Anh, new File(folder, XAuth.user.getAnh()));
            } else {
                XIcon.setIcon(Anh, "/Icon/Logo.png"); // Ảnh mặc định nếu không có
            }
        }
    }
    
    /**
     * ==============================================================================================================================
     * ==================================================== Loai Phong ==============================================================
     * ==============================================================================================================================
     */
    
    LoaiPhongDao dao = new LoaiPhongDaoImpl();
    java.util.List<LoaiPhong> items;
    
    public LoaiPhong layLoaiPhong() {
        LoaiPhong entity = new LoaiPhong();
        
        // Lấy ID loại phòng từ text field (chỉ khi có giá trị, tức là đang sửa)
        // txtLPID là trường hiển thị ID, được điền khi chọn từ bảng.
        if (!txtLPID.getText().isEmpty()) {
            try {
                entity.setId(Integer.parseInt(txtLPID.getText()));
            } catch (NumberFormatException e) {
                // Trường hợp này không nên xảy ra nếu txtLPID chỉ được thiết lập bằng chương trình
                // nhưng là một kiểm tra mạnh mẽ để đảm bảo tính toàn vẹn dữ liệu.
                JOptionPane.showMessageDialog(this, "ID Loại Phòng không hợp lệ. Vui lòng làm mới và chọn lại.", "Lỗi dữ liệu", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException("ID Loai Phong is not a valid number.", e); // Ném ngoại lệ để dừng thao tác nếu ID không hợp lệ
            }
        }
        
        // Lấy tên loại phòng từ text field tương ứng
        entity.setTenLoaiPhong(txtLPLoaiPhong.getText()); 

        return entity;
    }

    void taoLoaiPhong(){
        String loaiPhongText = txtLPLoaiPhong.getText().trim();
        StringBuilder err = new StringBuilder();
        if(loaiPhongText.isEmpty()){
            err.append("Chưa nhập loại phòng\n");
        }
        if(err.length()>0){
            JOptionPane.showMessageDialog(this, err.toString());
            return;
        }
        
         LoaiPhong newLoaiPhong = this.layLoaiPhong();
         dao.create(newLoaiPhong);
         XDialog.alert("Tạo loại phòng thành công!");
         this.laytblLoaiphong();
    }

    void laytblLoaiphong(){
        DefaultTableModel model = (DefaultTableModel) tblLoaiPhong.getModel();
        model.setRowCount(0);
        items = dao.findAll();
        items.forEach(item -> {
            Object[] rowData = {
                item.getId(),
                item.getTenLoaiPhong(),
                false
            };
            model.addRow(rowData);
        });
    }
    
    void suaLoaiPhong() {
        int selectedIndex = tblLoaiPhong.getSelectedRow(); // Lấy chỉ số hàng được chọn
        
        // Thêm kiểm tra để đảm bảo một hàng thực sự được chọn
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một loại phòng để sửa."); // Thông báo cho người dùng
            return; // Thoát khỏi phương thức nếu không có hàng nào được chọn
        }

        try {
            LoaiPhong entity = items.get(selectedIndex); // Sử dụng chỉ số đã được xác thực
            this.setFromLP(entity);
            this.suatblLP(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi chọn loại phòng để sửa: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    void setFromLP(LoaiPhong entity){
        txtLPID.setText(Integer.toString(entity.getId()));
        txtLPLoaiPhong.setText(entity.getTenLoaiPhong());
    }
    
    void suatblLP(boolean SuaLP){
        bntLPSua.setEnabled(SuaLP);
        bntLPTaoMoi.setEnabled(!SuaLP);
    }
    
    void capNLoaiPhong(){
        LoaiPhong entity = this.layLoaiPhong();
        dao.update(entity);
        this.laytblLoaiphong();
    }
    
    void xoaLoaiPhong(){
        if(XDialog.confirm("Bạn thực xự muốn xóa?")){
            Integer id = Integer.valueOf(txtLPID.getText());
            dao.deleteById(id);
            this.laytblLoaiphong();
            
        }
    }
    
    void lamMLoaiPhong(){
        this.setFromLP(new LoaiPhong());
        this.suatblLP(false);
    }
    
    void xoaMDCLoaiPhong(){
        if(XDialog.confirm("Bạn thực xự muốn xoa mục đã chọn?")){
            for(int i = 0; i < tblLoaiPhong.getRowCount(); i++){
                if((Boolean) tblLoaiPhong.getValueAt(i, 2)){
                    dao.deleteById(items.get(i).getId());
                }
            }
            this.laytblLoaiphong();
        }
    }
    
    void timKiemLoaiPhong() {
        DefaultTableModel model = (DefaultTableModel) tblLoaiPhong.getModel();
        model.setRowCount(0);
        String tenLP = txtLPTimKiem.getText();
        items = dao.findByName(tenLP);
        items.forEach(item -> {
            Object[] rowData = {
                item.getId(),
                item.getTenLoaiPhong(),
                false
            };
            model.addRow(rowData);
        });
    }
    
    /**
     * ==============================================================================================================================
     * ======================================================== Phong ===============================================================
     * ==============================================================================================================================
     */
    
    PhongDao Phongdao = new PhongDaoImpl();
    java.util.List<Phong> Phongitems;

    public Phong layPhong() {
        Phong entity = new Phong();
        entity.setSoPhong(txtPSoPhong.getText());
        entity.setTang(Integer.parseInt(txtPTang.getText()));
        entity.setGiaTien(new java.math.BigDecimal(txtPGiaThue.getText()));
        entity.setGhiChu(txaPGhiChu.getText());

        LoaiPhong loaiPhongChon = (LoaiPhong) cmbPLoaiPhong.getSelectedItem();
        if (loaiPhongChon != null) {
            entity.setIdLoaiPhong(loaiPhongChon.getId());
        }

        String trangThai = "Trống";
        if (rdoPPhongDuocThue.isSelected()) {
            trangThai = "Đang sử dụng";
        } else if (rdoPPhongSua1.isSelected()) {
            trangThai = "Đang sửa chữa";
        } else if (rdoPPhongDonDep.isSelected()){
            trangThai = "Đang dọn dẹp";
        }
        entity.setTrangThai(trangThai);
        return entity;
    }

    void fillLoaiPhongToCbo() {
        javax.swing.DefaultComboBoxModel model = (javax.swing.DefaultComboBoxModel) cmbPLoaiPhong.getModel();
        model.removeAllElements();
        try {
            java.util.List<LoaiPhong> list = new LoaiPhongDaoImpl().findAll();
            for (LoaiPhong lp : list) {
                model.addElement(lp);
            }
        } catch (Exception e) {
            XDialog.alert("Lỗi tải dữ liệu loại phòng!");
        }
    }

    void laytblPhong() {
        DefaultTableModel model = (DefaultTableModel) tblPhong.getModel();
        model.setRowCount(0);
        try {
            Phongitems = Phongdao.findAll();
            for (Phong item : Phongitems) {
                LoaiPhong loaiPhong = new LoaiPhongDaoImpl().findById(item.getIdLoaiPhong());
                String tenLoaiPhong = (loaiPhong != null) ? loaiPhong.getTenLoaiPhong() : "Không rõ";
                model.addRow(new Object[]{
                    item.getSoPhong(),
                    item.getTang(),
                    item.getGiaTien(),
                    tenLoaiPhong,
                    item.getTrangThai(),
                    false
                });
            }
        } catch (Exception e) {
            XDialog.alert("Lỗi tải dữ liệu phòng!");
            e.printStackTrace();
        }
    }

    void suaPhong() {
        try {
            int selectedIndex = tblPhong.getSelectedRow();
            if (selectedIndex >= 0) {
                Phong entity = Phongitems.get(selectedIndex);
                this.setFromP(entity);
                this.suatblP(true);
            }
        } catch (Exception e) {
            XDialog.alert("Lỗi khi chọn phòng để sửa!");
            e.printStackTrace();
        }
    }

    void setFromP(Phong entity) {
        txtPSoPhong.setText(entity.getSoPhong());
        txtPTang.setText(String.valueOf(entity.getTang()));
        txtPGiaThue.setText(String.valueOf(entity.getGiaTien()));
        txaPGhiChu.setText(entity.getGhiChu());

        DefaultComboBoxModel model = (DefaultComboBoxModel) cmbPLoaiPhong.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            LoaiPhong lp = (LoaiPhong) model.getElementAt(i);
            if (lp.getId() == entity.getIdLoaiPhong()) {
                cmbPLoaiPhong.setSelectedIndex(i);
                break;
            }
        }

        String trangThai = entity.getTrangThai() != null ? entity.getTrangThai() : "Trống";
        switch (trangThai) {
            case "Đang sử dụng" -> rdoPPhongDuocThue.setSelected(true);
            case "Đang sửa chữa" -> rdoPPhongSua1.setSelected(true);
            case "Đang dọn dẹp" -> rdoPPhongDonDep.setSelected(true);
            default -> rdoPPhongTrong.setSelected(true);
        }
    }


    void suatblP(boolean suaP) {
        bntPSua.setEnabled(suaP);
        bntPTaoMoi.setEnabled(!suaP);
    }
    /**
     * Cập nhật thông tin phòng trong CSDL.
     */
    void capNPhong() {
        int selectedIndex = tblPhong.getSelectedRow();
        if (selectedIndex < 0) {
            XDialog.alert("Vui lòng chọn một phòng để cập nhật.");
            return;
        }
        if (XDialog.confirm("Bạn có chắc chắn muốn cập nhật thông tin phòng này không?")) {
            try {
                Phong entity = this.layPhong();
                // Lấy ID từ đối tượng phòng đã được chọn trong danh sách
                Phong selectedPhong = Phongitems.get(selectedIndex);
                entity.setId(selectedPhong.getId()); 

                Phongdao.update(entity);
                this.laytblPhong(); // Tải lại dữ liệu bảng
                XDialog.alert("Cập nhật phòng thành công!");
            } catch (Exception e) {
                XDialog.alert("Cập nhật phòng thất bại!");
                e.printStackTrace();
            }
        }
    }


    /**
     * Xóa phòng được chọn trên form.
     */
    void xoaPhong() {
        int selectedIndex = tblPhong.getSelectedRow();
        // Kiểm tra xem có hàng nào được chọn không
        if (selectedIndex < 0) {
            XDialog.alert("Vui lòng chọn một phòng để xóa.");
            return;
        }

        if (XDialog.confirm("Bạn thực sự muốn xóa phòng này?")) {
            try {
                // Lấy ID từ đối tượng phòng đã được chọn trong danh sách
                Phong phongToDelete = Phongitems.get(selectedIndex);
                Phongdao.deleteById(phongToDelete.getId());

                this.laytblPhong(); // Tải lại dữ liệu bảng
                this.lamMPhong(); // Làm mới form
                XDialog.alert("Xóa phòng thành công!");
            } catch (Exception e) {
                XDialog.alert("Xóa phòng thất bại! Lỗi: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Xóa các phòng đã được chọn trong bảng.
     */
    void xoaMDCPhong() {
        if (XDialog.confirm("Bạn thực sự muốn xóa các mục đã chọn?")) {
            int successCount = 0;
            for (int i = 0; i < tblPhong.getRowCount(); i++) {
                if ((Boolean) tblPhong.getValueAt(i, 5)) {
                    try {
                        Phongdao.deleteById(Phongitems.get(i).getId());
                        successCount++;
                    } catch (Exception e) {
                    }
                }
            }
            this.laytblPhong();
            XDialog.alert("Đã xóa thành công " + successCount + " mục.");
        }
    }


    void lamMPhong() {
        this.setFromP(new Phong());
        this.suatblP(false);
    }


    void timKiemPhong() {
        DefaultTableModel model = (DefaultTableModel) tblPhong.getModel();
        model.setRowCount(0);
        String soPhongKeyword = txtPTimKiem.getText();
        try {
            java.util.List<Phong> list = Phongdao.findAll(); // Lấy tất cả và lọc
            for (Phong item : list) {
                if (item.getSoPhong().contains(soPhongKeyword)) {
                    LoaiPhong loaiPhong = new LoaiPhongDaoImpl().findById(item.getIdLoaiPhong());
                    String tenLoaiPhong = (loaiPhong != null) ? loaiPhong.getTenLoaiPhong() : "Không rõ";
                    model.addRow(new Object[]{
                        item.getSoPhong(),
                        item.getTang(),
                        item.getGiaTien(),
                        tenLoaiPhong,
                        item.getTrangThai(),
                        false
                    });
                }
            }
        } catch (Exception e) {
            XDialog.alert("Lỗi tìm kiếm phòng!");
        }
    }


    void taoPhong() {
        String soPhongStr = txtPSoPhong.getText().trim();
        String tangStr = txtPTang.getText().trim();
        String giaTienStr = txtPGiaThue.getText().trim();
        LoaiPhong loaiPhongChon = (LoaiPhong) cmbPLoaiPhong.getSelectedItem();

        StringBuilder err = new StringBuilder();

        if (soPhongStr.isEmpty()) {
            err.append("Vui lòng không để trống số phòng.\n");
        } else {
            try {
                Integer.parseInt(soPhongStr);
            } catch (NumberFormatException e) {
                err.append("Số phòng phải là một số hợp lệ.\n");
            }
        }

        if (tangStr.isEmpty()) {
            err.append("Vui lòng không để trống tầng.\n");
        } else {
            try {
                Integer.parseInt(tangStr);
            } catch (NumberFormatException e) {
                err.append("Tầng phải là một số hợp lệ.\n");
            }
        }

        if (giaTienStr.isEmpty()) {
            err.append("Vui lòng không để trống giá thuê.\n");
        } else {
            try {
                Double.parseDouble(giaTienStr);
            } catch (NumberFormatException e) {
                err.append("Giá thuê phải là một số hợp lệ.\n");
            }
        }

        if (loaiPhongChon == null) {
             err.append("Vui lòng chọn loại phòng.\n");
        }

        if (cboPTrangThai.getSelection() == null) {
            err.append("Vui lòng chọn trạng thái phòng.\n");
        }

        if (err.length() > 0) {
            XDialog.alert(err.toString());
            return;
        }

        Phong newPhong = this.layPhong();
        try {
            Phongdao.create(newPhong);
            this.laytblPhong();
            this.lamMPhong();
            XDialog.alert("Tạo mới phòng thành công!");
        } catch (Exception e) {
            XDialog.alert("Tạo mới phòng thất bại!");
            e.printStackTrace();
        }
    }
    
     /**
     * ==============================================================================================================================
     * ==================================================== Nhan Vien ==============================================================
     * ==============================================================================================================================
     */
    
    private String selectedLocalImagePath = null; // Lưu đường dẫn tạm thời của ảnh đã chọn từ máy tính
    private NguoiDungDao NVdao = new NguoiDungDaoImpl();
    private List<NguoiDung> NVitems;
    private DefaultTableModel modelNV;
    private boolean isClearingForm = false;
    
    String folder = "images";
    Consumer<File> fileChanged;

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
    
    public void setIcon(String icon) {
        NVAnh.setText("");
        NVAnh.setToolTipText(icon);
        XIcon.setIcon(NVAnh, new File(this.folder, icon));
    }
     
    public String getIcon() {
        return NVAnh.getToolTipText();
    }
    
    public NguoiDung layNguoiDung(){
        NguoiDung entity = new NguoiDung.Builder()
                .username(txtNVTenDangNhap.getText())
                .hoVaTen(txtNVHoVaTen.getText())
                .matKhau(txtNVMatKhau.getText())
                .sdt(txtNVSDT.getText())
                .build();
        
        // Đặt vai trò
        if (rdoNVQuanLy.isSelected()) {
            entity.setVaiTro("Quản lý");
        } else if (rdoNVTiepTan.isSelected()) {
            entity.setVaiTro("Tiếp tân");
        } else if (rdoNVDichVu.isSelected()) {
            entity.setVaiTro("Dịch vụ");
        }

        // Đặt trạng thái
        entity.setTrangThai(rdoNVHoatDong.isSelected());
        
        // Tên ảnh sẽ được đặt sau khi tạo hoặc cập nhật, không lấy trực tiếp từ tooltip
        // Do DAO sẽ tự generate key hoặc sử dụng key đã có
        
        return entity;
    }
    
    void taoNguoiDung(){
        // Thêm kiểm tra này ở đầu phương thức
        if (isClearingForm) { 
            return; // Nếu form đang được xóa, không thực hiện xác thực lại
        }

        NguoiDung newNguoiDung = this.layNguoiDung();
        StringBuilder err = new StringBuilder();

        // Phần xác thực dữ liệu (không thay đổi)
        if(newNguoiDung.getUsername().isEmpty()){
            err.append("Tên đăng nhập không được để trống.\n");
        }
        if(newNguoiDung.getMatKhau().isEmpty()){
            err.append("Mật khẩu không được để trống.\n");
        }
        if(newNguoiDung.getHoVaTen().isEmpty()){
            err.append("Họ và tên không được để trống.\n");
        }
        if(newNguoiDung.getSdt().isEmpty()){
            err.append("Số điện thoại không được để trống.\n");
        } else if (!newNguoiDung.getSdt().matches("\\d+")) {
            err.append("Số điện thoại chỉ được chứa ký tự số.\n");
        }
        if(newNguoiDung.getVaiTro() == null || newNguoiDung.getVaiTro().isEmpty()){
            err.append("Vui lòng chọn vai trò.\n");
        }
        
        if (err.length() > 0) {
            // Đây là thông báo lỗi mà bạn thấy, nó sẽ không xuất hiện
            // nếu isClearingForm là true và phương thức được gọi lại không mong muốn.
            JOptionPane.showMessageDialog(this, err.toString()); 
            return; 
        }

        try {
            // Kiểm tra trùng tên đăng nhập (không thay đổi)
            NguoiDung existingUser = NVdao.findById(newNguoiDung.getUsername());
            if (existingUser != null) {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại!");
                return;
            }
            
            // Xử lý tạo mới người dùng và sao chép ảnh (không thay đổi)
            newNguoiDung.setAnh(null); 
            newNguoiDung = NVdao.create(newNguoiDung); 

            if (selectedLocalImagePath != null && newNguoiDung.getAnh() != null && !newNguoiDung.getAnh().isEmpty()) {
                try {
                    Path source = Paths.get(selectedLocalImagePath);
                    Path destination = Paths.get(this.folder, newNguoiDung.getAnh());
                    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi sao chép ảnh: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            // Làm mới bảng và xóa form trước khi thông báo thành công
            this.laytblNhanVien(); 
            this.lamMNguoiDung(); 
            JOptionPane.showMessageDialog(this, "Tạo người dùng thành công!"); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tạo người dùng thất bại! Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void laytblNhanVien(){
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        try {
            NVitems = NVdao.findAll();
            for (NguoiDung item : NVitems) {
                Object[] rowData = {
                    item.getUsername(),
                    item.getHoVaTen(),
                    item.getMatKhau(),
                    item.getSdt(),
                    item.getVaiTro(),
                    item.isTrangThai() ? "Hoạt Động" : "Tạm Dừng",
                    false
                };
                model.addRow(rowData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu nhân viên!"); // Sử dụng JOptionPane
            e.printStackTrace();
        }
    }

     void lamMNguoiDung(){
        isClearingForm = true; // Bắt đầu quá trình xóa form
        txtNVTenDangNhap.setText("");
        txtNVMatKhau.setText("");
        txtNVHoVaTen.setText("");
        txtNVSDT.setText("");
        cboNVVaitro.clearSelection();
        cboNVTrangThai.clearSelection();
        
        // Đặt ảnh về logo mặc định
        XIcon.setIcon(NVAnh, "/Icon/Logo.png");
        NVAnh.setToolTipText("Logo.png"); // Reset tooltip
        
        selectedLocalImagePath = null; // Xóa đường dẫn ảnh tạm
        
        bntNVTaoMoi.setEnabled(true);
        bntNVSua.setEnabled(false);
        bntNVXoa.setEnabled(false);
        txtNVTenDangNhap.setEditable(true); // Cho phép sửa Username khi thêm mới
        isClearingForm = false; // Kết thúc quá trình xóa form
    }
    
    void suaNguoiDung() {
        try {
            int selectedIndex = tblNV.getSelectedRow();
            if (selectedIndex >= 0) {
                NguoiDung entity = NVitems.get(selectedIndex);
                this.setFromNV(entity);
                this.suatblNV(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi chọn nhân viên để sửa!");
            e.printStackTrace();
        }
    }

    void setFromNV(NguoiDung entity) {
        txtNVTenDangNhap.setText(entity.getUsername());
        txtNVMatKhau.setText(entity.getMatKhau());
        txtNVHoVaTen.setText(entity.getHoVaTen());
        txtNVSDT.setText(entity.getSdt());

        // Xử lý tải ảnh:
        String imageFileNameFromDB = entity.getAnh();
        if (imageFileNameFromDB != null && !imageFileNameFromDB.isEmpty()) {
            // Hiển thị ảnh từ thư mục 'images' dựa vào tên file từ DB
            XIcon.setIcon(NVAnh, new File(this.folder, imageFileNameFromDB)); 
            NVAnh.setToolTipText(imageFileNameFromDB); // Đặt tooltip thành tên tệp thực tế
        } else {
            // Trường hợp không có ảnh: đặt ảnh mặc định
            XIcon.setIcon(NVAnh, "/Icon/Logo.png"); 
            NVAnh.setToolTipText("Logo.png"); 
        }

        // Đặt các nút radio cho Vai Trò
        if ("Quản lý".equals(entity.getVaiTro())) {
            rdoNVQuanLy.setSelected(true);
        } else if ("Tiếp tân".equals(entity.getVaiTro())) {
            rdoNVTiepTan.setSelected(true);
        } else if ("Dịch vụ".equals(entity.getVaiTro())) {
            rdoNVDichVu.setSelected(true);
        } else {
            cboNVVaitro.clearSelection();
        }

        // Đặt các nút radio cho Trạng Thái
        if (entity.isTrangThai()) {
            rdoNVHoatDong.setSelected(true);
        } else {
            rdoNVTamDung.setSelected(true);
        }
        
        txtNVTenDangNhap.setEditable(false); // Không cho phép sửa Username khi chỉnh sửa
        selectedLocalImagePath = null; // Đảm bảo reset khi tải user mới lên form
    }

    void suatblNV(boolean suaNV){
        bntNVSua.setEnabled(suaNV);
        bntNVXoa.setEnabled(suaNV);
        bntNVTaoMoi.setEnabled(!suaNV);
    }
    
    void capNguoiDung(){
        NguoiDung updatedNguoiDung = this.layNguoiDung();
        // Lấy username của người dùng đang được chỉnh sửa
        String currentUsername = txtNVTenDangNhap.getText(); 
        updatedNguoiDung.setUsername(currentUsername); // Đảm bảo cập nhật đúng người dùng

        // Lấy thông tin người dùng gốc từ DB để giữ lại tên ảnh cũ nếu không chọn ảnh mới
        NguoiDung originalUser = NVdao.findById(currentUsername);
        String oldImageFileName = (originalUser != null) ? originalUser.getAnh() : null;

        try {
            // Nếu có ảnh mới được chọn từ máy tính
            if (selectedLocalImagePath != null) {
                String fileNameToSave = XStr.getKey() + ".jpg"; // Tạo tên file mới
                updatedNguoiDung.setAnh(fileNameToSave); // Gán tên ảnh mới cho đối tượng cập nhật

                // Sao chép ảnh mới vào thư mục
                Path source = Paths.get(selectedLocalImagePath);
                Path destination = Paths.get(this.folder, fileNameToSave);
                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                selectedLocalImagePath = null; // Reset đường dẫn tạm thời sau khi lưu
            } else {
                // Nếu không chọn ảnh mới, giữ nguyên tên ảnh cũ từ DB
                updatedNguoiDung.setAnh(oldImageFileName);
            }

            NVdao.update(updatedNguoiDung);
            this.laytblNhanVien();
            this.lamMNguoiDung();
            JOptionPane.showMessageDialog(this, "Cập nhật người dùng thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật người dùng thất bại! Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    void xoaNguoiDung(){
        int selectedIndex = tblNV.getSelectedRow();
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn người dùng cần xóa!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa người dùng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String username = (String) tblNV.getValueAt(selectedIndex, 0);
            try {
                // Lấy thông tin người dùng để tìm tên ảnh và xóa ảnh vật lý
                NguoiDung ndToDelete = NVdao.findById(username);
                
                // Gọi DAO để xóa người dùng. Logic xóa DatPhong liên quan đã có trong NguoiDungDaoImpl
                NVdao.deleteById(username); //

                // Xóa ảnh vật lý sau khi xóa thành công trong DB
                if (ndToDelete != null && ndToDelete.getAnh() != null && !ndToDelete.getAnh().isEmpty()) {
                    Path imagePath = Paths.get(this.folder, ndToDelete.getAnh());
                    if (Files.exists(imagePath)) {
                        Files.delete(imagePath);
                    }
                }
                
                this.laytblNhanVien();
                this.lamMNguoiDung();
                JOptionPane.showMessageDialog(this, "Xóa người dùng thành công!");
            } catch (Exception e) {
                // Log lỗi chi tiết để debug
                Logger.getLogger(TrangChuQLJFarme.class.getName()).log(Level.SEVERE, "Lỗi khi xóa người dùng: " + username, e);
                
                // Hiển thị thông báo lỗi rõ ràng hơn cho người dùng
                String errorMessage = "Xóa người dùng thất bại! ";
                if (e.getMessage() != null && e.getMessage().contains("REFERENCE constraint")) {
                    errorMessage += "Không thể xóa người dùng này vì có các dữ liệu khác đang tham chiếu đến (ví dụ: các đơn đặt phòng). Vui lòng xóa các dữ liệu liên quan trước.";
                } else {
                    errorMessage += "Lỗi: " + e.getMessage();
                }
                JOptionPane.showMessageDialog(this, errorMessage, "Lỗi Xóa", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    void xoaMDCNguoiDung() {
        int countSelected = 0;
        for (int i = 0; i < tblNV.getRowCount(); i++) {
            Boolean isSelected = (Boolean) tblNV.getValueAt(i, 6);
            if (isSelected != null && isSelected) {
                countSelected++;
            }
        }

        if (countSelected == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một người dùng để xóa.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa " + countSelected + " người dùng đã chọn?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int successCount = 0;
            int failCount = 0;
            StringBuilder errorMessages = new StringBuilder("Xóa các mục đã chọn thất bại:\n");

            for (int i = 0; i < tblNV.getRowCount(); i++) {
                Boolean isSelected = (Boolean) tblNV.getValueAt(i, 6);
                if (isSelected != null && isSelected) {
                    String username = (String) tblNV.getValueAt(i, 0);
                    try {
                        NguoiDung ndToDelete = NVdao.findById(username);
                        
                        // Gọi DAO để xóa người dùng. Logic xóa DatPhong liên quan đã có trong NguoiDungDaoImpl
                        NVdao.deleteById(username); //

                        // Xóa ảnh vật lý sau khi xóa thành công trong DB
                        if (ndToDelete != null && ndToDelete.getAnh() != null && !ndToDelete.getAnh().isEmpty()) {
                            Path imagePath = Paths.get(this.folder, ndToDelete.getAnh());
                            if (Files.exists(imagePath)) {
                                Files.delete(imagePath);
                            }
                        }
                        successCount++;
                    } catch (Exception e) {
                        failCount++;
                        errorMessages.append("- Người dùng ").append(username).append(": ").append(e.getMessage()).append("\n");
                        Logger.getLogger(TrangChuQLJFarme.class.getName()).log(Level.SEVERE, "Lỗi khi xóa người dùng: " + username, e);
                    }
                }
            }
            this.laytblNhanVien();
            this.lamMNguoiDung();

            if (failCount == 0) {
                JOptionPane.showMessageDialog(this, "Đã xóa thành công " + successCount + " người dùng.");
            } else {
                JOptionPane.showMessageDialog(this, errorMessages.toString(), "Lỗi Xóa", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    void timKiemNguoiDung() {
        String keyword = txtNVTimKiem.getText().trim();
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0); // Clear table
        try {
            // Lấy tất cả và lọc bằng tay
            List<NguoiDung> list = NVdao.findAll(); 
            for (NguoiDung nd : list) {
                if (nd.getUsername().toLowerCase().contains(keyword.toLowerCase()) ||
                    nd.getHoVaTen().toLowerCase().contains(keyword.toLowerCase()) ||
                    nd.getSdt().contains(keyword) ||
                    (nd.getVaiTro() != null && nd.getVaiTro().toLowerCase().contains(keyword.toLowerCase()))) {
                    Object[] rowData = {
                        nd.getUsername(),
                        nd.getHoVaTen(),
                        nd.getMatKhau(),
                        nd.getSdt(),
                        nd.getVaiTro(),
                        nd.isTrangThai() ? "Hoạt Động" : "Tạm Dừng",
                        false
                    };
                    model.addRow(rowData);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    void chonAnhNV(){
        if(ChonAnh.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File selectedFile = ChonAnh.getSelectedFile();
            selectedLocalImagePath = selectedFile.getAbsolutePath(); // Lưu đường dẫn tuyệt đối của ảnh đã chọn

            // Hiển thị ảnh tạm thời lên JLabel để người dùng xem trước
            try {
                ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                Image image = imageIcon.getImage();
                // Scale ảnh để vừa với JLabel
                Image scaledImage = image.getScaledInstance(NVAnh.getWidth(), NVAnh.getHeight(), Image.SCALE_SMOOTH);
                NVAnh.setIcon(new ImageIcon(scaledImage));
                NVAnh.setToolTipText(selectedFile.getName()); // Tooltip hiển thị tên file
            } catch (Exception e) {
                NVAnh.setIcon(null);
                NVAnh.setText("Lỗi tải ảnh");
                selectedLocalImagePath = null; // Reset nếu có lỗi
                e.printStackTrace(); // In lỗi để debug
            }
        }
    }
    
    /**
     * ==============================================================================================================================
     * ==================================================== Doanh Thu ==============================================================
     * ==============================================================================================================================
     */
    
    ChiTietThuePhongDao ChiTietThuePhongDao = new ChiTietThuePhongDaoImpl();
    private PhongDaoImpl phongDao;
    
    void fillTablePhong() {
        DefaultTableModel model = (DefaultTableModel) tblDTPhong.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

        ChiTietThuePhongDao chiTietThuePhongDao = new ChiTietThuePhongDaoImpl();
        // Lấy từ khóa tìm kiếm từ txtDTPTimKiem và chuyển sang chữ thường để tìm kiếm không phân biệt chữ hoa/thường
        String soPhongKeyword = txtDTPTimKiem.getText().trim().toLowerCase(); 
        
        try {
            List<Phong> allRooms = phongDao.findAll(); // Lấy tất cả các phòng
            List<ChiTietThuePhong> allChiTietThuePhong = chiTietThuePhongDao.findAll(); // Lấy tất cả chi tiết thuê phòng

            // Tạo các Map để lưu trữ dữ liệu tổng hợp (doanh thu và số ngày thuê)
            java.util.Map<Integer, Double> roomRevenueMap = new java.util.HashMap<>();
            java.util.Map<Integer, Long> roomRentedDaysMap = new java.util.HashMap<>();

            // Khởi tạo các Map với giá trị 0 cho tất cả các phòng
            for (Phong room : allRooms) {
                roomRevenueMap.put(room.getId(), 0.0);
                roomRentedDaysMap.put(room.getId(), 0L);
            }

            // Lặp qua tất cả các chi tiết thuê phòng để tính toán doanh thu và số ngày thuê
            for (ChiTietThuePhong chiTiet : allChiTietThuePhong) {
                Phong rentedRoom = phongDao.findById(chiTiet.getIdPhong()); // Tìm phòng tương ứng với chi tiết thuê
                if (rentedRoom != null) {
                    Date checkIn = chiTiet.getThoiGianNhanPhong();
                    Date checkOut = chiTiet.getThoiGianTraPhong();

                    if (checkIn != null && checkOut != null) {
                        // Tính toán số ngày thuê dựa trên ngày lịch (coi mỗi ngày có hoạt động là 1 ngày)
                        Date checkInOnlyDate = Util.XDate.removeTime(checkIn);
                        Date checkOutOnlyDate = Util.XDate.removeTime(checkOut);
                        
                        long diffMillisAdjusted = checkOutOnlyDate.getTime() - checkInOnlyDate.getTime();
                        long days = TimeUnit.DAYS.convert(diffMillisAdjusted, TimeUnit.MILLISECONDS);
                        
                        // Nếu thuê trong cùng một ngày lịch, tính là 1 ngày.
                        // Nếu thuê qua nhiều ngày, cộng thêm 1 để tính cả ngày nhận phòng.
                        if (days == 0 && diffMillisAdjusted >= 0) {
                            days = 1;
                        } else if (days > 0) {
                            days = days + 1;
                        } else { // Trường hợp không hợp lệ (ví dụ: ngày trả trước ngày nhận)
                            days = 0;
                        }

                        // Tính doanh thu cho phần thuê này
                        double segmentRevenue = rentedRoom.getGiaTien().doubleValue() * days;

                        // Cộng dồn vào tổng doanh thu và số ngày thuê của phòng
                        roomRentedDaysMap.put(rentedRoom.getId(), roomRentedDaysMap.getOrDefault(rentedRoom.getId(), 0L) + days);
                        roomRevenueMap.put(rentedRoom.getId(), roomRevenueMap.getOrDefault(rentedRoom.getId(), 0.0) + segmentRevenue);
                    }
                }
            }

            // Điền dữ liệu tổng hợp vào bảng, áp dụng bộ lọc tìm kiếm
            for (Phong room : allRooms) {
                // Kiểm tra nếu số phòng chứa từ khóa tìm kiếm (không phân biệt chữ hoa/thường)
                if (room.getSoPhong().toLowerCase().contains(soPhongKeyword)) {
                    Object[] row = {
                        room.getSoPhong(),
                        roomRevenueMap.get(room.getId()),
                        roomRentedDaysMap.get(room.getId())
                    };
                    model.addRow(row);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Util.XDialog.alert("Lỗi khi tải dữ liệu doanh thu phòng.");
        }
    }
    
    void fillTableDTTiepTan() {
        DefaultTableModel model = (DefaultTableModel) tblDTTiepTan.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

        HoaDonDao hoaDonDao = new HoaDonDaoImpl();
        NguoiDungDao nguoiDungDao = new NguoiDungDaoImpl();

        // Lấy từ khóa tìm kiếm từ txtDTTTTimKiem và chuyển sang chữ thường
        String receptionistKeyword = txtDTTTTimKiem.getText().trim().toLowerCase(); 

        try {
            List<HoaDon> allHoaDon = hoaDonDao.findAll(); // Lấy tất cả các hóa đơn
            List<NguoiDung> allNguoiDung = nguoiDungDao.findAll(); // Lấy tất cả người dùng

            // Các Map để tổng hợp dữ liệu theo tên đăng nhập của nhân viên
            java.util.Map<String, Double> revenueByReceptionist = new java.util.HashMap<>();
            java.util.Map<String, Long> invoiceCountByReceptionist = new java.util.HashMap<>();
            java.util.Map<String, Integer> firstInvoiceIdByReceptionist = new java.util.HashMap<>();
            java.util.Map<String, Integer> lastInvoiceIdByReceptionist = new java.util.HashMap<>();

            // Khởi tạo các Map với giá trị mặc định cho tất cả các nhân viên có vai trò "Tiếp tân"
            for (NguoiDung nd : allNguoiDung) {
                if ("Tiếp tân".equalsIgnoreCase(nd.getVaiTro())) { 
                    revenueByReceptionist.put(nd.getUsername(), 0.0);
                    invoiceCountByReceptionist.put(nd.getUsername(), 0L);
                    firstInvoiceIdByReceptionist.put(nd.getUsername(), Integer.MAX_VALUE); // Dùng MAX_VALUE để tìm số nhỏ nhất
                    lastInvoiceIdByReceptionist.put(nd.getUsername(), Integer.MIN_VALUE); // Dùng MIN_VALUE để tìm số lớn nhất
                }
            }

            // Tổng hợp dữ liệu từ các hóa đơn
            for (HoaDon hd : allHoaDon) {
                String username = hd.getIdNguoiDungLap();
                // Kiểm tra nếu người dùng này là một tiếp tân và có trong danh sách đã khởi tạo
                if (revenueByReceptionist.containsKey(username)) {
                    // Tổng hợp doanh thu
                    revenueByReceptionist.put(username, revenueByReceptionist.get(username) + hd.getTongTien());
                    // Tổng hợp số hóa đơn
                    invoiceCountByReceptionist.put(username, invoiceCountByReceptionist.get(username) + 1);
                    // Cập nhật ID hóa đơn đầu và cuối
                    firstInvoiceIdByReceptionist.put(username, Math.min(firstInvoiceIdByReceptionist.get(username), hd.getId()));
                    lastInvoiceIdByReceptionist.put(username, Math.max(lastInvoiceIdByReceptionist.get(username), hd.getId()));
                }
            }

            // Điền dữ liệu tổng hợp vào bảng, áp dụng bộ lọc tìm kiếm
            for (NguoiDung nd : allNguoiDung) {
                if ("Tiếp tân".equalsIgnoreCase(nd.getVaiTro())) { // Chỉ hiển thị nhân viên tiếp tân
                    // Áp dụng bộ lọc tìm kiếm theo Họ và Tên của nhân viên
                    if (nd.getHoVaTen().toLowerCase().contains(receptionistKeyword)) {
                        Double totalRevenue = revenueByReceptionist.getOrDefault(nd.getUsername(), 0.0);
                        Long totalInvoices = invoiceCountByReceptionist.getOrDefault(nd.getUsername(), 0L);
                        Integer firstInvoice = firstInvoiceIdByReceptionist.get(nd.getUsername());
                        Integer lastInvoice = lastInvoiceIdByReceptionist.get(nd.getUsername());

                        // Xử lý trường hợp nhân viên không có hóa đơn nào
                        String displayFirstInvoice = (firstInvoice == Integer.MAX_VALUE) ? "N/A" : String.valueOf(firstInvoice);
                        String displayLastInvoice = (lastInvoice == Integer.MIN_VALUE) ? "N/A" : String.valueOf(lastInvoice);

                        Object[] row = {
                            nd.getHoVaTen(),          // Tên Nhân Viên
                            totalRevenue,             // Doanh Thu
                            totalInvoices,            // Số Hóa Đơn
                            displayFirstInvoice,      // Hóa Đơn Đầu
                            displayLastInvoice        // Hóa Đơn Cuối
                        };
                        model.addRow(row);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // In lỗi để gỡ lỗi
            Util.XDialog.alert("Lỗi khi tải dữ liệu doanh thu theo tiếp tân.");
        }
    }
    
    /**
     * ==============================================================================================================================
     * ==================================================== QL DichVu ==============================================================
     * ==============================================================================================================================
     */
    
    private Dao.dao.DichVuDao DVdao = new Dao.daoimpl.DichVuDaoImpl();
    List<Dao.entity.DichVu> DichVuitems;
    
    public Dao.entity.DichVu layDichVu() {
        Dao.entity.DichVu entity = new Dao.entity.DichVu();
        entity.setTenDichVu(txtDVTen.getText().trim()); // Lấy tên dịch vụ và loại bỏ khoảng trắng thừa
        try {
            entity.setDonGia(Double.parseDouble(txtDVGia.getText().trim())); // Lấy giá tiền
        } catch (NumberFormatException e) {
            // Sẽ được xử lý bởi phần kiểm tra hợp lệ trong taoDichVu()
        }
        return entity;
    }
    
    void lamMDichVu() {
        txtDVTen.setText("");
        txtDVGia.setText("");
        // Đặt lại trạng thái của các nút
        bntDVTaoMoi.setEnabled(true); // Cho phép tạo mới
        bntDVSua.setEnabled(false);   // Vô hiệu hóa sửa
        bntDVXoa.setEnabled(false);   // Vô hiệu hóa xóa
        laytblDichVu(); // Tải lại bảng dịch vụ để hiển thị dữ liệu mới nhất
    }
    

    void laytblDichVu() {
        DefaultTableModel model = (DefaultTableModel) tblDV.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có

        // Lấy từ khóa tìm kiếm từ txtDVTimKiem và chuyển sang chữ thường để tìm kiếm không phân biệt chữ hoa/thường
        String tenDichVuKeyword = txtDVTimKiem.getText().trim().toLowerCase(); 

        try {
            DichVuitems = DVdao.findAll(); // Lấy tất cả dịch vụ
            for (Dao.entity.DichVu dv : DichVuitems) {
                // Áp dụng bộ lọc tìm kiếm: kiểm tra xem tên dịch vụ có chứa từ khóa không
                if (dv.getTenDichVu().toLowerCase().contains(tenDichVuKeyword)) {
                    model.addRow(new Object[]{
                        dv.getId(),
                        dv.getTenDichVu(),
                        dv.getDonGia(),
                        false // Cột "Chọn" cho các chức năng xóa nhiều
                    });
                }
            }
        } catch (Exception e) {
            Util.XDialog.alert("Lỗi khi tải dữ liệu dịch vụ!");
            e.printStackTrace();
        }
    }
    
    void taoDichVu() {
        Dao.entity.DichVu newDichVu = layDichVu();
        StringBuilder errors = new StringBuilder();

        // Kiểm tra hợp lệ dữ liệu nhập vào
        if (newDichVu.getTenDichVu().isEmpty()) {
            errors.append("Tên dịch vụ không được để trống.\n");
        }
        if (txtDVGia.getText().trim().isEmpty()) {
            errors.append("Giá tiền không được để trống.\n");
        } else {
            try {
                double gia = Double.parseDouble(txtDVGia.getText().trim());
                if (gia < 0) {
                    errors.append("Giá tiền phải là số dương.\n");
                }
            } catch (NumberFormatException e) {
                errors.append("Giá tiền phải là một số hợp lệ.\n");
            }
        }

        if (errors.length() > 0) {
            Util.XDialog.alert(errors.toString());
            return;
        }

        try {
            // Kiểm tra trùng lặp tên dịch vụ (nếu cần)
            List<Dao.entity.DichVu> existingServices = DVdao.findAll();
            for (Dao.entity.DichVu dv : existingServices) {
                if (dv.getTenDichVu().equalsIgnoreCase(newDichVu.getTenDichVu())) {
                    Util.XDialog.alert("Tên dịch vụ đã tồn tại. Vui lòng chọn tên khác.");
                    return;
                }
            }

            DVdao.create(newDichVu); // Gọi DAO để thêm dịch vụ vào DB
            Util.XDialog.alert("Thêm dịch vụ mới thành công!");
            lamMDichVu(); // Làm mới form và bảng sau khi thêm thành công
        } catch (Exception e) {
            Util.XDialog.alert("Thêm dịch vụ mới thất bại! Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    void setFromDV(Dao.entity.DichVu entity) {
        txtDVTen.setText(entity.getTenDichVu());
        txtDVGia.setText(String.valueOf(entity.getDonGia()));
        // Trong trường hợp này, Id của dịch vụ không được hiển thị trực tiếp trên form
        // nhưng nó được lưu trữ ngầm trong danh sách DichVuitems và sẽ được truy xuất
        // khi cần cho các chức năng Sửa/Xóa.
    }
    
    void suatblDV(boolean isEditing) {
        bntDVTaoMoi.setEnabled(!isEditing); // Khi sửa/xóa, vô hiệu hóa nút "Tạo Mới"
        bntDVSua.setEnabled(isEditing);     // Khi sửa/xóa, kích hoạt nút "Sửa"
        bntDVXoa.setEnabled(isEditing);     // Khi sửa/xóa, kích hoạt nút "Xóa"
    }
    
    void capNDichVu() {
        int selectedRow = tblDV.getSelectedRow();
        if (selectedRow < 0) {
            Util.XDialog.alert("Vui lòng chọn một dịch vụ để cập nhật.");
            return;
        }

        Dao.entity.DichVu updatedDichVu = layDichVu(); // Lấy dữ liệu cập nhật từ form
        // Lấy dịch vụ gốc từ danh sách để có ID của dịch vụ cần cập nhật
        Dao.entity.DichVu originalDichVu = DichVuitems.get(selectedRow); 
        updatedDichVu.setId(originalDichVu.getId()); // Gán ID cho đối tượng cập nhật

        StringBuilder errors = new StringBuilder();
        // Kiểm tra hợp lệ dữ liệu
        if (updatedDichVu.getTenDichVu().isEmpty()) {
            errors.append("Tên dịch vụ không được để trống.\n");
        }
        if (txtDVGia.getText().trim().isEmpty()) {
            errors.append("Giá tiền không được để trống.\n");
        } else {
            try {
                double gia = Double.parseDouble(txtDVGia.getText().trim());
                if (gia < 0) {
                    errors.append("Giá tiền phải là số dương.\n");
                }
            } catch (NumberFormatException e) {
                errors.append("Giá tiền phải là một số hợp lệ.\n");
            }
        }

        if (errors.length() > 0) {
            Util.XDialog.alert(errors.toString());
            return;
        }

        if (Util.XDialog.confirm("Bạn thực sự muốn cập nhật dịch vụ này?")) {
            try {
                // Kiểm tra tên dịch vụ có bị trùng với dịch vụ khác (không phải dịch vụ đang sửa)
                for (int i = 0; i < DichVuitems.size(); i++) {
                    if (i != selectedRow && DichVuitems.get(i).getTenDichVu().equalsIgnoreCase(updatedDichVu.getTenDichVu())) {
                        Util.XDialog.alert("Tên dịch vụ đã tồn tại cho dịch vụ khác. Vui lòng chọn tên khác.");
                        return;
                    }
                }

                DVdao.update(updatedDichVu); // Gọi DAO để cập nhật
                Util.XDialog.alert("Cập nhật dịch vụ thành công!");
                lamMDichVu(); // Làm mới bảng và form
            } catch (Exception e) {
                Util.XDialog.alert("Cập nhật dịch vụ thất bại! Lỗi: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    void xoaDichVu() {
        int selectedRow = tblDV.getSelectedRow();
        if (selectedRow < 0) {
            Util.XDialog.alert("Vui lòng chọn một dịch vụ để xóa.");
            return;
        }

        if (Util.XDialog.confirm("Bạn thực sự muốn xóa dịch vụ này?")) {
            try {
                int serviceIdToDelete = DichVuitems.get(selectedRow).getId();
                DVdao.deleteById(serviceIdToDelete); // Lệnh này có thể gây ra RuntimeException
                Util.XDialog.alert("Xóa dịch vụ thành công!");
                lamMDichVu(); // Làm mới bảng và form
            } catch (RuntimeException e) {
                Throwable cause = e.getCause(); // Lấy ngoại lệ gốc
                if (cause instanceof SQLServerException sqlEx) {
                    // Kiểm tra mã lỗi SQL Server cho lỗi ràng buộc khóa ngoại (thường là 547)
                    if (sqlEx.getErrorCode() == 547) {
                        Util.XDialog.alert("Không thể xóa dịch vụ này vì nó đã được sử dụng trong các hóa đơn hoặc chi tiết dịch vụ khác.", "Lỗi Xóa Dịch Vụ");
                    } else {
                        // Các lỗi SQL khác
                        Util.XDialog.alert("Xóa dịch vụ thất bại! Lỗi cơ sở dữ liệu: " + sqlEx.getMessage(), "Lỗi Xóa Dịch Vụ");
                        sqlEx.printStackTrace(); // In stack trace để gỡ lỗi chi tiết
                    }
                } else {
                    // Các loại RuntimeException khác
                    Util.XDialog.alert("Xóa dịch vụ thất bại! Lỗi không xác định: " + e.getMessage(), "Lỗi Xóa Dịch Vụ");
                    e.printStackTrace(); // In stack trace để gỡ lỗi chi tiết
                }
            }
        }
}

    // Phương thức để xóa nhiều dịch vụ đã chọn
    void xoaMDCDichVu() {
        int countSelected = 0;
        for (int i = 0; i < tblDV.getRowCount(); i++) {
            Boolean isSelected = (Boolean) tblDV.getValueAt(i, 3); // Cột thứ 3 là checkbox "Chọn"
            if (isSelected != null && isSelected) {
                countSelected++;
            }
        }

        if (countSelected == 0) {
            Util.XDialog.alert("Vui lòng chọn ít nhất một dịch vụ để xóa.");
            return;
        }

        if (Util.XDialog.confirm("Bạn có chắc muốn xóa " + countSelected + " dịch vụ đã chọn?")) {
            int successCount = 0;
            int failCount = 0;
            StringBuilder errorMessages = new StringBuilder("Các dịch vụ sau không thể xóa được:\n"); // Thay đổi thông báo cho rõ ràng hơn

            // Lặp ngược để tránh lỗi chỉ số hàng khi xóa
            for (int i = tblDV.getRowCount() - 1; i >= 0; i--) {
                Boolean isSelected = (Boolean) tblDV.getValueAt(i, 3); // Cột "Chọn"
                if (isSelected != null && isSelected) {
                    try {
                        int serviceIdToDelete = DichVuitems.get(i).getId(); // Lấy ID dịch vụ từ danh sách
                        DVdao.deleteById(serviceIdToDelete); // Lệnh này có thể gây ra RuntimeException
                        successCount++;
                    } catch (RuntimeException e) {
                        failCount++;
                        String serviceName = (String) tblDV.getValueAt(i, 1); // Lấy tên dịch vụ
                        Throwable cause = e.getCause(); // Lấy ngoại lệ gốc
                        if (cause instanceof SQLServerException sqlEx) {
                            if (sqlEx.getErrorCode() == 547) {
                                errorMessages.append("- '").append(serviceName).append("': Đã được sử dụng trong các hóa đơn.\n");
                            } else {
                                errorMessages.append("- '").append(serviceName).append("': Lỗi cơ sở dữ liệu: ").append(sqlEx.getMessage()).append("\n");
                            }
                        } else {
                            errorMessages.append("- '").append(serviceName).append("': Lỗi không xác định: ").append(e.getMessage()).append("\n");
                        }
                        e.printStackTrace(); // In stack trace để gỡ lỗi chi tiết
                    }
                }
            }

            lamMDichVu(); // Làm mới bảng và form sau khi xóa

            if (successCount > 0) {
                Util.XDialog.alert("Đã xóa thành công " + successCount + " dịch vụ.");
            }
            if (failCount > 0) {
                Util.XDialog.alert(errorMessages.toString(), "Lỗi Xóa Dịch Vụ"); // Sử dụng tiêu đề cụ thể cho thông báo lỗi
            }
        }
    }
    
    /**
     * ==============================================================================================================================
     * ==================================================== Dang Xuat ==============================================================
     * ==============================================================================================================================
     */

    void DX(){
        this.dispose();
        this.showDX(this);
    }
}