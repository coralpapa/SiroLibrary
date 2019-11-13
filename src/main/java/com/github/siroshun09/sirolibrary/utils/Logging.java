package com.github.siroshun09.sirolibrary.utils;

import java.util.logging.Logger;

/**
 * コンソールにログを流すクラス。
 * デフォルトではグローバルロガーが使用される。
 * オーバーライドでの使用を想定している。
 */
public class Logging {
    private static Logger LOGGER;
    private static Logger DEBUG_LOGGER;

    private static boolean DEBUG_MODE;

    /**
     * info レベルでログを流す。
     *
     * @param log 流したいログ
     */
    public static void info(String log) {
        if (LOGGER == null) LOGGER = Logger.getGlobal();
        LOGGER.info(log);
    }

    /**
     * warn レベルでログを流す。
     *
     * @param log 流したいログ
     */
    public static void warn(String log) {
        if (LOGGER == null) LOGGER = Logger.getGlobal();
        LOGGER.warning(log);
    }

    /**
     * severe レベルでログを流す。
     *
     * @param log 流したいログ
     */
    public static void severe(String log) {
        if (LOGGER == null) LOGGER = Logger.getGlobal();
        LOGGER.severe(log);
    }

    /**
     * デバッグログを流す。
     *
     * @param log 流したいログ
     */
    public static void debug(String log) {
        if (!DEBUG_MODE) return;
        if (DEBUG_LOGGER == null) DEBUG_LOGGER = Logger.getLogger("global.debug");
        DEBUG_LOGGER.info(log);
    }

    /**
     * デバッグモードを切り替える
     *
     * @param bool 有効なら {@code true}, 無効なら {@code false}
     */
    public static void setDebugMode(boolean bool) {
        DEBUG_MODE = bool;
    }
}
