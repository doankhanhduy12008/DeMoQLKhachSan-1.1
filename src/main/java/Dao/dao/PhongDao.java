package Dao.dao;

import Dao.entity.Phong;
import java.util.List;

public interface PhongDao extends CrudDao<Phong, Integer> {
    List<Phong> findByIdLoaiPhong(Integer idLoaiPhong);
    
    Phong findBySoPhong(String soPhong); 
}