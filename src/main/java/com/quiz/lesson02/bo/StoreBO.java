package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service // spring bean
public class StoreBO {

	@Autowired // DI
	private StoreMapper storeMapper;
	
	// input : X -> Controller에게 요청 받음
	// output : List<Store> -> Controller에게 돌려 준다
	public List<Store> getStoreList() {
		return storeMapper.selectStoreList();
	}
	
} // public class StoreBO