package dao;
import db.DBConnection;
import model.MenuItem;
import java.sql.*; import java.util.*;
public class MenuDAO {
    public static boolean addMenuItem(MenuItem item){
        String sql="INSERT INTO menu (name,category,price) VALUES (?,?,?)";
        try(Connection conn=DBConnection.getConnection(); PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,item.getName()); ps.setString(2,item.getCategory()); ps.setDouble(3,item.getPrice());
            return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace();} return false;
    }
    public static List<MenuItem> getAllMenuItems(){
        List<MenuItem> list=new ArrayList<>(); String sql="SELECT * FROM menu";
        try(Connection conn=DBConnection.getConnection(); Statement st=conn.createStatement(); ResultSet rs=st.executeQuery(sql)){
            while(rs.next()) list.add(new MenuItem(rs.getInt("id"),rs.getString("name"),rs.getString("category"),rs.getDouble("price")));
        }catch(Exception e){e.printStackTrace();} return list;
    }
    public static boolean updateMenuItem(MenuItem item){
        String sql="UPDATE menu SET name=?,category=?,price=? WHERE id=?";
        try(Connection conn=DBConnection.getConnection(); PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,item.getName()); ps.setString(2,item.getCategory()); ps.setDouble(3,item.getPrice()); ps.setInt(4,item.getId());
            return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace();} return false;
    }
    public static boolean deleteMenuItem(int id){
        String sql="DELETE FROM menu WHERE id=?";
        try(Connection conn=DBConnection.getConnection(); PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,id); return ps.executeUpdate()>0;
        }catch(Exception e){e.printStackTrace();} return false;
    }
}