package com.gyagoo.ex.lec02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyagoo.ex.lec02.bo.UsedGoodsBO;
import com.gyagoo.ex.lec02.model.UsedGoods;

@RestController
public class UsedGoodsRestController {
	//BO를 통해 DB 조회
	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	@RequestMapping("/lec02/ex01")
	public List<UsedGoods> ex01( ) {
		// 리스트 안에 들어갈 내용은 class 로 새로 만들 것
		// 팩키지 안에 모델 class 로 저장
		
		return usedGoodsBO.getUsedGoodsList();
	}
}
