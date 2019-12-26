package com.github.siroshun09.sirolibrary.bukkitutils;

import com.github.siroshun09.sirolibrary.message.BukkitMessage;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * アイテム用のメソッド集
 *
 * @since 1.1.1
 */
public class ItemUtil {
    private final static ItemStack AIR = new ItemStack(Material.AIR);
    private final static ItemStack FLAME = createFlame();

    /**
     * 空気としてのアイテムを取得する。
     *
     * @return 空気
     */
    @Contract(pure = true)
    @NotNull
    public static ItemStack getAir() {
        return AIR;
    }

    /**
     * メニューのフレームを取得する。
     *
     * @return フレーム
     */
    @Contract(pure = true)
    @NotNull
    public static ItemStack getFlame() {
        return FLAME;
    }

    /**
     * メニューのフレームを作成する。
     *
     * @return 作成したフレーム
     */
    @NotNull
    private static ItemStack createFlame() {
        ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.RED + "");
            item.setItemMeta(meta);
        }
        return item;
    }

    /**
     * アイテムメタに色付きで名前をつける。
     *
     * @param meta アイテムのメタ
     * @param name 名前
     * @return 名前をつけられたメタ
     * @since 1.4.3
     */
    @NotNull
    public static ItemMeta setName(@NotNull ItemMeta meta, @NotNull String name) {
        meta.setDisplayName(BukkitMessage.setColor(name));
        return meta;
    }

    /**
     * アイテムメタに Lore を色付きでセットする。
     *
     * @param meta アイテムのメタ
     * @param lore Lore
     * @return Lore が追加されたメタ
     * @since 1.4.3
     */
    @NotNull
    public static ItemMeta setLore(@NotNull ItemMeta meta, @NotNull List<String> lore) {
        meta.setLore(BukkitMessage.setColorList(lore));
        return meta;
    }

    /**
     * アイテムメタに1行の Lore を色付きでセットする。
     *
     * @param meta アイテムのメタ
     * @param lore Lore
     * @return 1行の Lore が存在するメタ
     * @since 1.4.3
     */
    @NotNull
    public static ItemMeta setLore(@NotNull ItemMeta meta, @NotNull String lore) {
        meta.setLore(BukkitMessage.setColorList(Collections.singletonList(lore)));
        return meta;
    }

    /**
     * アイテムメタに1行の Lore を色付きで追記する。
     *
     * @param meta アイテムのメタ
     * @param lore Lore
     * @return 1行色付きで Lore に追記されたメタ。
     * @since 1.4.3
     */
    @NotNull
    public static ItemMeta addLore(@NotNull ItemMeta meta, @NotNull String lore) {
        if (meta.getLore() != null) {
            List<String> newLore = new ArrayList<>(meta.getLore());
            newLore.add(lore);
            meta.setLore(newLore);
        }
        return meta;
    }

    /**
     * Lore の指定した行を削除する。
     *
     * @param meta  アイテムのメタ
     * @param index 削除する行
     * @return 指定した行が削除されたメタ
     * @since 1.4.3
     */
    @NotNull
    public static ItemMeta removeLore(@NotNull ItemMeta meta, int index) {
        if (meta.getLore() != null && index < meta.getLore().size()) {
            List<String> newLore = new ArrayList<>(meta.getLore());
            newLore.remove(index);
            meta.setLore(newLore);
        }
        return meta;
    }

    /**
     * アイテムの名前を比較する。
     *
     * @param source 比較元
     * @param item   比較されるアイテム
     * @return 名前が全く同じ場合 {@code true}, そうでなければ {@code false}
     */
    public static boolean compareName(@NotNull ItemStack source, @NotNull ItemStack item) {
        ItemMeta sourceMeta = source.getItemMeta();
        ItemMeta meta = item.getItemMeta();
        if (sourceMeta == null || meta == null) {
            return false;
        }
        return sourceMeta.getDisplayName().equals(meta.getDisplayName());
    }

    /**
     * アイテムの Lore を比較する。
     *
     * @param source 比較元
     * @param item   比較されるアイテム
     * @return Lore が全く同じ場合 {@code true}, そうでなければ {@code false}
     */
    public static boolean compareLore(@NotNull ItemStack source, @NotNull ItemStack item) {
        ItemMeta sourceMeta = source.getItemMeta();
        ItemMeta meta = item.getItemMeta();
        if (sourceMeta == null || meta == null || (sourceMeta.hasLore() != meta.hasLore())) {
            return false;
        }

        List<String> sourceLore = sourceMeta.getLore();
        List<String> itemLore = meta.getLore();
        if (sourceLore == null || itemLore == null || sourceLore.size() != itemLore.size()) {
            return false;
        }

        int i = 0;
        while (i < sourceLore.size()) {
            if (!sourceLore.get(i).equals(itemLore.get(i))) {
                return false;
            }
            i++;
        }
        return true;
    }
}
