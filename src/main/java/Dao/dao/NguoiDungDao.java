package Dao.dao;

import Dao.entity.NguoiDung;

/**
 * Giao diện cho các thao tác dữ liệu của NguoiDung.
 * Khóa chính là Username (String).
 */
public interface NguoiDungDao extends CrudDao<NguoiDung, String> {
    // Có thể thêm các phương thức truy vấn đặc thù khác ở đây nếu cần.
}
