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

public class BungeeYaml implements Yaml {

    protected final Plugin plugin;
    protected final Path filePath;

    protected Configuration config;

    /**
     * コンストラクタ
     * <p>
     * このコンストラクタでは {@link BungeeYaml#load()} の実行を必要とする。
     *
     * @param plugin   プラグイン (ロギングが有効になる)
     * @param filePath Yaml ファイルへのパス
     */
    public BungeeYaml(@NotNull Plugin plugin, @NotNull Path filePath) {
        this(filePath, plugin, false);
    }

    /**
     * コンストラクタ
     * <p>
     * このコンストラクタでは {@link BungeeYaml#load()} の実行を必要とする。
     *
     * @param filePath Yaml ファイルへのパス
     */
    public BungeeYaml(@NotNull Path filePath) {
        this(filePath, null, false);
    }

    /**
     * コンストラクタ
     *
     * @param filePath Yaml ファイルへのパス
     * @param autoLoad 自動的に読み込むか
     */
    public BungeeYaml(@NotNull Path filePath, boolean autoLoad) {
        this(filePath, null, autoLoad);
    }

    /**
     * コンストラクタ
     *
     * @param filePath Yaml ファイルへのパス
     * @param plugin   プラグイン (ロギングが有効になる)
     * @param autoLoad 自動的に読み込むか
     */
    public BungeeYaml(@NotNull Path filePath, @Nullable Plugin plugin, boolean autoLoad) {
        this.filePath = filePath;
        this.plugin = plugin;
        if (autoLoad) {
            load();
        }
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
            printInfo("Loaded " + filePath.getFileName().toString());
        } catch (IOException e) {
            printSevere("Failed to load " + filePath.getFileName().toString());
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
            printSevere("Failed to create file: " + filePath.toString());
            e.printStackTrace();
            return;
        }
        printInfo("Created the file: " + filePath.toString());
    }

    /**
     * メモリ上の Yaml データを再読み込みする
     */
    public void reload() {
        load();
        printInfo("Reloaded " + filePath.getFileName().toString());
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
     *
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
            printSevere("Failed to save config data: " + filePath);
            e.printStackTrace();
            return;
        }
        printInfo("Save config data to file: " + filePath.getFileName().toString());
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

    /**
     * ログを {@link java.util.logging.Level#INFO}でコンソールに流す。
     * <p>
     * {@link Plugin} インスタンスが渡されていない場合、流れない。
     *
     * @param log 流すログ
     */
    protected void printInfo(String log) {
        if (plugin != null) {
            plugin.getLogger().info(log);
        }
    }

    /**
     * ログを {@link java.util.logging.Level#SEVERE}でコンソールに流す。
     * <p>
     * {@link Plugin} インスタンスが渡されていない場合、流れない。
     *
     * @param log 流すログ
     */
    protected void printSevere(String log) {
        if (plugin != null) {
            plugin.getLogger().severe(log);
        }
    }
}
