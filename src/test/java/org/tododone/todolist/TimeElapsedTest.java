package org.tododone.todolist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeElapsedTest {
    @Test
    void testTimeElapsed1Sec() {
        TimeElapsed timeElapsed = new TimeElapsed(java.time.LocalDateTime.now().minusSeconds(1));
        assertEquals("(1 sec)", timeElapsed.toString());
    }

    @Test
    void testTimeElapsed1min() {
        TimeElapsed timeElapsed = new TimeElapsed(java.time.LocalDateTime.now().minusMinutes(1));
        assertEquals("(1 min)", timeElapsed.toString());
    }

    @Test
    void testTimeElapsed1h() {
        TimeElapsed timeElapsed = new TimeElapsed(java.time.LocalDateTime.now().minusHours(1));
        assertEquals("(1 h)", timeElapsed.toString());
    }

    @Test
    void testTimeElapsed1day() {
        TimeElapsed timeElapsed = new TimeElapsed(java.time.LocalDateTime.now().minusDays(1));
        assertEquals("(1 day)", timeElapsed.toString());
    }

    @Test
    void testTimeElapsed1week() {
        TimeElapsed timeElapsed = new TimeElapsed(java.time.LocalDateTime.now().minusWeeks(1));
        assertEquals("(1 week)", timeElapsed.toString());
    }

    @Test
    void testTimeElapsed1month() {
        TimeElapsed timeElapsed = new TimeElapsed(java.time.LocalDateTime.now().minusMonths(1));
        assertEquals("(1 month)", timeElapsed.toString());
    }

    @Test
    void testTimeElapsed1year() {
        TimeElapsed timeElapsed = new TimeElapsed(java.time.LocalDateTime.now().minusYears(1));
        assertEquals("(1 year)", timeElapsed.toString());
    }
}