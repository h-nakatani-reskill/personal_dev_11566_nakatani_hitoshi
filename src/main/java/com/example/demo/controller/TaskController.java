package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.PersonalDev11566NakataniHitoshiApplication;
import com.example.demo.entity.Categories;
import com.example.demo.entity.Task;
import com.example.demo.model.Account;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TaskRepository;

@Controller
public class TaskController {

	private final PersonalDev11566NakataniHitoshiApplication personalDev11566NakataniHitoshiApplication;

	private final CategoryRepository categoryRepository;
	private final Account account;
	private final TaskRepository taskRepository;

	public TaskController(TaskRepository taskRepository, Account account, CategoryRepository categoryRepository,
			PersonalDev11566NakataniHitoshiApplication personalDev11566NakataniHitoshiApplication) {
		this.taskRepository = taskRepository;
		this.account = account;
		this.categoryRepository = categoryRepository;
		this.personalDev11566NakataniHitoshiApplication = personalDev11566NakataniHitoshiApplication;
	}

	// タスク一覧表示
	@GetMapping("/tasks")
	public String index(
			@RequestParam(required = false) Integer categoryId,
			Model model) {

		//		未ログイン時にはエラー制御
		//		if (account.getId() == null) {
		//		    return "redirect:/login";
		//		}

		// categoriesテーブルから全カテゴリーを取得
		List<Categories> categoryList = categoryRepository.findAll();

		model.addAttribute("categories", categoryList);

		// 商品一覧orカテゴリー一覧を取得
		List<Task> taskList = null;

		if (categoryId == null) {
			taskList = taskRepository.findByUserId(account.getId());
		} else {
			taskList = taskRepository.findByUserIdAndCategoryId(account.getId(), categoryId);
		}

		model.addAttribute("tasks", taskList);

		return "tasks";
	}

	// 追加画面表示
	@GetMapping("/tasks/add")
	public String create(Model model) {

		//		未ログイン時にはエラー制御
		//		if (account.getId() == null) {
		//		    return "redirect:/login";
		//		}

		List<Categories> categoryList = categoryRepository.findAll();

		model.addAttribute("categories", categoryList);

		return "addTask";
	}

	// 追加処理
	@PostMapping("/tasks/add")
	public String add(
			@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") Integer userId,
			@RequestParam(defaultValue = "") Integer categoryId,
			@RequestParam(defaultValue = "") String recordDay,
			@RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "") Integer level,
			@RequestParam(defaultValue = "") Integer progress,
			@RequestParam(defaultValue = "") String memo,
			Model model) {

		//		未ログイン時にはエラー制御
		//		if (account.getId() == null) {
		//		    return "redirect:/login";
		//		}

		// エラーチェック
		List<String> errorList = new ArrayList<>();

		if (title.length() == 0) {
			errorList.add("種類は必須です");
		}
		if (recordDay.length() == 1) {
			errorList.add("登録日は必須です");
		}
		if (level == 0 || level == null) {
			errorList.add("残量は必須です");
		}
		if (progress == 0 || progress == null) {
			errorList.add("服用量は必須です");
		}

		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			model.addAttribute(title);
			model.addAttribute(recordDay);
			model.addAttribute(memo);
			return "addTask";
		}

		// categoriesテーブルから全カテゴリーを取得

		Calendar cl = Calendar.getInstance();

		//日付をyyyy/MM/ddの形で出力する
		SimpleDateFormat today = new SimpleDateFormat("yyyy/MM/dd");
		String recordToday = today.format(cl.getTime());

		Task task = new Task(id, categoryId, recordToday, title, level, progress, memo);

		// アカウントIDとユーザーIDを紐づける
		task.setUserId(account.getId());

		taskRepository.save(task);

		return "redirect:/tasks";
	}

	// 更新画面表示
	@GetMapping("/tasks/{id}/edit")
	public String edit(@PathVariable Integer id, Model model) {

		//		未ログイン時にはエラー制御
		//		if (account.getId() == null) {
		//		    return "redirect:/login";
		//		}

		Task task = taskRepository.findById(id).get();
		model.addAttribute("task", task);

		return "editTask";
	}

	// 更新処理
	@PostMapping("/tasks/{id}/edit")
	public String update(
			@PathVariable Integer id,
			@RequestParam(required = false) Integer categoryId,
			@RequestParam(defaultValue = "") String recordDay,
			@RequestParam(defaultValue = "") String title,
			@RequestParam(required = false) Integer level,
			@RequestParam(required = false) Integer progress,
			@RequestParam(defaultValue = "") String memo,
			Model model) {

		//		未ログイン時にはエラー制御
		//		if (account.getId() == null) {
		//		    return "redirect:/login";
		//		}

		// categoriesテーブルから全カテゴリーを取得
		List<Categories> categoryList = categoryRepository.findAll();

		model.addAttribute("categories", categoryList);

		Task task = taskRepository.findById(id).get();

		task.setCategoryId(categoryId);
		task.setRecordDay(recordDay);
		task.setTitle(title);
		task.setLevel(level);
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

	@PostMapping("/tasks/{id}/done")
	public String update(
			@PathVariable Integer id,
			@RequestParam(required = false) Integer level,
			@RequestParam(required = false) Integer progress,
			@RequestParam(required = false) Integer done,
			Model model) {

		//			未ログイン時にはエラー制御
		//			if (account.getId() == null) {
		//			    return "redirect:/login";
		//			}

		Task task = taskRepository.findById(id).get();

		task.setProgress(progress);

		Integer medicinelevel = task.getLevel();

		Integer medicineProgress = task.getProgress();

		done = medicinelevel - medicineProgress;

		Task doneTask = new Task(id, progress, done);

		taskRepository.save(doneTask);

		return "redirect:/tasks";
	}
}
