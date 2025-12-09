package org.example;

public class Main {
    public void main(String[] args) {
        UserService us = new UserService();

        if(us.registerUser("Arda", null, 19)){
            System.out.println("You successfully registered the system.");
        }
    }
}
