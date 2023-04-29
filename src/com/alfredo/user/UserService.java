package com.alfredo.user;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public User[] getUsers() {
        return userDAO.selectAllUsers();
    }

    public void displaySelectUserIDMenu() {
        displayAllUsers();
        System.out.println("-> Select User ID (Press 7 to go back to previous menu)");
    }

    public void displayAllUsers() {
        for (User user : getUsers()) {
            System.out.println(user);
        }
    }
}
