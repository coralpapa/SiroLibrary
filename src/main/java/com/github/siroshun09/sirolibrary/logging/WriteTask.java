package com.github.siroshun09.sirolibrary.logging;

import com.github.siroshun09.sirolibrary.SiroLibraryLogger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * ファイルへの書き込みタスク。
 *
 * @since 1.2.4
 */
class WriteTask implements Runnable {
    private final Path filePath;
    private final String log;

    WriteTask(@NotNull Path filePath, @NotNull String log) {
        this.filePath = filePath;
        this.log = log;
    }

    @Override
    public void run() {
        try {
            FileLogger.checkFile(filePath);
            if (Files.isWritable(filePath))
                Files.write(filePath, FileLogger.addDate(log, true).getBytes(), StandardOpenOption.APPEND);
            else printError();
        } catch (IOException e) {
            printError();
            e.printStackTrace();
        }
    }

    private void printError() {
        SiroLibraryLogger.getLogger().severe("ファイルに書き込めませんでした。");
        SiroLibraryLogger.getLogger().severe("ログ: " + log);
        SiroLibraryLogger.getLogger().severe("パス: " + filePath.toAbsolutePath().toString());
    }
}
