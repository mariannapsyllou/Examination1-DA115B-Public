package se.hkr;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String regex = "^[a-zA-Z0-9_!&'*=`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";
        Validation emailValidation = (String mail) -> mail.matches(regex);
        Path path = Paths.get("/Users/mariannap/Desktop/HKR/Year 1/Methods of Sustainable Programming/ProjectEx1/Examination1/src/se/hkr/names.txt");
        List<String> validEmails = new ArrayList<>();


        // If we want just to find out which emails are valid
        try(Stream<String> emails = Files.lines(path)){
             validEmails =emails.filter(emailValidation::isValid)
                    .collect(Collectors.toList());
             validEmails.forEach(System.out::println);

        // Grouping emails depending on their domain
            Map<String, List<String>> groupingEmails = validEmails.stream()
                    .collect(Collectors.groupingBy(email->email.substring(email.indexOf("@") + 1)));
            groupingEmails.entrySet().forEach(entry->{
                        System.out.printf("Domain: " +"\n" + entry.getKey());
                        System.out.println("\nEmails: ");
                        entry.getValue().forEach(email-> System.out.println("" + email));
            });

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


