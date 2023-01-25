package se.hkr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String regex = "^[a-zA-Z0-9_!&'*=`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";
        Validation emailValidation = (String mail) -> mail.matches(regex);
        Path path = Paths.get("/Users/mariannap/Desktop/HKR/Year 1/Methods of Sustainable Programming/ProjectEx1/Examination1/src/se/hkr/names.txt");
        List<String> validEmails = new ArrayList<>();

        try(Stream<String> emails = Files.lines(path)){
             validEmails =emails.filter(emailValidation::isValid)
                    .collect(Collectors.toList());
             validEmails.forEach(System.out::println);

        }catch(IOException e){
            e.printStackTrace();

        }
    }
}


