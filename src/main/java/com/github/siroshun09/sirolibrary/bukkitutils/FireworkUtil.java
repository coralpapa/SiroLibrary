package com.github.siroshun09.sirolibrary.bukkitutils;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * 花火系のメソッド集。
 *
 * @since 1.1.4
 */
public class FireworkUtil {

    /**
     * 花火を打ち上げる。
     * <p>
     * 花火の色や弾け方、効果時間などは、返された {@link Firework} に
     * メタを設定して変更する。ここでは単純に花火自体の打ち上げのみ行われる。
     *
     * @param player 打ち上げ場所のプレイヤー
     * @return 打ち上げた花火
     */
    @NotNull
    public static Firework setOff(@NotNull Player player) {
        return player.getWorld().spawn(player.getLocation(), Firework.class);
    }

    /**
     * 花火を打ち上げる。
     * <p>
     * 花火の色や弾け方、効果時間などは、返された {@link Firework} に
     * メタを設定して変更する。ここでは単純に花火自体の打ち上げのみ行われる。
     *
     * @param world    打ち上げるワールド
     * @param location 打ち上げ場所
     * @return 打ち上げた花火
     */
    @NotNull
    public static Firework setOff(@NotNull World world, @NotNull Location location) {
        return world.spawn(location, Firework.class);
    }

    /**
     * 花火の色を文字列から {@link Color} に準じて取得する。
     *
     * @param color 色の名前
     * @return 取得した色、できなければ {@link Color#WHITE}
     * @see Color
     */
    @Contract(pure = true)
    public static Color getColor(@NotNull String color) {
        switch (color) {
            case "AQUA":
                return Color.AQUA;
            case "BLACK":
                return Color.BLACK;
            case "BLUE":
                return Color.BLUE;
            case "FUCHSIA":
                return Color.FUCHSIA;
            case "GRAY":
                return Color.GRAY;
            case "GREEN":
                return Color.GREEN;
            case "LIME":
                return Color.LIME;
            case "MAROON":
                return Color.MAROON;
            case "NAVY":
                return Color.NAVY;
            case "OLIVE":
                return Color.OLIVE;
            case "ORANGE":
                return Color.ORANGE;
            case "PURPLE":
                return Color.PURPLE;
            case "RED":
                return Color.RED;
            case "SILVER":
                return Color.SILVER;
            case "TEAL":
                return Color.TEAL;
            case "YELLOW":
                return Color.YELLOW;
            default:
                return Color.WHITE;
        }
    }
}
