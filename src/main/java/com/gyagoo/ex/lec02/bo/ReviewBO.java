package com.gyagoo.ex.lec02.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyagoo.ex.lec02.dao.ReviewDAO;
import com.gyagoo.ex.lec02.model.Review;

@Service
public class ReviewBO {
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) {
		// 원하는 id 를 parameter 로 넘길 것
		return reviewDAO.selectReview(id);
	}
	// return 실행된 행의 갯수 -> xml 파일에 추가는 필요 없음
	public int addReview(int storeId, String menu, String userName, double point, String review) {
		return reviewDAO.insertReview(storeId, menu, userName, point, review);
	}
	
	// 하나하나 나열하는 것이 아니라 객체로 전달
	public int addReviewAsObject(Review review) {
		return reviewDAO.insertReviewAsObject(review);
	}
	
}
