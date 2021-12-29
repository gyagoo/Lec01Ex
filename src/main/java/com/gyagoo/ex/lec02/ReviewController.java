package com.gyagoo.ex.lec02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gyagoo.ex.lec02.bo.ReviewBO;
import com.gyagoo.ex.lec02.model.Review;

@RestController
@RequestMapping("/lec03")
public class ReviewController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	@RequestMapping("/ex01")
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
	
	// 211229 INSERT -> 두 가지 방법
	@RequestMapping("/ex02")
	public String ex02() {
		// 4, "오모기리김치찌개", "김바다", 4.5, "한국인의 맛"
//		int count = reviewBO.addReview(4, "오모가리김치찌개", "김바다", 4.5, "한국인의 맛");
		// 문자열 리턴
		
		Review review = new Review();
		review.setStoreId(4);
		review.setMenu("오모가리김치찌개");
		review.setUserName("김바다");
		review.setPoint(4.5);
		review.setReview("할머니의 손 맛");

		int count = reviewBO.addReviewAsObject(review);
		
		return "입력 결과 :: " + count;
	}
	// 객체 형태로 보여주는 방법
	
}
