package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
	// カテゴリー一覧表示
	@GetMapping("/category")
	public String showCategory() {
		return "category";
	}

	// 追加画面表示
	@GetMapping("/category/add")
	public String create() {
		return "categoryAdd";
	}

	// 追加処理
	@PostMapping("/category/add")
	public String add() {
		return "redirect:/category";
	}

	// 変更画面表示
	@GetMapping("/category/edit")
	public String edit() {
		return "categoryEdit";
	}

	// 変更処理
	@PostMapping("/category/edit")
	public String update() {
		return "redirect:/category";
	}
}
