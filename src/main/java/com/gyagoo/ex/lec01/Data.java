package com.gyagoo.ex.lec01;

import org.springframework.web.bind.annotation.RequestMapping;

public class Data {
	private int id;
	private String name;
	
	// 속성에 해당하는 getter, setter 모두 생성
	// 멤버 변수를 전달하는 과정을 위해 무조건 필요 ! 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
