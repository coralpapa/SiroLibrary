package com.github.siroshun09.sirolibrary.message;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Bukkit におけるメッセージ送信のメソッド集
 */
public class BukkitMessage {

    /**
     * {@code str} で {@code &} から始まるカラーコードを変換して返す。
     *
     * @param str 変換する文字列
     * @return 変換後の文字列
     * @since 1.0.10
     */
    @NotNull
    public static String setColor(@NotNull String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    /**
     * {@code list} を色付けして新しいリストとして返す。
     *
     * @param list 色付けするリスト
     * @return 色付け後のリスト
     * @since 1.4.3
     */
    @NotNull
    public static List<String> setColorList(@NotNull List<String> list) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            result.add(setColor(s));
        }
        return result;
    }

    /**
     * {@link CommandSender} に {@code msg} を送る
     *
     * @param sendTo メッセージの受取人
     * @param msg    送る文字列
     * @since 1.0.10
     */
    public static void sendMessage(@NotNull CommandSender sendTo, @NotNull String msg) {
        sendTo.sendMessage(msg);
    }

    /**
     * {@link CommandSender} に {@code msg} を色付きで送る
     *
     * @param sendTo メッセージの受取人
     * @param msg    送る文字列
     * @since 1.0.10
     */
    public static void sendMessageWithColor(@NotNull CommandSender sendTo, @NotNull String msg) {
        sendTo.sendMessage(setColor(msg));
    }

    /**
     * サーバーにログインしているプレイヤー全員に {@code msg} を送る。
     *
     * @param msg 送る文字列
     * @since 1.0.10
     */
    public static void broadcast(@NotNull String msg) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(msg);
        }
    }

    /**
     * サーバーにログインしているプレイヤー全員に {@code msg} を色付きで送る。
     *
     * @param msg 送る文字列
     * @since 1.0.10
     */
    public static void broadcastWithColor(@NotNull String msg) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(setColor(msg));
        }
    }

    /**
     * {@link Player} のアクションバーにメッセージを表示する。
     *
     * @param sendTo 表示するプレイヤー
     * @param msg    表示するメッセージ
     * @since 1.0.17
     */
    public static void sendActionBar(@NotNull Player sendTo, @NotNull String msg) {
        sendTo.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(setColor(msg)));
    }

    /**
     * コンソールにプラグインが有効化されたことを流す。
     *
     * @param plugin 有効化されたプラグイン
     * @since 1.5.4
     */
    public static void printEnabledMsg(@NotNull Plugin plugin) {
        plugin.getLogger().info(plugin.getName() + " v" + plugin.getDescription().getVersion() + " has been successfully enabled.");
    }

    /**
     * コンソールにプラグインが無効化されたことを流す。
     *
     * @param plugin 無効化されたプラグイン
     */
    public static void printDisabledMsg(@NotNull Plugin plugin) {
        plugin.getLogger().info(plugin.getName() + " v" + plugin.getDescription().getVersion() + " has been successfully disabled.");
    }
}
