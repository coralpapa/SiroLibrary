package com.github.siroshun09.sirolibrary.message;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
    public static String setColor(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    /**
     * {@link CommandSender} に {@code msg} を送る
     *
     * @param sendTo メッセージの受取人
     * @param msg    送る文字列
     * @since 1.0.10
     */
    public static void sendMessage(CommandSender sendTo, String msg) {
        sendTo.sendMessage(msg);
    }

    /**
     * {@link CommandSender} に {@code msg} を色付きで送る
     *
     * @param sendTo メッセージの受取人
     * @param msg    送る文字列
     * @since 1.0.10
     */
    public static void sendMessageWithColor(CommandSender sendTo, String msg) {
        sendTo.sendMessage(setColor(msg));
    }

    /**
     * サーバーにログインしているプレイヤー全員に {@code msg} を送る。
     *
     * @param msg 送る文字列
     * @since 1.0.10
     */
    public static void broadcast(String msg) {
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
    public static void broadcastWithColor(String msg) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(setColor(msg));
        }
    }
}
