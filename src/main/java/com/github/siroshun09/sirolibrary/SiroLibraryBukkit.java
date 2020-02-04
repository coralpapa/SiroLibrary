package com.github.siroshun09.sirolibrary;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Contract;

/**
 * Bukkit でのプラグインインスタンス。
 * Bukkit 上での稼働のみ使用される。
 */
public class SiroLibraryBukkit extends JavaPlugin {

    private static SiroLibraryBukkit instance;

    /**
     * コンストラクタ。
     * {@link JavaPlugin#onLoad()} より前に呼び出される。
     */
    public SiroLibraryBukkit() {
        instance = this;
        SiroLibraryLogger.setLogger(getLogger());
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
