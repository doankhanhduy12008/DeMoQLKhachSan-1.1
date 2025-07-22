package Util;

import Dao.entity.NguoiDung;
import Dao.entity.Phong;
import java.math.BigDecimal;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class XAuth {
    public static NguoiDung user = new NguoiDung.Builder()
                        .username("Bachbeo")
                        .hoVaTen("Nguyễn Văn A")
                        .matKhau("matkhau123")
                        .vaiTro("Tiếp tân")
                        .sdt("0987654321")
                        .anh("avatar.png")
                        .trangThai(true)
                        .build();
    
 
   public static Phong phong = new Phong.Builder()
    .id(101)
    .soPhong("VIP01")
    .idLoaiPhong(1)
    .tang(10)
    .trangThai("Trống")
    .giaTien(new BigDecimal("500000.0"))
    .giamGia(0.1) // Giảm 10%
    .ghiChu("Phòng có view biển đẹp")
    .build();             
}
