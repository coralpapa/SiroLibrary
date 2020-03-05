package com.github.siroshun09.sirolibrary.config;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Yaml {

    /**
     * Yaml ファイルをロードする。
     */
    void load();

    /**
     * メモリ上の Yaml データを再読み込みする
     */
    void reload();

    /**
     * メモリに乗っている設定値を Yaml ファイルに上書き保存する。
     */
    void save();

    /**
     * {@code key} の設定値を {@code boolean}で取得する。
     *
     * @param key 設定キー
     * @param def デフォルトのブール値
     * @return 取得したブール値、取得できなければデフォルトのブール値
     */
    boolean getBoolean(@NotNull String key, boolean def);

    /**
     * {@code key} の設定値を {@code double}で取得する。
     *
     * @param key 設定キー
     * @param def デフォルトの数値
     * @return 取得した数値、取得できなければデフォルトの数値
     */
    double getDouble(@NotNull String key, double def);

    /**
     * {@code key} の設定値を {@code int}で取得する。
     *
     * @param key 設定キー
     * @param def デフォルトの数値
     * @return 取得した数値、取得できなければデフォルトの数値
     */
    int getInt(@NotNull String key, int def);

    /**
     * {@code key} の設定値を {@code long}で取得する。
     *
     * @param key 設定キー
     * @param def デフォルトの数値
     * @return 取得した数値、取得できなければデフォルトの数値
     */
    long getLong(@NotNull String key, long def);

    /**
     * {@code key} の設定値を文字列で取得する。
     *
     * @param key 設定キー
     * @param def デフォルトの文字列
     * @return 取得した文字列、取得できなければデフォルトの文字列
     */
    @NotNull
    String getString(@NotNull String key, @NotNull String def);

    /**
     * {@code key} の設定値を文字列のリストで取得する。
     *
     * @param key 設定キー
     * @return 取得した文字列リスト、取得できなければ空のリスト
     */
    @NotNull
    List<String> getStringList(@NotNull String key);
}
