# SiroLibrary

[ ![Download](https://api.bintray.com/packages/siroshun/maven-repo/SiroLibrary/images/download.svg) ](https://bintray.com/siroshun/maven-repo/SiroLibrary/_latestVersion)
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/SiroPlugins/SiroLibrary/Java%20CI)
![GitHub](https://img.shields.io/github/license/SiroPlugins/SiroLibrary)
[![Bintray](https://img.shields.io/bintray/v/siroshun/maven-repo/SiroLibrary?color=orange&label=Javadoc)](https://siroplugins.github.io/SiroLibrary/)

Spigot や BungeeCode のプラグインを開発する上で、何度も使うコードを集めたライブラリ。

また、commons-lang3 などのライブラリも含まれる。

このライブラリを使ったプラグインを Spigot や BungeeCode のサーバーで使う場合、

プラグインとして SiroLibrary 自体も導入する必要がある。

## Maven

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