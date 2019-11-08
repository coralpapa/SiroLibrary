package com.github.siroshun09.sirolibrary.config;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BungeeConfig {
    private final Plugin plugin;
    private final Path filePath;
    private final boolean resource;
    private Configuration config;

    /**
     * コンストラクタ
     *
     * @param plugin   プラグイン (データフォルダーの取得とロガーとして使われる)
     * @param fileName Yaml ファイルの名前 (.yml も含む)
     * @param resource ファイルが存在しない場合、プラグインリソースからコピーするか
     */
    public BungeeConfig(@NotNull Plugin plugin, @NotNull String fileName, boolean resource) {
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

    private void load() {
        if (!Files.exists(filePath)) create();

        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(filePath.toFile());
        } catch (IOException e) {
            plugin.getLogger().severe(filePath.getFileName().toString() + " の読み込みに失敗しました");
            e.printStackTrace();
        }

        plugin.getLogger().info(filePath.getFileName().toString() + " を読み込みました");
    }

    private void create() {
        if (resource) {
            InputStream in = plugin.getResourceAsStream(filePath.getFileName().toString());

            if (in == null) {
                plugin.getLogger().warning(filePath.getFileName().toString() + " は PL に含まれていません");
                plugin.getLogger().warning("PL 製作者に問い合わせてください");
                return;
            }

            try {
                Files.copy(in, filePath);
            } catch (IOException e) {
                plugin.getLogger().severe("ファイルの作成に失敗しました: " + filePath);
                e.printStackTrace();
            }
            return;
        }

        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            plugin.getLogger().severe("ファイルの作成に失敗しました: " + filePath);
            e.printStackTrace();
        }

        plugin.getLogger().info("ファイルを作成しました: " + filePath);
    }

    /**
     * メモリ上の Yaml データを再読み込みする
     */
    public void reload() {
        if (!Files.exists(filePath)) create();

        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(filePath.toFile());
        } catch (IOException e) {
            plugin.getLogger().severe(filePath.getFileName().toString() + " の読み込みに失敗しました");
            e.printStackTrace();
        }

        plugin.getLogger().info(filePath.getFileName().toString() + " を再読み込みました");
    }

    /**
     * {@link Configuration} として取得する。
     *
     * @return {@link Configuration}
     */
    public Configuration getConfig() {
        return config;
    }

    /**
     * インスタンスごと取得する。
     *
     * @return {@link BungeeConfig}
     */
    public BungeeConfig get() {
        return this;
    }

    /**
     * メモリに乗っている設定値を Yaml ファイルに上書き保存する。
     * ファイルが存在しない場合、新しく作成される。
     */
    public void save() {
        if (!Files.exists(filePath)) create();

        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(getConfig(), filePath.toFile());
        } catch (IOException e) {
            plugin.getLogger().severe("ファイルの保存に失敗しました: " + filePath);
            e.printStackTrace();
        }
    }
}
