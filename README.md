# SiroLibrary

[![Download](https://api.bintray.com/packages/siroshun/maven-repo/SiroLibrary/images/download.svg) ](https://bintray.com/siroshun/maven-repo/SiroLibrary/_latestVersion)
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/SiroPlugins/SiroLibrary/Java%20CI)
![GitHub](https://img.shields.io/github/license/SiroPlugins/SiroLibrary)
[![Bintray](https://img.shields.io/bintray/v/siroshun/maven-repo/SiroLibrary?color=orange&label=Javadoc)](https://siroplugins.github.io/SiroLibrary/)

Spigot や BungeeCode のプラグインを開発する上で、何度も使うコードを集めたライブラリです。

また、commons-lang3 や Guava (28-jre) などのライブラリも含まれます。

このライブラリを使ったプラグインをサーバーで使う場合、SiroLibrary 自体もプラグインとして導入する必要があります。

Jar ファイルは上のバッジからダウンロード可能です。

## Requirements

- Java 10+
- Spigot or BungeeCode (Minecraft Version 1.15+)

## Usage (Maven)

Javadoc は上のバッジから閲覧できます。

```xml
        <repository>
            <id>bintray-siroshun-maven-repo</id>
            <url>https://siroshun.bintray.com/maven-repo</url>
        </repository>
```
```xml
        <dependency>
            <groupId>com.github.siroshun09</groupId>
            <artifactId>sirolibrary</artifactId>
            <version>1.4.6</version>
            <scope>provided</scope>
        </dependency>
```