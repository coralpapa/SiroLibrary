package com.github.siroshun09.sirolibrary.bukkitutils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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
