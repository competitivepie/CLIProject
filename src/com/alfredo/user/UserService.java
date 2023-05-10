package com.alfredo.user;

public class UserService {

    private final UserArrayDataAccessService userArrayDataAccessService;

    public UserService() {
        userArrayDataAccessService = new UserArrayDataAccessService();
    }

    public User[] getAllUsers() {
        return userArrayDataAccessService.getUsers();
    }

    public void displaySelectUserIDMenu() {
        displayAllUsers();
        System.out.println("-> Select User ID (Press 7 to go back to previous menu)");
    }

    public void displayAllUsers() {
        for (User user : getAllUsers()) {
            if (user != null) {
                System.out.println(user);
            } else {
                break;
            }
        }
    }
}
