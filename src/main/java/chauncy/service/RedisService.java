package chauncy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**   
 * @classDesc: 功能描述(redis demo)  
 * @author: ChauncyWang
 * @createTime: 2019年6月27日 下午4:05:47   
 * @version: 1.0  
 */  
@Service
public class RedisService {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	public void setString(String key,String value){
		set(key,value,null);
	}
	
	public void setString(String key,String value,Long timeout){
		set(key,value,timeout);
	}
	
	public void set(String key,Object obj,Long timeout){
		if(obj == null){
			return;
		}
		if(obj instanceof String){
			String value=(String) obj;
			stringRedisTemplate.opsForValue().set(key, value);
			if(timeout != null)
				//设置key的有效时间
				stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
		}
	}
	
	public Object getString(String key){
		return stringRedisTemplate.opsForValue().get(key);
	}
}
