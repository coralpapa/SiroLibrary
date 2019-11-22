package com.github.siroshun09.sirolibrary;

import org.jetbrains.annotations.Contract;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 非同期処理用の Executor 管理クラス。
 *
 * @since 1.0.14
 */
public class SiroExecutors {
    private final static ExecutorService executor =
            Executors.newSingleThreadExecutor(r -> new Thread(r, "SiroLibrary-Thread-1"));
    private final static ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor(r -> new Thread(r, "SiroLibrary-Thread-2"));

    /**
     * @return {@link ExecutorService}
     */
    @Contract(pure = true)
    public static ExecutorService getExecutor() {
        return executor;
    }

    /**
     * @return {@link ScheduledExecutorService}
     */
    @Contract(pure = true)
    public static ScheduledExecutorService getScheduler() {
        return scheduler;
    }
}
