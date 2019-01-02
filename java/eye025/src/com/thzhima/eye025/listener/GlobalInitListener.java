package com.thzhima.eye025.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class GlobalInitListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent evt)  { 
        ServletContext app = evt.getServletContext();
        app.setAttribute("adminList", new ArrayList());
        app.setAttribute("count", 0);
    }

    public void contextDestroyed(ServletContextEvent evt)  { 
         
    }

	
    
	
}
