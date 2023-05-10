package com.alfredo.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDAO {

    private static final int MAX_NUMBER_OF_USERS = 100;

    public User[] getUsers() {
        User[] users = new User[MAX_NUMBER_OF_USERS];

        File file = new File("src/com/alfredo/users.csv");
        try {
            Scanner sc = new Scanner(file);
            for(int i = 0; sc.hasNext(); i++) {
                String[] userData = sc.nextLine().split(",");
                users[i] = new User(UUID.fromString(userData[0]), userData[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
}
