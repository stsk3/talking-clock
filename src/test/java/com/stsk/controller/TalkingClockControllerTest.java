package com.stsk.controller;

import com.stsk.dto.ClockDTO;
import com.stsk.utils.ClockUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.format.DateTimeParseException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TalkingClockControllerTest {

    @Spy
    private TalkingClockController talkingClockController;


    @Test
    public void testOnValidInput() {
        //Condition
        final String time = "23:59";

        //Execution
        final ResponseEntity<ClockDTO> response = talkingClockController.getHumanFriendlyTime(time);

        //Result Check
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testOnValidNullInput() {
        //Condition
        final String time = null;

        //Execution
        final ResponseEntity<ClockDTO> response = talkingClockController.getHumanFriendlyTime(time);

        //Result Check
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void testOnInvalidInput() {
        //Condition
        final String time = "Hi, how are you?";

        //Result Check
        assertThatThrownBy(() -> ClockUtils.getHumanFriendlyTime(time))
                .isInstanceOf(DateTimeParseException.class);
    }

}
