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
    private final static ExecutorService executor = newSingleExecutor("SiroLibrary-Executor");
    private final static ScheduledExecutorService scheduler = newSingleScheduler("SiroLibrary-Scheduler");

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
    public static ExecutorService newSingleExecutor(@NotNull String name) {
        return Executors.newSingleThreadExecutor(r -> new Thread(r, name));
    }

    /**
     * @param name スレッドの名前
     * @return {@link ExecutorService}
     * @see Executors#newCachedThreadPool()
     * @since 1.2.3
     */
    @NotNull
    public static ExecutorService newCachedThreadPool(@NotNull String name) {
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
    public static ExecutorService newFixedThreadPool(int nThreads, @NotNull String name) {
        return Executors.newFixedThreadPool(nThreads, r -> new Thread(r, name));
    }

    /**
     * @param name スレッドの名前
     * @return {@link ScheduledExecutorService}
     * @see Executors#newSingleThreadScheduledExecutor()
     * @since 1.2.3
     */
    @NotNull
    public static ScheduledExecutorService newSingleScheduler(@NotNull String name) {
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
    public static ScheduledExecutorService newScheduledThreadPool(int nThreads, @NotNull String name) {
        return Executors.newScheduledThreadPool(nThreads, r -> new Thread(r, name));
    }
}
