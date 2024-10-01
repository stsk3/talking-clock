package com.stsk;

import com.stsk.dto.ClockDTO;
import com.stsk.utils.ClockUtils;

import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        try {
            final ClockDTO clockDTO = ClockUtils.getHumanFriendlyTime(args.length > 0 ? args[0] : null);
            System.out.println(clockDTO.getTalkTime());
        } catch (DateTimeParseException dtpe) {
            System.out.println("Your clock is malfunctioning!");
        }
    }
}