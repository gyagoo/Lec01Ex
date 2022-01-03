package com.gyagoo.ex.lec04.dao;

import org.springframework.stereotype.Repository;

import com.gyagoo.ex.lec04.model.NewStudent;

@Repository
public interface NewStudentDAO {
	public int insertStudent(NewStudent student);	// 객체 형태로 전달
}
