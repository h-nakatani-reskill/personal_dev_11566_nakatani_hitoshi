--ユーザーテーブルデータ
INSERT INTO users(user_id,email,name,password) VALUES(1,'tanaka@aaa.com','田中一郎','tanaka123');
INSERT INTO users(user_id,email,name,password) VALUES(2,'suzuki@bbb.com','鈴木次郎','suzuki456');
INSERT INTO users(user_id,email,name,password) VALUES(3,'kato@ccc.com','加藤三郎','kato123');

-- カテゴリーテーブルデータ
INSERT INTO categories(category_id,name) VALUES(1,'ビジネス');
INSERT INTO categories(category_id,name) VALUES(2,'プライベート');
INSERT INTO categories(category_id,name) VALUES(3,'その他');

-- タスクテーブルデータ
INSERT INTO tasks(task_id, category_id, user_id, title, closing_date, progress, memo) VALUES(1, 1, 1, '見積もり', '2025-12-31', 0, '案件に適した見積もりを取る');
INSERT INTO tasks(task_id, category_id, user_id, title, closing_date, progress, memo) VALUES(2, 2, 1, '買い物', '2003-04-23', 0, 'じゃがいも、にんじん、豚肉');
INSERT INTO tasks(task_id, category_id, user_id, title, closing_date, progress, memo) VALUES(3, 3, 1, 'ピアノの演奏会', '2022-05-28', 1, '午後2時に音楽ホール');
