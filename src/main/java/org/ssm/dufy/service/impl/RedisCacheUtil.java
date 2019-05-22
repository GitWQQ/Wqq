package org.ssm.dufy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Redis���湤��
 * @author 16406
 *
 */

@Component
public class RedisCacheUtil<T> {

	@SuppressWarnings("rawtypes")
	@Autowired
	public RedisTemplate redisTemplate;
	
	public void setRedisTemplate(RedisTemplate<String,Object> redisTemplate){
		this.redisTemplate=redisTemplate;
	}
	
	/**
	 * �����������Integer,String,ʵ�����
	 * @param key ����ļ�ֵ
	 * @param value �����ֵ
	 * @return ����Ķ���
	 */
	public <T> ValueOperations<String,T> setCacheObject(String key,T value){
	 	ValueOperations<String,T> operation=redisTemplate.opsForValue();
	 	operation.set(key, value);
	 	operation.append(key,"wang11111");
	 	return operation;
	}
	
	public void setIncrCacheObject(String key,Integer value){
		ValueOperations<String,T> operation=redisTemplate.opsForValue();
		operation.increment(key,value);
	}
	
	@SuppressWarnings("unchecked")
	public <T>  ValueOperations<String,T> setAppendCacheObject(String key,String value){
		ValueOperations<String,T> operation=redisTemplate.opsForValue();
		operation.append(key,value);
		return operation;
	}
	
	/**
	 * ��ȡ����Ļ�������
	 * @param key ����ļ�
	 * @return ����Ķ���
	 */
	public <T> T getCacheObject(String key){
		ValueOperations<String,T> operation=redisTemplate.opsForValue();
		return operation.get(key);
	}
	
	/**
	 * ����list����
	 * @param key ����ļ�
	 * @param dataList �������list����
	 * @return ����Ķ���
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> ListOperations<String,T> setCacheList(String key,List<T> dataList){
		ListOperations listOperation=redisTemplate.opsForList();
		if(null !=dataList){
			int size=dataList.size();
			for(int i=0;i<size;i++){
				listOperation.rightPush(key, dataList.get(i));
			}
		}
		return listOperation;
	}
	
	
	/**
	 * ��ȡ����List����
	 * 
	 * @param key
	 * @return
	 */
	public <T> List<T> getCacheList(String key){
		List<T> dataList=new ArrayList<T>();
		ListOperations<String,T> listOperation=redisTemplate.opsForList();
		Long size=listOperation.size(key);
		for(int i=0;i<size;i++){
			dataList.add((T)listOperation.leftPop(key));
		}
		
		return dataList;
	}
	
	/**
     * ����Set
     * @param key        �����ֵ
     * @param dataSet    ���������
     * @return            �������ݵĶ���
     */
	@SuppressWarnings("unchecked")
	public <T> BoundSetOperations<String,T> setCacheSet(String key,Set<T> dataSet){
		BoundSetOperations<String,T> setOperation = redisTemplate.boundSetOps(key); 
		Iterator<T> it = dataSet.iterator();
        while(it.hasNext())
        {
            setOperation.add(it.next());
        }
        
        return setOperation;
	}
	
	/**
	 * ��ȡ����set
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Set<T> getCacheSet(String key){
		Set<T> dataSet=new HashSet<>();
		BoundSetOperations<String,T> operation=redisTemplate.boundSetOps(key);
		Long size=operation.size();
		for(int i=0;i<size;i++){
			dataSet.add(operation.pop());
		}
		return dataSet;
	}
	
	/**
	 * ����map
	 * @param key
	 * @param dataMap
	 * @return
	 */
	
	public <T> HashOperations<String,String,T> setCacheMap(String key,Map<String,T> dataMap){
		HashOperations<String,String,T> hashOperation=redisTemplate.opsForHash();
		if(dataMap!=null){
			for (Map.Entry<String,T> entry : dataMap.entrySet()) {
				hashOperation.put(key,entry.getKey(),entry.getValue());
			}
		}
		return hashOperation;
		
		
	}
	
	/**
	 * ��ȡ����map
	 * @param args
	 */
	
	public Map<String,T> getCacheMap(String key){
		Map<String,T> resultMap=redisTemplate.opsForHash().entries(key);
		return resultMap;
	}
	
	/**
	 * ����Map
	 * 
	 * @param args
	 */
	public <T> HashOperations<String,Integer,T> setCacheIntegerMap(String key,Map<Integer,T> dataMap){
		HashOperations hashOperations=redisTemplate.opsForHash();
		if(null !=dataMap){
			for (Map.Entry<Integer,T> entry : dataMap.entrySet()) {
				hashOperations.put(key,entry.getKey(),entry.getValue());
			}
		}
		return hashOperations;
	}
	
	/**
	 * ��ȡmap
	 * @param key
	 * @return
	 */
	public <T> Map<Integer,T> getCacheIntegerMap(String key){
		Map<Integer,T> map=redisTemplate.opsForHash().entries(key);
		return map;
	}
	
	
	public static void main(String[] args) {
		Map<String,Object> map=new HashMap<>();
		map.put("0001","��̖1");
		map.put("0002","��̖2");
		map.put("0003","��̖3");
		map.put("0004","��̖4");
		
		for (Map.Entry<String,Object> entry :map.entrySet()) {
			System.out.println("entry:"+entry);
			System.out.println("key:"+entry.getKey()+"| value:"+entry.getValue());
		}
		
	}
}
