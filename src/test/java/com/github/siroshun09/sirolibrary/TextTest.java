package com.github.siroshun09.sirolibrary;

import com.github.siroshun09.sirolibrary.text.Formatter;
import com.github.siroshun09.sirolibrary.text.Padding;
import org.bukkit.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TextTest {
    private static LocalDate DATE;
    private static LocalTime TIME;
    private static LocalDateTime DATE_TIME;
    private static Location LOCATION;

    @BeforeAll
    static void initAll() {
        DATE = LocalDate.now();
        TIME = LocalTime.now();
        DATE_TIME = LocalDateTime.now();
        LOCATION = new Location(null, 5.0, 10.5, 25);
    }

    @Test
    @DisplayName("フォーマットテスト")
    void formatTest() {
        Assertions.assertEquals(DateTimeFormatter.ISO_LOCAL_DATE.format(DATE), Formatter.getDate(DATE));
        Assertions.assertEquals(DateTimeFormatter.ISO_LOCAL_TIME.format(TIME), Formatter.getTime(TIME));
        Assertions.assertEquals(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(DATE_TIME), Formatter.getDateTime(DATE_TIME));
        Assertions.assertEquals("5, 10, 25", Formatter.getLocation(LOCATION));
    }

    @Test
    @DisplayName("パディングテスト")
    void paddingTest() {
        Assertions.assertDoesNotThrow(() -> Padding.padUserName("Tes"));
        Assertions.assertDoesNotThrow(() -> Padding.padUserName("TestTestTestTest"));

        Assertions.assertEquals(16, Padding.padUserName("Tes").length());
        Assertions.assertEquals(16, Padding.padUserName("TestTest").length());
        Assertions.assertEquals(16, Padding.padUserName("TestTestTestTest").length());

        Throwable exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> Padding.padUserName("TestTestTestTestA"));
        Assertions.assertEquals("Name must be between 3 and 16 characters", exception1.getMessage());
        Throwable exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> Padding.padUserName("Te"));
        Assertions.assertEquals("Name must be between 3 and 16 characters", exception2.getMessage());

        Assertions.assertEquals(29, Padding.padDateTime().length());
    }
}
