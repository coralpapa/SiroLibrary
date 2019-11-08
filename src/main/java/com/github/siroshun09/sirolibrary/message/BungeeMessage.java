package com.github.siroshun09.sirolibrary.message;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import org.jetbrains.annotations.NotNull;

public class BungeeMessage {

    /**
     * {@code str} の & から始まるカラーコードを変換して返す。
     *
     * @param str 変換する文字列
     * @return 変換後の文字列
     */
    @NotNull
    public static String setColor(@NotNull String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    /**
     * {@link CommandSender} に {@code msg} を送る
     *
     * @param sendTo メッセージの受取人
     * @param msg    送る文字列
     */
    public static void sendMessage(@NotNull CommandSender sendTo, @NotNull String msg) {
        sendTo.sendMessage(TextComponent.fromLegacyText(msg));
    }

    /**
     * {@link CommandSender} に色付きで {@code msg} を送る
     *
     * @param sendTo メッセージの受取人
     * @param msg    送る文字列
     */
    public static void sendMessageWithColor(@NotNull CommandSender sendTo, @NotNull String msg) {
        sendTo.sendMessage(TextComponent.fromLegacyText(setColor(msg)));
    }
}
