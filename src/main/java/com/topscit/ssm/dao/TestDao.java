package com.topscit.ssm.dao;

import com.topscit.ssm.bean.TestBean;
import com.topscit.ssm.bean.User;

public interface TestDao {
	
	void setData(String key,String value);

	String getData(String key);
	
	void setBean(TestBean test);
	
	void saveUser(String key,User user);
	
	public User getUser(String key) ;
}
