package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

	// フィールド
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番
	private Integer id;
	@Column(name = "category_id")
	private Integer categoryId;
	@Column(name = "record_day")
	private String recordDay;
	private String title;
	private Integer progress;
	private String memo;

	// コンストラクタ
	public Task() {
	}

	public Task(Integer id, Integer categoryId, String recordDay, String title, String memo) {
		this.id = id;
		this.categoryId = categoryId;
		this.recordDay = recordDay;
		this.title = title;
		this.memo = memo;
	}

	public Task(Integer id, Integer categoryId, String recordDay, String title, Integer progress, String memo) {
		this.id = id;
		this.categoryId = categoryId;
		this.recordDay = recordDay;
		this.title = title;
		this.progress = progress;
		this.memo = memo;
	}

	// ゲッターセッター
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getRecordDay() {
		return recordDay;
	}

	public void setRecordDay(String recordDay) {
		this.recordDay = recordDay;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
