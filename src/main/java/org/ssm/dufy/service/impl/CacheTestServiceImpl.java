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
		System.out.println("�û����ݳ�ʼ��....��ʼ");
		usersData.put("2", "����");
		usersData.put("3", "�ҵĲ��ͣ�http://blog.csdn.net/jadyer");
		System.out.println("�û����ݳ�ʼ��..���");
		
	}
	
	@Cacheable(value="sysCache",key="'get'+#userNo")
	public String get(String userNo){
		System.out.println("���ݿ��в鵽���û���[" + userNo + "]��Ӧ���û���Ϊ[" + usersData.get(userNo) + "]");
		return usersData.get(userNo);
	}
	
	@CacheEvict(value="sysCache", key="'get'+#userNo")
	public void update(String userNo){
		System.out.println("�Ƴ������д��û���[" + userNo + "]��Ӧ���û���[" + usersData.get(userNo) + "]�Ļ���");
	}
	
	//allEntriesΪtrue��ʾ���value�е�ȫ������,Ĭ��Ϊfalse
	@CacheEvict(value="myCache", allEntries=true)
	public void removeAll(){
		System.out.println("�Ƴ������е���������");
	}
}
