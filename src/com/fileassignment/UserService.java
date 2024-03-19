package com.fileassignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
	private User[] users;

    public UserService(String filename) throws IOException {
        BufferedReader fileReader = null;
        fileReader=new BufferedReader(new FileReader(filename));
        users = new User[4];

        for (int i = 0; i < 4; i++) {
            String[] userInfo = fileReader.readLine().split(",");
            users[i] = new User(userInfo[0], userInfo[1], userInfo[2]);
        }

        fileReader.close();
    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
}
}