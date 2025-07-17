package Dao.daoimpl;

import Dao.dao.LoaiPhongDao;
import Dao.entity.LoaiPhong;
import Util.XJdbc;
import Util.XQuery;
import java.util.List;

public class LoaiPhongDaoImpl implements LoaiPhongDao {

    @Override
    public LoaiPhong create(LoaiPhong entity) {
        String sql = "INSERT INTO LoaiPhong (TenLoaiPhong) VALUES (?)";
        XJdbc.executeUpdate(sql, entity.getTenLoaiPhong());
        return null;
    }

    @Override
    public void update(LoaiPhong entity) {
        String sql = "UPDATE LoaiPhong SET TenLoaiPhong = ? WHERE Id = ?";
        XJdbc.executeUpdate(sql, entity.getTenLoaiPhong(), entity.getId());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM LoaiPhong WHERE Id = ?";
        XJdbc.executeUpdate(sql, id);
    }

    @Override
    public List<LoaiPhong> findAll() {
        String sql = "SELECT * FROM LoaiPhong";
        return XQuery.getBeanList(LoaiPhong.class, sql);
    }

    @Override
    public LoaiPhong findById(Integer id) {
        String sql = "SELECT * FROM LoaiPhong WHERE Id = ?";
        return XQuery.getSingleBean(LoaiPhong.class, sql, id);
    }
}