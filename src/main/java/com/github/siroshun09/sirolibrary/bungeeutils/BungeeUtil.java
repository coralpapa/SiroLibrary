package com.github.siroshun09.sirolibrary.bungeeutils;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.scheduler.ScheduledTask;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

/**
 * BungeeCord 関連のメソッド集。
 *
 * @since 1.2.2
 */
public class BungeeUtil {

    /**
     * 指定した時間遅らせてタスクを実行する。
     *
     * @param plugin プラグイン
     * @param task   実行するタスク
     * @param delay  遅延する時間
     * @param unit   時間の単位
     * @return {@link ScheduledTask}
     * @see net.md_5.bungee.api.scheduler.TaskScheduler#schedule(Plugin, Runnable, long, TimeUnit)
     */
    @NotNull
    public static ScheduledTask runLater(Plugin plugin, Runnable task, long delay, TimeUnit unit) {
        return ProxyServer.getInstance().getScheduler().schedule(plugin, task, delay, unit);
    }

    /**
     * 指定した時間遅らせてタスクを実行した後、キャンセルされるまで繰り返しタスクを実行し続ける。
     *
     * @param plugin プラグイン
     * @param task   実行するタスク
     * @param delay  遅延する時間
     * @param period 次の実行までの間隔
     * @param unit   時間の単位
     * @return {@link ScheduledTask}
     * @see net.md_5.bungee.api.scheduler.TaskScheduler#schedule(Plugin, Runnable, long, long, TimeUnit)
     */
    @NotNull
    public static ScheduledTask runTimer(Plugin plugin, Runnable task, long delay, long period, TimeUnit unit) {
        return ProxyServer.getInstance().getScheduler().schedule(plugin, task, delay, period, unit);
    }

    /**
     * コマンドを登録する。
     *
     * @param plugin  プラグイン
     * @param command セットするコマンド
     */
    public static void registerCommand(@NotNull Plugin plugin, @NotNull Command command) {
        ProxyServer.getInstance().getPluginManager().registerCommand(plugin, command);
    }

    /**
     * 指定したコマンドの登録を解除する。
     *
     * @param command 解除するコマンド
     */
    public static void unregisterCommand(@NotNull Command command) {
        ProxyServer.getInstance().getPluginManager().unregisterCommand(command);
    }

    /**
     * プラグインで登録されているコマンドの登録をすべて解除する。
     *
     * @param plugin プラグイン
     */
    public static void unregisterCommands(@NotNull Plugin plugin) {
        ProxyServer.getInstance().getPluginManager().unregisterCommands(plugin);
    }

    /**
     * リスナーを登録する。
     *
     * @param plugin   プラグイン
     * @param listener 登録するリスナー
     */
    public static void registerListener(@NotNull Plugin plugin, Listener listener) {
        ProxyServer.getInstance().getPluginManager().registerListener(plugin, listener);
    }

    /**
     * 指定したリスナーの登録を解除する。
     *
     * @param listener 解除するリスナー
     */
    public static void unregisterListener(Listener listener) {
        ProxyServer.getInstance().getPluginManager().unregisterListener(listener);
    }

    /**
     * プラグインで登録したすべてのリスナーの登録を解除する。
     *
     * @param plugin プラグイン
     */
    public static void unregisterListeners(Plugin plugin) {
        ProxyServer.getInstance().getPluginManager().unregisterListeners(plugin);
    }
}
