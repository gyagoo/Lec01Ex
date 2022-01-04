package com.gyagoo.ex.lec05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Lec05Controller {
	
	@GetMapping("/lec05/ex01")
	public String ex01() {
		return "lec05/ex01";
	}
}
