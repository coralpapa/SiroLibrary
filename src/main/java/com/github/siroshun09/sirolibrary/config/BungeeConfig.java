package com.github.siroshun09.sirolibrary.config;

import com.github.siroshun09.sirolibrary.file.FileUtil;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * BungeeCord で Yaml ファイルをロードしたり保存したりするクラス
 */
public class BungeeConfig extends BungeeYaml {
    private final boolean fromResource;

    /**
     * コンストラクタ
     * <p>
     * コンストラクタが呼び出された時点で Yaml ファイルを読み込む。
     *
     * @param plugin       プラグイン (データフォルダーの取得とロガーとして使われる)
     * @param fileName     Yaml ファイルの名前 (.yml も含む)
     * @param fromResource ファイルが存在しない場合、プラグインリソースからコピーするか
     */
    public BungeeConfig(@NotNull Plugin plugin, @NotNull String fileName, boolean fromResource) {
        super(plugin, plugin.getDataFolder().toPath().resolve(fileName));

        this.fromResource = fromResource;
        load();
    }

    /**
     * Yaml ファイルをロードする。ファイルが存在しない場合は作成される。
     *
     * @see BungeeConfig#create()
     */
    @Override
    public void load() {
        if (FileUtil.isNotExist(filePath)) this.create();
        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(filePath.toFile());
        } catch (IOException e) {
            plugin.getLogger().severe(filePath.getFileName().toString() + " の読み込みに失敗しました");
            e.printStackTrace();
        }
    }

    /**
     * Yaml ファイルを作成する。
     * <p>
     * {@code fromResource} が {@code true} の場合、{@code plugin} からコピーされる。
     *
     * @see BungeeYaml#createFile()
     * @see BungeeConfig#createFromResource()
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
        InputStream in = plugin.getResourceAsStream(filePath.getFileName().toString());

        if (in == null) {
            plugin.getLogger().severe("プラグインに " + filePath.getFileName().toString() + " がありません。");
            return;
        }

        try {
            Files.copy(in, filePath);
            plugin.getLogger().info("ファイルを作成しました: " + filePath.getFileName().toString());
        } catch (IOException e) {
            plugin.getLogger().severe("ファイルの作成に失敗しました: " + filePath.toString());
            e.printStackTrace();
        }
    }

    /**
     * メモリ上の Yaml データを再読み込みする
     */
    @Override
    public void reload() {
        load();
        plugin.getLogger().info(filePath.getFileName().toString() + " を再読み込みしました");
    }
}
