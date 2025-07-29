/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDCN.QuanLy;

import Dao.entity.LoaiPhong; // Thêm import này
import GDCN.Chung.DangNhapJDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
// import javax.swing.text.html.parser.Entity; // Xóa hoặc comment dòng này

/**
 *
 * @author ooOoo
 */
public interface TrangChuQLController {
    default void showJDialog(JDialog dialog){
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
}
default void showDX(JFrame frame){
    this.showJDialog(new DangNhapJDialog(frame, true));
    }
}