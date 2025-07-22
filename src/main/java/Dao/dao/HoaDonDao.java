package Dao.dao;

import Dao.entity.HoaDon;
import java.util.List;

public interface HoaDonDao extends CrudDao<HoaDon, Integer> {
    List<HoaDon> findByIdKhachHang(Integer idKhachHang);
    void deleteByIdDatPhong(Integer idDatPhong);
}