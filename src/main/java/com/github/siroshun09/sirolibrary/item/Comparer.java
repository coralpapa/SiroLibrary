package com.github.siroshun09.sirolibrary.item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * アイテムの比較メソッド集。
 *
 * @since 1.0.18
 */
public class Comparer {

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
