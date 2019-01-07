package com.thzhima.eye025.servlets.wx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thzhima.eye025.bean.Abstract;
import com.thzhima.eye025.service.AbstractService;


@WebServlet("/showAbstract")
public class ShowAbstractServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "{}";
		try {
			Abstract abs = AbstractService.getAbstract();
			if(abs != null) {
//				json="{\"p1\":\""+abs.getPicture1()+"\", \"p2\":\""+abs.getPicture2()+"\", \"p3\":\""
//			             +abs.getPicture3()+"\",\"content\":\""+abs.getContent()+"\"}";
				
				ObjectMapper mapper = new ObjectMapper();
				json = mapper.writeValueAsString(abs);
				System.out.println(json);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		response.setHeader("Content-type", "application/json; charset=utf-8"); 
		
		PrintWriter out = response.getWriter();
		out.print(json);
		
	    
	}

}
