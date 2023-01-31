package se.hkr.Without;

import se.hkr.WithStreams.Validation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        String regex = "^[a-zA-Z0-9_!&'*=`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";
        Path path = Paths.get("/Users/mariannap/Desktop/HKR/Year 1/Methods of Sustainable Programming/ProjectEx1/Examination1/src/se/hkr/WithStreams/names.txt");
        List<String> allEmails = Files.readAllLines(path);
        List<String> validEmails = new ArrayList<>();
        for(String email: allEmails) {
            if (email.matches(regex)) {
                validEmails.add(email);
            }
        }
        for(String mail: validEmails){
            System.out.println(mail);
        }
        long elapsedTime= System.nanoTime()-startTime;
        System.out.println("Time elapsed->" + elapsedTime/1000000 + " millis");


    // Group them according to Domain
        long startTime2 = System.nanoTime();
        Map<String, List<String>> groupingEmails = new HashMap<>();
        for(String email : validEmails){
            int index = email.indexOf("@") + 1;
            String domain = email.substring(index);
            if (!groupingEmails.containsKey(domain)){
                groupingEmails.put(domain, new ArrayList<String>());
            }
            groupingEmails.get(domain).add(email);
        }
        for(Map.Entry<String,List<String>> entry: groupingEmails.entrySet()){
            System.out.println("\nDomain: " + entry.getKey());
            System.out.println("Emails: ");
            for(String email: entry.getValue()){
                System.out.println("" + email);
            }
        }
        long elapsedTime2= System.nanoTime()-startTime2;
        System.out.println("Time elapsed->" + elapsedTime2/1000000 + " millis");


        }
    }

