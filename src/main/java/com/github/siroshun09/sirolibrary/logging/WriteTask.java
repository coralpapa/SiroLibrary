package com.github.siroshun09.sirolibrary.logging;

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

    WriteTask(Path filePath, String log) {
        this.filePath = filePath;
        this.log = log;
    }

    @Override
    public void run() {
        try {
            FileLogger.checkFile(filePath);
            Files.write(filePath, FileLogger.addDate(log).getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
