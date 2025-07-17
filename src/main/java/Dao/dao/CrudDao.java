package Dao.dao;

import java.util.List;

/**
 * Giao diện chung cho các thao tác CRUD (Create, Read, Update, Delete).
 * @param <T> Kiểu của entity
 * @param <ID> Kiểu của khóa chính
 */
public interface CrudDao<T, ID> {
    /**
     * Thêm một thực thể mới vào cơ sở dữ liệu.
     * @param entity Thực thể cần thêm.
     * @return Thực thể đã được thêm.
     */
    T create(T entity);

    /**
     * Cập nhật một thực thể đã có trong cơ sở dữ liệu.
     * @param entity Thực thể với thông tin cần cập nhật.
     */
    void update(T entity);

    /**
     * Xóa một thực thể khỏi cơ sở dữ liệu dựa trên ID.
     * @param id Khóa chính của thực thể cần xóa.
     */
    void deleteById(ID id);

    /**
     * Lấy tất cả các thực thể từ cơ sở dữ liệu.
     * @return Danh sách tất cả các thực thể.
     */
    List<T> findAll();

    /**
     * Tìm một thực thể dựa trên ID.
     * @param id Khóa chính của thực thể cần tìm.
     * @return Thực thể tìm thấy hoặc null nếu không tồn tại.
     */
    T findById(ID id);
}