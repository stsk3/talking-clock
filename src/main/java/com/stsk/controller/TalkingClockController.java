package com.stsk.controller;

import com.stsk.dto.ClockDTO;
import com.stsk.utils.ClockUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/talking-clock")
public class TalkingClockController {

    @GetMapping
    public ResponseEntity<ClockDTO> getHumanFriendlyTime(@RequestParam(value = "time", required = false) String time) {
        final ClockDTO clockDTO = ClockUtils.getHumanFriendlyTime(time);
        return ResponseEntity.status(HttpStatus.OK).body(clockDTO);
    }
}
