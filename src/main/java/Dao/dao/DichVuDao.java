package Dao.dao;

import Dao.entity.DichVu;

public interface DichVuDao extends CrudDao<DichVu, Integer> {
    DichVu findByTenDichVu(String tenDichVu) throws Exception;
}