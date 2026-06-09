package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file){
        Profile profile = new Profile();
       // Path path = file.toPath();

        try{
            List<String> lines = Files.readAllLines(file.toPath());
            String[]parts;
            String key;
            String value;
           for (String i:lines){
            parts =i.split(":\\s*",2);
            key= parts[0];
            value=parts[1];
            switch (key){
                case "Name": profile.setName(value);
                break;
                case "Age": profile.setAge(Integer.parseInt(value));
                    break;
                case "Email": profile.setEmail(value);
                    break;
                case "Phone": profile.setPhone(Long.parseLong(value));
                    break;

            }
           }

        } catch (IOException e) {
         e.printStackTrace();
        }



        return profile;
    }
}
