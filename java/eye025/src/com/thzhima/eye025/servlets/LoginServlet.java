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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// 取出全局配置参数。
		String charset = cfg.getServletContext().getInitParameter("charset");
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
			if(user != null) {// 登录成功
				
				// 获取用户的Session 对象。
				HttpSession session = req.getSession(true);
				// 把用户信息放到Session 中。
				session.setAttribute("userInfo", user);
				
				
				
				HttpServletResponse res  = (HttpServletResponse) response;
				res.sendRedirect("./admin_manage.jsp");//向浏览器发送一个重定向。定向到/admin_manage.html
				//res.sendRedirect("http://www.sina.com.cn");
				
				//response.getWriter().print(" login success. "+ user.getName()); // 响应。输出给浏览器的内容。
			}else { // 登录失败
				//response.getWriter().print(" user name or password error. "); // 响应。输出给浏览器的内容。
				request.setAttribute("msg", "用户名或密码不正确。");
				request.getRequestDispatcher("index.jsp").forward(request, response);
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
