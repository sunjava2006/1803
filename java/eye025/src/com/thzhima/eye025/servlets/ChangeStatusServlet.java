package com.thzhima.eye025.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thzhima.eye025.service.AbstractService;


@WebServlet("/chStatus")
public class ChangeStatusServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("absId");
		int id = Integer.parseInt(strId);
		
		try {
			AbstractService.setPublishStatus(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/abstractList").forward(request, response);
	}

}
