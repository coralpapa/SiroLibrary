package com.github.siroshun09.sirolibrary.bukkitutils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Bukkit 関連のメソッド集。
 *
 * @since 1.1.1
 */
public class BukkitUtil<T> {

    /**
     * 次のサーバーティックでタスクを実行する。
     *
     * @param plugin プラグイン
     * @param task   実行するタスク
     * @return {@link BukkitTask}
     * @see org.bukkit.scheduler.BukkitScheduler#runTask(Plugin, Runnable)
     */
    @NotNull
    public static BukkitTask runNextTick(Plugin plugin, Runnable task) {
        return Bukkit.getScheduler().runTask(plugin, task);
    }

    /**
     * 指定したティック数遅らせてタスクを実行する。
     *
     * @param plugin プラグイン
     * @param task   実行するタスク
     * @param ticks  遅延するティック数
     * @return {@link BukkitTask}
     * @see org.bukkit.scheduler.BukkitScheduler#runTaskLater(Plugin, Runnable, long)
     */
    @NotNull
    public static BukkitTask runLater(Plugin plugin, Runnable task, long ticks) {
        return Bukkit.getScheduler().runTaskLater(plugin, task, ticks);
    }

    /**
     * 指定したティック数遅らせてタスクを実行した後、キャンセルされるまで繰り返しタスクを実行し続ける。
     *
     * @param plugin プラグイン
     * @param task   実行するタスク
     * @param delay  遅延するティック数
     * @param period 次の実行までのティック数
     * @return {@link BukkitTask}
     * @see org.bukkit.scheduler.BukkitScheduler#runTaskTimer(Plugin, Runnable, long, long)
     */
    @NotNull
    public static BukkitTask runTimer(Plugin plugin, Runnable task, long delay, long period) {
        return Bukkit.getScheduler().runTaskTimer(plugin, task, delay, period);
    }

    /**
     * メインスレッドでメソッドを呼び出す。
     * <p>
     * 注意: {@link Future#get()} はメインスレッド上で呼び出してはいけない。
     *
     * @param plugin プラグイン
     * @param task   タスク
     * @param <V>    返される結果のタイプ
     * @return 実行結果
     * @see org.bukkit.scheduler.BukkitScheduler#callSyncMethod(Plugin, Callable)
     */
    @NotNull
    public static <V> Future<V> callSyncMethod(Plugin plugin, Callable<V> task) {
        return Bukkit.getScheduler().callSyncMethod(plugin, task);
    }

    /**
     * オンライン人数を取得する。
     *
     * @return 現在のオンライン人数
     */
    public static int getNumberOfOnline() {
        return Bukkit.getOnlinePlayers().size();
    }

    /**
     * 今までサーバーにログインしたプレイヤーの人数を取得する。
     *
     * @return オフライン人数
     */
    public static int getNumberOfOffline() {
        return Bukkit.getOfflinePlayers().length;
    }

    /**
     * コマンドが実行されたときに使用される {@link CommandExecutor} をセットする。
     *
     * @param cmd      セットされるコマンド
     * @param executor セットする {@link CommandExecutor}
     */
    public static void setCommandExecutor(@Nullable PluginCommand cmd, @NotNull CommandExecutor executor) {
        Optional.ofNullable(cmd).ifPresent(c -> c.setExecutor(executor));
    }

    /**
     * コマンドが実行されたときに使用される {@link TabCompleter} をセットする。
     * <p>
     * {@link CommandExecutor} を実装しているクラスに {@link TabCompleter} も実装されている場合
     * {@link BukkitUtil#setCommandExecutor(PluginCommand, CommandExecutor)} のみでも動く。
     *
     * @param cmd       セットされるコマンド
     * @param completer セットする {@link TabCompleter}
     */
    public static void setTabCompleter(@Nullable PluginCommand cmd, @NotNull TabCompleter completer) {
        Optional.ofNullable(cmd).ifPresent(c -> c.setTabCompleter(completer));
    }

    /**
     * イベントリスナーを登録する。
     *
     * @param listener リスナー
     * @param plugin   プラグイン
     * @since 1.1.2
     */
    public static void registerEvents(@NotNull Listener listener, Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }
}
