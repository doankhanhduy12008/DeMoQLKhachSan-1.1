/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDCN.DichVu;

import GDCN.Chung.DangNhapJDialog;
import GDCN.TiepTan.ThemPhong;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Acer
 */
public interface TrangChuDVController extends CrudController{
    void anh();
    default void showJDialog(JDialog dialog){
dialog.setLocationRelativeTo(null);
dialog.setVisible(true);
}
default void showThemPhongJDiaLog(JFrame frame){
this.showJDialog(new XemDichVu(frame, true));
}
default void showXemPhongDVTungTangJDiaLog(JFrame frame){
this.showJDialog(new XemPhongDVTungTang(frame, true));
}
default void showDX(JFrame frame){
this.showJDialog(new DangNhapJDialog(frame, true));
}
}
