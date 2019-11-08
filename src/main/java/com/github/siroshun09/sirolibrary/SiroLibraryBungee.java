package com.github.siroshun09.sirolibrary;

import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.Contract;

/**
 * Bungee のプラグインインスタンス。
 * Bungee での稼働でのみ使用される。
 */
public class SiroLibraryBungee extends Plugin {

    private static SiroLibraryBungee instance;

    public SiroLibraryBungee() {
        instance = this;
    }

    /**
     * Bungee 上のこのプラグインのインスタンスを取得する。
     *
     * @return SiroLibraryBungee のプラグインインスタンス
     */
    @Contract(pure = true)
    public static SiroLibraryBungee getInstance() {
        return instance;
    }
}
