package com.epam.mjc.nio;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.stream.Stream;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        Path path = file.toPath();

        try (Stream<String> lines = Files.lines(path)) { // ✅ NIO + try-with-resources
            lines.forEach(line -> {
                String[] parts = line.split(":\\s*", 2);
                if (parts.length < 2) return;

                String key = parts[0];
                String value = parts[1];

                switch (key) {
                    case "Name":
                        profile.setName(value);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(value));
                        break;
                    case "Email":
                        profile.setEmail(value);
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(value));
                        break;
                    default: break;
                }
            });

        } catch (IOException e) {
            System.err.println("не удалось прочесть файл: " + e.getMessage());
        }

        return profile;
    }
}