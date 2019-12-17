package com.github.siroshun09.sirolibrary.text;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

/**
 * パディングクラス。
 *
 * @since 1.0.12
 */
public class Padding {

    /**
     * {@code name} の末尾に空白を付け足し、16字にして返す。
     * <p>
     * Minecraft ID は3字以上16字以下でなければならないため、
     * その条件を満たさない場合 {@link IllegalArgumentException} を投げる。
     *
     * @param name パディングする名前
     * @return パディングされた16字の文字列
     * @throws IllegalArgumentException {@code name} が3字以上16字以下でない場合
     */
    public static String padUserName(@NotNull String name) {
        if (name.length() < 3 || 16 < name.length()) {
            throw new IllegalArgumentException("Name must be between 3 and 16 characters");
        }
        return StringUtils.rightPad(name, 16);
    }

    /**
     * 現在の時刻を ISO 8601 形式にし、29字で返す。29字に満たない場合、末尾に0を付け足す。
     *
     * @return パディングされた ISO 8601 形式の現在時刻
     */
    @NotNull
    public static String padDateTime() {
        return StringUtils.rightPad(LocalDateTime.now().toString(), 29, '0');
    }
}