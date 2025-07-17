package Dao.dao;

import Dao.entity.ChiTietThuePhong;
import java.util.List;

public interface ChiTietThuePhongDao extends CrudDao<ChiTietThuePhong, Integer> {
    List<ChiTietThuePhong> findByIdHoaDon(Integer idHoaDon);
}