package com.gyagoo.ex.lec04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyagoo.ex.lec04.dao.UserDAO;
import com.gyagoo.ex.lec04.model.User;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	
	public int addUser(String name, String yyyymmdd, String introduce, String hobby) {
		return userDAO.insertUser(name, yyyymmdd, introduce, hobby);
	}
	
	public User getUser(int id) {
		// id 기반 SELECT
		return userDAO.selectUser(id);
	}
	
	// lec06
	public Boolean isDuplicateName(String name) {
		
		int count = userDAO.selectCountName(name);
		if (count == 0) {
			return false;	// 중복 X
		} else {
			return true;	// 중복 O
		}
	}
}
