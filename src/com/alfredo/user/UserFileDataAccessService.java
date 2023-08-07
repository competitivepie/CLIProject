package com.alfredo.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserFileDataAccessService implements UserDAO {

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        File file = new File("src/com/alfredo/users.csv");
        try {
            Scanner sc = new Scanner(file);
            for(int i = 0; sc.hasNext(); i++) {
                String[] userData = sc.nextLine().split(",");
                users.add(new User(UUID.fromString(userData[0]), userData[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
}
