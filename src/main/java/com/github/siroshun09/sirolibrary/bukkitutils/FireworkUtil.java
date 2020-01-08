package com.github.siroshun09.sirolibrary.bukkitutils;

import com.github.siroshun09.sirolibrary.SiroLibraryBukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
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
    @NotNull
    public static Color getColor(@NotNull String color) {
        switch (color.toUpperCase()) {
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
            case "WHITE":
                return Color.WHITE;
            default:
                SiroLibraryBukkit.getInstance().getLogger().warning("Color に " + color + " は存在しません");
                return Color.WHITE;
        }
    }

    /**
     * 花火の形を文字列から {@link FireworkEffect.Type} に準じて取得する。
     *
     * @param type 形の名前
     * @return 取得した形、できなければ {@link FireworkEffect.Type#BALL}
     * @see FireworkEffect.Type
     * @since 1.1.6
     */
    @NotNull
    public static FireworkEffect.Type getType(@NotNull String type) {
        switch (type.toUpperCase()) {
            case "BALL_LARGE":
                return FireworkEffect.Type.BALL_LARGE;
            case "BURST":
                return FireworkEffect.Type.BURST;
            case "CREEPER":
                return FireworkEffect.Type.CREEPER;
            case "STAR":
                return FireworkEffect.Type.STAR;
            case "BALL":
                return FireworkEffect.Type.BALL;
            default:
                SiroLibraryBukkit.getInstance().getLogger().warning("Firework Type に " + type + " は存在しません");
                return FireworkEffect.Type.BALL;
        }
    }
}
