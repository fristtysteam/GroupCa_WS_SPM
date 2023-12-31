package com.example.groupca_ws_spm.repositories;



import com.example.groupca_ws_spm.business.User;

import java.util.List;

public interface UserDaoInterface {
    List<User> findAllUsers();
    User findUserByUsernamePassword(String uname, String pword);
    User findUserById(int id);
    int addUser(String uname, String pword, String fName, String lName);
    int changePassword(String username, String oldPass, String newPass);
    List<User> findAllUsersContainingUsername(String username);
}
