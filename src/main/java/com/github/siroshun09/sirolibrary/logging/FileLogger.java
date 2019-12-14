package com.github.siroshun09.sirolibrary.logging;

import com.github.siroshun09.sirolibrary.text.Formatter;
import com.github.siroshun09.sirolibrary.text.Padding;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ファイルへのログ保存を非同期で行うクラス。
 *
 * @since 1.0.12
 */
public class FileLogger {
    private final static ExecutorService executor =
            Executors.newSingleThreadExecutor(r -> new Thread(r, "SiroLibrary-FileLogger-Thread"));
    private final static String separator = System.getProperty("line.separator");

    private final Path dir;
    private Path filePath;
    private LocalDate date;

    public FileLogger(@NotNull Path dir) {
        this.dir = dir;
        date = LocalDate.now();
        filePath = dir.resolve(Formatter.getDate(date) + ".log");
    }

    /**
     * {@code file} にログを書き込む。
     *
     * @param file 書き込み先
     * @param log  書き込むログ
     * @since 1.0.12
     */
    public static void write(Path file, String log) {
        executor.submit(new WriteTask(file, log));
    }

    /**
     * 日付を確認し、必要に応じてログファイルを更新する。
     *
     * @since 1.2.4
     */
    private void checkDate() {
        if (!date.equals(LocalDate.now())) {
            date = LocalDate.now();
            filePath = dir.resolve(Formatter.getDate(date) + ".log");
        }
    }

    /**
     * ファイルにログを書き込む。
     *
     * @param log 書き込むログ
     * @since 1.2.4
     */
    public void write(String log) {
        checkDate();
        executor.submit(new WriteTask(filePath, log));
    }

    /**
     * 渡された文字列の最初に日時を、最後に改行を追加する。
     *
     * @param log ログ
     * @return 追記したログ
     * @see Padding#padDateTime()
     * @since 1.0.12
     */
    @NotNull
    public static String addDate(String log) {
        return "[" + Padding.padDateTime() + "] " + log + separator;
    }

    /**
     * 与えられたパスのファイルが存在していなければ、ディレクトリとともに作成する。
     *
     * @param file ファイル
     * @throws IOException 入出力エラー
     * @since 1.0.12
     */
    public static void checkFile(Path file) throws IOException {
        if (!Files.exists(file)) {
            Files.createDirectories(file.getParent());
            Files.createFile(file);
        }
    }
}
