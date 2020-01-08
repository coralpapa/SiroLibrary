package com.github.siroshun09.sirolibrary.bukkitutils;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * サウンド用のメソッド集
 *
 * @since 1.1.1
 */
public class SoundUtil {

    /**
     * {@link Player} にサウンドを再生する。
     *
     * @param player 再生されるプレイヤー
     * @param sound  再生する音
     */
    public static void playSound(@NotNull Player player, @NotNull Sound sound) {
        player.playSound(player.getLocation(), sound, SoundCategory.MASTER, 100f, 1.0f);
    }

    /**
     * {@link Player} にサウンドを再生する。
     *
     * @param player 再生されるプレイヤー
     * @param sound  再生する音
     * @param pitch  ピッチ
     */
    public static void playSound(@NotNull Player player, @NotNull Sound sound, float pitch) {
        player.playSound(player.getLocation(), sound, SoundCategory.MASTER, 100f, pitch);
    }

    /**
     * {@link World} の {@link Location} でサウンドを再生する。
     *
     * @param world    再生されるワールド
     * @param location 再生される位置
     * @param sound    再生する音
     */
    public static void playSound(@NotNull World world, @NotNull Location location, @NotNull Sound sound) {
        world.playSound(location, sound, SoundCategory.MASTER, 100f, 1.0f);
    }

    /**
     * {@link World} の {@link Location} でサウンドを再生する。
     *
     * @param world    再生されるワールド
     * @param location 再生される位置
     * @param sound    再生する音
     * @param pitch    ピッチ
     */
    public static void playSound(@NotNull World world, @NotNull Location location, @NotNull Sound sound, float pitch) {
        world.playSound(location, sound, SoundCategory.MASTER, 100f, pitch);
    }
}
