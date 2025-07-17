package Util;

import Dao.entity.NguoiDung;


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
}
