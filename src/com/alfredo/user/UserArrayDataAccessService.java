package com.alfredo.user;

import java.util.UUID;

public class UserArrayDataAccessService implements UserDAO {

    private static final User[] users;

    static {
        users = new User[] {
                new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"), "James"),
                new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"), "Jamila"),
                new User(UUID.fromString("288be01e-4e8a-40d3-87e7-6b1ab62f9776"), "Jeff"),
                new User(UUID.fromString("7477ac25-9af4-424d-a30b-2d9a2196b2eb"), "Bryce"),
                new User(UUID.fromString("4be41523-4722-4484-825b-cbadcdb90b4c"), "Amanda"),
                new User(UUID.fromString("baa3b77b-dca2-4ea8-af28-b68c51eefdc6"), "Taylor")
        };
    }

    public User[] getUsers() { return users; }
}
