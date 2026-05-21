package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "progresses")
public class Progresses {

	// フィールド
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番
	private Integer id;
	private String name;

	// コンストラクタ
	public Progresses() {
	}

	public Progresses(String name) {
		this(null, name);
	}

	public Progresses(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	// ゲッターセッター
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
