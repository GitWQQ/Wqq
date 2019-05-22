package org.ssm.dufy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.ssm.dufy.dao.PcdDao;
import org.ssm.dufy.service.PcdService;

@Service
public class PcdServiceImpl implements PcdService {

	@Autowired
	private PcdDao pcdDao;
	/**
	 * Cacheable注解负责将方法的返回值加入到缓存中
	 * CacheEvict注解负责清除缓存，它的三个参数与@Cacheable的意思是一样的
	 * 
	 * 	-- value : 缓存位置的名称，不能为空，
	 * 		若使用EHCache则值为ehcache.xml中的<cache name="sysCache">
	 *  -- key：缓存的key，默认为空（表示使用方法的参数类型及参数值作为key）,支持SpEL
	 *  -- condition: 只有满足条件的情况才会加入缓存。默认为空（表示全部都加入缓存），
	 *  				支持SpEL
	 *  
	 */
	@Cacheable(value="sysCache",key="'queryByParam'")
	@Override
	public List queryByParam(Map paramMap) {
		List resultList=pcdDao.queryByParam(paramMap);
		return resultList;
	}

}
