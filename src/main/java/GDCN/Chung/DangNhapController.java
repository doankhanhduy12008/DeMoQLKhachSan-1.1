/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDCN.Chung;

import GDCN.DichVu.TrangChuDV;
import GDCN.QuanLy.TrangChuJDialog;
import GDCN.QuanLy.TrangChuQLJFarme;
import GDCN.TiepTan.TrangChuTT;
import Util.XDialog;
import java.awt.Dialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Acer
 */
public interface DangNhapController {
    void open();
void login();
default void exit(){
if(XDialog.confirm("Bạn muốn kết thúc?")){
System.exit(0);
}
}

default void showJFrame(JFrame frame){
frame.setLocationRelativeTo(null);
frame.setVisible(true);
}


default void showDV() {
    this.showJFrame(new TrangChuDV());
}
default void showTT() {
    this.showJFrame(new TrangChuTT());
}
default void showQL(){
    this.showJFrame(new TrangChuQLJFarme());
}
}
