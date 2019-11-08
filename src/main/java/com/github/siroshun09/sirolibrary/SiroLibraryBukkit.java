package com.github.siroshun09.sirolibrary;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Contract;

/**
 * Bukkit のプラグインインスタンス。
 * Bukkit での稼働でのみ使用される。
 */
public class SiroLibraryBukkit extends JavaPlugin {

    private static SiroLibraryBukkit instance;

    public SiroLibraryBukkit() {
        instance = this;
    }

    /**
     * Bukkit 上のこのプラグインのインスタンスを取得する。
     *
     * @return SiroLibraryBungee のプラグインインスタンス
     */
    @Contract(pure = true)
    public static SiroLibraryBukkit getInstance() {
        return instance;
    }
}
