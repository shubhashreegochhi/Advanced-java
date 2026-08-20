package dao;

import entity.student;

import java.sql.*;

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


    public boolean register(int id, String name, String email, int redg,String password) throws SQLException {
        try {
            String sql = "insert into student_data  values(?,?,?,?,?)";
            PreparedStatement prt = studentservice.con.prepareStatement(sql);

            prt.setInt(1, id);
            prt.setString(2, name);
            prt.setString(3, email);
            prt.setInt(4, redg);
            prt.setString(5,password);
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

    public boolean login(String email, String password) throws SQLException {
        String sql = "select * from student_data where email=? and password=?";
        PreparedStatement prt = studentservice.con.prepareStatement(sql);
        prt.setString(1, email);
        prt.setString(2, password);
        ResultSet rs = prt.executeQuery();
        if (rs.next()) {
            return true;

        }else {
            return false;
        }
    }
}
