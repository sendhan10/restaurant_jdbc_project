package db;
import java.sql.*;
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant_db";
    private static final String USER = "root";
    private static final String PASSWORD = "@Sendhansk6";
    public static Connection getConnection() {
        try { return DriverManager.getConnection(URL, USER, PASSWORD); }
        catch (Exception e) { e.printStackTrace(); return null; }
    }
}