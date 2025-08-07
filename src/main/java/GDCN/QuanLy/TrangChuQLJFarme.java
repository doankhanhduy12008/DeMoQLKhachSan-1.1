package GDCN.QuanLy;
import Dao.dao.ChiTietThuePhongDao;
import Dao.dao.HoaDonDao;
import Dao.dao.KhachHangDao;
import Dao.dao.LoaiPhongDao;
import Dao.dao.NguoiDungDao;
import Dao.dao.PhongDao;
import Dao.daoimpl.ChiTietThuePhongDaoImpl;
import Dao.daoimpl.HoaDonDaoImpl;
import Dao.daoimpl.KhachHangDaoImpl;
import Dao.daoimpl.LoaiPhongDaoImpl;
import Dao.daoimpl.NguoiDungDaoImpl;
import Dao.daoimpl.PhongDaoImpl;
import Dao.entity.ChiTietThuePhong;
import Dao.entity.HoaDon;
import Dao.entity.KhachHang;
import Dao.entity.LoaiPhong;
import Dao.entity.NguoiDung;
import Dao.entity.Phong;
import GDCN.Chung.ChonTG;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.PatternSyntaxException;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public final class TrangChuQLJFarme extends javax.swing.JFrame implements TrangChuQLController{
    private TableRowSorter<DefaultTableModel> sorter;
    private TableRowSorter<DefaultTableModel> sorterLP;
    private TableRowSorter<DefaultTableModel> sorterP;
    private TableRowSorter<DefaultTableModel> sorterDV;
    private TableRowSorter<DefaultTableModel> sorterKH;
    public TrangChuQLJFarme(){
        initComponents();
        openFullScreen();
        open();
        pnlChat.setLayout(new java.awt.BorderLayout());
        pnlChat.add(new GDCN.Chat.ChatJPanel()); 
        pnlChat.revalidate();
        pnlChat.repaint();
        pnlChonTG.setLayout(new java.awt.BorderLayout());
        ChonTG chonTGPanel = new GDCN.Chung.ChonTG();
        pnlChonTG.add(chonTGPanel, java.awt.BorderLayout.CENTER);        
        chonTGPanel.setTimeChanged((startDate, endDate) -> {
            fillTablePhong(startDate, endDate);
            fillTableDTTiepTan(startDate, endDate);
        });
        
        pnlChonTG.revalidate();
        pnlChonTG.repaint();
        
        this.phongDao = new PhongDaoImpl();
        
        DefaultTableModel tableModel = (DefaultTableModel) tblNV.getModel();
        sorter = new TableRowSorter<>(tableModel);
        tblNV.setRowSorter(sorter);
        DefaultTableModel tableModelLP = (DefaultTableModel) tblLoaiPhong.getModel();
        sorterLP = new TableRowSorter<>(tableModelLP);
        tblLoaiPhong.setRowSorter(sorterLP);
//        DefaultTableModel tableModelP = (DefaultTableModel) tblPhong.getModel();
//        sorterP = new TableRowSorter<>(tableModelLP);
//        tblPhong.setRowSorter(sorterP);

    }

    
    int chieungang = 1000;
    int chieudai = 52;
    
    private void openFullScreen() {
         // Bỏ viềds (tuỳ chọn)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocationRelativeTo(null); // Đặt giữa, thực ra không quan trọng
    }
    void OpenMenuBar(){
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                
                for (int i=0; i<chieungang; i++){
                    pnlMenuBar.setSize(i,chieudai);
                    try {
                        //mở từ từ
                        Thread.sleep(0);
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
                        Thread.sleep(0);
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
        btnDangXuat = new javax.swing.JLabel();
        btnTroChuyen = new javax.swing.JLabel();
        bntQlKhachhang1 = new javax.swing.JLabel();
        bntQlKhachhang2 = new javax.swing.JLabel();
        NoiDung = new javax.swing.JPanel();
        pnlTrangChu = new javax.swing.JPanel();
        txtTenNV = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Anh = new javax.swing.JLabel();
        bntQLLoaiPhong1 = new javax.swing.JLabel();
        bntQLPhong1 = new javax.swing.JLabel();
        bntQlKhachhang = new javax.swing.JLabel();
        bntQLDoanhThu1 = new javax.swing.JLabel();
        bntQLDichVu1 = new javax.swing.JLabel();
        bntQLNhanVien1 = new javax.swing.JLabel();
        pnlChat = new javax.swing.JPanel();
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
        jLabel11 = new javax.swing.JLabel();
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
        bntNVSua = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        bntNVTimKiem = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        txtNVTimKiem = new javax.swing.JTextField();
        pnlQLDoanhThu = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        pnlChonTG = new javax.swing.JPanel();
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
        pnlQLKhachHang = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtSocmt = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabKhachHang = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        btnSuaKH = new javax.swing.JButton();
        btnLamMoiKH = new javax.swing.JButton();
        btnTaoMoiKH = new javax.swing.JButton();
        btnXoaKH = new javax.swing.JButton();
        txtTimKiemKH = new javax.swing.JTextField();
        bntTimKiemKH = new javax.swing.JButton();
        btnTaoMoiKH1 = new javax.swing.JButton();
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
        pnlTDQLKhachHang = new javax.swing.JPanel();
        txtChoChuyen1 = new javax.swing.JLabel();
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
        pnlMenuBar.setMaximumSize(new java.awt.Dimension(32767, 52));
        pnlMenuBar.setMinimumSize(new java.awt.Dimension(1100, 52));
        pnlMenuBar.setPreferredSize(new java.awt.Dimension(1220, 52));

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
        bntQLLoaiPhong.setText("Loại Phòng");
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
        bntQLPhong.setText("Phòng");
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
        bntQLNhanVien.setText("Nhân Viên");
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
        bntQLDoanhThu.setText("Doanh Thu");
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
        bntQLDichVu.setText("Dịch Vụ");
        bntQLDichVu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQLDichVu.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQLDichVu.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQLDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQLDichVuMouseClicked(evt);
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

        bntQlKhachhang1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQlKhachhang1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQlKhachhang1.setText("Khách Hàng");
        bntQlKhachhang1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQlKhachhang1.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQlKhachhang1.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQlKhachhang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQlKhachhang1MouseClicked(evt);
            }
        });

        bntQlKhachhang2.setBackground(new java.awt.Color(204, 204, 204));
        bntQlKhachhang2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQlKhachhang2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQlKhachhang2.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQlKhachhang2.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQlKhachhang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQlKhachhang2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuBarLayout = new javax.swing.GroupLayout(pnlMenuBar);
        pnlMenuBar.setLayout(pnlMenuBarLayout);
        pnlMenuBarLayout.setHorizontalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bntTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQLLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQLPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQLDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQLDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQlKhachhang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntQlKhachhang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTroChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntDong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        pnlMenuBarLayout.setVerticalGroup(
            pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bntTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntQLLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntQLPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntQLDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntQLDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTroChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntQlKhachhang1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntQlKhachhang2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bntDong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(267, Short.MAX_VALUE)
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

        bntQlKhachhang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntQlKhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bntQlKhachhang.setText("Quản Lý Khách Hàng");
        bntQlKhachhang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntQlKhachhang.setMinimumSize(new java.awt.Dimension(291, 40));
        bntQlKhachhang.setPreferredSize(new java.awt.Dimension(91, 40));
        bntQlKhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntQlKhachhangMouseClicked(evt);
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bntQLNhanVien1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnlChatLayout = new javax.swing.GroupLayout(pnlChat);
        pnlChat.setLayout(pnlChatLayout);
        pnlChatLayout.setHorizontalGroup(
            pnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        pnlChatLayout.setVerticalGroup(
            pnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTrangChuLayout = new javax.swing.GroupLayout(pnlTrangChu);
        pnlTrangChu.setLayout(pnlTrangChuLayout);
        pnlTrangChuLayout.setHorizontalGroup(
            pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrangChuLayout.createSequentialGroup()
                .addGroup(pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTrangChuLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bntQLPhong1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntQLLoaiPhong1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntQlKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bntQLDoanhThu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntQLDichVu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntQLNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTrangChuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTrangChuLayout.setVerticalGroup(
            pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenNV)
                .addGap(33, 33, 33)
                .addGroup(pnlTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntQlKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntQLNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(66, Short.MAX_VALUE))
            .addComponent(pnlChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        txtPGiaThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPGiaThueActionPerformed(evt);
            }
        });

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("VNĐ");

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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtPGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
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
                        .addComponent(txtPGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addContainerGap(148, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntNVSua, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtNVTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntNVTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
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

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1124, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        pnlChonTG.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlChonTGLayout = new javax.swing.GroupLayout(pnlChonTG);
        pnlChonTG.setLayout(pnlChonTGLayout);
        pnlChonTGLayout.setHorizontalGroup(
            pnlChonTGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlChonTGLayout.setVerticalGroup(
            pnlChonTGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane3.addTab("Doanh Thu Theo Tiếp Tân", tabDoanhThu);

        javax.swing.GroupLayout pnlQLDoanhThuLayout = new javax.swing.GroupLayout(pnlQLDoanhThu);
        pnlQLDoanhThu.setLayout(pnlQLDoanhThuLayout);
        pnlQLDoanhThuLayout.setHorizontalGroup(
            pnlQLDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLDoanhThuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlQLDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlChonTG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlQLDoanhThuLayout.setVerticalGroup(
            pnlQLDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLDoanhThuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(pnlQLDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlChonTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
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

        pnlQLKhachHang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Tên Khách Hàng:");

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Số cmt:");

        txtSocmt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSocmt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtSocmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSocmtActionPerformed(evt);
            }
        });

        txtSDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setText("Số điện thoại:");

        tabKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Khách Hàng", "Số cmt", "Số điện thoại", ""
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
        tabKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabKhachHangMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tabKhachHang);

        btnSuaKH.setBackground(new java.awt.Color(204, 204, 204));
        btnSuaKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaKH.setText("Sửa");
        btnSuaKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnSuaKH.setEnabled(false);
        btnSuaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKHActionPerformed(evt);
            }
        });

        btnLamMoiKH.setBackground(new java.awt.Color(204, 204, 204));
        btnLamMoiKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLamMoiKH.setText("Làm mới");
        btnLamMoiKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnLamMoiKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLamMoiKHMouseClicked(evt);
            }
        });
        btnLamMoiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiKHActionPerformed(evt);
            }
        });

        btnTaoMoiKH.setBackground(new java.awt.Color(204, 204, 204));
        btnTaoMoiKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTaoMoiKH.setText("Tạo mới");
        btnTaoMoiKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnTaoMoiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiKHActionPerformed(evt);
            }
        });

        btnXoaKH.setBackground(new java.awt.Color(204, 204, 204));
        btnXoaKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaKH.setText("Xóa");
        btnXoaKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnXoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKHActionPerformed(evt);
            }
        });

        txtTimKiemKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTimKiemKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtTimKiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemKHActionPerformed(evt);
            }
        });

        bntTimKiemKH.setBackground(new java.awt.Color(204, 204, 204));
        bntTimKiemKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bntTimKiemKH.setText("Tìm Kiếm");
        bntTimKiemKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        bntTimKiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntTimKiemKHActionPerformed(evt);
            }
        });

        btnTaoMoiKH1.setBackground(new java.awt.Color(204, 204, 204));
        btnTaoMoiKH1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTaoMoiKH1.setText("Xóa Mục Đã Chọn");
        btnTaoMoiKH1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnTaoMoiKH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiKH1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlQLKhachHangLayout = new javax.swing.GroupLayout(pnlQLKhachHang);
        pnlQLKhachHang.setLayout(pnlQLKhachHangLayout);
        pnlQLKhachHangLayout.setHorizontalGroup(
            pnlQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLKhachHangLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(pnlQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlQLKhachHangLayout.createSequentialGroup()
                        .addComponent(btnSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTaoMoiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator5)
                        .addGroup(pnlQLKhachHangLayout.createSequentialGroup()
                            .addGroup(pnlQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22)
                                .addComponent(jLabel23)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(pnlQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenKH)
                                .addComponent(txtSocmt)
                                .addComponent(txtSDT)))
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                        .addGroup(pnlQLKhachHangLayout.createSequentialGroup()
                            .addComponent(txtTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bntTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnTaoMoiKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlQLKhachHangLayout.setVerticalGroup(
            pnlQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLKhachHangLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtSocmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoMoiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntTimKiemKH, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(txtTimKiemKH))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTaoMoiKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        NoiDung.add(pnlQLKhachHang, "card9");

        TieuDe.setBackground(new java.awt.Color(255, 255, 255));
        TieuDe.setLayout(new java.awt.CardLayout());

        pnlTDTrangChu.setBackground(new java.awt.Color(204, 204, 204));

        txtTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTrangChu.setText("Trang Chủ");

        javax.swing.GroupLayout pnlTDTrangChuLayout = new javax.swing.GroupLayout(pnlTDTrangChu);
        pnlTDTrangChu.setLayout(pnlTDTrangChuLayout);
        pnlTDTrangChuLayout.setHorizontalGroup(
            pnlTDTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTDTrangChuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(txtLoaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
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
            .addComponent(txtPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
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
            .addComponent(txtNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
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
            .addComponent(txtDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
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
            .addComponent(txtDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
        );
        pnlTTQLDichVuLayout.setVerticalGroup(
            pnlTTQLDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTQLDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        TieuDe.add(pnlTTQLDichVu, "card6");

        pnlTDQLKhachHang.setBackground(new java.awt.Color(204, 204, 204));

        txtChoChuyen1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtChoChuyen1.setText("Khách Hàng");

        javax.swing.GroupLayout pnlTDQLKhachHangLayout = new javax.swing.GroupLayout(pnlTDQLKhachHang);
        pnlTDQLKhachHang.setLayout(pnlTDQLKhachHangLayout);
        pnlTDQLKhachHangLayout.setHorizontalGroup(
            pnlTDQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtChoChuyen1, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
        );
        pnlTDQLKhachHangLayout.setVerticalGroup(
            pnlTDQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTDQLKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtChoChuyen1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        TieuDe.add(pnlTDQLKhachHang, "card2");

        pnlTDTroChuyen.setBackground(new java.awt.Color(204, 204, 204));

        txtChoChuyen.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtChoChuyen.setText("Trò Chuyện");

        javax.swing.GroupLayout pnlTDTroChuyenLayout = new javax.swing.GroupLayout(pnlTDTroChuyen);
        pnlTDTroChuyen.setLayout(pnlTDTroChuyenLayout);
        pnlTDTroChuyenLayout.setHorizontalGroup(
            pnlTDTroChuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtChoChuyen, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlMenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(Open, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(NoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Open, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);
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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);
        laytblLoaiphong();
        lamMLoaiPhong();
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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);
        laytblPhong();
        fillLoaiPhongToCbo();
        laytblPhong();
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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);
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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);
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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);
        laytblDichVu();
    }//GEN-LAST:event_bntQLDichVuMouseClicked

    private void bntLPSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLPSuaActionPerformed
        capNLoaiPhong();
        lamMLoaiPhong();
    }//GEN-LAST:event_bntLPSuaActionPerformed

    private void bntLPTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLPTimKiemActionPerformed
        timKiemLoaiPhong();
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

    private void bntDVTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDVTimKiemActionPerformed
        timKiemDichVu();
    }//GEN-LAST:event_bntDVTimKiemActionPerformed

    private void bntLPTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLPTaoMoiActionPerformed
        this.taoLoaiPhong();
    }//GEN-LAST:event_bntLPTaoMoiActionPerformed

    private void tblLoaiPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiPhongMouseClicked
                                    
        if (evt.getClickCount() == 2) {
            int viewRowIndex = tblLoaiPhong.getSelectedRow();
            if (viewRowIndex != -1) {
                // Chuyển đổi chỉ mục hàng của view sang chỉ mục hàng của model
                int modelRowIndex = tblLoaiPhong.convertRowIndexToModel(viewRowIndex);

                // In ra để kiểm tra
                System.out.println("Chỉ mục trên view (LP): " + viewRowIndex);
                System.out.println("Chỉ mục trên model (LP): " + modelRowIndex);

                // Gọi phương thức suaLoaiPhong() với chỉ mục model chính xác
                suaLoaiPhong(modelRowIndex);
            }
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
        txtLPTimKiem.setText("");
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
            int viewRowIndex = tblPhong.getSelectedRow();
            if (viewRowIndex != -1) {
                int modelRowIndex = tblPhong.convertRowIndexToModel(viewRowIndex);

                suaPhong(modelRowIndex);
            }
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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);
        laytblLoaiphong();
        lamMLoaiPhong();
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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);
        laytblPhong();
        fillLoaiPhongToCbo();
        laytblPhong();
    }//GEN-LAST:event_bntQLPhong1MouseClicked

    private void bntQlKhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQlKhachhangMouseClicked
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
        Open.setVisible(true);
        pnlQLKhachHang.setVisible(true);
        pnlTDQLKhachHang.setVisible(true);
        fillTableKhachHang();
    }//GEN-LAST:event_bntQlKhachhangMouseClicked

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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);
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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);;
        laytblDichVu();
    }//GEN-LAST:event_bntQLDichVu1MouseClicked


    private void cmbPLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPLoaiPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPLoaiPhongActionPerformed

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
        if (evt.getClickCount() == 2) {
        int viewRowIndex = tblNV.getSelectedRow();
        if (viewRowIndex != -1) {

            int modelRowIndex = tblNV.convertRowIndexToModel(viewRowIndex);
            suaNguoiDung(modelRowIndex);
        }
    }
    }//GEN-LAST:event_tblNVMouseClicked

    private void bntNVTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNVTimKiemActionPerformed
        timKiemNguoiDung();
    }//GEN-LAST:event_bntNVTimKiemActionPerformed

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
        if (evt.getClickCount() == 2) {
            int viewRowIndex = tblDV.getSelectedRow();
            if (viewRowIndex != -1) {
                // Chuyển đổi chỉ mục hàng của view sang chỉ mục hàng của model
                int modelRowIndex = tblDV.convertRowIndexToModel(viewRowIndex);

                System.out.println("Chỉ mục trên view (DV): " + viewRowIndex);
                System.out.println("Chỉ mục trên model (DV): " + modelRowIndex);

                // Gọi phương thức suaDichVu() với chỉ mục model chính xác
                suaDichVu(modelRowIndex);
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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);
        
    }//GEN-LAST:event_btnTroChuyenMouseClicked
        
    private void bntQLNhanVien1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLNhanVien1MouseClicked
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
        pnlQLKhachHang.setVisible(false);
        pnlTDQLKhachHang.setVisible(false);
        laytblNhanVien();
    }//GEN-LAST:event_bntQLNhanVien1MouseClicked

    private void bntQlKhachhang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQlKhachhang1MouseClicked
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
        Open.setVisible(true);
        pnlQLKhachHang.setVisible(true);
        pnlTDQLKhachHang.setVisible(true);
        fillTableKhachHang();
    }//GEN-LAST:event_bntQlKhachhang1MouseClicked

    private void bntQlKhachhang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQlKhachhang2MouseClicked
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
        Open.setVisible(true);
        pnlQLKhachHang.setVisible(true);
        pnlTDQLKhachHang.setVisible(true);
        fillTableKhachHang();
    }//GEN-LAST:event_bntQlKhachhang2MouseClicked

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtSocmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSocmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSocmtActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void tabKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabKhachHangMouseClicked
        if (evt.getClickCount() == 2) {
            int viewRowIndex = tabKhachHang.getSelectedRow();
            if (viewRowIndex != -1) {
                int modelRowIndex = tabKhachHang.convertRowIndexToModel(viewRowIndex);
                displaySelectedKhachHang();
            }
        }
    }//GEN-LAST:event_tabKhachHangMouseClicked

    private void btnSuaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKHActionPerformed
        // TODO add your handling code here:
        updateKH();
    }//GEN-LAST:event_btnSuaKHActionPerformed

    private void btnLamMoiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiKHActionPerformed
        // TODO add your handling code here:
        clearFormKH();
    }//GEN-LAST:event_btnLamMoiKHActionPerformed

    private void btnTaoMoiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiKHActionPerformed
        // TODO add your handling code here:
        btnTaoMoiKH();
    }//GEN-LAST:event_btnTaoMoiKHActionPerformed

    private void btnXoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKHActionPerformed
        // TODO add your handling code here:
        deleteKH();
    }//GEN-LAST:event_btnXoaKHActionPerformed

    private void bntQLNhanVien1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntQLNhanVien1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bntQLNhanVien1MouseEntered

    private void txtTimKiemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemKHActionPerformed

    private void bntTimKiemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntTimKiemKHActionPerformed
        String keyword = txtTimKiemKH.getText().trim();
        // Gọi phương thức timKiemKhachHang() đã được sửa đổi
        timKiemKhachHang(keyword);
    }//GEN-LAST:event_bntTimKiemKHActionPerformed

    private void btnTaoMoiKH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiKH1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTaoMoiKH1ActionPerformed

    private void btnLamMoiKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiKHMouseClicked
        clearFormKH();
    }//GEN-LAST:event_btnLamMoiKHMouseClicked

    private void txtPGiaThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPGiaThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPGiaThueActionPerformed


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
    private javax.swing.JLabel bntQlKhachhang;
    private javax.swing.JLabel bntQlKhachhang1;
    private javax.swing.JLabel bntQlKhachhang2;
    private javax.swing.JButton bntTimKiemKH;
    private javax.swing.JLabel bntTrangChu;
    private javax.swing.JLabel btnDangXuat;
    private javax.swing.JButton btnLamMoiKH;
    private javax.swing.JButton btnSuaKH;
    private javax.swing.JButton btnTaoMoiKH;
    private javax.swing.JButton btnTaoMoiKH1;
    private javax.swing.JLabel btnTroChuyen;
    private javax.swing.JButton btnXoaKH;
    private javax.swing.ButtonGroup cboNVTrangThai;
    private javax.swing.ButtonGroup cboNVVaitro;
    private javax.swing.ButtonGroup cboPTrangThai;
    private javax.swing.JComboBox<String> cmbPLoaiPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JPanel pnlChat;
    private javax.swing.JPanel pnlChonTG;
    private javax.swing.JPanel pnlMenuBar;
    private javax.swing.JPanel pnlQLDichVu;
    private javax.swing.JPanel pnlQLDoanhThu;
    private javax.swing.JPanel pnlQLKhachHang;
    private javax.swing.JPanel pnlQLLoaiPhong;
    private javax.swing.JPanel pnlQLNhanVien;
    private javax.swing.JPanel pnlQLPhong;
    private javax.swing.JPanel pnlTDQLKhachHang;
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
    private javax.swing.JTable tabKhachHang;
    private javax.swing.JPanel tabPhong;
    private javax.swing.JTable tblDTPhong;
    private javax.swing.JTable tblDTTiepTan;
    private javax.swing.JTable tblDV;
    private javax.swing.JTable tblLoaiPhong;
    private javax.swing.JTable tblNV;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTextArea txaPGhiChu;
    private javax.swing.JLabel txtChoChuyen;
    private javax.swing.JLabel txtChoChuyen1;
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
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSocmt;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JLabel txtTenNV;
    private javax.swing.JTextField txtTimKiemKH;
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
    private Integer currentLoaiPhongId = null;

    private boolean validateLoaiPhongData(boolean isNew) {
        String tenLoaiPhong = txtLPLoaiPhong.getText().trim();
        if (tenLoaiPhong.isEmpty()) {
            XDialog.alert("Tên loại phòng không được để trống!");
            txtLPLoaiPhong.requestFocus();
            return false;
        }

        try {
            LoaiPhong existingLoaiPhong = dao.findByName(tenLoaiPhong).stream().findFirst().orElse(null);
            if (existingLoaiPhong != null) {
                if (isNew || (currentLoaiPhongId != null && !currentLoaiPhongId.equals(existingLoaiPhong.getId()))) {
                    XDialog.alert("Tên loại phòng đã tồn tại. Vui lòng nhập tên khác.");
                    txtLPLoaiPhong.requestFocus();
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi kiểm tra tên loại phòng trùng lặp: " + e.getMessage());
        }
        return true;
    }

    // Phương thức lấy dữ liệu từ form
    private LoaiPhong getFormLP() {
        LoaiPhong entity = new LoaiPhong();
        if (!txtLPID.getText().isEmpty()) {
            entity.setId(Integer.parseInt(txtLPID.getText()));
        }
        entity.setTenLoaiPhong(txtLPLoaiPhong.getText().trim());
        return entity;
    }

    // Phương thức điền dữ liệu lên form
    private void setFormLP(LoaiPhong entity) {
        txtLPID.setText(String.valueOf(entity.getId()));
        txtLPLoaiPhong.setText(entity.getTenLoaiPhong());
    }

    // Phương thức tải dữ liệu lên bảng
    public void laytblLoaiphong() {
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

    // Phương thức tạo mới loại phòng
    private void taoLoaiPhong() {
        if (!validateLoaiPhongData(true)) {
            return;
        }
        try {
            LoaiPhong newLoaiPhong = getFormLP();
            dao.create(newLoaiPhong);
            XDialog.alert("Tạo loại phòng thành công!");
            laytblLoaiphong();
            lamMLoaiPhong();
        } catch (Exception e) {
            XDialog.alert("Tạo loại phòng thất bại! Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Phương thức cập nhật loại phòng
    private void capNLoaiPhong() {
        if (!validateLoaiPhongData(false)) {
            return;
        }
        if (XDialog.confirm("Bạn có chắc chắn muốn cập nhật loại phòng này không?")) {
            try {
                LoaiPhong entity = getFormLP();
                dao.update(entity);
                XDialog.alert("Cập nhật loại phòng thành công!");
                laytblLoaiphong();
                lamMLoaiPhong();
            } catch (Exception e) {
                XDialog.alert("Cập nhật loại phòng thất bại! Lỗi: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // Phương thức xóa loại phòng
    private void xoaLoaiPhong() {
        // Thêm kiểm tra này để đảm bảo có ID để xóa
        if (txtLPID.getText().isEmpty()) {
            XDialog.alert("Vui lòng chọn một loại phòng để xóa.");
            return;
        }

        Integer id = Integer.valueOf(txtLPID.getText());

        if (XDialog.confirm("Bạn thực sự muốn xóa loại phòng này? Thao tác này sẽ xóa tất cả phòng thuộc loại này!")) {
            try {
                // Kiểm tra xem có phòng nào thuộc loại này không
                PhongDao phongDao = new PhongDaoImpl();
                List<Phong> rooms = phongDao.findByIdLoaiPhong(id);
                if (!rooms.isEmpty()) {
                     int confirm = JOptionPane.showConfirmDialog(this,
                            "Có " + rooms.size() + " phòng đang thuộc loại này. Bạn có chắc chắn muốn xóa tất cả các phòng này?",
                            "Xác nhận xóa",
                            JOptionPane.YES_NO_OPTION);
                     if(confirm == JOptionPane.YES_OPTION){
                         for(Phong phong : rooms){
                             phongDao.deleteById(phong.getId());
                         }
                         dao.deleteById(id);
                         XDialog.alert("Xóa loại phòng và các phòng liên quan thành công!");
                         laytblLoaiphong();
                         lamMLoaiPhong();
                     } else {
                         XDialog.alert("Đã hủy thao tác xóa.");
                     }
                } else {
                    dao.deleteById(id);
                    XDialog.alert("Xóa loại phòng thành công!");
                    laytblLoaiphong();
                    lamMLoaiPhong();
                }
            } catch (Exception e) {
                XDialog.alert("Xóa loại phòng thất bại! Lỗi: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // Phương thức làm mới form
    private void lamMLoaiPhong() {
        txtLPLoaiPhong.setText("");
        txtLPID.setText("");
        setButtonStateLP(false);
        currentLoaiPhongId = null;
        laytblLoaiphong();
    }

    // Phương thức xóa các mục đã chọn trong bảng
    private void xoaMDCLoaiPhong() {
        int selectedCount = 0;
        for (int i = 0; i < tblLoaiPhong.getRowCount(); i++) {
            if (tblLoaiPhong.getValueAt(i, 2) instanceof Boolean && (Boolean) tblLoaiPhong.getValueAt(i, 2)) {
                selectedCount++;
            }
        }

        if (selectedCount == 0) {
            XDialog.alert("Vui lòng chọn ít nhất một mục để xóa.");
            return;
        }
        
        if (XDialog.confirm("Bạn thực sự muốn xóa " + selectedCount + " mục đã chọn?")) {
            List<Integer> idsToDelete = new ArrayList<>();
            for (int i = 0; i < tblLoaiPhong.getRowCount(); i++) {
                 // Lấy chỉ mục hàng của model
                int modelRowIndex = tblLoaiPhong.convertRowIndexToModel(i); 
                if (tblLoaiPhong.getValueAt(i, 2) instanceof Boolean && (Boolean) tblLoaiPhong.getValueAt(i, 2)) {
                    idsToDelete.add((Integer) tblLoaiPhong.getValueAt(i, 0));
                }
            }

            int successCount = 0;
            for (Integer id : idsToDelete) {
                try {
                    dao.deleteById(id);
                    successCount++;
                } catch (Exception e) {
                    System.err.println("Lỗi khi xóa loại phòng có ID " + id + ": " + e.getMessage());
                }
            }

            if (successCount > 0) {
                XDialog.alert("Đã xóa thành công " + successCount + " mục.");
            }
            laytblLoaiphong();
        }
    }

    // Phương thức tìm kiếm loại phòng
    private void timKiemLoaiPhong() {
        String keyword = txtLPTimKiem.getText().trim();
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tblLoaiPhong.getRowSorter();
        if (sorter != null) {
            try {
                if (keyword.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    RowFilter<TableModel, Object> rf = RowFilter.regexFilter("(?i)" + keyword, 1);
                    sorter.setRowFilter(rf);
                }
            } catch (PatternSyntaxException pse) {
                XDialog.alert("Từ khóa tìm kiếm không hợp lệ.");
            }
        }
    }
    
    private void suaLoaiPhong(int modelRowIndex) {
        try {
            if (modelRowIndex >= 0 && modelRowIndex < items.size()) {
                LoaiPhong entity = items.get(modelRowIndex);
                this.setFromLP(entity);
                this.setButtonStateLP(true);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy loại phòng để sửa.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi chọn loại phòng để sửa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void setFromLP(LoaiPhong entity) {
        txtLPID.setText(String.valueOf(entity.getId()));
        txtLPLoaiPhong.setText(entity.getTenLoaiPhong());
    }

    private void setButtonStateLP(boolean isEditing) {
        bntLPTaoMoi.setEnabled(!isEditing);
        bntLPSua.setEnabled(isEditing);
        bntLPXoaPhongLP.setEnabled(isEditing);
        txtLPID.setEnabled(false);
    }
    
    /**
     * ==============================================================================================================================
     * ======================================================== Phong ===============================================================
     * ==============================================================================================================================
     */
    
    PhongDao Phongdao = new PhongDaoImpl(); 
    java.util.List<Phong> Phongitems;
    private Integer currentPhongId = null;

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
    
    private boolean validatePhongData() {
        String soPhongStr = txtPSoPhong.getText().trim();
        String tangStr = txtPTang.getText().trim();
        String giaTienStr = txtPGiaThue.getText().trim();
        LoaiPhong loaiPhongChon = (LoaiPhong) cmbPLoaiPhong.getSelectedItem();

        // 1. Kiểm tra Số phòng không trống
        if (soPhongStr.isEmpty()) {
            XDialog.alert("Vui lòng không để trống Số phòng.");
            txtPSoPhong.requestFocus(); // Đặt focus vào trường bị lỗi
            return false;
        }

        // 2. Kiểm tra Số phòng là số nguyên dương
        try {
            int soPhongInt = Integer.parseInt(soPhongStr);
            if (soPhongInt <= 0) {
                XDialog.alert("Số phòng phải là một số nguyên dương.");
                txtPSoPhong.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            XDialog.alert("Số phòng phải là một số hợp lệ.");
            txtPSoPhong.requestFocus();
            return false;
        }

        // 3. Kiểm tra Số phòng bị trùng
        try {
            Phong existingPhong = Phongdao.findBySoPhong(soPhongStr);
            if (existingPhong != null) {
                // Kiểm tra nếu đang ở chế độ THÊM MỚI hoặc số phòng bị trùng với phòng khác
                if (currentPhongId == null || !currentPhongId.equals(existingPhong.getId())) {
                    XDialog.alert("Số phòng này đã tồn tại. Vui lòng nhập số phòng khác.");
                    txtPSoPhong.requestFocus();
                    return false;
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi kiểm tra số phòng trùng lặp: " + e.getMessage());
            XDialog.alert("Lỗi hệ thống khi kiểm tra số phòng.");
            return false;
        }

        // 4. Kiểm tra Tầng không trống
        if (tangStr.isEmpty()) {
            XDialog.alert("Vui lòng không để trống Tầng.");
            txtPTang.requestFocus();
            return false;
        }

        // 5. Kiểm tra Tầng là số nguyên dương
        try {
            int tangInt = Integer.parseInt(tangStr);
            if (tangInt <= 0) {
                XDialog.alert("Tầng phải là một số nguyên dương.");
                txtPTang.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            XDialog.alert("Tầng phải là một số hợp lệ.");
            txtPTang.requestFocus();
            return false;
        }

        // 6. Kiểm tra Giá thuê không trống
        if (giaTienStr.isEmpty()) {
            XDialog.alert("Vui lòng không để trống Giá thuê.");
            txtPGiaThue.requestFocus();
            return false;
        }

        // 7. Kiểm tra Giá thuê là số dương
        try {
            double giaTienDouble = Double.parseDouble(giaTienStr);
            if (giaTienDouble <= 0) {
                XDialog.alert("Giá thuê phải là một số dương.");
                txtPGiaThue.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            XDialog.alert("Giá thuê phải là một số hợp lệ.");
            txtPGiaThue.requestFocus();
            return false;
        }

        // 8. Kiểm tra Loại phòng đã chọn
        if (loaiPhongChon == null) {
            XDialog.alert("Vui lòng chọn Loại phòng.");
            cmbPLoaiPhong.requestFocus();
            return false;
        }

        // 9. Kiểm tra Trạng thái phòng đã chọn
        if (!rdoPPhongDuocThue.isSelected() && !rdoPPhongSua1.isSelected() &&
                !rdoPPhongDonDep.isSelected() && !rdoPPhongTrong.isSelected()) {
            XDialog.alert("Vui lòng chọn Trạng thái phòng.");
            return false;
        }

        // Nếu tất cả các kiểm tra đều thành công
        return true;
    }


    void laytblPhong() {
        // Khởi tạo một DefaultTableModel mới
        DefaultTableModel newModel = new DefaultTableModel() {
            String[] columnNames = {"Số phòng", "Tầng", "Giá tiền", "Loại phòng", "Trạng thái", "Chọn"};

            @Override
            public int getColumnCount() {
                return columnNames.length;
            }

            @Override
            public String getColumnName(int column) {
                return columnNames[column];
            }

            // Ghi đè phương thức isCellEditable
            @Override
            public boolean isCellEditable(int row, int column) {
                // Chỉ cho phép chỉnh sửa cột cuối cùng (cột "Chọn")
                return column == getColumnCount() - 1; 
            }

            // Ghi đè phương thức getColumnClass để chỉ định kiểu dữ liệu cho từng cột
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == getColumnCount() - 1) {
                    return Boolean.class; // Cột cuối cùng là kiểu Boolean
                }
                return super.getColumnClass(columnIndex); // Các cột khác giữ nguyên
            }
        };

        try {
            Phongitems = Phongdao.findAll();
            for (Phong item : Phongitems) {
                LoaiPhong loaiPhong = new LoaiPhongDaoImpl().findById(item.getIdLoaiPhong());
                String tenLoaiPhong = (loaiPhong != null) ? loaiPhong.getTenLoaiPhong() : "Không rõ";

                java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,##0 VNĐ");
                String giaTienFormatted = formatter.format(item.getGiaTien());

                newModel.addRow(new Object[]{
                    item.getSoPhong(),
                    item.getTang(),
                    giaTienFormatted,
                    tenLoaiPhong,
                    item.getTrangThai(),
                    false // Giá trị ban đầu cho cột "Chọn"
                });
            }

            tblPhong.setModel(newModel);

            // Khởi tạo và gán lại TableRowSorter cho model mới
            sorterP = new TableRowSorter<>(newModel);
            tblPhong.setRowSorter(sorterP);

        } catch (Exception e) {
            XDialog.alert("Lỗi tải dữ liệu phòng!");
            e.printStackTrace();
        }
    }

    void suaPhong(int modelRowIndex) {
        try {
            if (modelRowIndex >= 0 && modelRowIndex < Phongitems.size()) {
                Phong entity = Phongitems.get(modelRowIndex);
                this.setFromP(entity);
                this.suatblP(true);
                this.currentPhongId = entity.getId(); 
            } else {
                XDialog.alert("Không tìm thấy phòng để sửa.");
            }
        } catch (Exception e) {
            XDialog.alert("Lỗi khi chọn phòng để sửa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void setFromP(Phong entity) { 
        txtPSoPhong.setText(entity.getSoPhong()); 
        txtPTang.setText(String.valueOf(entity.getTang())); 

        java.text.DecimalFormat df = new java.text.DecimalFormat("#"); 
        txtPGiaThue.setText(df.format(entity.getGiaTien())); 

        txaPGhiChu.setText(entity.getGhiChu()); 

        javax.swing.DefaultComboBoxModel model = (javax.swing.DefaultComboBoxModel) cmbPLoaiPhong.getModel(); 
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
     
    void capNPhong() { 
        int selectedIndex = tblPhong.getSelectedRow(); 
        if (selectedIndex < 0) { 
            XDialog.alert("Vui lòng chọn một phòng để cập nhật."); 
            return; 
        } 

        // Kiểm tra dữ liệu đầu vào trước khi cập nhật
        // currentPhongId sẽ chứa ID của phòng đang sửa, nên validatePhongData sẽ bỏ qua kiểm tra trùng lặp với chính nó
        if (!validatePhongData()) {
            return; 
        }

        if (XDialog.confirm("Bạn có chắc chắn muốn cập nhật thông tin phòng này không?")) { 
            try { 
                Phong entity = this.layPhong(); 
                Phong selectedPhong = Phongitems.get(selectedIndex); 
                entity.setId(selectedPhong.getId()); 

                Phongdao.update(entity); 
                this.laytblPhong(); 
                XDialog.alert("Cập nhật phòng thành công!"); 
                this.currentPhongId = null; 
            } catch (Exception e) { 
                XDialog.alert("Cập nhật phòng thất bại! " + e.getMessage()); 
                e.printStackTrace(); 
            } 
        } 
    } 



     /** * Xóa phòng được chọn trên form. 
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

     /** * Xóa các phòng đã được chọn trong bảng. 
      */ 
     void xoaMDCPhong() { 
         if (XDialog.confirm("Bạn thực sự muốn xóa các mục đã chọn?")) { 
             int successCount = 0; 
             for (int i = 0; i < tblPhong.getRowCount(); i++) { 
                 if ((Boolean) tblPhong.getValueAt(i, 5)) { 
                     try { 
                         // Lấy ID từ đối tượng Phongitems tại vị trí i. 
                         // Cần đảm bảo rằng chỉ mục i của bảng khớp với chỉ mục trong Phongitems.
                         // Cân nhắc thêm một cột ID ẩn hoặc cách khác để lấy ID chính xác.
                         // Hiện tại, giả định rằng thứ tự trong bảng và Phongitems là như nhau.
                         Phongdao.deleteById(Phongitems.get(i).getId()); 
                         successCount++; 
                     } catch (Exception e) { 
                         // Ghi log lỗi cho các mục không xóa được nếu cần
                         System.err.println("Lỗi khi xóa phòng: " + e.getMessage());
                     } 
                 } 
             } 
             this.laytblPhong(); 
             XDialog.alert("Đã xóa thành công " + successCount + " mục."); 
         } 
     } 


    void lamMPhong() { 
        Phong emptyPhong = new Phong(); 
        emptyPhong.setGiaTien(java.math.BigDecimal.ZERO); 
        emptyPhong.setSoPhong(""); 
        emptyPhong.setTang(0); 
        emptyPhong.setGhiChu(""); 

        this.setFromP(emptyPhong); 
        this.suatblP(false); 
        rdoPPhongTrong.setSelected(true);
        this.currentPhongId = null; 
    } 


    void timKiemPhong() {
        String soPhongKeyword = txtPTimKiem.getText().trim();
        if (sorterP == null) {
            JOptionPane.showMessageDialog(this, "Lỗi: TableRowSorter chưa được khởi tạo cho bảng Phòng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (soPhongKeyword.isEmpty()) {
            sorterP.setRowFilter(null);
        } else {
            try {
                // Giả sử cột "Số phòng" có chỉ mục là 0
                int soPhongColumnIndex = 0; 
                RowFilter<TableModel, Object> rf = RowFilter.regexFilter("(?i)" + soPhongKeyword, soPhongColumnIndex);
                sorterP.setRowFilter(rf);
            } catch (PatternSyntaxException pse) {
                JOptionPane.showMessageDialog(this, "Từ khóa tìm kiếm không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    void taoPhong() { 
        if (!validatePhongData()) {
            return; 
        }
        try { 
            Phong newPhong = this.layPhong(); 
            Phongdao.create(newPhong); 
            this.laytblPhong(); 
            this.lamMPhong(); 
            XDialog.alert("Tạo mới phòng thành công!"); 
        } catch (Exception e) { 
            XDialog.alert("Tạo mới phòng thất bại! " + e.getMessage()); 
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

    // Hàm lấy dữ liệu từ form, không thực hiện validation ở đây
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
        } else {
            entity.setVaiTro(""); // Đảm bảo vai trò là rỗng nếu không chọn
        }

        // Đặt trạng thái
        entity.setTrangThai(rdoNVHoatDong.isSelected());
        
        // Ảnh sẽ được xử lý riêng trong tao/capNguoiDung
        // entity.setAnh() sẽ được gọi sau khi validation và xử lý file ảnh
        
        return entity;
    }

    private boolean isPhoneNumberDuplicate(String sdt, String currentUsername) {
        try {
            List<NguoiDung> allUsers = NVdao.findAll();
            for (NguoiDung user : allUsers) {
                // Bỏ qua người dùng đang được sửa
                if (currentUsername != null && user.getUsername().equals(currentUsername)) {
                    continue;
                }
                if (user.getSdt().equals(sdt)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    

    private boolean validateNguoiDungData(boolean isNewUser) {
        NguoiDung nguoiDung = this.layNguoiDung(); // Lấy dữ liệu thô từ form

        // 1. Kiểm tra Tên đăng nhập
        String username = nguoiDung.getUsername();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập không được để trống.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVTenDangNhap.requestFocus();
            return false;
        }
        if (username.contains(" ") || !username.matches("^[a-zA-Z0-9]+$")) {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập không được chứa ký tự trống và không dấu (chỉ chữ và số).", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVTenDangNhap.requestFocus();
            return false;
        }
        if (isNewUser) { // Chỉ kiểm tra trùng lặp khi tạo mới
            try {
                NguoiDung existingUser = NVdao.findById(username);
                if (existingUser != null) {
                    JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại. Vui lòng chọn tên khác.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                    txtNVTenDangNhap.requestFocus();
                    return false;
                }
            } catch (Exception e) {
                System.err.println("Lỗi khi kiểm tra tên đăng nhập trùng lặp: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Lỗi hệ thống khi kiểm tra tên đăng nhập.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // 2. Kiểm tra Mật khẩu
        String password = nguoiDung.getMatKhau();
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVMatKhau.requestFocus();
            return false;
        }
        if (password.equals(username)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được trùng với tên đăng nhập.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVMatKhau.requestFocus();
            return false;
        }
        if (password.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được chứa khoảng trống.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVMatKhau.requestFocus();
            return false;
        }
        if (!password.matches("^[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?`~]+$")) {
            JOptionPane.showMessageDialog(this, "Mật khẩu chỉ được chứa chữ cái (không dấu), số và các ký tự đặc biệt.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVMatKhau.requestFocus();
            return false;
        }

        // 3. Kiểm tra Họ và tên
        String hoVaTen = nguoiDung.getHoVaTen();
        if (hoVaTen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ và tên không được để trống.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVHoVaTen.requestFocus();
            return false;
        }
        if (!Character.isUpperCase(hoVaTen.charAt(0))) {
            JOptionPane.showMessageDialog(this, "Họ và tên phải viết hoa chữ cái đầu tiên.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVHoVaTen.requestFocus();
            return false;
        }
        if (!hoVaTen.matches("^[\\p{L}\\s.'-]+$")) {
            JOptionPane.showMessageDialog(this, "Họ và tên chỉ được chứa chữ cái, khoảng trắng, dấu chấm, dấu gạch ngang, dấu nháy đơn.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVHoVaTen.requestFocus();
            return false;
        }

        // 4. Kiểm tra Số điện thoại
        String sdt = nguoiDung.getSdt();
        if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVSDT.requestFocus();
                return false;
        }
        if (!sdt.matches("^0[0-9]{6,14}$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải bắt đầu bằng số 0 và có từ 7 đến 15 chữ số.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVSDT.requestFocus();
            return false;            
        }
                    
        if (isPhoneNumberDuplicate(sdt, isNewUser ? null : nguoiDung.getUsername())) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại. Vui lòng sử dụng số khác.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            txtNVSDT.requestFocus();
            return false;
        }
        

        // 5. Kiểm tra Vai trò
        if (nguoiDung.getVaiTro() == null || nguoiDung.getVaiTro().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn vai trò.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            rdoNVQuanLy.requestFocus();
            return false;
        }

        // 6. Kiểm tra Trạng thái
        if (!rdoNVHoatDong.isSelected() && !rdoNVTamDung.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


    void taoNguoiDung(){
        if (!validateNguoiDungData(true)) {
            return; 
        }

        NguoiDung newNguoiDung = this.layNguoiDung();

        try {
            String fileNameToSave = null;
            if (selectedLocalImagePath != null) {
                fileNameToSave = XStr.getKey() + ".jpg";
                newNguoiDung.setAnh(fileNameToSave);
            } else {
                newNguoiDung.setAnh("avata.jpg");
            }

            // Thực hiện tạo mới người dùng
            // Nếu DAO của bạn trả về đối tượng có ID (tự sinh) hoặc tên ảnh (nếu được DB generate)
            // thì bạn có thể gán lại newNguoiDung = NVdao.create(newNguoiDung);
            // Ở đây, tôi giả định create() chỉ thực hiện insert và không trả về ID
            NVdao.create(newNguoiDung); // Thêm người dùng vào DB

            // Nếu bạn muốn lấy ID tự sinh hoặc tên ảnh tự sinh từ DB sau khi tạo
            // (nếu DB có trigger hoặc sequence cho ảnh), bạn cần fetch lại đối tượng
            // Ví dụ, nếu Username là unique và có thể dùng để fetch:
            NguoiDung createdUser = NVdao.findById(newNguoiDung.getUsername());

            // Xử lý sao chép ảnh CHỈ KHI CÓ selectedLocalImagePath
            // và đảm bảo rằng createdUser đã có tên ảnh (nếu DB tự đặt tên)
            // HOẶC dùng fileNameToSave đã tạo ở trên.
            if (selectedLocalImagePath != null && createdUser != null) { // Đảm bảo có người dùng đã được tạo và có ảnh được chọn
                try {
                    Path source = Paths.get(selectedLocalImagePath);
                    // Sử dụng tên file đã gán cho newNguoiDung (hoặc createdUser.getAnh() nếu DAO trả về)
                    Path destination = Paths.get(this.folder, newNguoiDung.getAnh()); 
                    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                    selectedLocalImagePath = null; // Xóa đường dẫn tạm thời sau khi lưu
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi sao chép ảnh: " + e.getMessage(), "Lỗi ảnh", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }

            // Làm mới bảng và xóa form trước khi thông báo thành công
            this.laytblNhanVien();
            this.lamMNguoiDung();
            JOptionPane.showMessageDialog(this, "Tạo người dùng thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tạo người dùng thất bại! Lỗi: " + e.getMessage(), "Lỗi hệ thống", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE); 
            e.printStackTrace();
        }
    }

    void lamMNguoiDung(){
        txtNVTenDangNhap.setText("");
        txtNVMatKhau.setText("");
        txtNVHoVaTen.setText("");
        txtNVSDT.setText("");
        cboNVVaitro.clearSelection(); // Xóa lựa chọn của ButtonGroup
        cboNVTrangThai.clearSelection(); // Xóa lựa chọn của ButtonGroup
        rdoNVHoatDong.setSelected(true); // Đặt mặc định trạng thái hoạt động khi làm mới

        // Đặt ảnh về logo mặc định
        XIcon.setIcon(NVAnh, "/Icon/Logo.png"); // Đường dẫn này phải là resource path
        NVAnh.setToolTipText("Logo.png"); // Reset tooltip
        
        selectedLocalImagePath = null; // Xóa đường dẫn ảnh tạm
        
        bntNVTaoMoi.setEnabled(true);
        bntNVSua.setEnabled(false);
        txtNVTenDangNhap.setEditable(true); // Cho phép sửa Username khi thêm mới
    }
    
    private void suaNguoiDung(int modelRowIndex) {
        try {
            if (modelRowIndex >= 0) {
                // Lấy đối tượng NguoiDung chính xác từ danh sách gốc
                NguoiDung entity = NVitems.get(modelRowIndex);
                this.setFromNV(entity);
                this.suatblNV(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi chọn nhân viên để sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
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
            // XIcon.setIcon(JLabel, File)
            XIcon.setIcon(NVAnh, new File(this.folder, imageFileNameFromDB)); 
            NVAnh.setToolTipText(imageFileNameFromDB); // Đặt tooltip thành tên tệp thực tế
        } else {
            // Trường hợp không có ảnh: đặt ảnh mặc định
            // XIcon.setIcon(JLabel, String) cho resource path
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
        selectedLocalImagePath = null; // Đảm bảo reset khi tải user mới lên form, không có ảnh mới được chọn
    }

    void suatblNV(boolean suaNV){
        bntNVSua.setEnabled(suaNV);
        bntNVTaoMoi.setEnabled(!suaNV);
    }
    
    void capNguoiDung(){
        // Gọi hàm validation trước khi tiếp tục
        if (!validateNguoiDungData(false)) { // isNewUser = false
            return; 
        }

        NguoiDung updatedNguoiDung = this.layNguoiDung();
        // Username không thay đổi khi cập nhật
        String currentUsername = txtNVTenDangNhap.getText(); 
        updatedNguoiDung.setUsername(currentUsername); 

        try {
            // Lấy thông tin người dùng gốc từ DB để giữ lại tên ảnh cũ nếu không chọn ảnh mới
            NguoiDung originalUser = NVdao.findById(currentUsername);
            String oldImageFileName = (originalUser != null) ? originalUser.getAnh() : null;

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
            JOptionPane.showMessageDialog(this, "Cập nhật người dùng thất bại! Lỗi: " + e.getMessage(), "Lỗi hệ thống", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    void timKiemNguoiDung() {
        String keyword = txtNVTimKiem.getText().trim();
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tblNV.getRowSorter();

        // Nếu sorter chưa được khởi tạo, có thể hiển thị thông báo lỗi
        if (sorter == null) {
            JOptionPane.showMessageDialog(this, "Lỗi: TableRowSorter chưa được khởi tạo.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (keyword.isEmpty()) {
            sorter.setRowFilter(null); // Hiển thị lại toàn bộ dữ liệu nếu ô tìm kiếm trống
        } else {
            try {
                // Tạo một RowFilter chỉ lọc trên cột "SĐT" (chỉ mục 3)
                // "(?i)" để tìm kiếm không phân biệt chữ hoa, chữ thường
                // 3 là chỉ mục của cột "SĐT"
                RowFilter<TableModel, Object> rf = RowFilter.regexFilter("(?i)" + keyword, 3);
                sorter.setRowFilter(rf);
            } catch (PatternSyntaxException pse) {
                JOptionPane.showMessageDialog(this, "Từ khóa tìm kiếm không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
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
                JOptionPane.showMessageDialog(this, "Không thể tải ảnh đã chọn. Vui lòng kiểm tra định dạng tệp.", "Lỗi tải ảnh", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace(); 
            }
        }
    }
    
    /**
     * ==============================================================================================================================
     * ==================================================== Doanh Thu ==============================================================
     * ==============================================================================================================================
     */
    
    // Khai báo các DAO cần thiết ở cấp lớp (class level) để tái sử dụng
    ChiTietThuePhongDao chiTietThuePhongDao = new ChiTietThuePhongDaoImpl();
    HoaDonDao hoaDonDao = new HoaDonDaoImpl();
    PhongDao phongDao = new PhongDaoImpl();
    NguoiDungDao nguoiDungDao = new NguoiDungDaoImpl();

    /**
     * Phương thức quá tải để gọi khi cần tải dữ liệu mặc định (dựa trên lựa chọn
     * hiện tại của ChonTG panel).
     */
    void fillTablePhong() {
        // Lấy instance của ChonTG panel đã được thêm vào pnlChonTG
        if (pnlChonTG.getComponentCount() > 0 && pnlChonTG.getComponent(0) instanceof ChonTG) {
            ChonTG chonTGPanel = (ChonTG) pnlChonTG.getComponent(0);
            fillTablePhong(chonTGPanel.getFrom(), chonTGPanel.getTo());
        }
    }

    /**
     * Tải và lọc dữ liệu doanh thu theo từng phòng dựa trên khoảng thời gian.
     * @param startDate Ngày bắt đầu
     * @param endDate Ngày kết thúc
     */
    void fillTablePhong(Date startDate, Date endDate) {
        DefaultTableModel model = (DefaultTableModel) tblDTPhong.getModel();
        model.setRowCount(0);

        List<HoaDon> allInvoices = hoaDonDao.findAll();
        Map<Integer, Double> roomRevenueMap = new HashMap<>();
        Map<Integer, Long> roomRentedDaysMap = new HashMap<>();

        for (HoaDon invoice : allInvoices) {
            Date ngayLap = invoice.getNgayLap();
            // Chỉ xử lý các hóa đơn nằm trong khoảng thời gian đã chọn
            if (ngayLap != null && !ngayLap.before(startDate) && !ngayLap.after(endDate)) {
                List<ChiTietThuePhong> details = chiTietThuePhongDao.findByIdHoaDon(invoice.getId());
                for (ChiTietThuePhong detail : details) {
                    if (detail.getThoiGianNhanPhong() != null && detail.getThoiGianTraPhong() != null) {
                        long diff = detail.getThoiGianTraPhong().getTime() - detail.getThoiGianNhanPhong().getTime();
                        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                        if (days == 0) days = 1; // Tính tối thiểu 1 ngày

                        Phong room = phongDao.findById(detail.getIdPhong());
                        if (room != null) {
                            double revenue = days * room.getGiaTien().doubleValue();
                            roomRevenueMap.put(room.getId(), roomRevenueMap.getOrDefault(room.getId(), 0.0) + revenue);
                            roomRentedDaysMap.put(room.getId(), roomRentedDaysMap.getOrDefault(room.getId(), 0L) + days);
                        }
                    }
                }
            }
        }

        DecimalFormat formatter = new DecimalFormat("#,##0 VNĐ");
        for (Map.Entry<Integer, Double> entry : roomRevenueMap.entrySet()) {
            Phong room = phongDao.findById(entry.getKey());
            if (room != null) {
                model.addRow(new Object[]{
                    room.getSoPhong(),
                    formatter.format(entry.getValue()),
                    roomRentedDaysMap.getOrDefault(entry.getKey(), 0L)
                });
            }
        }
    }

    /**
     * Phương thức quá tải để gọi khi cần tải dữ liệu mặc định.
     */
    void fillTableDTTiepTan() {
        if (pnlChonTG.getComponentCount() > 0 && pnlChonTG.getComponent(0) instanceof ChonTG) {
            ChonTG chonTGPanel = (ChonTG) pnlChonTG.getComponent(0);
            fillTableDTTiepTan(chonTGPanel.getFrom(), chonTGPanel.getTo());
        }
    }

    /**
     * Tải và lọc dữ liệu doanh thu theo từng nhân viên tiếp tân.
     * @param startDate Ngày bắt đầu
     * @param endDate Ngày kết thúc
     */
    void fillTableDTTiepTan(Date startDate, Date endDate) {
        DefaultTableModel model = (DefaultTableModel) tblDTTiepTan.getModel();
        model.setRowCount(0);

        List<HoaDon> allInvoices = hoaDonDao.findAll();

        Map<String, Double> revenueByReceptionist = new HashMap<>();
        Map<String, Long> invoiceCountByReceptionist = new HashMap<>();
        Map<String, Integer> firstInvoiceId = new HashMap<>();
        Map<String, Integer> lastInvoiceId = new HashMap<>();

        for (HoaDon hd : allInvoices) {
            Date ngayLap = hd.getNgayLap();
            // Chỉ xử lý các hóa đơn nằm trong khoảng thời gian đã chọn
            if (ngayLap != null && !ngayLap.before(startDate) && !ngayLap.after(endDate)) {
                String username = hd.getIdNguoiDungLap();
                
                revenueByReceptionist.put(username, revenueByReceptionist.getOrDefault(username, 0.0) + hd.getTongTien());
                invoiceCountByReceptionist.put(username, invoiceCountByReceptionist.getOrDefault(username, 0L) + 1);

                if (!firstInvoiceId.containsKey(username) || hd.getId() < firstInvoiceId.get(username)) {
                    firstInvoiceId.put(username, hd.getId());
                }
                if (!lastInvoiceId.containsKey(username) || hd.getId() > lastInvoiceId.get(username)) {
                    lastInvoiceId.put(username, hd.getId());
                }
            }
        }

        DecimalFormat formatter = new DecimalFormat("#,##0 VNĐ");
        for (Map.Entry<String, Double> entry : revenueByReceptionist.entrySet()) {
            String username = entry.getKey();
            NguoiDung user = nguoiDungDao.findById(username);
            if (user != null && "Tiếp tân".equals(user.getVaiTro())) {
                model.addRow(new Object[]{
                    user.getHoVaTen(),
                    formatter.format(entry.getValue()),
                    invoiceCountByReceptionist.get(username),
                    firstInvoiceId.get(username),
                    lastInvoiceId.get(username)
                });
            }
        }
    }
    /**
     * ==============================================================================================================================
     * ==================================================== QL DichVu ==============================================================
     * ==============================================================================================================================
     */
    
    private Dao.dao.DichVuDao DVdao = new Dao.daoimpl.DichVuDaoImpl();
    List<Dao.entity.DichVu> DichVuitems;
    private Integer currentDichVuId = null; 
    
    public Dao.entity.DichVu layDichVu() {
        Dao.entity.DichVu entity = new Dao.entity.DichVu();
        entity.setTenDichVu(txtDVTen.getText().trim());
        try {
            // Chỉ lấy giá trị, việc kiểm tra NumberFormatException sẽ ở validateDichVuData()
            entity.setDonGia(Double.parseDouble(txtDVGia.getText().trim())); 
        } catch (NumberFormatException e) {
            // Bỏ qua lỗi ở đây, vì validateDichVuData sẽ xử lý
        }
        return entity;
    }

    void lamMDichVu() {
        txtDVTen.setText("");
        txtDVGia.setText("");
        bntDVTaoMoi.setEnabled(true);
        bntDVSua.setEnabled(false);
        bntDVXoa.setEnabled(false);
        laytblDichVu(); // Tải lại bảng dịch vụ
        this.currentDichVuId = null; // Reset ID dịch vụ đang chỉnh sửa
    }
    
    void suaDichVu(int modelRowIndex) {
        try {
            // Kiểm tra chỉ mục có hợp lệ hay không
            if (modelRowIndex >= 0 && modelRowIndex < DichVuitems.size()) {
                // Lấy đối tượng DichVu chính xác từ danh sách gốc
                Dao.entity.DichVu selectedService = DichVuitems.get(modelRowIndex);

                // Điền dữ liệu vào các trường trên form
                setFromDV(selectedService);

                // Đặt trạng thái form sang chế độ sửa
                suatblDV(true);
            } else {
                Util.XDialog.alert("Không tìm thấy dịch vụ để sửa.");
            }
        } catch (Exception e) {
            Util.XDialog.alert("Lỗi khi chọn dịch vụ để sửa: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    void timKiemDichVu() {
        String keyword = txtDVTimKiem.getText().trim();
        if (sorterDV == null) {
            JOptionPane.showMessageDialog(this, "Lỗi: TableRowSorter chưa được khởi tạo.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (keyword.isEmpty()) {
            sorterDV.setRowFilter(null);
        } else {
            try {
                // Giả sử cột "Tên Dịch vụ" có chỉ mục là 1
                int tenDichVuColumnIndex = 1;
                RowFilter<TableModel, Object> rf = RowFilter.regexFilter("(?i)" + keyword, tenDichVuColumnIndex);
                sorterDV.setRowFilter(rf);
            } catch (PatternSyntaxException pse) {
                JOptionPane.showMessageDialog(this, "Từ khóa tìm kiếm không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    void laytblDichVu() {
        DefaultTableModel newModel = new DefaultTableModel() {
            String[] columnNames = {"ID", "Tên Dịch vụ", "Đơn giá", "Chọn"};

            @Override
            public int getColumnCount() {
                return columnNames.length;
            }

            @Override
            public String getColumnName(int column) {
                return columnNames[column];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == getColumnCount() - 1;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == getColumnCount() - 1) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };

        try {
            DichVuitems = DVdao.findAll();
            DecimalFormat formatter = new DecimalFormat("#,##0 VNĐ");

            for (Dao.entity.DichVu dv : DichVuitems) {
                newModel.addRow(new Object[]{
                    dv.getId(),
                    dv.getTenDichVu(),
                    formatter.format(dv.getDonGia()),
                    false
                });
            }

            tblDV.setModel(newModel);

            // Khởi tạo và gán lại TableRowSorter cho model mới
            sorterDV = new TableRowSorter<>(newModel);
            tblDV.setRowSorter(sorterDV);

        } catch (Exception e) {
            Util.XDialog.alert("Lỗi khi tải dữ liệu dịch vụ!");
            e.printStackTrace();
        }
    }
    
    // --- Bắt đầu hàm validation mới ---
    private boolean validateDichVuData(boolean isNewService) {
        Dao.entity.DichVu dichVu = layDichVu();
        StringBuilder errors = new StringBuilder();

        // 1. Kiểm tra Tên dịch vụ
        String tenDichVu = dichVu.getTenDichVu();
        if (tenDichVu.isEmpty()) {
            errors.append("Tên dịch vụ không được để trống.\n");
        } else {
            try {
                Dao.entity.DichVu existingService = DVdao.findByTenDichVu(tenDichVu);
                if (existingService != null) {
                    // Nếu đang tạo mới HOẶC (đang cập nhật VÀ ID của dịch vụ tìm thấy không phải là ID của dịch vụ đang sửa)
                    if (isNewService || (currentDichVuId != null && !currentDichVuId.equals(existingService.getId()))) {
                        errors.append("Tên dịch vụ đã tồn tại. Vui lòng chọn tên khác.\n");
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi khi kiểm tra tên dịch vụ trùng lặp: " + e.getMessage());
                // Không thông báo lỗi hệ thống cho người dùng cuối
            }
        }

        // 2. Kiểm tra Giá tiền
        String giaText = txtDVGia.getText().trim();
        if (giaText.isEmpty()) {
            errors.append("Giá tiền không được để trống.\n");
        } else {
            try {
                double gia = Double.parseDouble(giaText);
                if (gia <= 0) { // Giá tiền phải là số dương (lớn hơn 0)
                    errors.append("Giá tiền phải là số dương.\n");
                }
            } catch (NumberFormatException e) {
                errors.append("Giá tiền phải là một số hợp lệ.\n");
            }
        }

        if (errors.length() > 0) {
            Util.XDialog.alert(errors.toString());
            return false;
        }
        return true;
    }
    // --- Kết thúc hàm validation mới ---

    void taoDichVu() {
        if (!validateDichVuData(true)) { // isNewService = true
            return;
        }

        Dao.entity.DichVu newDichVu = layDichVu();
        try {
            DVdao.create(newDichVu);
            Util.XDialog.alert("Thêm dịch vụ mới thành công!");
            lamMDichVu(); 
        } catch (Exception e) {
            Util.XDialog.alert("Thêm dịch vụ mới thất bại! Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    void setFromDV(Dao.entity.DichVu entity) {
        txtDVTen.setText(entity.getTenDichVu());
        // Định dạng lại giá tiền khi hiển thị lên ô nhập liệu
        DecimalFormat df = new DecimalFormat("#"); // Không có .00 và không có VNĐ
        txtDVGia.setText(df.format(entity.getDonGia()));
        
        // Lưu ID của dịch vụ đang được chỉnh sửa
        this.currentDichVuId = entity.getId();
    }
    
    void suatblDV(boolean isEditing) {
        bntDVTaoMoi.setEnabled(!isEditing); 
        bntDVSua.setEnabled(isEditing);    
        bntDVXoa.setEnabled(isEditing);    
    }
    
    void capNDichVu() {
        int selectedRow = tblDV.getSelectedRow();
        if (selectedRow < 0) {
            Util.XDialog.alert("Vui lòng chọn một dịch vụ để cập nhật.");
            return;
        }
        
        if (!validateDichVuData(false)) { // isNewService = false
            return;
        }

        Dao.entity.DichVu updatedDichVu = layDichVu();
        Dao.entity.DichVu originalDichVu = DichVuitems.get(selectedRow); 
        updatedDichVu.setId(originalDichVu.getId()); 

        if (Util.XDialog.confirm("Bạn thực sự muốn cập nhật dịch vụ này?")) {
            try {
                DVdao.update(updatedDichVu);
                Util.XDialog.alert("Cập nhật dịch vụ thành công!");
                lamMDichVu(); 
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
                DVdao.deleteById(serviceIdToDelete);
                Util.XDialog.alert("Xóa dịch vụ thành công!");
                lamMDichVu();
            } catch (RuntimeException e) {
                // Đảm bảo bạn đã import SQLServerException nếu bạn muốn sử dụng nó
                // import com.microsoft.sqlserver.jdbc.SQLServerException;
                Throwable cause = e.getCause();
                if (cause instanceof com.microsoft.sqlserver.jdbc.SQLServerException sqlEx) { // Kiểm tra SQLServerException
                    if (sqlEx.getErrorCode() == 547) {
                        Util.XDialog.alert("Không thể xóa dịch vụ này vì nó đã được sử dụng trong các hóa đơn hoặc chi tiết dịch vụ khác.", "Lỗi Xóa Dịch Vụ");
                    } else {
                        Util.XDialog.alert("Xóa dịch vụ thất bại! Lỗi cơ sở dữ liệu: " + sqlEx.getMessage(), "Lỗi Xóa Dịch Vụ");
                        sqlEx.printStackTrace();
                    }
                } else {
                    Util.XDialog.alert("Xóa dịch vụ thất bại! Lỗi không xác định: " + e.getMessage(), "Lỗi Xóa Dịch Vụ");
                    e.printStackTrace();
                }
            }
        }
    }

    void xoaMDCDichVu() {
        int countSelected = 0;
        for (int i = 0; i < tblDV.getRowCount(); i++) {
            Boolean isSelected = (Boolean) tblDV.getValueAt(i, 3);
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
            StringBuilder errorMessages = new StringBuilder("Các dịch vụ sau không thể xóa được:\n");

            for (int i = tblDV.getRowCount() - 1; i >= 0; i--) {
                Boolean isSelected = (Boolean) tblDV.getValueAt(i, 3);
                if (isSelected != null && isSelected) {
                    try {
                        int serviceIdToDelete = DichVuitems.get(i).getId(); 
                        DVdao.deleteById(serviceIdToDelete);
                        successCount++;
                    } catch (RuntimeException e) {
                        failCount++;
                        String serviceName = (String) tblDV.getValueAt(i, 1);
                        Throwable cause = e.getCause();
                        if (cause instanceof com.microsoft.sqlserver.jdbc.SQLServerException sqlEx) {
                            if (sqlEx.getErrorCode() == 547) {
                                errorMessages.append("- '").append(serviceName).append("': Đã được sử dụng trong các hóa đơn.\n");
                            } else {
                                errorMessages.append("- '").append(serviceName).append("': Lỗi cơ sở dữ liệu: ").append(sqlEx.getMessage()).append("\n");
                            }
                        } else {
                            errorMessages.append("- '").append(serviceName).append("': Lỗi không xác định: ").append(e.getMessage()).append("\n");
                        }
                        e.printStackTrace();
                    }
                }
            }

            lamMDichVu(); 

            if (successCount > 0) {
                Util.XDialog.alert("Đã xóa thành công " + successCount + " dịch vụ.");
            }
            if (failCount > 0) {
                Util.XDialog.alert(errorMessages.toString(), "Lỗi Xóa Dịch Vụ"); 
            }
        }
    }
    
/**
     * ==============================================================================================================================
     * ==================================================== Khach Hang ==============================================================
     * ==============================================================================================================================
     */
    
    // CẢI TIẾN: Khởi tạo DAO một lần để tái sử dụng, tránh tạo đối tượng mới liên tục.
    private final KhachHangDao khachHangDao = new KhachHangDaoImpl(); 
    private List<KhachHang> kh_items = new ArrayList<>(); // Danh sách gốc chứa tất cả khách hàng
    
    // Cần đảm bảo bạn đã khai báo các biến giao diện này ở phần trên của lớp
    // private javax.swing.JTable tabKhachHang;
    // private javax.swing.JTextField txtTenKH, txtSocmt, txtSDT, txtTimKiemKH;
    // private javax.swing.JButton btnSuaKH, btnTaoMoiKH;
    
    void fillTableKhachHang() {
        // CẢI TIẾN: Lấy model hiện tại thay vì tạo mới để giữ lại cấu trúc cột
        DefaultTableModel model = (DefaultTableModel) tabKhachHang.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trên bảng
    
        try {
            kh_items = khachHangDao.findAll(); // Cập nhật danh sách khách hàng gốc
            for (KhachHang kh : kh_items) {
                Object[] row = {
                    kh.getHoTen(),
                    kh.getCmt(),
                    kh.getSdt()
                };
                model.addRow(row);
            }
    
            // CẢI TIẾN: Chỉ khởi tạo sorter một lần nếu nó chưa tồn tại
            if (tabKhachHang.getRowSorter() == null) {
                sorterKH = new TableRowSorter<>(model);
                tabKhachHang.setRowSorter(sorterKH);
            }
    
        } catch (Exception e) {
            XDialog.alert("Lỗi tải dữ liệu khách hàng!");
            e.printStackTrace();
        }
    }
    
    // CẢI TIẾN: Tìm kiếm trên cả 3 cột: Tên, CMT và SĐT
    void timKiemKhachHang(String keyword) {
        if (sorterKH == null) return;
    
        if (keyword == null || keyword.trim().isEmpty()) {
            sorterKH.setRowFilter(null);
        } else {
            // "(?i)" để tìm kiếm không phân biệt chữ hoa, chữ thường
            String searchKeyword = "(?i)" + keyword.trim();
            // Tìm kiếm trên các cột Tên (0), CMT (1), SĐT (2)
            sorterKH.setRowFilter(RowFilter.regexFilter(searchKeyword, 0, 1, 2));
        }
    }
    
    // CẢI TIẾN: Đổi tên hàm để rõ nghĩa hơn. Hàm này được gọi khi người dùng click vào một hàng trên bảng
    void displaySelectedKhachHang() {
        int selectedViewRow = tabKhachHang.getSelectedRow();
        if (selectedViewRow >= 0) {
            // SỬA LỖI: Luôn chuyển đổi index của view sang model để lấy đúng dữ liệu khi bảng bị lọc/sắp xếp
            int modelRowIndex = tabKhachHang.convertRowIndexToModel(selectedViewRow);
            
            // Lấy CMT từ model để đảm bảo tính duy nhất và chính xác
            String cmt = (String) tabKhachHang.getModel().getValueAt(modelRowIndex, 1);
            
            // Tìm khách hàng trong danh sách gốc
            KhachHang kh = findKhachHangByCmt(cmt);
            if (kh != null) {
                setFormKH(kh);
                suatblKH(true); // Bật nút Sửa, tắt nút Tạo mới
            }
        }
    }
    
    void setFormKH(KhachHang kh) {
        txtTenKH.setText(kh.getHoTen());
        txtSocmt.setText(kh.getCmt());
        txtSDT.setText(kh.getSdt());
    }
    
    void suatblKH(boolean isEditing) {
        btnSuaKH.setEnabled(isEditing);
        btnTaoMoiKH.setEnabled(!isEditing);
    }
    
    KhachHang getFormKH() {
        KhachHang kh = new KhachHang();
        kh.setHoTen(txtTenKH.getText().trim());
        kh.setCmt(txtSocmt.getText().trim());
        kh.setSdt(txtSDT.getText().trim());
        return kh;
    }
    
    void btnTaoMoiKH() {
        KhachHang kh = getFormKH();
        if (!validateInput(kh, null)) { // Dùng hàm validate tập trung, null vì đang tạo mới
            return;
        }
        
        try {
            khachHangDao.create(kh);
            fillTableKhachHang();
            clearFormKH();
            XDialog.alert("Thêm mới khách hàng thành công!");
        } catch (Exception e) {
            XDialog.alert("Thêm mới khách hàng thất bại!");
            e.printStackTrace();
        }
    }
    
    void updateKH() {
        int selectedViewRow = tabKhachHang.getSelectedRow();
        if (selectedViewRow < 0) {
            XDialog.alert("Bạn chưa chọn khách hàng nào để sửa.");
            return;
        }
        
        // SỬA LỖI: Lấy đúng đối tượng KhachHang cần sửa, ngay cả khi bảng đã được lọc/sắp xếp
        int modelRowIndex = tabKhachHang.convertRowIndexToModel(selectedViewRow);
        String cmtCu = (String) tabKhachHang.getModel().getValueAt(modelRowIndex, 1);
        KhachHang khToUpdate = findKhachHangByCmt(cmtCu);
        if (khToUpdate == null) {
            XDialog.alert("Lỗi: Không tìm thấy khách hàng trong danh sách gốc.");
            return;
        }
    
        KhachHang khFromForm = getFormKH();
        if (!validateInput(khFromForm, khToUpdate.getId())) { // Truyền ID để bỏ qua chính nó khi check trùng
            return;
        }
    
        // Cập nhật thông tin cho đối tượng gốc
        khToUpdate.setHoTen(khFromForm.getHoTen());
        khToUpdate.setCmt(khFromForm.getCmt());
        khToUpdate.setSdt(khFromForm.getSdt());
    
        try {
            khachHangDao.update(khToUpdate);
            fillTableKhachHang();
            clearFormKH();
            XDialog.alert("Cập nhật khách hàng thành công!");
        } catch (Exception e) {
            XDialog.alert("Cập nhật khách hàng thất bại!");
            e.printStackTrace();
        }
    }
    
    void deleteKH() {
        int selectedViewRow = tabKhachHang.getSelectedRow();
        if (selectedViewRow < 0) {
            XDialog.alert("Bạn chưa chọn khách hàng nào để xóa.");
            return;
        }
    
        if (XDialog.confirm("Bạn có chắc chắn muốn xóa khách hàng này không?")) {
            try {
                // SỬA LỖI: Lấy đúng đối tượng cần xóa ngay cả khi bảng đã lọc/sắp xếp
                int modelRowIndex = tabKhachHang.convertRowIndexToModel(selectedViewRow);
                String cmt = (String) tabKhachHang.getModel().getValueAt(modelRowIndex, 1);
                KhachHang khToDelete = findKhachHangByCmt(cmt);
                if(khToDelete == null) {
                    XDialog.alert("Lỗi: Không tìm thấy khách hàng để xóa.");
                    return;
                }
                
                khachHangDao.deleteById(khToDelete.getId());
                fillTableKhachHang();
                clearFormKH();
                XDialog.alert("Xóa khách hàng thành công!");
            } catch (Exception e) {
                // Hiển thị thông báo cụ thể hơn nếu xóa không thành công do ràng buộc khóa ngoại
                XDialog.alert("Xóa khách hàng thất bại! Khách hàng có thể đang liên quan đến một hóa đơn hoặc phiếu đặt phòng.");
                e.printStackTrace();
            }
        }
    }
    
    void clearFormKH() {
        txtTenKH.setText("");
        txtSocmt.setText("");
        txtSDT.setText("");
        txtTimKiemKH.setText("");
        
        // CẢI TIẾN: Chỉ cần xóa bộ lọc thay vì load lại cả bảng từ DB
        if (sorterKH != null) {
            sorterKH.setRowFilter(null);
        }
        
        tabKhachHang.clearSelection();
        suatblKH(false); // Chuyển về trạng thái thêm mới
    }
    
    /**
    * Các phương thức kiểm tra (validate) và tiện ích
    */
    
    // CẢI TIẾN: Hàm validate tập trung
    private boolean validateInput(KhachHang kh, Integer currentId) {
        if (!validateCustomerName(kh.getHoTen()) || 
            !validateIDNumber(kh.getCmt()) || 
            !validatePhoneNumber(kh.getSdt())) {
            return false;
        }
        
        String duplicateField = findDuplicateField(kh, currentId);
        if (duplicateField != null) {
            if (duplicateField.equals("cmt")) {
                XDialog.alert("Số CCCD/CMT này đã tồn tại!");
            } else if (duplicateField.equals("sdt")) {
                XDialog.alert("Số điện thoại này đã tồn tại!");
            }
            return false;
        }
        return true;
    }
    
    // SỬA LỖI: Phương thức kiểm tra trùng lặp được viết lại hoàn toàn
    private String findDuplicateField(KhachHang khToCheck, Integer currentKhachHangId) {
        String cmtToCheck = khToCheck.getCmt();
        String sdtToCheck = khToCheck.getSdt();
    
        for (KhachHang kh : kh_items) { // Kiểm tra trên danh sách đã tải, không query lại DB
            // Bỏ qua chính nó khi đang ở chế độ cập nhật
            if (currentKhachHangId != null && kh.getId() == currentKhachHangId) {
                continue;
            }
    
            // SỬA LỖI: Thêm kiểm tra null trước khi so sánh để tránh NullPointerException
            String existingCmt = kh.getCmt();
            if (existingCmt != null && existingCmt.equalsIgnoreCase(cmtToCheck)) {
                return "cmt"; // Trả về tên trường bị trùng
            }
            
            String existingSdt = kh.getSdt();
            if (existingSdt != null && existingSdt.equalsIgnoreCase(sdtToCheck)) {
                return "sdt"; // Trả về tên trường bị trùng
            }
        }
        return null; // Không tìm thấy trùng lặp
    }
    
    // CẢI TIẾN: Hàm tiện ích để tìm khách hàng trong danh sách gốc bằng CMT
    private KhachHang findKhachHangByCmt(String cmt) {
        if (cmt == null) return null;
        for (KhachHang kh : kh_items) {
            if (cmt.equals(kh.getCmt())) {
                return kh;
            }
        }
        return null;
    }
    
//    // Giữ nguyên các hàm validate của bạn
//    private boolean validateCustomerName(String name) {
//        if (name == null || name.trim().isEmpty()) {
//            XDialog.alert("Tên khách hàng không được để trống!");
//            return false;
//        }
//        String trimmedName = name.trim();
//        if (!trimmedName.matches("^[\\p{L} .'-]+$")) { // Thêm ^ và $ để khớp toàn bộ chuỗi
//            XDialog.alert("Tên khách hàng không hợp lệ.");
//            return false;
//        }
//        String[] words = trimmedName.split("\\s+");
//        for (String word : words) {
//            if (!word.isEmpty() && !Character.isUpperCase(word.charAt(0))) {
//                XDialog.alert("Chữ cái đầu của mỗi từ trong tên khách hàng phải viết hoa.");
//                return false;
//            }
//        }
//        return true;
//    }
//    
//    private boolean validateIDNumber(String cccd) {
//        if (cccd == null || cccd.trim().isEmpty()) {
//            XDialog.alert("Số CCCD không được để trống!");
//            return false;
//        }
//        String trimmedCccd = cccd.trim();
//        if (!trimmedCccd.matches("^\\d{12}$")) { // Gộp 2 điều kiện vào 1 regex
//            XDialog.alert("Số CCCD phải là 12 chữ số.");
//            return false;
//        }
//        return true;
//    }
//    
//    private boolean validatePhoneNumber(String sdt) {
//        if (sdt == null || sdt.trim().isEmpty()) {
//            XDialog.alert("Số điện thoại không được để trống!");
//            return false;
//        }
//        
//        if (!sdt.trim().matches("^0\\d{9}$")) {
//            XDialog.alert("Số điện thoại không hợp lệ. SĐT phải bắt đầu bằng 0 và có 17 chữ số.");
//            return false;
//        }
//        return true;
//    }
        private boolean validateCustomerName(String name) {
       if (name == null || name.trim().isEmpty()) {
           XDialog.alert("Tên khách hàng không được để trống!");
           return false;
       }

       String trimmedName = name.trim();
       if (!trimmedName.matches("[\\p{L} .'-]+")) {
           XDialog.alert("Tên khách hàng chỉ được chứa chữ cái, dấu cách, dấu chấm, dấu nháy đơn và dấu gạch nối.");
           return false;
       }

       String[] words = trimmedName.split("\\s+");
       for (String word : words) {
           if (!word.isEmpty() && !Character.isUpperCase(word.charAt(0))) {
               XDialog.alert("Chữ cái đầu của mỗi từ trong tên khách hàng phải viết hoa.");
               return false;
           }
       }
       return true;
   }



    private boolean validateIDNumber(String cccd) {
        if (cccd == null || cccd.trim().isEmpty()) {
            XDialog.alert("Số CCCD không được để trống!");
            return false;
        }

        String trimmedCccd = cccd.trim();

        // Kiểm tra xem có phải là số không
        if (!trimmedCccd.matches("\\d+")) {
            XDialog.alert("Số CCCD chỉ được chứa chữ số.");
            return false;
        }


        // Thêm điều kiện kiểm tra độ dài phải là 12 ký tự
        if (trimmedCccd.length() != 12) {
            XDialog.alert("Số CCCD phải có đúng 12 chữ số.");
            return false;
        }

        return true;
    }



    private boolean validatePhoneNumber(String sdt) {
        if (sdt == null || sdt.trim().isEmpty()) {
            XDialog.alert("Số điện thoại không được để trống!");
            return false;
        }
        String trimmedSdt = sdt.trim();
        if (!trimmedSdt.startsWith("0")) {
            XDialog.alert("Số điện thoại phải bắt đầu bằng số 0.");
            return false;
        }

        if (!trimmedSdt.matches("\\d{7,15}")) {
            XDialog.alert("Số điện thoại phải có từ 7 đến 15 chữ số và chỉ chứa chữ số.");
            return false;
        }
        return true;
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