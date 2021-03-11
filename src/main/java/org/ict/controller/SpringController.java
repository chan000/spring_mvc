package org.ict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/spring/*")
public class SpringController {
	
	@RequestMapping("")
	public void base() {
		
		System.out.println("기본 url로 접속했습니다.");
	}
	
}
