package com.github.siroshun09.sirolibrary.bukkitutils;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * インベントリ用のメソッド集
 *
 * @since 1.1.1
 */
public class InventoryUtil {

    public static void setItems(@NotNull Inventory inv, @NotNull List<ItemStack> items) {
        int i = 0;
        for (ItemStack item : items) {
            inv.setItem(i, item);
            i++;
        }
    }
}
