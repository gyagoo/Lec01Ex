package com.gyagoo.ex.lec04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gyagoo.ex.lec04.model.User;

@Repository
public interface UserDAO {
	// query 와 유사하게 
	public int insertUser(
			@Param("name") String name
			, @Param("yyyymmdd") String yyyymmdd
			, @Param("introduce") String introduce
			, @Param("hobby") String hobby);
	
	public User selectUser(@Param("id") int id);
	
	// lec06
	public int selectCountName(@Param("name") String name);
	/*
	 	중복되는 이름이 '몇 개'인지? -> count
	 */
}
