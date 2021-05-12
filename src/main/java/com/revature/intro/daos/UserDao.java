package com.revature.intro.daos;

import com.revature.intro.models.AppUser;
import com.revature.intro.util.ConnectionFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//double check
public class UserDao {
    BufferedReader br;


    public AppUser save(AppUser brandNewUser) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sqlInsertUser = "insert into bank.customers (hero_status, first_name , last_name, age, email, username , password) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsertUser, new String[]{"customer_id"});
            pstmt.setString(1, brandNewUser.getHeroStatus());
            pstmt.setString(2, brandNewUser.getFirstName());
            pstmt.setString(3, brandNewUser.getLastName());
            pstmt.setInt(4, brandNewUser.getAge());
            pstmt.setString(5, brandNewUser.getEmail());
            pstmt.setString(6, brandNewUser.getUsername());
            pstmt.setString(7, brandNewUser.getPassword());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()) {
                    brandNewUser.setCustomerId(rs.getInt("customer_id")); //same as implementing a getbyID method.
                    //you are asking for this particular column customerID, as the method auto generates keys connect that
                    //with the user and what we defined as customer_id which in serialized to autoincrement and store.
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return brandNewUser;
    }

    public boolean isUsernameAvailable(String username) { //boolean is--- is a type of getter.
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from customers where username = ?"; //This is the ONLY THING that ever changes.
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;

    }

    public boolean isEmailAvailable(String email) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from bank.customers where email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public AppUser findUserByUsernameAndPassword(String username, String password) {

        AppUser user = new AppUser();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from bank.customers where usernames = ? and passwords = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new AppUser();
                user.setCustomerId(rs.getInt("customer_id"));
                user.setHeroStatus(rs.getString("hero_status"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("usernames"));
                user.setPassword(rs.getString("passwords"));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

}
