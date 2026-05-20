package com.example.demo.controller;

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
		// 名前が空の場合はエラーにする
		if (userList == null || userList.size() == 0) {
			model.addAttribute("message", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}

		User user = userList.get(0);

		account.setId(user.getId());
		account.setName(user.getName());

		return "redirect:/tasks";
	}

}
