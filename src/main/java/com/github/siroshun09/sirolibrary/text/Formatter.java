package com.github.siroshun09.sirolibrary.text;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 文字列にして返すメソッド集。
 *
 * @since 1.0.13
 */
public class Formatter {

    /**
     * 現在の日付を {@link DateTimeFormatter#ISO_LOCAL_DATE} 形式にして返す。
     *
     * @return {@link DateTimeFormatter#ISO_LOCAL_DATE} 形式の日付
     */
    @NotNull
    public static String getDate() {
        return getDate(LocalDate.now());
    }

    /**
     * 渡された {@link LocalDate} を {@link DateTimeFormatter#ISO_LOCAL_DATE} 形式にして返す。
     *
     * @param date フォーマットする日付
     * @return {@link DateTimeFormatter#ISO_LOCAL_DATE} 形式の日付
     */
    @NotNull
    public static String getDate(@NotNull LocalDate date) {
        return DateTimeFormatter.ISO_LOCAL_DATE.format(date);
    }

    /**
     * 現在の時刻を {@link DateTimeFormatter#ISO_LOCAL_TIME} 形式にして返す。
     * <p>
     * ミリ秒以下は切り捨てられる。
     *
     * @return {@link DateTimeFormatter#ISO_LOCAL_TIME} 形式の時刻
     */
    @NotNull
    public static String getTime() {
        return getTime(LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

    /**
     * 渡された {@link LocalTime} を {@link DateTimeFormatter#ISO_LOCAL_TIME} 形式にして返す。
     *
     * @param time フォーマットする時刻
     * @return {@link DateTimeFormatter#ISO_LOCAL_TIME} 形式の時刻
     */
    @NotNull
    public static String getTime(@NotNull LocalTime time) {
        return DateTimeFormatter.ISO_LOCAL_TIME.format(time);
    }

    /**
     * 現在の日時を {@link DateTimeFormatter#ISO_LOCAL_DATE_TIME} 形式にして返す。
     * <p>
     * ミリ秒以下は切り捨てられる。
     *
     * @return {@link DateTimeFormatter#ISO_LOCAL_DATE_TIME} 形式の日時
     */
    @NotNull
    public static String getDateTime() {
        return getDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

    /**
     * 渡された {@link LocalDateTime} を {@link DateTimeFormatter#ISO_LOCAL_DATE_TIME} 形式にして返す。
     *
     * @param dateTime フォーマットする日時
     * @return {@link DateTimeFormatter#ISO_LOCAL_DATE_TIME} 形式の日時
     */
    @NotNull
    public static String getDateTime(@NotNull LocalDateTime dateTime) {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(dateTime);
    }

    /**
     * 渡された {@link Location} を {@code x, y, z} にして返す。
     *
     * @param l フォーマットするロケーション
     * @return {@code x, y, z}
     */
    @NotNull
    public static String getLocation(@NotNull Location l) {
        return l.getBlockX() + ", " + l.getBlockY() + ", " + l.getBlockZ();
    }
}
