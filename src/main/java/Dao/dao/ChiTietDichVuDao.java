package Dao.dao;

import Dao.entity.ChiTietDichVu;
import java.util.List;

public interface ChiTietDichVuDao extends CrudDao<ChiTietDichVu, Integer> {
    /**
     * Tìm tất cả các chi tiết dịch vụ theo ID của hóa đơn.
     * @param idHoaDon ID của hóa đơn.
     * @return Danh sách các chi tiết dịch vụ.
     */
    List<ChiTietDichVu> findByIdHoaDon(Integer idHoaDon);
}