package com.example.groupca_ws_spm.repositories;


import business.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao implements UserDaoInterface
    {
        public UserDao(String dbName){
            super(dbName);
        }

        @Override
        public List<User> findAllUsers()
        {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<User> users = new ArrayList<User>();

            try
            {

                con = this.getConnection();

                String query = "SELECT * FROM USER";
                ps = con.prepareStatement(query);


                rs = ps.executeQuery();
                while (rs.next())
                {
                    int userId = rs.getInt("ID");
                    String username = rs.getString("USERNAME");
                    String password = rs.getString("PASSWORD");
                    String lastname = rs.getString("LAST_NAME");
                    String firstname = rs.getString("FIRST_NAME");
                    User u = new User(userId, firstname, lastname, username, password);
                    users.add(u);
                }
            }
            catch (SQLException e)
            {
                System.out.println("An error occurred in the findAllUsers() method: " + e.getMessage());
            }
            finally
            {
                try
                {
                    if (rs != null)
                    {
                        rs.close();
                    }
                    if (ps != null)
                    {
                        ps.close();
                    }
                    if (con != null)
                    {
                        freeConnection(con);
                    }
                }
                catch (SQLException e)
                {
                    System.out.println("An error occurred when shutting down the findAllUsers() method: " + e.getMessage());
                }
            }
            return users;
        }

        @Override
        public User findUserByUsernamePassword(String uname, String pword)
        {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            User u = null;
            try {
                con = this.getConnection();

                String query = "SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, uname);
                ps.setString(2, pword);

                rs = ps.executeQuery();
                if (rs.next())
                {
                    int userId = rs.getInt("ID");
                    String username = rs.getString("USERNAME");
                    String password = rs.getString("PASSWORD");
                    String lastname = rs.getString("LAST_NAME");
                    String firstname = rs.getString("FIRST_NAME");
                    u = new User(userId, firstname, lastname, username, password);
                }
            }
            catch (SQLException e)
            {
                System.out.println("An error occurred in the findUserByUsernamePassword() method: " + e.getMessage());
            }
            finally
            {
                try
                {
                    if (rs != null)
                    {
                        rs.close();
                    }
                    if (ps != null)
                    {
                        ps.close();
                    }
                    if (con != null)
                    {
                        freeConnection(con);
                    }
                }
                catch (SQLException e)
                {
                    System.out.println("An error occurred when shutting down the findUserByUsernamePassword() method: " + e.getMessage());
                }
            }
            return u;
        }

        @Override
        public User findUserById(int id) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            User u = null;
            try {
                con = this.getConnection();

                String query = "SELECT * FROM USER WHERE ID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, id);

                rs = ps.executeQuery();
                if (rs.next())
                {
                    int userId = rs.getInt("ID");
                    String username = rs.getString("USERNAME");
                    String password = rs.getString("PASSWORD");
                    String lastname = rs.getString("LAST_NAME");
                    String firstname = rs.getString("FIRST_NAME");
                    u = new User(userId, firstname, lastname, username, password);
                }
            }
            catch (SQLException e)
            {
                System.out.println("An error occurred in the findUserById() method: " + e.getMessage());
            }
            finally
            {
                try
                {
                    if (rs != null)
                    {
                        rs.close();
                    }
                    if (ps != null)
                    {
                        ps.close();
                    }
                    if (con != null)
                    {
                        freeConnection(con);
                    }
                }
                catch (SQLException e)
                {
                    System.out.println("An error occurred when shutting down the findUserById() method: " + e.getMessage());
                }
            }
            return u;
        }

        @Override
        public int addUser(String uname, String pword, String fName, String lName) {
            Connection con = null;
            PreparedStatement ps = null;

            ResultSet generatedKeys = null;

            int newId = -1;
            try {
                con = this.getConnection();

                String query = "INSERT INTO user(first_name, last_name, username, password) VALUES (?, ?, ?, ?)";


                ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, fName);
                ps.setString(2, lName);
                ps.setString(3, uname);
                ps.setString(4, pword);


                ps.executeUpdate();


                generatedKeys = ps.getGeneratedKeys();

                if(generatedKeys.next())
                {

                    newId = generatedKeys.getInt(1);
                }
            }
            catch (SQLException e)
            {
                System.err.println("\tA problem occurred during the addUser method:");
                System.err.println("\t"+e.getMessage());
                newId = -1;
            }
            finally
            {
                try
                {
                    if(generatedKeys != null){
                        generatedKeys.close();
                    }
                    if (ps != null)
                    {
                        ps.close();
                    }
                    if (con != null)
                    {
                        freeConnection(con);
                    }
                }
                catch (SQLException e)
                {
                    System.err.println("A problem occurred when closing down the addUser method:\n" + e.getMessage());
                }
            }
            return newId;
        }

        @Override
        public int changePassword(String username, String oldPass, String newPass) {
            Connection con = null;
            PreparedStatement ps = null;
            int rowsAffected = -1;
            try {
                con = this.getConnection();

                String query = "UPDATE user SET password = ? WHERE username = ? AND password = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, newPass);
                ps.setString(2, username);
                ps.setString(3, oldPass);

                rowsAffected = ps.executeUpdate();
            }
            catch (SQLException e){
                System.out.println("An error occurred in the changePassword() method: " + e.getMessage());
            }
            finally{
                try{
                    if (ps != null){
                        ps.close();
                    }
                    if (con != null){
                        freeConnection(con);
                    }
                }
                catch (SQLException e){
                    System.out.println("An error occurred when shutting down the changePassword() method: " + e.getMessage());
                }
            }
            return rowsAffected;
        }

        @Override
        public List<User> findAllUsersContainingUsername(String username) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<User> users = new ArrayList<User>();

            try{

                con = this.getConnection();

                String query = "SELECT * FROM USER WHERE username LIKE ?";
                ps = con.prepareStatement(query);
                ps.setString(1, "%"+username+"%");


                rs = ps.executeQuery();
                while (rs.next()){
                    int userId = rs.getInt("ID");
                    String uname = rs.getString("USERNAME");
                    String password = rs.getString("PASSWORD");
                    String lastname = rs.getString("LAST_NAME");
                    String firstname = rs.getString("FIRST_NAME");
                    User u = new User(userId, firstname, lastname, uname, password);
                    users.add(u);
                }
            }
            catch (SQLException e){
                System.out.println("An error occurred in the findAllUsersContainingUsername() method: " + e.getMessage());
            }
            finally{
                try{
                    if (rs != null){
                        rs.close();
                    }
                    if (ps != null){
                        ps.close();
                    }
                    if (con != null){
                        freeConnection(con);
                    }
                }
                catch (SQLException e){
                    System.out.println("An error occurred when shutting down the findAllUsersContainingUsername() method: " + e.getMessage());
                }
            }
            return users;
        }

        public static void main(String [] args){
            UserDao userDao = new UserDao("user_database");
            User u = userDao.findUserById(1);
            System.out.println("User with id #1: " + u);
            int changed = userDao.changePassword("smithj", "pword", "password");
            if(changed == 1){
                System.out.println("The password appears to have changed");
            }else{
                System.out.println("No change seems to have been made");
            }
            u = userDao.findUserById(1);
            System.out.println("Password now contains: " + u.getPassword());
        }
    }
}
