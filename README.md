# お薬日記帳

## 1.アプリ概要

このアプリは薬の在庫管理と記録を目的としたアプリケーションです。
ユーザーはメールアドレスとパスワードでログインし、薬を飲むタイミングごとに服用時間と服用量をきろくできます。
現在の実装では、ユーザー情報、部位カテゴリ情報、タスク情報をPostgreSQLで管理し、ログイン後に薬品記録の一覧を表示する構成になっています。

## 2.主な機能

## 3.使用技術

## 4.プロジェクト構成

'''
personal_dev_11566_nakatani_hitoshi
│
│  build.gradle
│  gradlew
│  gradlew.bat
│  settings.gradle
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─example
    │  │          └─demo
    │  │              │  PersonalDev11566NakataniHitoshiApplication.java
    │  │              │
    │  │              ├─AOP
    │  │              │      LoggingAspect.java
    │  │              │
    │  │              ├─controller
    │  │              │      CategoryController.java
    │  │              │      TaskController.java
    │  │              │      UserController.java
    │  │              │
    │  │              ├─entity
    │  │              │      Categories.java
    │  │              │      Progresses.java
    │  │              │      Task.java
    │  │              │      User.java
    │  │              │
    │  │              ├─model
    │  │              │      Account.java
    │  │              │
    │  │              └─repository
    │  │                      CategoryRepository.java
    │  │                      TaskRepository.java
    │  │                      UserRepository.java
    │  │
    │  └─resources
    │      │  application.properties
    │      │  data.sql
    │      │  schema.sql
    │      │
    │      ├─static
    │      │  └─css
    │      │          style.css
    │      │
    │      └─templates
    │              addCategory.html
    │              addTask.html
    │              addUser.html
    │              categories.html
    │              editCategory.html
    │              editTask.html
    │              footer.html
    │              header.html
    │              login.html
    │              tasks.html
    │
    └─test
'''

## 5.画面一覧

## 6.URL一覧

## 7.データベース設計

## 8.初期データ

## 9.Entity一覧

## 10.Repository一覧

## 11.Model一覧

## 12.処理の流れ

## 13.application.properties

## 14.セットアップ手順

## 15.現在の問題点

## 16.実装要領

## 17.修正優先順位

## 18.マスト機能の達成状況

## 19.今後追加すると良い機能
 
 **※上に行くほど優先度高い**
 
#### 記録日：2026/05/22

 - [x]task登録時におけるuser_idの登録と保存
 
 - [x]task一覧の表示をログインユーザーIDで絞り込む
 
 - taskAdd.htmlにカテゴリー一覧を表示、受け渡す
 
- [x]task登録時にIntegerへ '(defaultvalue="")'を渡すのは危険なので、(required = false)に変更

- タスクの編集・削除時にuserIdとaccount.getId()が一致するか確認する

- カテゴリー削除時にそのカテゴリーに紐づくタスクがあるか調べて、判断させる処理を行う

- カテゴリー追加・編集時の入力チェック

- [~]直接URL対策
 
- 服用個数と残量を連動させ、ボタンを押すと一回あたり個数分の残量が減る機能

## 20.最終まとめ

