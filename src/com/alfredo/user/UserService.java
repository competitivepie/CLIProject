package com.alfredo.user;

import java.util.List;

public class UserService {

    private final UserFileDataAccessService userFileDataAccessService;

    public UserService(UserFileDataAccessService userFileDataAccessService) {
        this.userFileDataAccessService = userFileDataAccessService;
    }

    public List<User> getAllUsers() {
        return userFileDataAccessService.getUsers();
    }

    public void displaySelectUserIDMenu() {
        displayAllUsers();
        System.out.println("-> Select User ID (Press 7 to go back to previous menu)");
    }

    public void displayAllUsers() {
        for(User user : getAllUsers()) {
            System.out.println(user);
        }
    }

    public void viewAllUsers() { displayAllUsers(); }
}
