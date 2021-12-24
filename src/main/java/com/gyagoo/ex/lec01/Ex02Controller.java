package com.gyagoo.ex.lec01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	@RequestMapping("/lec01/ex02/01")
	public String view() {
		// jsp 아래부터의 경로
		return "lec01/ex02";
	}
}
