package com.github.siroshun09.sirolibrary;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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

    /**
     * @param name スレッドの名前
     * @return {@link ExecutorService}
     * @see Executors#newSingleThreadExecutor()
     * @since 1.2.3
     */
    @NotNull
    public static ExecutorService newSingleExecutor(String name) {
        return Executors.newSingleThreadExecutor(r -> new Thread(r, name));
    }

    /**
     * @param name スレッドの名前
     * @return {@link ExecutorService}
     * @see Executors#newCachedThreadPool()
     * @since 1.2.3
     */
    @NotNull
    public static ExecutorService newCachedThreadPool(String name) {
        return Executors.newCachedThreadPool(r -> new Thread(r, name));
    }

    /**
     * @param nThreads スレッド数
     * @param name     スレッドの名前
     * @return {@link ExecutorService}
     * @see Executors#newFixedThreadPool(int)
     * @since 1.2.3
     */
    @NotNull
    public static ExecutorService newFixedThreadPool(int nThreads, String name) {
        return Executors.newFixedThreadPool(nThreads, r -> new Thread(r, name));
    }

    /**
     * @param name スレッドの名前
     * @return {@link ScheduledExecutorService}
     * @see Executors#newSingleThreadScheduledExecutor()
     * @since 1.2.3
     */
    @NotNull
    public static ScheduledExecutorService newSingleScheduler(String name) {
        return Executors.newSingleThreadScheduledExecutor(r -> new Thread(r, name));
    }

    /**
     * @param nThreads スレッド数
     * @param name     スレッドの名前
     * @return {@link ScheduledExecutorService}
     * @see Executors#newScheduledThreadPool(int)
     * @since 1.2.3
     */
    @NotNull
    public static ScheduledExecutorService newScheduledThreadPool(int nThreads, String name) {
        return Executors.newScheduledThreadPool(nThreads, r -> new Thread(r, name));
    }
}
