package com.github.siroshun09.sirolibrary.bukkitutils;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * スコアボード用のメソッド集。
 *
 * @since 1.2.3
 */
public class ScoreboardUtil {

    /**
     * サーバーで使用されているスコアボードを取得する。
     *
     * @return サーバーのスコアボード
     */
    @NotNull
    public static Scoreboard getMainScoreboard() {
        return getScoreboardManager().getMainScoreboard();
    }

    /**
     * {@link ScoreboardManager} を取得する。
     * <p>
     * ワールド読み込みより前に呼び出されると {@link IllegalStateException} を投げる。
     *
     * @return {@link ScoreboardManager}
     */
    @NotNull
    public static ScoreboardManager getScoreboardManager() {
        return Optional.ofNullable(Bukkit.getScoreboardManager()).orElseThrow(IllegalStateException::new);
    }

    /**
     * {@code name} のスコアボードを取得する。
     *
     * @param name スコアボード名
     * @return 指定したスコアボード、存在しなければ {@code null}
     */
    @Nullable
    public static Objective getObjective(@NotNull String name) {
        return getMainScoreboard().getObjective(name);
    }
}
