package com.github.siroshun09.sirolibrary;

import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

/**
 * ロガー管理クラス。
 *
 * @since 1.4.7
 */
public class SiroLibraryLogger {
    private static Logger LOGGER;

    /**
     * {@link Logger} を取得する。
     * <p>
     * 基本的に、プラグインのロガーが返される。
     * プラグインが有効でない時に呼び出された場合、グローバルなロガーが返される。
     *
     * @return ロガー
     * @since 1.4.7
     */
    @NotNull
    public static Logger getLogger() {
        if (LOGGER == null) setLogger(Logger.getLogger("SiroLibrary"));
        return LOGGER;
    }

    /**
     * {@link Logger} をセットする。
     *
     * @param logger ロガー
     * @since 1.4.7
     */
    static void setLogger(@NotNull Logger logger) {
        LOGGER = logger;
    }
}
