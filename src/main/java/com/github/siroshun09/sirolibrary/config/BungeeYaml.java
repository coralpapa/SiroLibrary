package com.github.siroshun09.sirolibrary.config;

import com.github.siroshun09.sirolibrary.file.FileUtil;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BungeeYaml {
    protected final Plugin plugin;
    protected final Path filePath;

    protected Configuration config;

    /**
     * コンストラクタ
     * <p>
     * コンストラクタを呼び出した時点では Yaml ファイルを読み込まないので、 {@link BungeeYaml#load()} を実行する必要がある。
     *
     * @param plugin   プラグイン
     * @param filePath Yaml ファイルへのパス
     */
    public BungeeYaml(@NotNull Plugin plugin, @NotNull Path filePath) {
        this.plugin = plugin;
        this.filePath = filePath;
    }

    /**
     * Yaml ファイルをロードする。ファイルが存在しない場合は作成される。
     *
     * @see BungeeYaml#create()
     */
    public void load() {
        if (FileUtil.isNotExist(filePath)) create();
        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(filePath.toFile());
            plugin.getLogger().info(filePath.getFileName().toString() + " を読み込みました");
        } catch (IOException e) {
            plugin.getLogger().severe(filePath.getFileName().toString() + " の読み込みに失敗しました");
            e.printStackTrace();
        }
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
            plugin.getLogger().severe("ファイルの作成に失敗しました: " + filePath);
            e.printStackTrace();
            return;
        }
        plugin.getLogger().info("ファイルを作成しました: " + filePath);
    }

    /**
     * メモリ上の Yaml データを再読み込みする
     */
    public void reload() {
        load();
        plugin.getLogger().info(filePath.getFileName().toString() + " を再読み込みました");
    }

    /**
     * {@link Configuration} として取得する。
     *
     * @return {@link Configuration}
     */
    @Nullable
    public Configuration getConfig() {
        return config;
    }

    /**
     * メモリに乗っている設定値を Yaml ファイルに上書き保存する。
     * ファイルが存在しない場合、新しく作成される。
     *
     * @see BungeeYaml#create()
     */
    public void save() {
        if (config == null) return;

        try {
            if (FileUtil.isNotExist(filePath)) createFile();
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(getConfig(), filePath.toFile());
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
        if (config == null) {
            return def;
        }
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
        if (config == null) {
            return def;
        }
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
        if (config == null) {
            return def;
        }
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
        if (config == null) {
            return def;
        }
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
        if (config == null) {
            return def;
        }
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
        if (config == null) {
            return new ArrayList<>();
        }
        return config.getStringList(key);
    }
}
