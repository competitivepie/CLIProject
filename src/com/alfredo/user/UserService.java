package com.alfredo.user;

public class UserService {

    private UserDAO userDAO;

    {
        userDAO = new UserDAO();
    }

    public User[] getUsers() {
        return userDAO.selectAllUsers();
    }
}
