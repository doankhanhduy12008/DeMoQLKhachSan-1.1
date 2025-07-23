package Dao.daoimpl;

import Dao.dao.ChiTietThuePhongDao;
import Dao.entity.ChiTietThuePhong;
import Util.XJdbc;
import Util.XQuery;
import java.util.List;

public class ChiTietThuePhongDaoImpl implements ChiTietThuePhongDao {

    @Override
    public ChiTietThuePhong create(ChiTietThuePhong entity) {
        String sql = "INSERT INTO ChiTietThuePhong (IdHoaDon, IdPhong, ThoiGianNhanPhong, ThoiGianTraPhong) VALUES (?, ?, ?, ?)";
        XJdbc.executeUpdate(sql, entity.getIdHoaDon(), entity.getIdPhong(), entity.getThoiGianNhanPhong(), entity.getThoiGianTraPhong());
        return null;
    }

    @Override
    public void update(ChiTietThuePhong entity) {
        // Sửa đổi câu lệnh UPDATE để sử dụng cả IdHoaDon và IdPhong trong mệnh đề WHERE
        String sql = "UPDATE ChiTietThuePhong SET ThoiGianNhanPhong = ?, ThoiGianTraPhong = ? WHERE IdHoaDon = ? AND IdPhong = ?";
        XJdbc.executeUpdate(sql, entity.getThoiGianNhanPhong(), entity.getThoiGianTraPhong(), entity.getIdHoaDon(), entity.getIdPhong());
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM ChiTietThuePhong WHERE IdHoaDon = ?";
        XJdbc.executeUpdate(sql, id);
    }

    @Override
    public List<ChiTietThuePhong> findAll() {
        String sql = "SELECT * FROM ChiTietThuePhong";
        return XQuery.getBeanList(ChiTietThuePhong.class, sql);
    }

    @Override
    public ChiTietThuePhong findById(Integer id) {
        // Lưu ý: findById chỉ tìm theo IdHoaDon, có thể cần một phương thức findByCompoundId nếu khóa chính là composite
        String sql = "SELECT * FROM ChiTietThuePhong WHERE IdHoaDon = ?";
        return XQuery.getSingleBean(ChiTietThuePhong.class, sql, id);
    }

    @Override
    public List<ChiTietThuePhong> findByIdHoaDon(Integer idHoaDon) {
        String sql = "SELECT * FROM ChiTietThuePhong WHERE IdHoaDon = ?";
        return XQuery.getBeanList(ChiTietThuePhong.class, sql, idHoaDon);
    }
}