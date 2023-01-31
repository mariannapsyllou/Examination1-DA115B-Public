package se.hkr.WithStreams;

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
        Path path = Paths.get("/Users/mariannap/Desktop/HKR/Year 1/Methods of Sustainable Programming/ProjectEx1/Examination1/src/se/hkr/WithStreams/names.txt");
        List<String> validEmails = new ArrayList<>();


        // If we want just to find out which emails are valid
        long startTime = System.nanoTime();
        try(Stream<String> emails = Files.lines(path)){
             validEmails =emails.filter(emailValidation::isValid)
                    .collect(Collectors.toList());
             validEmails.forEach(System.out::println);

            long elapsedTime= System.nanoTime()-startTime;
            System.out.println("Time elapsed->" + elapsedTime/1000000 + " millis");


        // Grouping emails depending on their domain
            long startTime2 = System.nanoTime();
            Map<String, List<String>> groupingEmails = validEmails.stream()
                    .collect(Collectors.groupingBy(email->email.substring(email.indexOf("@") + 1)));
            groupingEmails.entrySet().forEach(entry->{
                        System.out.println("\nDomain: " + entry.getKey());
                        System.out.println("Emails: ");
                        entry.getValue().forEach(email-> System.out.println("" + email));

            });
            long elapsedTime2= System.nanoTime()-startTime;
            System.out.println("Time elapsed->" + elapsedTime2/1000000 + " millis");



        }catch(IOException e){
            e.printStackTrace();
        }


    }
}


