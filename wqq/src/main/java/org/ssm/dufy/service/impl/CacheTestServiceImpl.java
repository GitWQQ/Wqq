package org.ssm.dufy.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheTestServiceImpl {
	
	private Map<String, String> usersData = new ConcurrentHashMap<String, String>();
	
	Map<String,String> uuu=new ConcurrentHashMap<>();
	public CacheTestServiceImpl() {
		System.out.println("用户数据初始化....开始");
		usersData.put("2", "玄玉");
		usersData.put("3", "我的博客：http://blog.csdn.net/jadyer");
		System.out.println("用户数据初始化..完毕");
		
	}
	
	@Cacheable(value="sysCache",key="'get'+#userNo")
	public String get(String userNo){
		System.out.println("数据库中查到此用户号[" + userNo + "]对应的用户名为[" + usersData.get(userNo) + "]");
		return usersData.get(userNo);
	}
	
	@CacheEvict(value="sysCache", key="'get'+#userNo")
	public void update(String userNo){
		System.out.println("移除缓存中此用户号[" + userNo + "]对应的用户名[" + usersData.get(userNo) + "]的缓存");
	}
	
	//allEntries为true表示清除value中的全部缓存,默认为false
	@CacheEvict(value="myCache", allEntries=true)
	public void removeAll(){
		System.out.println("移除缓存中的所有数据");
	}
}
