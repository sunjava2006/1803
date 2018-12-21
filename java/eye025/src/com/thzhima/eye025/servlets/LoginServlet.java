package com.thzhima.eye025.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.thzhima.eye025.bean.Sysadmin;
import com.thzhima.eye025.service.UserService;


public class LoginServlet implements Servlet{
	private String contentType ;
	
	public LoginServlet() {
		System.out.println("============构造中=============");
	}
	
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		System.out.println("============init中=============");
		String charset = cfg.getInitParameter("charset");
		this.contentType = "text/html;charset="+charset;
		
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType(this.contentType);
		
		String adminName = request.getParameter("adminName"); // 获取用户发送的请求参数
		String password = request.getParameter("password");
		//=================================================
		System.out.println(request.getRemoteHost());
		System.out.println(request.getServerName());
		System.out.println(request.getCharacterEncoding());
		System.out.println(request.getContentLength());
		System.out.println(request.getLocalAddr());
		
		System.out.println(request.getProtocol());
		
		System.out.println(request.getRemotePort());
		System.out.println(request.getLocalPort());
		System.out.println(request.getServerPort());
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		
		Enumeration<String> heads = req.getHeaderNames();
		while(heads.hasMoreElements()) {
			String name = heads.nextElement();
			String val = req.getHeader(name);
			System.out.println(name + ":" + val);
		}
		
		
		//==================================================
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
				
				response.getWriter().print(" login success. "+ user.getName()); // 响应。输出给浏览器的内容。
			}else {
				response.getWriter().print(" user name or password error. "); // 响应。输出给浏览器的内容。
			}
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("============将要关闭=============");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("============getServletConfig中=============");
		
		
		
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("============getServletInfo中=============");
		return null;
	}

	



}
