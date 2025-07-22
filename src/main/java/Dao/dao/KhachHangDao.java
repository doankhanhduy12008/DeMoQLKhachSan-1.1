package Dao.dao;

import Dao.entity.KhachHang;
import java.util.List;

public interface KhachHangDao extends CrudDao<KhachHang, Integer> {
    KhachHang findBySDT(String sdt);
    List<KhachHang> searchBySDT(String sdt);
}