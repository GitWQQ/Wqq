package org.ssm.dufy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.ssm.dufy.dao.DemoDao;
import org.ssm.dufy.entity.Goods;
import org.ssm.dufy.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    private DemoDao demoDao;
    
    @Override
    @Cacheable(value="sysCache",key="'queryby'+#id")
    public List queryAllRecord(String id) {
        List result=demoDao.queryAllRecord(Integer.valueOf(id));
        return result;
    }

	@Override
	public void updatePrice(Integer id,Integer price) {
		Goods goods=new Goods();
		if(id !=null && !"".equals(id) && price !=null && !"".equals(price)){
			goods.setId(id);
			goods.setPrice(price);
			goods.setPrice(price-50);
			demoDao.updatePrice(goods);
		
			goods.setId(2);
			goods.setPrice(price+50);
			demoDao.updatePrice(goods);
			
		}
	}

}