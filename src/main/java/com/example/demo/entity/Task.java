package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	private Integer task_id;
	private Integer category_id;
	private Date date_now;
	private String name;
	private String title;
	private Date closing_date;
	private Integer progress;
	private String memo;
}
