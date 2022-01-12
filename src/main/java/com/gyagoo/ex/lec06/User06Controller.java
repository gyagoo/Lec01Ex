package com.gyagoo.ex.lec06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gyagoo.ex.lec04.bo.UserBO;

@Controller
public class User06Controller {

	@Autowired
	private UserBO userBO;	// lec04 > bo > UserBO
	
	@GetMapping("/lec06/ex01/add_user_view")
	public String ex01() {
		return "lec06/addUser";
	}
	
	@ResponseBody
	@PostMapping("/lec06/ex01/add_user")
	public String ex02(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("introduce") String introduce,
			@RequestParam("hobby") String hobby) {
		int count = userBO.addUser(name, yyyymmdd, introduce, hobby);	// 파라미터 일치 확인
		
//		return "삽입 성공 : " + count;
		if(count == 1) {
			return "success";
		} else { 
			return "fail";
		}
		/*
		 	입력할 내용이 아직 없는 경우 이런 방식으로 규격화 해놓는 것이 좋다 ! ! !
		 	
		 	요청의 결과를 순수한 데이터 형태로 돌려주는 것 = API
		 	API 개념, API와 ajax 
		  	controller를 여기에서 사용할 수 있다
		 */
		
	}
	
	@ResponseBody
	@GetMapping("/lec06/ex02/duplicate_name")
	public Map<String, String> duplicateName(@RequestParam("name") String name) {
		Map<String, String> result = new HashMap<>();
		
		if (userBO.isDuplicate(name) == true) {
			result.put("isDuplicate", "true");
		} else {
			result.put("isDuplicate", "false");
		}
		
		return result;
	}
}
