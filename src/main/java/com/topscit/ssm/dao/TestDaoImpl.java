package com.topscit.ssm.dao;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import com.topscit.ssm.bean.TestBean;
import com.topscit.ssm.bean.User;


@Repository("testDao")
public class TestDaoImpl implements TestDao{
	
/*	@Resource
	private RedisTemplate<String, String> rt;

	@Override
	public void setData(String key, String value) {
		System.out.println("-=======");
		ValueOperations<String, String> opsForValue = rt.opsForValue();
		opsForValue.set(key, value);
	}

	@Override
	public String getData(String key) {
		ValueOperations<String, String> opsForValue = rt.opsForValue();
		return opsForValue.get(key);
	}*/

	
	//当配置为JdkSerializationRedisSerializer这个序列化对象，
	//则只要对象声明了可序列化，则都可以自动被序列化存到redis
	
	@Resource
	private RedisTemplate<String, Object> rt;
	
	@Override
	public void setBean(TestBean test) {
		
//		ListOperations<String, Object> opsForList = rt.opsForList();
//		ZSetOperations<String, Object> opsForZSet = rt.opsForZSet();
		
		
		
		ValueOperations<String, Object> opsForValue = rt.opsForValue();
		opsForValue.set("t", test);
		TestBean obj = (TestBean)opsForValue.get("t");
		System.out.println(obj.getName());
	}

	@Override
	public void setData(String key, String value) {
		ValueOperations<String, Object> opsForValue = rt.opsForValue();
		opsForValue.set(key, value);
	}

	@Override
	public String getData(String key) {
		ValueOperations<String, Object> opsForValue = rt.opsForValue();
		return (String)opsForValue.get(key);
	}

	@Override
	public void saveUser(String key, User user) {
		ValueOperations<String, Object> opsForValue = rt.opsForValue();
		opsForValue.set(key, user, 1800, TimeUnit.SECONDS);
	}
	
	@Override
	public User getUser(String key) {
		ValueOperations<String, Object> opsForValue = rt.opsForValue();
		return (User)opsForValue.get(key);
	}
	
	

}
