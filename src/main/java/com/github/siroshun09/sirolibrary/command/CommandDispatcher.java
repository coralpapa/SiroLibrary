package com.github.siroshun09.sirolibrary.command;

import com.github.siroshun09.sirolibrary.SiroLibraryBukkit;
import com.github.siroshun09.sirolibrary.SiroLibraryBungee;
import net.md_5.bungee.api.ProxyServer;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

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
    public static boolean toBukkit(@NotNull String command) {
        return asPlayer(Bukkit.getConsoleSender(), command);
    }

    /**
     * BungeeCord のコンソールでコマンドを実行する。
     *
     * @param command 実行するコマンド
     * @return コマンドの実行が成功したら {@code true}, しなかったら {@code false}
     * @since 1.0.11
     */
    public static boolean toBungee(@NotNull String command) {
        return asPlayer(ProxyServer.getInstance().getConsole(), command);
    }

    /**
     * Bukkit のプレイヤーとしてコマンドを実行する。
     *
     * @param sender  実行者
     * @param command 実行するコマンド
     * @return コマンドの実行が成功したら {@code true}, しなかったら {@code false}
     * @since 1.0.11
     */
    public static boolean asPlayer(@NotNull org.bukkit.command.CommandSender sender, @NotNull String command) {
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
    public static boolean asPlayer(@NotNull net.md_5.bungee.api.CommandSender sender, @NotNull String command) {
        return ProxyServer.getInstance().getPluginManager().dispatchCommand(sender, command);
    }

    /**
     * 複数のコマンドを Bukkit のコンソールで一気に実行する。
     *
     * @param commands 実行するコマンドリスト
     * @since 1.0.19
     */
    public static void runCommands(@NotNull List<String> commands) {
        runCommands(commands, true);
    }

    /**
     * 複数のコマンドをコンソールで一気に実行する。
     *
     * @param commands 実行するコマンドリスト
     * @param isBukkit Bukkit 上かどうか
     * @since 1.0.19
     */
    public static void runCommands(@NotNull List<String> commands, boolean isBukkit) {
        if (isBukkit) {
            for (String cmd : commands) {
                if (toBukkit(cmd)) {
                    SiroLibraryBukkit.getInstance().getLogger().warning("コマンド \"" + cmd + "\" を正常に実行できませんでした");
                }
            }
        } else {
            for (String cmd : commands) {
                if (toBungee(cmd)) {
                    SiroLibraryBungee.getInstance().getLogger().warning("コマンド \"" + cmd + "\" を正常に実行できませんでした");
                }
            }
        }
    }
}
