package Dao.dao;

import Dao.entity.DatPhong;

public interface DatPhongDao extends CrudDao<DatPhong, Integer> {
    void deleteByIdNguoiDung(String idNguoiDung);
}