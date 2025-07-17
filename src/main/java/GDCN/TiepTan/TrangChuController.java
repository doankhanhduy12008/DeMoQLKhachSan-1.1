/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDCN.TiepTan;

import GDCN.Chung.DangNhapJDialog;
import GDCN.DichVu.TrangChuDV;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Acer
 */
public interface TrangChuController extends CrudController{
    void anh();
default void showJDialog(JDialog dialog){
dialog.setLocationRelativeTo(null);
dialog.setVisible(true);
}
default void showJFrame(JFrame frame) {
    frame.setLocationRelativeTo(null); // căn giữa màn hình
    frame.setVisible(true);            // hiển thị frame
}
default void showThemPhongJDiaLog(JFrame frame){
this.showJDialog(new ChonLoaiPhong(frame, true));
}
default void showThemDichVuJDiaLog(JFrame frame){
this.showJDialog(new ThemDichVu(frame, true));
}
default void showChonLoaiPhongJDiaLog(JFrame frame){
this.showJDialog(new ChonLoaiPhong(frame, true));
}
default void showThongTinPhongJDiaLog(JFrame frame){
this.showJDialog(new ThongTinPhong(frame, true));
}
default void showDX(JFrame frame){
this.showJDialog(new DangNhapJDialog(frame, true));
}
}
