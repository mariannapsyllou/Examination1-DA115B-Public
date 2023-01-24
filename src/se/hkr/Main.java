package se.hkr;


import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args){
        String email = "?????@gmail.com";
        String regex = "^[a-zA-Z0-9_!&'*+=`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";


        Validation emailValidation = (String mail) -> mail.matches(regex);

        if (emailValidation.isValid(email)) {
            System.out.println("valid email address");
        } else {
            System.out.println("invalid email address");
        }



    }
}


