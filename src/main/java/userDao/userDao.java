package userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import user.user;

public class userDao {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/book", "root", "root");
            if (con != null) {
                System.out.println("Connected");
            } else {
                System.out.println("Not Connected");
            }
        } catch (Exception e) {
            System.out.println("Driver not found in catch method");
        }
        return con;
    }

    public static int saveDetails(user u) {
      //  user u=new user();
        int result = 0;
        Connection con = getConnection();
        try {
            String createUser = "insert into library(name,author_name,price,publisher,isbn) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(createUser);
            ps.setString(1,u.getName());
            ps.setString(2,u.getAuthor_name());
            ps.setInt(3,u.getPrice());
            ps.setString(4,u.getPublisher());
            ps.setInt(5,u.getIsbn());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static List<user> selectUser() {
        ArrayList<user> listitem = new ArrayList<>();
        Connection con = getConnection();
        try {
            String selectUser = "select * from library";
            PreparedStatement ps = con.prepareStatement(selectUser);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user User = new user();
                User.setSlno(rs.getInt("slno"));
                User.setName(rs.getString("name"));
                User.setAuthor_name(rs.getString("author_name"));
                User.setPrice(rs.getInt("price"));
                User.setPublisher(rs.getString("publisher"));
                User.setIsbn(rs.getInt("isbn"));
                listitem.add(User);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listitem;
    }
    public static int deleteUser(int slno){
        int result = 0;
        Connection con =getConnection();
        try{
            String deleteUser="delete from library where slno=?";
            PreparedStatement ps = con.prepareStatement(deleteUser);
            ps.setInt(1,slno);
            result =ps.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static  int updateUser(user e){
        int result =0;
        Connection con = getConnection();
        try{
            String updateUser="update library set name=?,author_name=?,price=?,publisher=? ,isbn=? where slno=?";
            PreparedStatement ps =con.prepareStatement(updateUser);
            ps.setString(1,e.getName());
            ps.setString(2,e.getAuthor_name());
            ps.setInt(3,e.getPrice());
            ps.setString(4,e.getPublisher());
            ps.setInt(5,e.getIsbn());
            ps.setInt(6,e.getSlno());
            result=ps.executeUpdate();

        }
        catch (Exception f ){
            f.printStackTrace();
        }
        return result;
    }
//    //select User by id
    public static user getUserbyid(int slno) {
        user user = new user();

        Connection con = getConnection();
        try {
            String selectUserbyID="select slno,name,author_name,price,publisher,isbn from library where slno=?";
            PreparedStatement ps = con.prepareStatement(selectUserbyID);
            ps.setInt(1, slno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                user.setSlno(rs.getInt("slno"));
                user.setName(rs.getString("name"));  // Here is where setName() is called
                user.setAuthor_name(rs.getString("author_name"));
                user.setPrice(rs.getInt("price"));
                user.setPublisher(rs.getString("publisher"));
                user.setIsbn(rs.getInt("isbn"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
