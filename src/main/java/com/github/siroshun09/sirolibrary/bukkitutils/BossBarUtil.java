package com.github.siroshun09.sirolibrary.bukkitutils;

import com.github.siroshun09.sirolibrary.SiroLibraryBukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.jetbrains.annotations.NotNull;

public class BossBarUtil {

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
