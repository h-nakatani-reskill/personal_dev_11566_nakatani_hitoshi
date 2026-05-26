--ユーザーテーブルデータ
INSERT INTO users(name,email,password) VALUES('河童','kappa@kawatarou.com','kyuuri');
INSERT INTO users(name,email,password) VALUES('田中一郎','tanaka@aaa.com','tanaka123');
INSERT INTO users(name,email,password) VALUES('鈴木次郎','suzuki@bbb.com','suzuki456');
INSERT INTO users(name,email,password) VALUES('加藤三郎','kato@ccc.com','kato123');

-- カテゴリーテーブルデータ
INSERT INTO categories(name) VALUES('朝');
INSERT INTO categories(name) VALUES('昼');
INSERT INTO categories(name) VALUES('夜');
INSERT INTO categories(name) VALUES('食事');
INSERT INTO categories(name) VALUES('入浴後');
INSERT INTO categories(name) VALUES('就寝前');
INSERT INTO categories(name) VALUES('その他');

-- タスクテーブルデータ
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(1,1, '2013-07-31', '風邪薬', 20,2,'朝食後');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(2,1, '2003-06-23', '高血圧薬',20,1, '昼食後');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(3,1, '2022-05-28', '高血圧薬', 22,2,'夕食後');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(4,1, '2025-12-24', '軟膏', 20,2,'お茶はNG');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(5,1, '2008-11-29', 'かゆみ止め',18,1, '保湿クリームも塗る');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(6,1, '2015-01-15', '睡眠薬', 22,2,'白湯で飲む');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(7,1, '2017-10-27', '酔い止め', 22,2,'乗車前');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(1,2, '2004-09-30', '風邪薬', 20,2,'毎食後');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(2,2, '2001-04-21', 'かゆみ止め',18,1, '1日');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(3,2, '2023-02-14', '酔い止め', 22,2,'乗車前');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(1,3, '2014-12-19', '風邪薬', 20,2,'毎食後');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(2,3, '2007-03-17', 'かゆみ止め',18,1, '1日');
INSERT INTO tasks(category_id,user_id,record_day,title,level,progress,memo) VALUES(1,3, '2021-08-16', '酔い止め', 22,2,'乗車前');