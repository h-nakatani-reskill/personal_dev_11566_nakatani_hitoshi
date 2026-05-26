package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findByCategoryId(Integer categoryId);

	List<Task> findByUserIdOrderByRecordDayAsc(Integer userId);

	List<Task> findByTitleLikeAndRecordDayOrderByRecordDayAsc(String title, String recordDay);

	List<Task> findByTitleLikeOrderByRecordDayAsc(String keyword);

	List<Task> findByRecordDayOrderByRecordDayAsc(String recordDay);

	List<Task> findByUserIdAndCategoryIdOrderByRecordDayAsc(Integer userId, Integer CategoryId);
}
