package com.topscit.ssm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.topscit.ssm.bean.TestBean;
import com.topscit.ssm.bean.User;
import com.topscit.ssm.dao.TestDao;

@Service("testService")
public class TestServiceImpl implements TestService{
	
	@Resource
	private TestDao testDao;

	@Override
	public void setData(String key, String value) {
		System.out.println("-----");
		testDao.setData(key, value);
	}

	@Override
	public String getData(String key) {
		return testDao.getData(key);
	}

	@Override
	public void setBean(TestBean test) {
		testDao.setBean(test);
	}

	@Override
	public void saveUser(String key, User user) {
		testDao.saveUser(key, user);
	}

	@Override
	public User getUser(String key) {
		// TODO Auto-generated method stub
		return testDao.getUser(key);
	}
	
	

}
