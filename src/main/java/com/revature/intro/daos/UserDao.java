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


<<<<<<< HEAD
=======
    // TODO (Associate task) Implement me! call it save or insert User //to do
>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173
    public AppUser save(AppUser newUser) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sqlInsertUser = "insert into quizzard.users (current_status, username , password , email , first_name , last_name , dob ) values (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsertUser, new String[]{"user_id"});
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getEmail());
            pstmt.setString(4, newUser.getFirstName());
            pstmt.setString(5, newUser.getLastName());
            pstmt.setString(6, newUser.getDob());
<<<<<<< HEAD
            pstmt.setString(7, newUser.getHeroStatus());
            pstmt.executeUpdate();
=======
            pstmt.setString(7, newUser.getCurrentStatus());
>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()) {
                    newUser.setId(String.valueOf(rs.getInt("user_id")));
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return newUser;
    }

    public boolean isUsernameAvailable(String username) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from quizzard.users where username = ?";
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

            String sql = "select * from quizzard.users where email = ?";
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

        AppUser user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select * from quizzard.users where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new AppUser();
<<<<<<< HEAD
                user.setId(String.valueOf(rs.getInt("customer_id"))); //to change later
=======
                user.setId(String.valueOf(rs.getInt("id"))); //to change later
>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
<<<<<<< HEAD
                user.setHeroStatus(rs.getString("hero_status"));
=======
                user.setCurrentStatus(rs.getString("current_status"));
>>>>>>> a810b6d56a64f769524cce173fbb1cacab1d3173
                user.setDob(rs.getString("date_of_birth"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

}
