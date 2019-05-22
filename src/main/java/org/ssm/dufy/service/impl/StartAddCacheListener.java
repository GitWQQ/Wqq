package org.ssm.dufy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.ssm.dufy.entity.UserInfo;


/**
 * ��������������Ŀ������ʱ���ʼ����Ϣ
 * @author 16406
 *
 */
@Service
public class StartAddCacheListener implements ApplicationListener<ContextRefreshedEvent>{
	
	//��־����
	private final Logger log=Logger.getLogger(StartAddCacheListener.class);
	
	@Autowired
	private RedisCacheUtil<Object> redisCache;
	
	//@Autowired
	//private BrandStoreService brandStoreService;
	
 	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")){
			//Spring������ʱ�򻺴���к͹�����Ϣ
			System.err.println("=========================================");
			System.err.println("=========Spring�����ˣ���ʱ�򻺴�һЩ������========");
			System.err.println("====================");
			System.out.println("����������ݣ�");
			redisCache.setCacheObject("A_Key","BBBBB");
			redisCache.setAppendCacheObject("A_Key","wang");
			System.out.println("����ɹ���");
			System.out.println("ȡ�����������:");
			String result=redisCache.getCacheObject("A_Key");
			System.out.println("result:"+result);
			System.err.println("====================");
			System.out.println("����ʵ������");
			UserInfo userInfo=new UserInfo();
			userInfo.setName("Jack.Wang");
			userInfo.setPassword("123456789");
			userInfo.setEmail("1640611853@qq.com");
			userInfo.setYh_id("66666");
			redisCache.setCacheObject(userInfo.getYh_id(),userInfo);
			System.out.println("ȡ������ʵ������"+redisCache.getCacheObject(userInfo.getYh_id()));
			System.err.println("====================");
			System.out.println("����hash����: Map<String,Map<String,Object>>  hash=new HashMap<String,Map<String,Object>>");
			List<UserInfo> listUser=new ArrayList();
			Map<String,UserInfo> userMap=new HashMap<String,UserInfo>();
			UserInfo userInfo2=new UserInfo();
			userInfo2.setYh_id("77777");
			userInfo2.setName("Jack.Chen");
			userInfo2.setEmail("111111111@qq.com");
			userInfo2.setPassword("2222222222222");
			listUser.add(userInfo);
			listUser.add(userInfo2);
			int listUserSize=listUser.size();
			for(int i=0;i<listUserSize;i++){
				userMap.put(listUser.get(i).getYh_id(),listUser.get(i));
			}
			redisCache.setCacheMap("userInfo",userMap);
			System.out.println("ȡ��hash���棺");
			Map<String, Object> hash_result=redisCache.getCacheMap("userInfo");
			for(String key:hash_result.keySet()){
				System.out.println("Key="+key+",Value="+hash_result.get(key));
			}
			System.err.println("=================");
			System.err.println("����List��");
			redisCache.setCacheList("ListUser1",listUser);
			System.out.println("ȡ��List���棺/n"+redisCache.getCacheList("ListUser1"));
			
			System.err.println("=========================================");
			System.err.println("=========================================");
			System.err.println("=========================================");
		}
	}

}
