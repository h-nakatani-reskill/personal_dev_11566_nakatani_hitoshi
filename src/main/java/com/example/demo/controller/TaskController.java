package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

	// 初期ログイン画面表示
	@GetMapping({ "/", "/login", "/logout" })
	public String login() {
		return "login";
	}

	// ログインボタン押した際の処理
	@PostMapping("/tasks/view")
	public String users() {
		return "redirect:/tasks";
	}

	// 新規会員登録画面表示
	@GetMapping("/user/add")
	public String adduser() {
		return "addUser";
	}

	// 登録ボタン押した際の処理
	@PostMapping("/login")
	public String storeuser() {
		return "redirect:/login";
	}

	// タスク一覧表示
	@GetMapping({ "tasks", "/tasks/view" })
	public String index() {
		return "tasks";
	}

	// 追加画面表示
	@GetMapping("/tasks/add")
	public String create() {
		return "addTask";
	}

	// 追加処理
	@PostMapping("/tasks/add")
	public String add() {
		return "tasks";
	}

	// 変更画面表示
	@GetMapping("/tasks/edit")
	public String edit() {
		return "editTasks";
	}

	// 変更処理
	@PostMapping("/tasks/edit")
	public String update() {
		return "tasks";
	}

	// 削除処理
	@PostMapping("/tasks/delete")
	public String delete() {
		return "redirect:/tasks";
	}
}
