package Dao.daoimpl;

import Dao.dao.DatPhongDao;
import Dao.entity.DatPhong;
import Util.XJdbc;
import Util.XQuery;
import java.util.List;

public class DatPhongDaoImpl implements DatPhongDao {

    @Override
public DatPhong create(DatPhong entity) {
    String sql = "INSERT INTO DatPhong (IdKhachHang, IdNguoiDung, NgayDat, NgayNhanPhongDuKien, NgayTraPhongDuKien, TrangThai, GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?)";
    XJdbc.executeUpdate(sql, entity.getIdKhachHang(), entity.getIdNguoiDung(), entity.getNgayDat(),
            entity.getNgayNhanPhongDuKien(), entity.getNgayTraPhongDuKien(), entity.getTrangThai(), entity.getGhiChu());
    
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
}