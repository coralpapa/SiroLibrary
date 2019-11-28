package com.github.siroshun09.sirolibrary.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * 個々のアイテムを {@link ItemStack} で取得するメソッド集。
 *
 * @since 1.0.18
 */
public class Items {
    private final static ItemStack AIR = new ItemStack(Material.AIR);
    private static ItemStack FLAME = createFlame();

    /**
     * 空気としてのアイテムを取得する。
     *
     * @return 空気
     */
    @Contract(pure = true)
    public static ItemStack getAir() {
        return AIR;
    }

    /**
     * メニューのフレームを取得する。
     *
     * @return フレーム
     */
    @Contract(pure = true)
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
}
