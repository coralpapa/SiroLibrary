# 変更履歴

## 1.5.5

- Yaml インターフェースを作成し、BukkitYaml, BungeeYaml にて実装する

## 1.5.4

- BukkitMessage, BungeeMessage - プラグインの有効/無効ログ
- config パッケージ - ロギングを英語化
- コード整形

## 1.5.3

- HikariCP を Relocate する

## 1.5.2

- BukkitYaml, BungeeYaml のコンストラクタの種類を増やす

## 1.5.1

- Fix - 1.5.0 の BukkitConfig, BungeeConfig にて、リソースからファイルを作成しない問題

## 1.5.0

- BukkitYaml, BungeeYaml - ただの Yaml として読み込みたいときに使用
- BukkitConfig, BungeeConfig - BukkitYaml を拡張する
- 上のクラス内のコードを改善

## 1.4.9

- FileUtil - ファイル操作系のメソッド類
- Bintray のレポを変更

## 1.4.8

- HikariCP を内包した

## 1.4.7

- BukkitUtil - 権限系メソッド
- FileLogger - 定数名を大文字化
- FileLogger - addDate(String, boolean) の追加 (改行の有無)
- FileLogger - addDate() での日付フォーマット変更
- WriteTask - Files.isWritable で書き込みチェック
- SiroLibraryLogger - 稼働場所に関わらず、ロガーを取得する。
- Guava 削除 (使用しないため)

## 1.4.6

- NumberChecker - Int または Long であるか判定するメソッド
- パッケージの公開先を Bintray にする
