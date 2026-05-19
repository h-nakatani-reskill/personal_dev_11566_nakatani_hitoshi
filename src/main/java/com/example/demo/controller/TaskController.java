package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

	@GetMapping("/tasks")
	public String index() {
		return "tasks";
	}

	@GetMapping("/tasks/add")
	public String create() {
		return "addTask";
	}

	@PostMapping("/tasks/add")
	public String add() {
		return "tasks";
	}

	@GetMapping("/tasks/edit")
	public String edit() {
		return "editTasks";
	}

	@PostMapping("/tasks/edit")
	public String update() {
		return "tasks";
	}

	@PostMapping("/tasks/delete")
	public String delete() {
		return "redirect:/tasks";
	}
}
