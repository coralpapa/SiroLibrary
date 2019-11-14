package com.github.siroshun09.sirolibrary.command;

import net.md_5.bungee.api.ProxyServer;
import org.bukkit.Bukkit;

/**
 * コマンドを実行するメソッド集。
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
}
