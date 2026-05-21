--ユーザーテーブルデータ
INSERT INTO users(name,email,password) VALUES('田中一郎','tanaka@aaa.com','tanaka123');
--INSERT INTO users(email,name,password) VALUES('suzuki@bbb.com','鈴木次郎','suzuki456');
--INSERT INTO users(email,name,password) VALUES('kato@ccc.com','加藤三郎','kato123');

-- カテゴリーテーブルデータ
INSERT INTO categories(name) VALUES('ビジネス');
INSERT INTO categories(name) VALUES('プライベート');

-- タスクテーブルデータ
INSERT INTO tasks(category_id,user_id,record_day, title, progress, memo) VALUES(1,1, '2025/12/31', '見積もり', 0, '案件に適した見積もりを取る');
INSERT INTO tasks(category_id,user_id,record_day, title, progress, memo) VALUES(2,1, '2003/04/23', '買い物', 0, 'じゃがいも、にんじん、豚肉');
INSERT INTO tasks(category_id,user_id,record_day, title, progress, memo) VALUES(1,1, '2022/05/28', 'ピアノの演奏会', 1, '午後2時に音楽ホール');
