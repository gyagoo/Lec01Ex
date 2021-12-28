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
}
