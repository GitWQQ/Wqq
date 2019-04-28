package org.ssm.dufy.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository("shiroDemoDao")
public interface ShiroDemoDao {
	
	public List queryInfoListByParam(Map<String,Object> param); 
	
	public List queryAllInfo();
	
	public int addNewUserInfo(Map param);
	
	public List getAllData();
	
}
