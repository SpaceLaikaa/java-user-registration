package org.example;

public class UserService {
    public boolean registerUser(String userNameControl, String passwordControl, int ageControl){
        if (userNameControl == null || userNameControl.length()<3) {
            throw new IllegalArgumentException("Please enter a valid Username.(It should be at least 3 character long)");
        }
        if (passwordControl.toLowerCase().contains("admin") || passwordControl.length()<6){
            throw new IllegalArgumentException("Your password must have at least 6 characters & not contain admin.");
        }
        if (ageControl<18 || ageControl>100){
            throw new IllegalArgumentException("Unfortunately your age is not acceptable");
        }
        else{
            return true;
        }
    }
 }
