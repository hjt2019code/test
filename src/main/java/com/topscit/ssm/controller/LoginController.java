package com.topscit.ssm.controller;

import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topscit.ssm.bean.User;
import com.topscit.ssm.service.TestService;

@Controller
public class LoginController {
	
	@Resource
	private TestService testService;
	
	@RequestMapping("/login")
	public String login(User user,HttpServletResponse resp)
	{
		if(user.getName().equals("admin")&&user.getPass().equals("123456"))
		{
			String uid = UUID.randomUUID().toString();
			testService.saveUser(uid, user);
			
			Cookie cookie = new Cookie("uid", uid);
//			cookie.setMaxAge(-1);当不设置事件则关闭浏览器销毁  -1就是永久不销毁
			cookie.setDomain("localhost");
			cookie.setPath("/");
			resp.addCookie(cookie);
			return "";
		}
		else
		{
			return "redirect:/login.jsp";
		}
		
	}
	

	@RequestMapping("/getUserState")
	public String getUserState(String key,Map<String, String> data)
	{
		System.out.println(key);
		User user = testService.getUser(key);
		if(user != null)
		{
			data.put("state", "1");
			return "forward:/result.jsp";
		}
		else
		{
			data.put("state", "0");
			return "forward:/result.jsp";
		}
	}
	
}
