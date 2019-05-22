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
 * Redis缓存工具
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
	 * 缓存基本对象，Integer,String,实体类等
	 * @param key 缓存的键值
	 * @param value 缓存的值
	 * @return 缓存的对象
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
	 * 获取缓存的基本对象
	 * @param key 缓存的键
	 * @return 缓存的对象
	 */
	public <T> T getCacheObject(String key){
		ValueOperations<String,T> operation=redisTemplate.opsForValue();
		return operation.get(key);
	}
	
	/**
	 * 缓存list数据
	 * @param key 缓存的键
	 * @param dataList 待缓存的list数据
	 * @return 缓存的对象
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
	 * 获取缓存List对象
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
     * 缓存Set
     * @param key        缓存键值
     * @param dataSet    缓存的数据
     * @return            缓存数据的对象
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
	 * 获取缓存set
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
	 * 缓存map
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
	 * 获取缓存map
	 * @param args
	 */
	
	public Map<String,T> getCacheMap(String key){
		Map<String,T> resultMap=redisTemplate.opsForHash().entries(key);
		return resultMap;
	}
	
	/**
	 * 缓存Map
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
	 * 获取map
	 * @param key
	 * @return
	 */
	public <T> Map<Integer,T> getCacheIntegerMap(String key){
		Map<Integer,T> map=redisTemplate.opsForHash().entries(key);
		return map;
	}
	
	
	public static void main(String[] args) {
		Map<String,Object> map=new HashMap<>();
		map.put("0001","編號1");
		map.put("0002","編號2");
		map.put("0003","編號3");
		map.put("0004","編號4");
		
		for (Map.Entry<String,Object> entry :map.entrySet()) {
			System.out.println("entry:"+entry);
			System.out.println("key:"+entry.getKey()+"| value:"+entry.getValue());
		}
		
	}
}
