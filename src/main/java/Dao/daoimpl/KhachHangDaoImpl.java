package Dao.daoimpl;

import Dao.dao.KhachHangDao;
import Dao.entity.KhachHang;
import Util.XJdbc;
import Util.XQuery;
import java.util.List;

public class KhachHangDaoImpl implements KhachHangDao {

    @Override
    public KhachHang create(KhachHang entity) {
        String sql = "INSERT INTO KhachHang (HoTen, SDT, CMT) VALUES (?, ?, ?)";
        XJdbc.executeUpdate(sql, entity.getHoTen(), entity.getSdt(), entity.getCmt());
        return null; 
    }

    @Override
    public void update(KhachHang entity) {
        String sql = "UPDATE KhachHang SET HoTen = ?, SDT = ?, CMT = ? WHERE Id = ?";
        XJdbc.executeUpdate(sql, entity.getHoTen(), entity.getSdt(), entity.getCmt(), entity.getId());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM KhachHang WHERE Id = ?";
        XJdbc.executeUpdate(sql, id);
    }

    @Override
    public List<KhachHang> findAll() {
        String sql = "SELECT * FROM KhachHang";
        return XQuery.getBeanList(KhachHang.class, sql);
    }

    @Override
    public KhachHang findById(Integer id) {
        String sql = "SELECT * FROM KhachHang WHERE Id = ?";
        return XQuery.getSingleBean(KhachHang.class, sql, id);
    }
    
    @Override
    public KhachHang findBySDT(String sdt) {
        String sql = "SELECT * FROM KhachHang WHERE SDT = ?";
        return XQuery.getSingleBean(KhachHang.class, sql, sdt);
    }
    
    @Override
    public List<KhachHang> searchBySDT(String sdt) {
        String sql = "SELECT * FROM KhachHang WHERE SDT LIKE ?";
        return XQuery.getBeanList(KhachHang.class, sql, "%" + sdt + "%");
    }
}