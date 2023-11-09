package pl.javastart.task;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Zone {

    public static Map<String, ZonedDateTime> countTimes(LocalDateTime localDateTime) {
        Map<String, ZonedDateTime> zones = new LinkedHashMap<>();
        ZonedDateTime localTime = localDateTime.atZone(ZoneId.systemDefault());
        zones.put("Czas lokalny: ", localTime);
        zones.put("UTC: ", localTime.withZoneSameInstant(ZoneId.of("UTC")));
        zones.put("Londyn: ", localTime.withZoneSameInstant(ZoneId.of("Europe/London")));
        zones.put("Los Angeles: ", localTime.withZoneSameInstant(ZoneId.of("America/Los_Angeles")));
        zones.put("Sydney: ", localTime.withZoneSameInstant(ZoneId.of("Australia/Sydney")));
        return zones;
    }

}
