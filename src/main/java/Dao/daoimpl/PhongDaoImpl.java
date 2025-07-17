package Dao.daoimpl;

import Dao.dao.PhongDao;
import Dao.entity.Phong;
import Util.XJdbc;
import Util.XQuery;
import java.util.List;

public class PhongDaoImpl implements PhongDao {

    @Override
    public Phong create(Phong entity) {
        String sql = "INSERT INTO Phong (IdLoaiPhong, SoPhong, Tang, TrangThai, GiaTien, GiamGia, GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?)";
        XJdbc.executeUpdate(sql, entity.getIdLoaiPhong(), entity.getSoPhong(), entity.getTang(),
                entity.getTrangThai(), entity.getGiaTien(), entity.getGiamGia(), entity.getGhiChu());
        return null;
    }

    @Override
    public void update(Phong entity) {
        String sql = "UPDATE Phong SET IdLoaiPhong = ?, SoPhong = ?, Tang = ?, TrangThai = ?, GiaTien = ?, GiamGia = ?, GhiChu = ? WHERE Id = ?";
        XJdbc.executeUpdate(sql, entity.getIdLoaiPhong(), entity.getSoPhong(), entity.getTang(),
                entity.getTrangThai(), entity.getGiaTien(), entity.getGiamGia(), entity.getGhiChu(), entity.getId());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM Phong WHERE Id = ?";
        XJdbc.executeUpdate(sql, id);
    }

    @Override
    public List<Phong> findAll() {
        String sql = "SELECT * FROM Phong";
        return XQuery.getBeanList(Phong.class, sql);
    }

    @Override
    public Phong findById(Integer id) {
        String sql = "SELECT * FROM Phong WHERE Id = ?";
        return XQuery.getSingleBean(Phong.class, sql, id);
    }

    @Override
    public List<Phong> findByIdLoaiPhong(Integer idLoaiPhong) {
        String sql = "SELECT * FROM Phong WHERE IdLoaiPhong = ?";
        return XQuery.getBeanList(Phong.class, sql, idLoaiPhong);
    }
}