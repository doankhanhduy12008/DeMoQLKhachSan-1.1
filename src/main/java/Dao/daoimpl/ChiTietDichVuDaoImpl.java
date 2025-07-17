package Dao.daoimpl;

import Dao.dao.ChiTietDichVuDao;
import Dao.entity.ChiTietDichVu;
import Util.XJdbc;
import Util.XQuery;
import java.util.List;

public class ChiTietDichVuDaoImpl implements ChiTietDichVuDao {

    @Override
    public ChiTietDichVu create(ChiTietDichVu entity) {
        String sql = "INSERT INTO ChiTietDichVu (IdHoaDon, IdDichVu, IdNguoiDungThem, SoLuong, TongTien, ThoiGian) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.executeUpdate(sql, entity.getIdHoaDon(), entity.getIdDichVu(), entity.getIdNguoiDungThem(), 
                entity.getSoLuong(), entity.getTongTien(), entity.getThoiGian());
        return null;
    }

    @Override
    public void update(ChiTietDichVu entity) {
        String sql = "UPDATE ChiTietDichVu SET IdDichVu = ?, IdNguoiDungThem = ?, SoLuong = ?, TongTien = ?, ThoiGian = ? WHERE IdHoaDon = ?";
        XJdbc.executeUpdate(sql, entity.getIdDichVu(), entity.getIdNguoiDungThem(), entity.getSoLuong(), 
                entity.getTongTien(), entity.getThoiGian(), entity.getIdHoaDon());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM ChiTietDichVu WHERE IdHoaDon = ?";
        XJdbc.executeUpdate(sql, id);
    }

    @Override
    public List<ChiTietDichVu> findAll() {
        String sql = "SELECT * FROM ChiTietDichVu";
        return XQuery.getBeanList(ChiTietDichVu.class, sql);
    }

    @Override
    public ChiTietDichVu findById(Integer id) {
        String sql = "SELECT * FROM ChiTietDichVu WHERE IdHoaDon = ?";
        return XQuery.getSingleBean(ChiTietDichVu.class, sql, id);
    }

    @Override
    public List<ChiTietDichVu> findByIdHoaDon(Integer idHoaDon) {
        String sql = "SELECT * FROM ChiTietDichVu WHERE IdHoaDon = ?";
        return XQuery.getBeanList(ChiTietDichVu.class, sql, idHoaDon);
    }
}