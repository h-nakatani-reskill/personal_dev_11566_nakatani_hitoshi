--ユーザーテーブルデータ
INSERT INTO users(name,email,password) VALUES('田中一郎','tanaka@aaa.com','tanaka123');
--INSERT INTO users(email,name,password) VALUES('suzuki@bbb.com','鈴木次郎','suzuki456');
--INSERT INTO users(email,name,password) VALUES('kato@ccc.com','加藤三郎','kato123');

-- カテゴリーテーブルデータ
INSERT INTO categories(name) VALUES('朝');
INSERT INTO categories(name) VALUES('昼');
INSERT INTO categories(name) VALUES('夜');
INSERT INTO categories(name) VALUES('その他');

-- タスクテーブルデータ
INSERT INTO tasks(category_id,user_id,record_day, title, progress, memo) VALUES(1,1, '2025/12/31', '風邪薬', 20, '毎食後1つ');
INSERT INTO tasks(category_id,user_id,record_day, title, progress, memo) VALUES(2,1, '2003/04/23', 'かゆみ止め', 18, '1日2回');
INSERT INTO tasks(category_id,user_id,record_day, title, progress, memo) VALUES(1,1, '2022/05/28', '酔い止め', 22, '乗車前2粒');
