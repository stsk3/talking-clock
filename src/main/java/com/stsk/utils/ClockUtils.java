package com.stsk.utils;

import com.stsk.dto.ClockDTO;
import io.micrometer.common.util.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ClockUtils {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    public static ClockDTO getHumanFriendlyTime(final String timeStr) throws DateTimeParseException{
        LocalTime time;

        if (StringUtils.isNotBlank(timeStr)) {
            //With user input
            time = LocalTime.parse(timeStr, TIME_FORMAT);
        } else {
            //Without user input -> current time
            time = LocalTime.now();
        }

        return new ClockDTO(time.format(TIME_FORMAT), convertTime(time));
    }

    private static String convertTime(final LocalTime time) {
        //Extract hour and minute
        final int hour = time.getHour();
        final int minute = time.getMinute();

        if (minute == 0) {
            //01:00 One o'clock
            return convertHour(hour, false) + " o'clock";
        } else if (minute == 30) {
            //13:30 Half past one
            return "Half past " + convertHour(hour, true);
        } else if (minute < 30) {
            //13:10 Ten past one
            return convertMinute(minute) + " past " + convertHour(hour, true);
        } else {
            //13:55 Five to two
            return convertMinute(60 - minute) + " to " + convertHour(hour + 1, true);
        }
    }

    private static String convertHour(final int hour, final boolean toLowerCase) {
        final String[] words = {"Twelve", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven"};
        final String word = words[hour % 12];
        return toLowerCase ? word.toLowerCase() : word;
    }

    private static String convertMinute(final int minute) {
        final String[] words = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Quarter", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        if (minute >= 20) {
            return "Twenty" + (minute == 20 ? "":" ") + convertMinute(minute % 10).toLowerCase();
        } else {
            return words[minute];
        }
    }
}
