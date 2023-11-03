package pl.javastart.task;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {
        // uzupełnij rozwiązanie. Korzystaj z przekazanego w parametrze scannera
        System.out.println("Podaj datę: ");
        System.out.printf("Dostępne formaty: yyyy-MM-dd HH:mm:ss | yyyy-MM-dd | dd.MM.yyy HH:mm:ss\n");
        String date = scanner.nextLine();
        LocalDateTime localDateTime = TimePatterns.parseTimeFormat(date);
        DateTimeFormatter dateFormatterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        printTimes(localDateTime, dateFormatterWithTime);

    }

    public void printTimes(LocalDateTime localDateTime, DateTimeFormatter dateFormatterWithTime) {
        ZoneId localZone = ZoneId.systemDefault();
        ZoneId utcZone = ZoneId.of("UTC");
        ZoneId londonZone = ZoneId.of("Europe/London");
        ZoneId losAngelesZone = ZoneId.of("America/Los_Angeles");
        ZoneId sydneyZone = ZoneId.of("Australia/Sydney");

        ZonedDateTime localTime = localDateTime.atZone(localZone);
        ZonedDateTime utcTime = localTime.withZoneSameInstant(utcZone);
        ZonedDateTime londonTime = localTime.withZoneSameInstant(londonZone);
        ZonedDateTime losAngelesTime = localTime.withZoneSameInstant(losAngelesZone);
        ZonedDateTime sydneyTime = localTime.withZoneSameInstant(sydneyZone);

        System.out.println("Czas lokalny: " + localTime.format(dateFormatterWithTime));
        System.out.println("UTC: " + utcTime.format(dateFormatterWithTime));
        System.out.println("Londyn: " + londonTime.format(dateFormatterWithTime));
        System.out.println("Los Angeles: " + losAngelesTime.format(dateFormatterWithTime));
        System.out.println("Sydney: " + sydneyTime.format(dateFormatterWithTime));

    }

}
