package com.github.siroshun09.sirolibrary.command;

import net.md_5.bungee.api.ProxyServer;
import org.bukkit.Bukkit;

import java.util.List;

/**
 * コマンドを実行するメソッド集。
 *
 * @since 1.0.11
 */
public class CommandDispatcher {

    /**
     * Bukkit のコンソールでコマンドを実行する。
     *
     * @param command 実行するコマンド
     * @return コマンドの実行が成功したら {@code true}, しなかったら {@code false}
     * @since 1.0.11
     */
    public static boolean toBukkit(String command) {
        return Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }

    /**
     * BungeeCord のコンソールでコマンドを実行する。
     *
     * @param command 実行するコマンド
     * @return コマンドの実行が成功したら {@code true}, しなかったら {@code false}
     * @since 1.0.11
     */
    public static boolean toBungee(String command) {
        return ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), command);
    }

    /**
     * Bukkit のプレイヤーとしてコマンドを実行する。
     *
     * @param sender  実行者
     * @param command 実行するコマンド
     * @return コマンドの実行が成功したら {@code true}, しなかったら {@code false}
     * @since 1.0.11
     */
    public static boolean asPlayer(org.bukkit.command.CommandSender sender, String command) {
        return Bukkit.dispatchCommand(sender, command);
    }

    /**
     * BungeeCord のプレイヤーしてコマンドを実行する。
     *
     * @param sender  実行者
     * @param command 実行するコマンド
     * @return コマンドの実行が成功したら {@code true}, しなかったら {@code false}
     * @since 1.0.11
     */
    public static boolean asPlayer(net.md_5.bungee.api.CommandSender sender, String command) {
        return ProxyServer.getInstance().getPluginManager().dispatchCommand(sender, command);
    }

    /**
     * 複数のコマンドを Bukkit のコンソールで一気に実行する。
     *
     * @param commands 実行するコマンドリスト
     * @since 1.0.19
     */
    public static void runCommands(List<String> commands) {
        runCommands(commands, true);
    }

    /**
     * 複数のコマンドをコンソールで一気に実行する。
     *
     * @param commands 実行するコマンドリスト
     * @param isBukkit Bukkit 上かどうか
     * @since 1.0.19
     */
    public static void runCommands(List<String> commands, boolean isBukkit) {
        if (isBukkit) {
            for (String cmd : commands) {
                toBukkit(cmd);
            }
        } else {
            for (String cmd : commands) {
                toBungee(cmd);
            }
        }
    }
}
