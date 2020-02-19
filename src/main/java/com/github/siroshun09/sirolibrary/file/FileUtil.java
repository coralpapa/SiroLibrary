package com.github.siroshun09.sirolibrary.file;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * ファイル操作系のメソッド集
 *
 * @since 1.4.9
 */
public final class FileUtil {

    /**
     * 渡されたパスを絶対パスに変換し、その親ディレクトリが存在しない場合作成する。
     *
     * @param path 親ディレクトリを作成するパス
     * @throws IOException 出入力例外が発生した時
     * @see FileUtil#isNotExist(Path)
     */
    public static void createParentDirectories(@NotNull Path path) throws IOException {
        Path directoriesPath = path.toAbsolutePath().getParent();
        if (isNotExist(directoriesPath)) {
            Files.createDirectories(directoriesPath);
        }
    }

    /**
     * 渡されたパスで、ファイルが存在しない場合作成する。
     *
     * @param path ファイルパス
     * @throws IOException 出入力例外が発生した時
     * @see FileUtil#isNotExist(Path)
     */
    public static void createFile(@NotNull Path path) throws IOException {
        if (isNotExist(path)) {
            Files.createFile(path);
        }
    }

    /**
     * 渡されたパスの親ディレクトリとファイルを作成する。
     *
     * @param path 親ディレクトリとファイルを作成するパス
     * @throws IOException 出入力例外が発生した時
     * @see FileUtil#isNotExist(Path)
     * @see FileUtil#createParentDirectories(Path)
     * @see FileUtil#createFile(Path)
     */
    public static void createDirAndFile(@NotNull Path path) throws IOException {
        createParentDirectories(path);
        createFile(path);
    }

    /**
     * 渡されたパスのファイルまたはディレクトリが存在しなければ {@code true} を返す。
     *
     * @param path 判定するパス
     * @return 存在しなければ {@code true}, していれば {@code false}
     */
    public static boolean isNotExist(@NotNull Path path) {
        return !Files.exists(path);
    }
}
