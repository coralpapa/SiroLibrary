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
     *
     * @param plugin       プラグイン
     * @param fileName     Yaml ファイルの名前 (.yml も含む)
     * @param fromResource ファイルが存在しない場合、プラグインリソースからコピーするか
     */
    public BukkitConfig(@NotNull Plugin plugin, @NotNull String fileName, boolean fromResource) {
        super(plugin, plugin.getDataFolder().toPath().resolve(fileName));
        this.fromResource = fromResource;
        load();
        plugin.getLogger().info(filePath.getFileName().toString() + " を読み込みました");
    }

    /**
     * Yaml ファイルをロードする。ファイルが存在しない場合は作成される。
     *
     * @see BukkitConfig#create()
     */
    @Override
    protected void load() {
        if (FileUtil.isNotExist(filePath)) create();
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
            plugin.getLogger().info("ファイルを作成しました: " + filePath);
        } else {
            plugin.getLogger().severe("プラグインに " + filePath.getFileName().toString() + " がありません。");
        }
    }

    /**
     * メモリ上の Yaml データを再読み込みする
     */
    public void reload() {
        load();
        plugin.getLogger().info(filePath.getFileName().toString() + " を再読み込みしました");
    }
}
