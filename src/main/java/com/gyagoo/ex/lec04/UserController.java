package com.gyagoo.ex.lec04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gyagoo.ex.lec04.bo.UserBO;
import com.gyagoo.ex.lec04.model.User;

@Controller
@RequestMapping("/lec04")
public class UserController {
	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/ex01/1")
	public String addUserView() {
		// JSP 파일 return 
		return "lec04/addUser";
	}
	
	@ResponseBody
	@RequestMapping("/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name
			, @RequestParam("yyyymmdd") String yyyymmdd
			, @RequestParam("introduce") String introduce
			, @RequestParam("hobby") String hobby) {
		
		int count = userBO.addUser(name, yyyymmdd, introduce, hobby);
		
		return "입력 성공 : " + count;
	}
//	SELECT
	@RequestMapping("/ex01/2")
	public String getUser(Model model) {
		User user = userBO.getUser(12);
		model.addAttribute("result", user); // key 이름으로 user에서 값을 꺼내서 저장 
		model.addAttribute("subject", "회원정보"); 
		
		return "lec04/userInfo";
	}
	// 컨버터가 query 들을 json 형태로 사용자에게 보여준다
	// json ResponseBody 없이 경로 return 
}
