package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Lớp tiện ích hỗ trợ làm việc với CSDL quan hệ
 * trung beo
 * @author NghiemN
 * @version 1.0
 */

public class XJdbc {

    private static Connection connection;
    
//    public static Connection openConnection() {
//        var driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        var dburl = "jdbc:sqlserver://localhost:1433;database=DEMO_QL_KhachSan;encrypt=true;trustServerCertificate=true;";
//        var username = "sa";
//        var password = "1234$";
//        try {
//            if (!XJdbc.isReady()) {
//                Class.forName(driver);
//                connection = DriverManager.getConnection(dburl, username, password);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return connection;
//    }
    /**
     * Mở kết nối nếu chưa mở hoặc đã đóng
     *
     * @return Kết nối đã sẵn sàng
     */
//    public static Connection openConnection() {
//    // Thông số kết nối
//    // 116.99.33.177 ip cong cong
//    // check ip ipconfig
//    final String url  = "jdbc:sqlserver://116.99.33.177:1433;" 
//                      + "databaseName=QLKhachSan;"
//                      + "encrypt=true;trustServerCertificate=true;";
//    final String user = "QLKhachSan";
//    final String pass = "Duy12@";
//
//    try {
//        if (connection == null || connection.isClosed()) {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connection = DriverManager.getConnection(url, user, pass);
//        }
//    } catch (ClassNotFoundException | SQLException ex) {
//        throw new RuntimeException("Không thể kết nối SQL Server", ex);
//    }
//
//    return connection;
//}
    
    public static Connection openConnection() {
    // Thông số kết nối
    // 26.164.194.236 ip cong cong
    // check ip ipconfig
    final String url  = "jdbc:sqlserver://10.82.70.121:20000;" 
                      + "databaseName=QLKhachSan;"
                      + "encrypt=true;trustServerCertificate=true;";
//    final String url = "jdbc:sqlserver://192.168.1.3:1433;databaseName=QLKhachSan;encrypt=true;trustServerCertificate=true;";
//    final String url = "jdbc:sqlserver://26.162.30.188:1433;databaseName=QLKhachSan;encrypt=true;trustServerCertificate=true;";
    final String user = "QLKhachSan";
    final String pass = "Duy12@";

    try {
        if (connection == null || connection.isClosed()) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        }
    } catch (ClassNotFoundException | SQLException ex) {
        throw new RuntimeException("Không thể kết nối SQL Server", ex);
    }

    return connection;
    }

    /**
     * Đóng kết nối
     */
    public static void closeConnection() {
        try {
            if (XJdbc.isReady()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Kiểm tra kết nối đã sẵn sàng hay chưa
     * @return true nếu kết nối đã được mở
     */
    public static boolean isReady() {
        try {
            return (connection != null && !connection.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Thao tác dữ liệu
     *
     * @param sql câu lệnh SQL (INSERT, UPDATE, DELETE)
     * @param values các giá trị cung cấp cho các tham số trong SQL
     * @return số lượng bản ghi đã thực hiện
     * @throws RuntimeException không thực thi được câu lệnh SQL
     */
    public static int executeUpdate(String sql, Object... values) {
        try {
            var stmt = XJdbc.getStmt(sql, values);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Truy vấn dữ liệu
     *
     * @param sql câu lệnh SQL (SELECT)
     * @param values các giá trị cung cấp cho các tham số trong SQL
     * @return tập kết quả truy vấn
     * @throws RuntimeException không thực thi được câu lệnh SQL
     */
    public static ResultSet executeQuery(String sql, Object... values) {
        try {
            var stmt = XJdbc.getStmt(sql, values);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Truy vấn một giá trị
     *
     * @param <T> kiểu dữ liệu kết quả
     * @param sql câu lệnh SQL (SELECT)
     * @param values các giá trị cung cấp cho các tham số trong SQL
     * @return giá trị truy vấn hoặc null
     * @throws RuntimeException không thực thi được câu lệnh SQL
     */
    public static <T> T getValue(String sql, Object... values) {
        try {
            var resultSet = XJdbc.executeQuery(sql, values);
            if (resultSet.next()) {
                return (T) resultSet.getObject(1);
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Tạo PreparedStatement từ câu lệnh SQL/PROC
     *
     * @param sql câu lệnh SQL/PROC
     * @param values các giá trị cung cấp cho các tham số trong SQL/PROC
     * @return đối tượng đã tạo
     * @throws SQLException không tạo được PreparedStatement
     */
    private static PreparedStatement getStmt(String sql, Object... values) throws SQLException {
        var conn = XJdbc.openConnection();
        var stmt = sql.trim().startsWith("{") ? conn.prepareCall(sql) : conn.prepareStatement(sql);
        for (int i = 0; i < values.length; i++) {
            stmt.setObject(i + 1, values[i]);
        }
        return stmt;
    }

    public static void main(String[] args) {
        System.out.println("TrungGay");
//        demoSelectPhong();
//        demoMaxGiaPhong();
}
//    // Lấy danh sách phòng có giá trong khoảng
//    private static void demoSelectPhong() {
//        String sql = "SELECT * FROM Phong WHERE GiaPhong BETWEEN ? AND ?";
//        var rs = XJdbc.executeQuery(sql, 400000.0, 1000000.0);
//        try {
//            while (rs.next()) {
//                System.out.println("Phong: " + rs.getInt("Id") + ", SoPhong: " + rs.getString("SoPhong"));
//            }
//            rs.getStatement().getConnection().close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Lấy giá phòng cao nhất
//    private static void demoMaxGiaPhong() {
//        String sql = "SELECT MAX(GiaPhong) FROM Phong WHERE GiaPhong > ?";
//        Object value = XJdbc.getValue(sql, 400000.0);
//        if (value == null) {
//            System.out.println("Khong co gia phong nao lon hon 400000");
//        } else {
//            double maxPrice = ((Number) value).doubleValue();
//            System.out.println("Gia phong cao nhat: " + maxPrice);
//        }
//    }

}

