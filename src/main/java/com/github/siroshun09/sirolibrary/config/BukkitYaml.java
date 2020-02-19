package com.github.siroshun09.sirolibrary.config;

import com.github.siroshun09.sirolibrary.file.FileUtil;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class BukkitYaml {
    protected final Plugin plugin;
    protected final Path filePath;

    protected FileConfiguration config;

    /**
     * コンストラクタ
     *
     * @param plugin   プラグイン
     * @param filePath Yaml ファイルへのパス
     */
    public BukkitYaml(@NotNull Plugin plugin, @NotNull Path filePath) {
        this.plugin = plugin;
        this.filePath = filePath;
        load();
        plugin.getLogger().info(filePath.getFileName().toString() + " を読み込みました");
    }

    /**
     * Yaml ファイルをロードする。ファイルが存在しない場合は作成される。
     *
     * @see BukkitYaml#create()
     */
    protected void load() {
        if (FileUtil.isNotExist(filePath)) create();
        config = YamlConfiguration.loadConfiguration(filePath.toFile());
    }

    /**
     * Yaml ファイルを作成する。
     */
    protected void create() {
        createFile();
    }

    /**
     * 空の Yaml ファイルを作成する。
     */
    protected void createFile() {
        try {
            FileUtil.createDirAndFile(filePath);
        } catch (IOException e) {
            plugin.getLogger().severe("ファイルの作成に失敗しました: " + filePath.toString());
            e.printStackTrace();
            return;
        }
        plugin.getLogger().info("ファイルを作成しました: " + filePath.toString());
    }

    /**
     * メモリ上の Yaml データを再読み込みする
     */
    public void reload() {
        load();
        plugin.getLogger().info(filePath.getFileName().toString() + " を再読み込みしました");
    }

    /**
     * {@link FileConfiguration} として取得する。
     *
     * @return {@link FileConfiguration}
     */
    @NotNull
    public FileConfiguration getConfig() {
        return config;
    }

    /**
     * メモリに乗っている設定値を Yaml ファイルに上書き保存する。
     * ファイルが存在しない場合、新しく作成される。
     *
     * @see BukkitYaml#create()
     */
    public void save() {
        try {
            if (FileUtil.isNotExist(filePath)) createFile();
            getConfig().save(filePath.toFile());
        } catch (IOException e) {
            plugin.getLogger().severe("ファイルの保存に失敗しました: " + filePath);
            e.printStackTrace();
            return;
        }

        plugin.getLogger().info("ファイルに保存しました: " + filePath.getFileName().toString());
    }

    /**
     * {@code key} の設定値を {@code boolean}で取得する。
     *
     * @param key 設定キー
     * @param def デフォルトのブール値
     * @return 取得したブール値、取得できなければデフォルトのブール値
     */
    public boolean getBoolean(@NotNull String key, boolean def) {
        return config.getBoolean(key, def);
    }

    /**
     * {@code key} の設定値を {@code double}で取得する。
     *
     * @param key 設定キー
     * @param def デフォルトの数値
     * @return 取得した数値、取得できなければデフォルトの数値
     */
    public double getDouble(@NotNull String key, double def) {
        return config.getDouble(key, def);
    }

    /**
     * {@code key} の設定値を {@code int}で取得する。
     *
     * @param key 設定キー
     * @param def デフォルトの数値
     * @return 取得した数値、取得できなければデフォルトの数値
     */
    public int getInt(@NotNull String key, int def) {
        return config.getInt(key, def);
    }

    /**
     * {@code key} の設定値を {@code long}で取得する。
     *
     * @param key 設定キー
     * @param def デフォルトの数値
     * @return 取得した数値、取得できなければデフォルトの数値
     */
    public long getLong(@NotNull String key, long def) {
        return config.getLong(key, def);
    }

    /**
     * {@code key} の設定値を文字列で取得する。
     *
     * @param key 設定キー
     * @param def デフォルトの文字列
     * @return 取得した文字列、取得できなければデフォルトの文字列
     */
    @NotNull
    public String getString(@NotNull String key, @NotNull String def) {
        return Objects.requireNonNullElse(config.getString(key), def);
    }

    /**
     * {@code key} の設定値を文字列のリストで取得する。
     *
     * @param key 設定キー
     * @return 取得した文字列リスト、取得できなければ空のリスト
     */
    @NotNull
    public List<String> getStringList(@NotNull String key) {
        return config.getStringList(key);
    }

    /**
     * {@code key} の設定値をアイテムとして取得する。
     *
     * @param key 設定キー
     * @return 取得したアイテム、取得できなければ空気
     */
    @NotNull
    public ItemStack getItemStack(@NotNull String key) {
        return getItemStack(key, new ItemStack(Material.AIR));
    }

    /**
     * {@code key} の設定値をアイテムとして取得する。
     *
     * @param key 設定キー
     * @param def デフォルトのアイテム
     * @return 取得したアイテム、取得できなければデフォルト
     */
    @NotNull
    public ItemStack getItemStack(@NotNull String key, @NotNull ItemStack def) {
        return Objects.requireNonNullElse(config.getItemStack(key), def);
    }
}
