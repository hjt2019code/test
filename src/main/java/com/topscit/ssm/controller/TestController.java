package com.topscit.ssm.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topscit.ssm.bean.TestBean;
import com.topscit.ssm.service.TestService;

@Controller
public class TestController {
	
	@Resource
	private TestService testService;
	
	@RequestMapping("/setRedisData")
	public String setRedisData(String key,String value)
	{
		testService.setData(key, value);
		return "";
	}
	
	@RequestMapping("/getRedisData")
	public String getRedisData(String key)
	{
		String data = testService.getData(key);
		System.out.println(data);
		return "";
	}
	
	@RequestMapping("/setBean")
	public String setBean(TestBean test)
	{
		testService.setBean(test);
		return "";
	}

}
