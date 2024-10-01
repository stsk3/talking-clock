package com.stsk;

import com.stsk.dto.ClockDTO;
import com.stsk.utils.ClockUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testOnValidInput() {
        //Condition
        final String time = "01:00";

        //Execution
        final ClockDTO clockDTO = ClockUtils.getHumanFriendlyTime(time);
        Main.main(new String[]{time});

        //Result Check
        assertEquals(clockDTO.getTalkTime(), outputStreamCaptor.toString().trim());
    }

    @Test
    public void testOnValidNullInput() {
        //Condition
        final String time = null;

        //Execution
        final ClockDTO clockDTO = ClockUtils.getHumanFriendlyTime(time);
        Main.main(new String[]{time});

        //Result Check
        assertEquals(clockDTO.getTalkTime(), outputStreamCaptor.toString().trim());
    }
    @Test
    public void testOnInvalidInput() {
        //Condition
        final String time = "I am ready~";

        //Execution
        Main.main(new String[]{time});

        //Result Check
        assertEquals("Your clock is malfunctioning!", outputStreamCaptor.toString().trim());
    }

}
