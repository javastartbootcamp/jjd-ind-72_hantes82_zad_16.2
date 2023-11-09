package pl.javastart.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TimePatterns {
    public static LocalDateTime parseTimeFormat(String userInput) {
        List<String> formatters = new ArrayList<>();
        Collections.addAll(formatters, "yyyy-MM-dd HH:mm:ss", "dd.MM.yyyy HH:mm:ss", "2022-10-23");
        LocalDateTime parsedDateTime = null;
        boolean parsed = false;
        for (String formatter : formatters) {
            try {
                if (!userInput.contains(" ")) {
                    userInput += " 00:00:00";
                }
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(formatter);
                parsedDateTime = LocalDateTime.parse(userInput, dateFormatter);
                parsed = true;
                break;
            } catch (DateTimeParseException e) {
                //empty
            }
        }
        if (!parsed) {
            throw new IllegalArgumentException("Nie udało się sparsować podanej daty: " + userInput);
        }

        return parsedDateTime;
    }
}
