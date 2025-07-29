package Dao.daoimpl;

import Dao.dao.DichVuDao;
import Dao.entity.DichVu;
import Util.XJdbc;
import Util.XQuery;
import java.util.List;

public class DichVuDaoImpl implements DichVuDao {

    @Override
    public DichVu create(DichVu entity) {
        String sql = "INSERT INTO DichVu (TenDichVu, DonGia, GiamGia) VALUES (?, ?, ?)";
        XJdbc.executeUpdate(sql, entity.getTenDichVu(), entity.getDonGia(), entity.getGiamGia());
        return null;
    }

    @Override
    public void update(DichVu entity) {
        String sql = "UPDATE DichVu SET TenDichVu = ?, DonGia = ?, GiamGia = ? WHERE Id = ?";
        XJdbc.executeUpdate(sql, entity.getTenDichVu(), entity.getDonGia(), entity.getGiamGia(), entity.getId());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM DichVu WHERE Id = ?";
        XJdbc.executeUpdate(sql, id);
    }

    @Override
    public List<DichVu> findAll() {
        String sql = "SELECT * FROM DichVu";
        return XQuery.getBeanList(DichVu.class, sql);
    }

    @Override
    public DichVu findById(Integer id) {
        String sql = "SELECT * FROM DichVu WHERE Id = ?";
        return XQuery.getSingleBean(DichVu.class, sql, id);
    }
    
    @Override
    public DichVu findByTenDichVu(String tenDichVu) throws Exception {
        String sql = "SELECT * FROM DichVu WHERE TenDichVu = ?";
        return XQuery.getSingleBean(DichVu.class, sql, tenDichVu);
    }
}