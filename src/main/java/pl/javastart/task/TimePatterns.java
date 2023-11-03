package pl.javastart.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimePatterns {
    public static LocalDateTime parseTimeFormat(String userInput) {
        DateTimeFormatter dateFormatterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateFormatterWithoutTime = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateFormatterAlternative = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime parsedDateTime = null;
        if (userInput.contains(" ") && userInput.contains("-")) {
            parsedDateTime = LocalDateTime.parse(userInput, dateFormatterWithTime);
        } else if (userInput.contains(".")) {
            parsedDateTime = LocalDateTime.parse(userInput, dateFormatterAlternative);
        } else {
            parsedDateTime = LocalDateTime.parse(userInput + " 00:00:00", dateFormatterWithoutTime);
        }
        return parsedDateTime;
    }
}
