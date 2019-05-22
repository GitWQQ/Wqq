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
	 * Cacheableע�⸺�𽫷����ķ���ֵ���뵽������
	 * CacheEvictע�⸺��������棬��������������@Cacheable����˼��һ����
	 * 
	 * 	-- value : ����λ�õ����ƣ�����Ϊ�գ�
	 * 		��ʹ��EHCache��ֵΪehcache.xml�е�<cache name="sysCache">
	 *  -- key�������key��Ĭ��Ϊ�գ���ʾʹ�÷����Ĳ������ͼ�����ֵ��Ϊkey��,֧��SpEL
	 *  -- condition: ֻ����������������Ż���뻺�档Ĭ��Ϊ�գ���ʾȫ�������뻺�棩��
	 *  				֧��SpEL
	 *  
	 */
	@Cacheable(value="sysCache",key="'queryByParam'")
	@Override
	public List queryByParam(Map paramMap) {
		List resultList=pcdDao.queryByParam(paramMap);
		return resultList;
	}

}
