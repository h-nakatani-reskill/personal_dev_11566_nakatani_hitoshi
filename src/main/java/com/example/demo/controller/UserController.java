package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	private final HttpSession session;
	private final Account account;
	private final UserRepository userRepository;

	public UserController(
			HttpSession session,
			Account account,
			UserRepository userRepository) {
		this.session = session;
		this.account = account;
		this.userRepository = userRepository;
	}

	// ログイン画面表示
	@GetMapping({ "/", "/login", "/logout" })
	public String index() {
		session.invalidate();
		return "login";
	}

	// ログイン実行
	@PostMapping("/login")
	public String login(
			@RequestParam String email,
			@RequestParam String password,
			Model model) {

		// 名前が空の場合はエラーにする
		if (email.length() == 0 || password.length() == 0) {
			model.addAttribute("message", "入力してください");
			return "login";
		}

		List<User> userList = userRepository.findByEmailAndPassword(email, password);
		// メールアドレスとパスワードが一致していないとエラーにする
		if (userList == null || userList.size() == 0) {
			model.addAttribute("message", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}

		User user = userList.get(0);

		// セッション管理されたアカウントに情報をセット
		account.setId(user.getId());
		account.setName(user.getName());

		return "redirect:/tasks";
	}

	//  会員登録画面の表示
	@GetMapping("/account")
	public String adduser() {
		return "addUser";
	}

	// 登録ボタン押した際の処理
	@PostMapping("/account")
	public String storeuser(
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String email,
			@RequestParam(defaultValue = "") String password,
			Model model) {

		// エラーチェック
		List<String> errorList = new ArrayList<>();
		if (name.length() == 0) {
			errorList.add("名前は必須です");
		}
		if (email.length() == 0) {
			errorList.add("メールアドレスは必須です");
		}

		List<User> userList = userRepository.findByEmail(email);

		if (userList != null && userList.size() > 0) {
			errorList.add("登録済みのメールアドレスです");
		}

		if (password.length() == 0) {
			errorList.add("パスワードは必須です");
		}

		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			model.addAttribute(name);
			model.addAttribute(email);
			return "addUser";
		}

		User user = new User(name, email, password);

		userRepository.save(user);

		return "redirect:/";
	}
}
