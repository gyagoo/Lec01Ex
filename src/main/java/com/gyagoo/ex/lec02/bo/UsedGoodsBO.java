package com.gyagoo.ex.lec02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyagoo.ex.lec02.dao.UsedGoodsDAO;
import com.gyagoo.ex.lec02.model.UsedGoods;

@Service
public class UsedGoodsBO {
	
	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
	
	public List<UsedGoods> getUsedGoodsList() {
		// 필요한 query 를 가져와서 조작하고 정리해서 return 하는 역할
		// 역시 데이터를 가져와야 함 -> 팩키지 생성
//		UsedGoodsDAO usedGoodsDAO = new UsedGoodsDAO(); -> 잘못된 spring 객체 관리법
		// 객체 관리를 사용자가 아닌 spring 에서 담당 (@Autowired)
		
		// 추가 및 수정에 필요한 코드를 이 부분에 작성해서 return 
		return usedGoodsDAO.selectUsedGoodsList();	// 객체 생성 없이 메소드 호출 가능
	}
}
