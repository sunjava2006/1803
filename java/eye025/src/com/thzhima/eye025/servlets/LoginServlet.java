package com.thzhima.eye025.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.thzhima.eye025.bean.Sysadmin;
import com.thzhima.eye025.service.UserService;


public class LoginServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String adminName = request.getParameter("adminName"); // 获取用户发送的请求参数
		String password = request.getParameter("password");
		boolean ok = true;
		
		Sysadmin user = null;
		
		try {
			user = UserService.login(adminName, password);
		} catch (SQLException e) {
			e.printStackTrace();
			ok =false;
		}
		System.out.println("----------- 我可以为你进行登录服务------------");
		if(!ok) {
			response.getWriter().print(" 服务器出现错误。 "); // 响应。输出给浏览器的内容。
			
		}
		else {
			if(user != null) {
				response.getWriter().print(" login success. "); // 响应。输出给浏览器的内容。
			}else {
				response.getWriter().print(" user name or password error. "); // 响应。输出给浏览器的内容。
			}
		}
		
		
	}

}
