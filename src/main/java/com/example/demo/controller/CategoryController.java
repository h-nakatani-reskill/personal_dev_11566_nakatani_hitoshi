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
	@GetMapping("/category")
	public String index(Model model) {

		List<Categories> categoryList = categoryRepository.findAll();

		model.addAttribute("categories", categoryList);

		return "category";
	}

	// 追加画面表示
	@GetMapping("/category/add")
	public String create() {
		return "categoryAdd";
	}

	// 追加処理
	@PostMapping("/category/add")
	public String add(
			@RequestParam(defaultValue = "") Integer id,
			@RequestParam(defaultValue = "") String name) {

		Categories categories = new Categories(id, name);

		categoryRepository.save(categories);

		return "redirect:/category";
	}

	// 変更画面表示
	@GetMapping("/category/{id}/edit")
	public String edit(@PathVariable Integer id, Model model) {

		Categories categories = categoryRepository.findById(id).get();

		model.addAttribute(categories);

		return "categoryEdit";
	}

	// 更新処理
	@PostMapping("/category/{id}/edit")
	public String update(
			@PathVariable Integer id,
			@RequestParam(defaultValue = "") String name) {

		Categories categories = categoryRepository.findById(id).get();

		categories.setName(name);

		categoryRepository.save(categories);

		return "redirect:/categories";
	}

	// 変更処理
	@PostMapping("/category/edit")
	public String update() {
		return "redirect:/category";
	}
}
