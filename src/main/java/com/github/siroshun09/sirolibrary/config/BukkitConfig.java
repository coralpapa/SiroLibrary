package com.github.siroshun09.sirolibrary.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Bukkit で Yaml ファイルをロードしたり保存したりするクラス
 */
public class BukkitConfig {
    private final Plugin plugin;
    private final Path filePath;
    private final boolean resource;

    private FileConfiguration config;

    /**
     * コンストラクタ
     *
     * @param plugin   プラグイン (データフォルダーの取得とロガーとして使われる)
     * @param fileName Yaml ファイルの名前 (.yml も含む)
     * @param resource ファイルが存在しない場合、プラグインリソースからコピーするか
     */
    public BukkitConfig(@NotNull Plugin plugin, @NotNull String fileName, boolean resource) {
        this.plugin = plugin;
        filePath = plugin.getDataFolder().toPath().resolve(fileName);
        this.resource = resource;

        try {
            Files.createDirectories(plugin.getDataFolder().toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        load();
    }

    /**
     * Yaml ファイルをロードする。ファイルが存在しない場合は作成される。
     *
     * @see BukkitConfig#create()
     */
    private void load() {
        if (!Files.exists(filePath)) create();
        config = YamlConfiguration.loadConfiguration(filePath.toFile());
        plugin.getLogger().info(filePath.getFileName().toString() + " を読み込みました");
    }

    /**
     * Yaml ファイルを作成する。
     * 要求元プラグインのリソースからのコピーが要求されているも、存在しない場合は {@link IllegalArgumentException} が発生する。
     *
     * @throws IllegalArgumentException {@link BukkitConfig#resource} が true で、プラグインリソースにファイルが存在しない場合
     */
    private void create() {
        if (resource) {
            if (plugin.getResource(filePath.getFileName().toString()) != null) {
                plugin.saveResource(filePath.getFileName().toString(), false);
                plugin.getLogger().info("ファイルを作成しました: " + filePath);
            } else {
                throw new IllegalArgumentException("プラグインから " + filePath.getFileName().toString() + " を検出できません");
            }
        } else {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                plugin.getLogger().severe("ファイルの作成に失敗しました: " + filePath);
                e.printStackTrace();
            }
            plugin.getLogger().info("ファイルを作成しました: " + filePath);
        }
    }

    /**
     * メモリ上の Yaml データを再読み込みする
     */
    public void reload() {
        if (!Files.exists(filePath)) create();
        config = YamlConfiguration.loadConfiguration(filePath.toFile());
        plugin.getLogger().info(filePath.getFileName().toString() + " を再読み込みました");
    }

    /**
     * {@link FileConfiguration} として取得する。
     *
     * @return {@link FileConfiguration}
     */
    public FileConfiguration getConfig() {
        if (config == null) reload();
        return config;
    }

    /**
     * メモリに乗っている設定値を Yaml ファイルに上書き保存する。
     * ファイルが存在しない場合、新しく作成される。
     *
     * @see BukkitConfig#create()
     */
    public void save() {
        if (config == null) return;

        try {
            getConfig().save(filePath.toFile());
        } catch (IOException e) {
            plugin.getLogger().severe("ファイルの保存に失敗しました: " + filePath);
            e.printStackTrace();
        }
    }
}
