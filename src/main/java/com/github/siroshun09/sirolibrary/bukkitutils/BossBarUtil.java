package com.github.siroshun09.sirolibrary.bukkitutils;

import com.github.siroshun09.sirolibrary.SiroLibraryBukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.jetbrains.annotations.NotNull;

/**
 * ボスバー用のメソッド集
 */
public class BossBarUtil {

    /**
     * ボスバーの表示タイプを文字列から取得する。
     *
     * @param style タイプ名
     * @return 指定したタイプ、存在しなければ警告した上 {@link BarStyle#SOLID} を返す
     * @since 1.1.7
     */
    public static BarStyle getStyle(@NotNull String style) {
        switch (style.toUpperCase()) {
            case "SEGMENTED_6":
                return BarStyle.SEGMENTED_6;
            case "SEGMENTED_10":
                return BarStyle.SEGMENTED_10;
            case "SEGMENTED_12":
                return BarStyle.SEGMENTED_12;
            case "SEGMENTED_20":
                return BarStyle.SEGMENTED_20;
            case "SOLID":
                return BarStyle.SOLID;
            default:
                SiroLibraryBukkit.getInstance().getLogger().warning("BossBar Style に " + style + " は存在しません");
                return BarStyle.SOLID;
        }
    }

    /**
     * ボスバーの色を文字列から取得する。
     *
     * @param color 色名
     * @return 指定した色、存在しなければ警告した上 {@link BarColor#WHITE} を返す
     * @since 1.1.7
     */
    public static BarColor getColor(@NotNull String color) {
        switch (color.toUpperCase()) {
            case "BLUE":
                return BarColor.BLUE;
            case "GREEN":
                return BarColor.GREEN;
            case "PINK":
                return BarColor.PINK;
            case "PURPLE":
                return BarColor.PURPLE;
            case "RED":
                return BarColor.RED;
            case "YELLOW":
                return BarColor.YELLOW;
            case "WHITE":
                return BarColor.WHITE;
            default:
                SiroLibraryBukkit.getInstance().getLogger().warning("BossBar Color に " + color + " は存在しません");
                return BarColor.WHITE;
        }
    }
}
