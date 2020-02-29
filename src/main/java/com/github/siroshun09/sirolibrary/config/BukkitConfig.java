package com.github.siroshun09.sirolibrary.config;

import com.github.siroshun09.sirolibrary.file.FileUtil;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Bukkit で Yaml ファイルをロードしたり保存したりするクラス
 */
public class BukkitConfig extends BukkitYaml {
    private final boolean fromResource;

    /**
     * コンストラクタ
     * <p>
     * コンストラクタが呼び出された時点で Yaml ファイルを読み込む。
     *
     * @param plugin       プラグイン
     * @param fileName     Yaml ファイルの名前 (.yml も含む)
     * @param fromResource ファイルが存在しない場合、プラグインリソースからコピーするか
     */
    public BukkitConfig(@NotNull Plugin plugin, @NotNull String fileName, boolean fromResource) {
        super(plugin, plugin.getDataFolder().toPath().resolve(fileName));
        this.fromResource = fromResource;
        load();
        printInfo("Loaded " + filePath.getFileName().toString());
    }

    /**
     * Yaml ファイルをロードする。ファイルが存在しない場合は作成される。
     *
     * @see BukkitConfig#create()
     */
    @Override
    public void load() {
        if (FileUtil.isNotExist(filePath)) this.create();
        config = YamlConfiguration.loadConfiguration(filePath.toFile());
    }

    /**
     * Yaml ファイルを作成する。
     * <p>
     * {@code fromResource} が {@code true} の場合、{@code plugin} からコピーされる。
     *
     * @see BukkitYaml#createFile()
     * @see BukkitConfig#createFromResource()
     */
    @Override
    protected void create() {
        try {
            if (fromResource) {
                FileUtil.createParentDirectories(filePath);
                createFromResource();
            } else {
                createFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * プラグインのリソースからコピーし、新しい Yaml ファイルを作成する。
     */
    private void createFromResource() {
        if (plugin.getResource(filePath.getFileName().toString()) != null) {
            plugin.saveResource(filePath.getFileName().toString(), false);
            printInfo("Created the file: " + filePath.toString());
        } else {
            printSevere("Failed to copy file from resource: " + filePath.getFileName().toString());
        }
    }

    /**
     * メモリ上の Yaml データを再読み込みする
     */
    public void reload() {
        load();
        printInfo("Reloaded " + filePath.getFileName().toString());
    }
}
