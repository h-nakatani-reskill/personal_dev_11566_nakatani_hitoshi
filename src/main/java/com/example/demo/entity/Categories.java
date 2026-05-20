package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Categories {

	// フィールド
	@Id // 主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番
	private Integer id;
	private String name;

	// コンストラクタ
	public Categories() {
	}

	public Categories(String name) {
		this(null, name);
	}

	public Categories(Integer id, String name) {
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
