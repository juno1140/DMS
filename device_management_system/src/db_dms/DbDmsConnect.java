package db_dms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDmsConnect {

    public static void main(String[] args){

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName("con.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/dms?useSSL=false",
                    "root",
                    "45241971"
        );

        stmt = con.createStatement();

    rs = stmt.executeQuery("select * from device");

    while(rs.next()){
        System.out.println(rs.getString("device_name"));
    }
    } catch (SQLException e) {
        // DBとの処理で何らかのエラーがあった場合の例外
        e.printStackTrace();

    } catch (ClassNotFoundException e) {
        // JDBCドライバを読み込めないエラーがあった場合の例外
        e.printStackTrace();

    } finally {
        // 7. 接続を閉じる
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
}