package com.github.siroshun09.sirolibrary.message;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * BungeeCord におけるメッセージ送信・タブ保管のメソッド集
 */
public class BungeeMessage {

    /**
     * {@code str} で {@code &} から始まるカラーコードを変換して返す。
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

    /**
     * プロキシに接続しているプレイヤー全員に {@code msg} を送る。
     *
     * @param msg 送る文字列
     * @since 1.4.5
     */
    public static void broadcast(@NotNull String msg) {
        for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
            p.sendMessage(TextComponent.fromLegacyText(msg));
        }
    }

    /**
     * プロキシに接続しているプレイヤー全員に {@code msg} を色付きで送る。
     *
     * @param msg 送る文字列
     * @since 1.4.5
     */
    public static void broadcastWithColor(@NotNull String msg) {
        for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
            p.sendMessage(TextComponent.fromLegacyText(setColor(msg)));
        }
    }

    /**
     * {@link ProxiedPlayer} のアクションバーにメッセージを表示する。
     *
     * @param sendTo 表示するプレイヤー
     * @param msg    表示するメッセージ
     * @since 1.0.17
     */
    public static void sendActionBar(@NotNull ProxiedPlayer sendTo, @NotNull String msg) {
        sendTo.sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
    }

    /**
     * コンソールにプラグインが有効化されたことを流す。
     *
     * @param plugin 有効化されたプラグイン
     * @since 1.5.4
     */
    public static void printEnabledMsg(@NotNull Plugin plugin) {
        plugin.getLogger().info(
                plugin.getDescription().getName() + " v" + plugin.getDescription().getVersion() + " has been successfully enabled.");
    }

    /**
     * コンソールにプラグインが無効化されたことを流す。
     *
     * @param plugin 無効化されたプラグイン
     * @since 1.5.4
     */
    public static void printDisabledMsg(@NotNull Plugin plugin) {
        plugin.getLogger().info(
                plugin.getDescription().getName() + " v" + plugin.getDescription().getVersion() + " has been successfully disabled.");
    }

    /**
     * <b>{@link org.bukkit.util.StringUtil#copyPartialMatches(String, Iterable, Collection)} からのコピー</b>
     * <p>
     * Copies all elements from the iterable collection of originals to the
     * collection provided.
     *
     * @param <T>        the collection of strings
     * @param token      String to search for
     * @param originals  An iterable collection of strings to filter.
     * @param collection The collection to add matches to
     * @return the collection provided that would have the elements copied
     * into
     * @throws UnsupportedOperationException if the collection is immutable
     *                                       and originals contains a string which starts with the specified
     *                                       search string.
     * @throws IllegalArgumentException      if any parameter is is null
     * @throws IllegalArgumentException      if originals contains a null element.
     *                                       <b>Note: the collection may be modified before this is thrown</b>
     */
    @Contract("_, _, _ -> param3")
    @NotNull
    public static <T extends Collection<? super String>> T copyPartialMatches(@NotNull String token, @NotNull Iterable<String> originals, @NotNull T collection) throws UnsupportedOperationException, IllegalArgumentException {
        for (String string : originals) {
            if (startsWithIgnoreCase(string, token)) {
                collection.add(string);
            }
        }
        return collection;
    }

    /**
     * <b>{@link org.bukkit.util.StringUtil#startsWithIgnoreCase(String, String)} からのコピー</b>
     * <p>
     * This method uses a region to check case-insensitive equality. This
     * means the internal array does not need to be copied like a
     * toLowerCase() call would.
     *
     * @param string String to check
     * @param prefix Prefix of string to compare
     * @return true if provided string starts with, ignoring case, the prefix
     * provided
     * @throws NullPointerException     if prefix is null
     * @throws IllegalArgumentException if string is null
     */
    private static boolean startsWithIgnoreCase(@NotNull String string, @NotNull String prefix) throws IllegalArgumentException, NullPointerException {
        if (string.length() < prefix.length()) {
            return false;
        }
        return string.regionMatches(true, 0, prefix, 0, prefix.length());
    }
}
