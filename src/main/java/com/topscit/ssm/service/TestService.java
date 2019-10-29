package com.topscit.ssm.service;

import com.topscit.ssm.bean.TestBean;
import com.topscit.ssm.bean.User;

public interface TestService {
	
	void setData(String key,String value);

	String getData(String key);
	
	void setBean(TestBean test);
	
	void saveUser(String key,User user);
	
	public User getUser(String key);
}
