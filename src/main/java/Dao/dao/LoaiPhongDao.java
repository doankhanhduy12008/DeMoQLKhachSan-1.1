package Dao.dao;

import Dao.entity.LoaiPhong;
import java.util.List;

public interface LoaiPhongDao extends CrudDao<LoaiPhong, Integer> {
    List<LoaiPhong> findByName(String tenLoaiPhong);
}