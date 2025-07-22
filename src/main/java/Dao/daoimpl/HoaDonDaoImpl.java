package Dao.daoimpl;

import Dao.dao.HoaDonDao;
import Dao.entity.HoaDon;
import Util.XJdbc;
import Util.XQuery;
import java.util.List;

public class HoaDonDaoImpl implements HoaDonDao {

    @Override
    public HoaDon create(HoaDon entity) {
        String sql = "INSERT INTO HoaDon (IdKhachHang, IdNguoiDungLap, IdDatPhong, NgayLap, TongTien, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.executeUpdate(sql, entity.getIdKhachHang(), entity.getIdNguoiDungLap(), entity.getIdDatPhong(), 
                entity.getNgayLap(), entity.getTongTien(), entity.getTrangThai());

        // Lấy lại bản ghi vừa tạo để có ID mới nhất
        String findNewestSql = "SELECT TOP 1 * FROM HoaDon ORDER BY Id DESC";
        return XQuery.getSingleBean(HoaDon.class, findNewestSql);
    }

    @Override
    public void update(HoaDon entity) {
        String sql = "UPDATE HoaDon SET IdKhachHang = ?, IdNguoiDungLap = ?, IdDatPhong = ?, NgayLap = ?, TongTien = ?, TrangThai = ? WHERE Id = ?";
        XJdbc.executeUpdate(sql, entity.getIdKhachHang(), entity.getIdNguoiDungLap(), entity.getIdDatPhong(), 
                entity.getNgayLap(), entity.getTongTien(), entity.getTrangThai(), entity.getId());
    }

    @Override
    public void deleteById(Integer id) {
        // Xóa các bản ghi liên quan trước
        XJdbc.executeUpdate("DELETE FROM ChiTietThuePhong WHERE IdHoaDon = ?", id);
        XJdbc.executeUpdate("DELETE FROM ChiTietDichVu WHERE IdHoaDon = ?", id);
        String sql = "DELETE FROM HoaDon WHERE Id = ?";
        XJdbc.executeUpdate(sql, id);
    }

    @Override
    public List<HoaDon> findAll() {
        String sql = "SELECT * FROM HoaDon";
        return XQuery.getBeanList(HoaDon.class, sql);
    }

    @Override
    public HoaDon findById(Integer id) {
        String sql = "SELECT * FROM HoaDon WHERE Id = ?";
        return XQuery.getSingleBean(HoaDon.class, sql, id);
    }

    @Override
    public List<HoaDon> findByIdKhachHang(Integer idKhachHang) {
        String sql = "SELECT * FROM HoaDon WHERE IdKhachHang = ?";
        return XQuery.getBeanList(HoaDon.class, sql, idKhachHang);
    }
    
     @Override
    public void deleteByIdDatPhong(Integer idDatPhong) {
        String findSql = "SELECT * FROM HoaDon WHERE IdDatPhong = ?";
        List<HoaDon> hoaDonList = XQuery.getBeanList(HoaDon.class, findSql, idDatPhong);
        for (HoaDon hoaDon : hoaDonList) {
            this.deleteById(hoaDon.getId());
        }
    }
}