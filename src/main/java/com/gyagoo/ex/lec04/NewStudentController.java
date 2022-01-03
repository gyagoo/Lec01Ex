package com.gyagoo.ex.lec04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gyagoo.ex.lec04.bo.NewStudentBO;
import com.gyagoo.ex.lec04.model.NewStudent;

@Controller
@RequestMapping("/lec04")
public class NewStudentController {

	@Autowired
	private NewStudentBO newStudentBO;
	
	@RequestMapping("/ex02/1")
	public String addStudentView() {
		return "lec04/addStudent";
	}
	
//	@RequestMapping(path="/ex02/add_student", method = RequestMethod.POST) 
	@PostMapping("/ex02/add_student")	// 축약된 버전
	public String addStudent(
			@ModelAttribute NewStudent student
			, Model model) {
		// 객체 request parameter
		// class 이름으로 전달을 받고 전달되는 parameter 와 일치하는 method 에 전달
//		return student.getName() + " " + student.getEmail();
		int count = newStudentBO.addStudent(student);
		
		model.addAttribute("result", student);	// model을 통해 student 안에 있는 값을 갖다 쓸 수 있게 됨
		return "lec04/studentInfo";
	}
}

// 실제 id는 insert 할 때 결정되기 때문에 당장은 비어있는 상태 -> 바로 얻어오는 방법?
