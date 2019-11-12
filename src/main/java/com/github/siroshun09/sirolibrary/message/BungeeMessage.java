package com.github.siroshun09.sirolibrary.message;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

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
     * <br>このメソッドは {@link org.bukkit.util.StringUtil#copyPartialMatches(String, Iterable, Collection)} からのコピーである</br>
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
    public static <T extends Collection<? super String>> T copyPartialMatches(@NotNull final String token, @NotNull final Iterable<String> originals, @NotNull final T collection) throws UnsupportedOperationException, IllegalArgumentException {
        Validate.notNull(token, "Search token cannot be null");
        Validate.notNull(collection, "Collection cannot be null");
        Validate.notNull(originals, "Originals cannot be null");

        for (String string : originals) {
            if (startsWithIgnoreCase(string, token)) {
                collection.add(string);
            }
        }

        return collection;
    }

    /**
     * <br>このメソッドは {@link org.bukkit.util.StringUtil#startsWithIgnoreCase(String, String)} からのコピーである</br>
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
    private static boolean startsWithIgnoreCase(@NotNull final String string, @NotNull final String prefix) throws IllegalArgumentException, NullPointerException {
        Validate.notNull(string, "Cannot check a null string for a match");
        if (string.length() < prefix.length()) {
            return false;
        }
        return string.regionMatches(true, 0, prefix, 0, prefix.length());
    }
}
