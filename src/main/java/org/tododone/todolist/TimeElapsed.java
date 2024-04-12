package org.tododone.todolist;

import java.time.LocalDateTime;

public class TimeElapsed {
    public final String unit;
    public final Integer value;

    public TimeElapsed (LocalDateTime dateTimeCreated) {
        LocalDateTime now = LocalDateTime.now();
        long seconds = java.time.Duration.between(dateTimeCreated, now).getSeconds();
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        long weeks = days / 7;
        long months = days / 30;
        long years = days / 365;

        if (years > 0) {
            this.value = (int) years;
            this.unit = this.value > 1 ? "years" : "year";
        } else if (months > 0) {
            this.value = (int) months;
            this.unit = this.value > 1 ? "months" : "month";
        } else if (weeks > 0) {
            this.value = (int) weeks;
            this.unit = this.value > 1 ? "weeks" : "week";
        } else if (days > 0) {
            this.value = (int) days;
            this.unit = this.value > 1 ? "days" : "day";
        } else if (hours > 0) {
            this.value = (int) hours;
            this.unit = "h";
        } else if (minutes > 0) {
            this.value = (int) minutes;
            this.unit = "min";
        } else {
            this.value = (int) seconds;
            this.unit = "sec";
        }
    }

    public String toString() {
        return "(" + this.value + " " + this.unit + ")";
    }
}
