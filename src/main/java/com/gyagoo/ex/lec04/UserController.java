package com.gyagoo.ex.lec04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping("/lec04/ex01/1")
	public String addUserView() {
		// JSP 파일 return 
		return "lec04/addUser";
	}
	
	@ResponseBody
	@RequestMapping("/lec04/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name
			, @RequestParam("yyyymmdd") String yyyymmdd
			, @RequestParam("introduce") String introduce
			, @RequestParam("hobby") String hobby) {
		return "이름 : " + name + "<br>생년월일 : " + yyyymmdd + "<br>자기소개 : " + introduce + "<br>취미 : " + hobby;
	}
}
