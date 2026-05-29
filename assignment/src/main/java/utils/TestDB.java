package utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDB {

    public static void main(String[] args) throws SQLException {

        Connection conn = DBConnect.getConnection();

        if(conn != null) {
            System.out.println("Kết nối thành công!");
        } else {
            System.out.println("Kết nối thất bại!");
        }
    }
}