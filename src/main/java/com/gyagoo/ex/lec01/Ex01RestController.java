package com.gyagoo.ex.lec01;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	// @Controller + @ResponseBody
@RequestMapping("lec01/ex01")
public class Ex01RestController {
	
	@RequestMapping("/3")
	public String printString() {
		return "RestController Test";
	}
	
	@RequestMapping("/4")
	public Data printData() {
		Data data = new Data();
		
		// getter, setter 통해 값 저장
		data.setId(10);
		data.setName("임승화");
		
		return data;
	}
	
	// 컨텐츠와 에러 내용을 동시에 전달
	// data, HttpStatus.INTERNAL_SERVER_ERROR
	@RequestMapping("/5")
	public ResponseEntity<Data> entity() {
		// 감싸서 전달하는 형태
		Data data = new Data();
		data.setId(5);
		data.setName("임승화");
		
		// 객체 생성
		ResponseEntity<Data> entity = new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
