package com.stsk.dto;

public class ClockDTO {
    private String time;
    private String talkTime;

    public ClockDTO(String time, String talkTime) {
        this.time = time;
        this.talkTime = talkTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(String talkTime) {
        this.talkTime = talkTime;
    }
}
