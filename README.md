# SiroLibrary

[![Download](https://api.bintray.com/packages/siroplugins/maven-repo/SiroLibrary/images/download.svg) ](https://bintray.com/siroshun/maven-repo/SiroLibrary/_latestVersion)
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/SiroPlugins/SiroLibrary/Java%20CI)
![GitHub](https://img.shields.io/github/license/SiroPlugins/SiroLibrary)
[![Bintray](https://img.shields.io/bintray/v/siroplugins/maven-repo/SiroLibrary?color=orange&label=Javadoc)](https://siroplugins.github.io/SiroLibrary/)

Spigot や BungeeCord のプラグインを開発する上で、何度も使うコードを集めたライブラリです。

また、commons-lang3 などのライブラリも含まれます。

このライブラリを使ったプラグインをサーバーで使う場合、SiroLibrary 自体もプラグインとして導入する必要があります。

Jar ファイルは上のバッジからダウンロード可能です。

## Requirements

- Java 11+
- Spigot or BungeeCord (Minecraft Version 1.15+)

## Usage (Maven)

Javadoc は上のバッジから閲覧できます。

```xml
        <repository>
            <id>bintray-siroplugins-maven-repo</id>
            <url>https://dl.bintray.com/siroplugins/maven-repo</url>
        </repository>
```
```xml
        <dependency>
            <groupId>com.github.siroshun09</groupId>
            <artifactId>sirolibrary</artifactId>
            <version>1.4.9</version>
            <scope>provided</scope>
        </dependency>
```

## License

このプロジェクトは GPL-3.0 のもとで公開しています。詳しくは [ライセンスファイル](LICENSE) をお読みください。

This project is licensed under the permissive GPL-3.0 license. Please see [LICENSE](LICENSE) for more info.

Copyright © 2019-2020, Siroshun09