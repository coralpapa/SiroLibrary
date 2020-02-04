package com.github.siroshun09.sirolibrary;

import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.Contract;

/**
 * BungeeCord でのプラグインインスタンス。
 * BungeeCord 上での稼働のみ使用される。
 */
public class SiroLibraryBungee extends Plugin {

    private static SiroLibraryBungee instance;

    /**
     * コンストラクタ。
     * {@link Plugin#onLoad()} より前に呼び出さる。
     */
    public SiroLibraryBungee() {
        instance = this;
        SiroLibraryLogger.setLogger(getLogger());
    }

    /**
     * BungeeCord 上のこのプラグインのインスタンスを取得する。
     *
     * @return SiroLibraryBungee のプラグインインスタンス
     */
    @Contract(pure = true)
    public static SiroLibraryBungee getInstance() {
        return instance;
    }
}
