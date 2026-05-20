package com.example.demo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;

@Aspect
@Component
public class LoggingAspect {
	private final Account account;

	public LoggingAspect(Account account) {
		this.account = account;
	}

	@Before("execution(* com.example.demo.Controller.*Controller.*)(..))")
	public void log(JoinPoint jp) {
		if (account == null || account.getName() == null
				|| account.getName().length() == 0) {
			System.out.print("ゲスト：");
		} else {
			System.out.print(account.getName() + "：");
		}
		System.out.println(jp.getSignature().toShortString());
	}
}
