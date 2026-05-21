package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Categories;
import com.example.demo.repository.CategoryRepository;

@Controller
public class CategoryController {

	public CategoryRepository categoryRepository;

	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	// カテゴリー一覧表示
	@GetMapping("/categories")
	public String index(Model model) {

		List<Categories> categoryList = categoryRepository.findAll();

		model.addAttribute("categories", categoryList);

		return "categories";
	}

	// 追加画面表示
	@GetMapping("/categories/add")
	public String create() {
		return "addCategory";
	}

	// 追加処理
	@PostMapping("/categories/add")
	public String add(
			@RequestParam(defaultValue = "") String name) {

		Categories category = new Categories(name);

		categoryRepository.save(category);

		return "redirect:/categories";
	}

	// 更新画面表示
	@GetMapping("/categories/{id}/edit")
	public String edit(@PathVariable Integer id, Model model) {

		// categoriesテーブルから全カテゴリーを取得
		List<Categories> categoryList = categoryRepository.findAll();

		model.addAttribute("categories", categoryList);

		Categories category = categoryRepository.findById(id).get();

		model.addAttribute("category", category);

		return "editCategory";
	}

	// 更新処理
	@PostMapping("/categories/{id}/edit")
	public String update(
			@PathVariable Integer id,
			@RequestParam(defaultValue = "") String name,
			Model model) {

		// categoriesテーブルから全カテゴリーを取得
		List<Categories> categoryList = categoryRepository.findAll();

		model.addAttribute("categories", categoryList);

		Categories category = categoryRepository.findById(id).get();

		category.setName(name);

		categoryRepository.save(category);

		return "redirect:/categories";
	}

	// 削除処理
	@PostMapping("/categories/{id}/delete")
	public String delete(@PathVariable Integer id) {
		// tasksテーブルから削除
		categoryRepository.deleteById(id);
		return "redirect:/categories";
	}
}
