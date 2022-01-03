package com.gyagoo.ex.lec04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyagoo.ex.lec04.dao.NewStudentDAO;
import com.gyagoo.ex.lec04.model.NewStudent;

@Service
public class NewStudentBO {
	@Autowired
	private NewStudentDAO newStudentDAO;
	
	public int addStudent(NewStudent student) {	// 객체 형태로 전달
		return newStudentDAO.insertStudent(student);
	}
}
