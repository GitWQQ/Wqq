package org.ssm.dufy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.dufy.dao.GoodsDao;
import org.ssm.dufy.service.GoodsService;

@Service
public class GoodsServiceImpl  implements GoodsService{

	@Autowired
	private GoodsDao goodsDao;
	
	public List getAllRecord(Map<String,Object> paramMap){
		return goodsDao.getAllRecord(paramMap);
	}
}
