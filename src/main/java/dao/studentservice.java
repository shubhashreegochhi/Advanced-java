package dao;

import entity.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class studentservice {
    private  static String url="jdbc:mysql://localhost:3306/student";
    private  static String user="root";
    private  static String password="shubha@2610";
   private static Connection con;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
            System.out.println("database connected successfully");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean register(int id, String name, String email, int redg) throws SQLException {
        try {
            String sql = "insert into student_data  values(?,?,?,?)";
            PreparedStatement prt = studentservice.con.prepareStatement(sql);

            prt.setInt(1, id);
            prt.setString(2, name);
            prt.setString(3, email);
            prt.setInt(4, redg);
            int rows = prt.executeUpdate();
            if (rows > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
