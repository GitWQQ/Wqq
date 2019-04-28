package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Redis缓存工具类
 * @author 16406
 *
 */

@Service
public class RedisCacheUtil {
		
	@Autowired @Qualifier("jedisTemplate")
	public RedisTemplate redisTemplate;
}
