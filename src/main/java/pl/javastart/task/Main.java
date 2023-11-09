package pl.javastart.task;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.util.Map.entry;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {
        // uzupełnij rozwiązanie. Korzystaj z przekazanego w parametrze scannera
        System.out.println("Podaj datę: ");
        System.out.print("Dostępne formaty: yyyy-MM-dd HH:mm:ss | yyyy-MM-dd | dd.MM.yyy HH:mm:ss\n");
        String date = scanner.nextLine();
        LocalDateTime localDateTime = TimePatterns.parseTimeFormat(date);
        DateTimeFormatter dateFormatterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Map<String, ZonedDateTime> zones = Zone.countTimes(localDateTime);
        printTimes(zones, dateFormatterWithTime);
    }

    public void printTimes(Map<String, ZonedDateTime> zones, DateTimeFormatter dateFormatterWithTime) {
        for (Map.Entry<String, ZonedDateTime> entry : zones.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue().format(dateFormatterWithTime));
        }
    }

}
