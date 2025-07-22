package Dao.daoimpl;

import Dao.dao.DatPhongDao;
import Dao.dao.HoaDonDao;
import Dao.entity.DatPhong;
import Dao.entity.HoaDon;
import Util.XJdbc;
import Util.XQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatPhongDaoImpl implements DatPhongDao {


    @Override
    public DatPhong create(DatPhong entity) {
    String sql = "INSERT INTO DatPhong (IdKhachHang, IdNguoiDung, NgayDat, NgayNhanPhongDuKien, NgayTraPhongDuKien, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
    XJdbc.executeUpdate(sql, 
            entity.getIdKhachHang(), 
            entity.getIdNguoiDung(), 
            entity.getNgayDat(),
            entity.getNgayNhanPhongDuKien(), 
            entity.getNgayTraPhongDuKien(), // Sẽ được thêm ở bước sau
            entity.getTrangThai()
    );
    
    // Lấy lại bản ghi vừa tạo để có ID mới nhất
    String findNewestSql = "SELECT TOP 1 * FROM DatPhong ORDER BY Id DESC";
    return XQuery.getSingleBean(DatPhong.class, findNewestSql);
}

    @Override
    public void update(DatPhong entity) {
        String sql = "UPDATE DatPhong SET IdKhachHang = ?, IdNguoiDung = ?, NgayDat = ?, NgayNhanPhongDuKien = ?, NgayTraPhongDuKien = ?, TrangThai = ?, GhiChu = ? WHERE Id = ?";
        XJdbc.executeUpdate(sql, entity.getIdKhachHang(), entity.getIdNguoiDung(), entity.getNgayDat(), 
                entity.getNgayNhanPhongDuKien(), entity.getNgayTraPhongDuKien(), entity.getTrangThai(), entity.getGhiChu(), entity.getId());
    }

    @Override
    public void deleteById(Integer id) {
        // Bước 1: Xóa các bản ghi ChiTietThuePhong và ChiTietDichVu liên quan đến các HoaDon của DatPhong này
        // Điều này phải được thực hiện trước khi xóa HoaDon
        XJdbc.executeUpdate("DELETE FROM ChiTietThuePhong WHERE IdHoaDon IN (SELECT Id FROM HoaDon WHERE IdDatPhong = ?)", id);
        XJdbc.executeUpdate("DELETE FROM ChiTietDichVu WHERE IdHoaDon IN (SELECT Id FROM HoaDon WHERE IdDatPhong = ?)", id);

        // Bước 2: Xóa các bản ghi HoaDon liên quan trực tiếp đến DatPhong này
        XJdbc.executeUpdate("DELETE FROM HoaDon WHERE IdDatPhong = ?", id);

        // Bước 3: Cuối cùng, xóa bản ghi DatPhong
        String sql = "DELETE FROM DatPhong WHERE Id = ?";
        XJdbc.executeUpdate(sql, id);
    }
    
    @Override
    public List<DatPhong> findAll() {
        String sql = "SELECT * FROM DatPhong";
        return XQuery.getBeanList(DatPhong.class, sql);
    }

    @Override
    public DatPhong findById(Integer id) {
        String sql = "SELECT * FROM DatPhong WHERE Id = ?";
        return XQuery.getSingleBean(DatPhong.class, sql, id);
    }

    @Override
    public void deleteByIdNguoiDung(String idNguoiDung) {
        String findDatPhongIdsSql = "SELECT Id FROM DatPhong WHERE IdNguoiDung = ?";
        List<Integer> datPhongIds = new ArrayList<>(); // Khởi tạo ArrayList

        try (ResultSet rs = XJdbc.executeQuery(findDatPhongIdsSql, idNguoiDung)) { // Sử dụng XJdbc.executeQuery
            while (rs.next()) {
                datPhongIds.add(rs.getInt("Id")); // Lấy giá trị int từ ResultSet và thêm vào danh sách
            }
        } catch (Exception e) {
            // Ném RuntimeException để báo lỗi trong quá trình lấy ID
            throw new RuntimeException("Lỗi khi lấy ID DatPhong để xóa: " + e.getMessage(), e);
        }

        for (Integer datPhongId : datPhongIds) {
            this.deleteById(datPhongId); // Lời gọi này sẽ sử dụng deleteById(Integer id) đã sửa ở trên
        }
    }
}