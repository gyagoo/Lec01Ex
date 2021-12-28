package com.gyagoo.ex.lec02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gyagoo.ex.lec02.bo.ReviewBO;
import com.gyagoo.ex.lec02.model.Review;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	@RequestMapping("/lec03/ex01")
	public Review ex01(
//			@RequestParam("id") int id
			@RequestParam(value="id", required=false, defaultValue="5") int id) {
//			디폴트는 required, 없으면 에러(400)
//			false -> 실행 에러(500)
//			기본 실행 id 파라미터
		
//			, @RequestParam("") 파라미터 추가 가능
		// id 기반을 SELECT 할 것이기 때문에 
		// list 가 아닌 int	
		return reviewBO.getReview(id);
		
	}
	
	// 서로 다른 파일끼리 파라미터를 주고받아야 할 경우
	// annotation 을 사용한다
}
