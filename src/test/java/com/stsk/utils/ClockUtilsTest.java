package com.stsk.utils;

import com.stsk.dto.ClockDTO;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClockUtilsTest {

    @Test
    public void testOnZero() {
        //Condition
        final String time = "01:00";

        //Execution
        final ClockDTO clockDTO = ClockUtils.getHumanFriendlyTime(time);

        //Result Check
        assertEquals(time, clockDTO.getTime());
        assertEquals("One o'clock", clockDTO.getTalkTime());
    }

    @Test
    public void testOnBetweenZeroAndThirty() {
        //Condition
        final String time = "01:01";

        //Execution
        final ClockDTO clockDTO = ClockUtils.getHumanFriendlyTime(time);

        //Result Check
        assertEquals(time, clockDTO.getTime());
        assertEquals("One past one", clockDTO.getTalkTime());
    }

    @Test
    public void testOnThirty() {
        //Condition
        final String time = "01:30";

        //Execution
        final ClockDTO clockDTO = ClockUtils.getHumanFriendlyTime(time);

        //Result Check
        assertEquals(time, clockDTO.getTime());
        assertEquals("Half past one", clockDTO.getTalkTime());
    }

    @Test
    public void testOnBetweenThirtyAndZero() {
        //Condition
        final String time = "01:31";

        //Execution
        final ClockDTO clockDTO = ClockUtils.getHumanFriendlyTime(time);

        //Result Check
        assertEquals(time, clockDTO.getTime());
        assertEquals("Twenty nine to two", clockDTO.getTalkTime());
    }

    @Test
    public void testOnHours() {
        //Condition
        final String time1 = "11:01";
        final String time2 = "23:01";

        //Execution
        final ClockDTO clockDTO1 = ClockUtils.getHumanFriendlyTime(time1);
        final ClockDTO clockDTO2 = ClockUtils.getHumanFriendlyTime(time2);

        //Result Check
        assertEquals(clockDTO1.getTalkTime(), clockDTO2.getTalkTime());
    }

    @Test
    public void testOnNoInput() {
        //Condition
        final String time = null;

        //Execution
        final ClockDTO clockDTO = ClockUtils.getHumanFriendlyTime(time);

        //Result Check
        assertNotNull(clockDTO.getTime());
        assertNotNull(clockDTO.getTalkTime());
    }

    @Test
    public void testOnErrorNumber() {
        //Condition
        final String time = "25:61";

        //Result Check
        assertThatThrownBy(() -> ClockUtils.getHumanFriendlyTime(time))
                .isInstanceOf(DateTimeParseException.class);
    }

    @Test
    public void testOnErrorString() {
        //Condition
        final String time = "Would like to know the feedback of my program:)";

        //Result Check
        assertThatThrownBy(() -> ClockUtils.getHumanFriendlyTime(time))
                .isInstanceOf(DateTimeParseException.class);
    }

}
