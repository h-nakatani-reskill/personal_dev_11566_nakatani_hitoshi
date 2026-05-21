package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Task;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TaskRepository;

@Controller
public class TaskController {

	private final CategoryRepository categoryRepository;

	private final TaskRepository taskRepository;

	public TaskController(TaskRepository taskRepository, CategoryRepository categoryRepository) {
		this.taskRepository = taskRepository;
		this.categoryRepository = categoryRepository;
	}

	// タスク一覧表示
	@GetMapping("/tasks")
	public String index(
			@RequestParam(defaultValue = "") Integer categoryId,
			Model model) {

		// categoriesテーブルから全カテゴリーを取得
		List<Categories> categoryList = categoryRepository.findAll();

		model.addAttribute("categories", categoryList);

		// 商品一覧orカテゴリー一覧を取得
		List<Task> taskList = null;

		if (categoryId == null) {
			taskList = taskRepository.findAll();
		} else {
			taskList = taskRepository.findByCategoryId(categoryId);
		}

		model.addAttribute("tasks", taskList);

		return "tasks";
	}

	// 追加画面表示
	@GetMapping("/tasks/add")
	public String create() {
		return "addTask";
	}

	// 追加処理
	@PostMapping("/tasks/add")
	public String add(
			@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") Integer categoryId,
			@RequestParam(defaultValue = "") String recordDay,
			@RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "") Integer progress,
			@RequestParam(defaultValue = "") String memo,
			Model model) {

		// categoriesテーブルから全カテゴリーを取得
		List<Categories> categoryList = categoryRepository.findAll();

		model.addAttribute("categories", categoryList);

		Calendar cl = Calendar.getInstance();

		//日付をyyyy/MM/ddの形で出力する
		SimpleDateFormat today = new SimpleDateFormat("yyyy/MM/dd");
		String recordToday = today.format(cl.getTime());

		Task task = new Task(id, categoryId, recordToday, title, progress, memo);

		taskRepository.save(task);

		return "redirect:/tasks";
	}

	// 更新画面表示
	@GetMapping("/tasks/{id}/edit")
	public String edit(@PathVariable Integer id, Model model) {

		Task task = taskRepository.findById(id).get();
		model.addAttribute("task", task);
		return "editTask";
	}

	// 更新処理
	@PostMapping("/tasks/{id}/edit")
	public String update(
			@PathVariable Integer id,
			@RequestParam(defaultValue = "") Integer categoryId,
			@RequestParam(defaultValue = "") String recordDay,
			@RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "") Integer progress,
			@RequestParam(defaultValue = "") String memo,
			Model model) {

		// categoriesテーブルから全カテゴリーを取得
		List<Categories> categoryList = categoryRepository.findAll();

		model.addAttribute("categories", categoryList);

		Task task = taskRepository.findById(id).get();

		task.setCategoryId(categoryId);
		task.setRecordDay(recordDay);
		task.setTitle(title);
		task.setProgress(progress);
		task.setMemo(memo);

		taskRepository.save(task);

		return "redirect:/tasks";
	}

	// 削除処理
	@PostMapping("/tasks/{id}/delete")
	public String delete(@PathVariable Integer id) {
		// tasksテーブルから削除
		taskRepository.deleteById(id);
		return "redirect:/tasks";
	}
}
