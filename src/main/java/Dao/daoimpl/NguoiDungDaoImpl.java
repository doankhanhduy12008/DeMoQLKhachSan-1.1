package Dao.daoimpl;

import Dao.dao.NguoiDungDao;
import Dao.entity.NguoiDung;
import Util.XJdbc;
import Util.XQuery;
import java.util.List;

public class NguoiDungDaoImpl implements NguoiDungDao {

    @Override
    public NguoiDung create(NguoiDung entity) {
        String sql = "INSERT INTO NguoiDung (Username, HoVaTen, MatKhau, VaiTro, SDT, Anh, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        XJdbc.executeUpdate(sql, 
                entity.getUsername(), 
                entity.getHoVaTen(), 
                entity.getMatKhau(), 
                entity.getVaiTro(), 
                entity.getSdt(), 
                entity.getAnh(),
                entity.isTrangThai());
        return entity;
    }

    @Override
    public void update(NguoiDung entity) {
        String sql = "UPDATE NguoiDung SET HoVaTen = ?, MatKhau = ?, VaiTro = ?, SDT = ?, Anh = ?, TrangThai = ? WHERE Username = ?";
        XJdbc.executeUpdate(sql, 
                entity.getHoVaTen(), 
                entity.getMatKhau(), 
                entity.getVaiTro(), 
                entity.getSdt(), 
                entity.getAnh(), 
                entity.isTrangThai(),
                entity.getUsername());
    }

    @Override
    public void deleteById(String username) {
        String sql = "DELETE FROM NguoiDung WHERE Username = ?";
        XJdbc.executeUpdate(sql, username);
    }

    @Override
    public List<NguoiDung> findAll() {
        String sql = "SELECT * FROM NguoiDung";
        return XQuery.getBeanList(NguoiDung.class, sql);
    }

    @Override
    public NguoiDung findById(String username) {
        String sql = "SELECT * FROM NguoiDung WHERE Username = ?";
        return XQuery.getSingleBean(NguoiDung.class, sql, username);
    }
}
