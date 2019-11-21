package com.github.siroshun09.sirolibrary.logging;

import com.github.siroshun09.sirolibrary.text.Padding;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileLogger {
    private final static ExecutorService executor =
            Executors.newSingleThreadExecutor(r -> new Thread(r, "SiroLibrary-FileLogger-Thread"));
    private final static String separator = System.getProperty("line.separator");

    public static void write(Path file, String log) {
        executor.submit(() -> {
            try {
                checkFile(file);
                Files.write(file, addDate(log).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @NotNull
    public static String addDate(String log) {
        return "[" + Padding.padDateTime() + "] " + log + separator;
    }

    public static void checkFile(Path file) throws IOException {
        if (!Files.exists(file)) {
            Files.createDirectories(file.getParent());
            Files.createFile(file);
        }
    }
}
