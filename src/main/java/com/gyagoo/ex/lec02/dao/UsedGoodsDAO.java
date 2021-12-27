package com.gyagoo.ex.lec02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gyagoo.ex.lec02.model.UsedGoods;

@Repository
public interface UsedGoodsDAO {
	// sql 데이터와 직접적으로 연결되는 부분
	// 이 class 에 조회한 데이터를 가져가서 사용할 메소드가 필요
	public List<UsedGoods> selectUsedGoodsList();
}
