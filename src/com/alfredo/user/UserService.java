package com.alfredo.user;

public class UserService {

    private final UserFileDataAccessService userFileDataAccessService;

    public UserService() {
        userFileDataAccessService = new UserFileDataAccessService();
    }

    public User[] getAllUsers() {
        return userFileDataAccessService.getUsers();
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
