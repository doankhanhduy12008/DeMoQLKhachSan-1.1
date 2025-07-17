package Dao.dao;

import Dao.entity.KhachHang;

public interface KhachHangDao extends CrudDao<KhachHang, Integer> {
    KhachHang findBySDT(String sdt);
}