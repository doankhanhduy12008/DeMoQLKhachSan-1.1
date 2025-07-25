package Dao.daoimpl;

import Dao.dao.TinNhanDao;
import Dao.entity.TinNhan;
import Util.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TinNhanDaoImpl implements TinNhanDao {

    @Override
    public TinNhan create(TinNhan entity) {
        String sql = "INSERT INTO TinNhan (NguoiGuiUsername, NoiDungTinNhan, ThoiGianGui) VALUES (?, ?, ?)";
        XJdbc.executeUpdate(sql,
                entity.getNguoiGuiUsername(),
                entity.getNoiDungTinNhan(),
                entity.getThoiGianGui());
        return entity;
    }

    @Override
    public void update(TinNhan entity) {
        String sql = "UPDATE TinNhan SET NoiDungTinNhan = ?, ThoiGianGui = ? WHERE Id = ?";
        XJdbc.executeUpdate(sql,
                entity.getNoiDungTinNhan(),
                entity.getThoiGianGui(),
                entity.getId());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM TinNhan WHERE Id = ?";
        XJdbc.executeUpdate(sql, id);
    }

    @Override
    public List<TinNhan> findAll() {
        String sql = "SELECT Id, NguoiGuiUsername, NoiDungTinNhan, ThoiGianGui FROM TinNhan ORDER BY ThoiGianGui ASC";
        return select(sql);
    }

    @Override
    public TinNhan findById(Integer id) {
        String sql = "SELECT Id, NguoiGuiUsername, NoiDungTinNhan, ThoiGianGui FROM TinNhan WHERE Id = ?";
        List<TinNhan> list = select(sql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    private List<TinNhan> select(String sql, Object... args) {
        List<TinNhan> list = new ArrayList<>();
        try (ResultSet rs = XJdbc.executeQuery(sql, args)) {
            while (rs.next()) {
                TinNhan msg = new TinNhan();
                msg.setId(rs.getInt("Id"));
                msg.setNguoiGuiUsername(rs.getString("NguoiGuiUsername"));
                msg.setNoiDungTinNhan(rs.getString("NoiDungTinNhan"));
                msg.setThoiGianGui(rs.getTimestamp("ThoiGianGui"));
                list.add(msg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi truy vấn tin nhắn: " + e.getMessage(), e);
        }
        return list;
    }
    
}