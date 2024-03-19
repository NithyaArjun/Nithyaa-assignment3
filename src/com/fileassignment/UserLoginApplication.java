package com.fileassignment;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		 Scanner scanner = new Scanner(System.in);

	        try {
	            UserService userService = new UserService("data.txt");

	            int attempts = 5;
	            while (attempts > 0) {
	                System.out.print("Enter your username: ");
	                String username = scanner.nextLine();
	                System.out.print("Enter your password: ");
	                String password = scanner.nextLine();

	                User authenticatedUser = userService.authenticate(username, password);
	                if (authenticatedUser != null) {
	                    System.out.println("Welcome, " + authenticatedUser.getName());
	                    break;
	                } else {
	                    System.out.println("Invalid login. Please try again.");
	                    attempts--;
	                }

	                if (attempts == 0) {
	                    System.out.println("Too many failed login attempts. You are now locked out.");
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Error reading user data: " + e.getMessage());
	        } 
	        
	}

}
