package se.hkr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        String mail = "opåw+++@gmail.com";
        //Pattern pattern = new Pattern.matches(regex);
        Validation valid = Validation.isValid(mail);
        System.out.println(Validation.isValid(mail));
        System.out.println("DO you want to validate your email by input or by file");
        /*File file = new File("/Users/mariannap/Desktop/HKR/Year 1/Methods of Sustainable Programming/ProjectEx1/Examination1/src/se/hkr/names.txt");
        Scanner scanner = new Scanner(file);
        List<String> namesEmails = new ArrayList<String>();
        List<String> filteredNames = new ArrayList<>();
        while(scanner.hasNextLine()){
            namesEmails.add(scanner.nextLine());
        }
        Validation nameEmailValidation = Validation.valid.isValid(String mail);
        filteredNames = namesEmails.stream().filter(nameEmailValidation(String mail))
                .collect(Collectors.toList());*/



    }
}


