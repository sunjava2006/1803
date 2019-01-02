package com.thzhima.eye025.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


@WebListener
public class AdminLoginListener implements HttpSessionAttributeListener {

   
    public void attributeAdded(HttpSessionBindingEvent evt)  { 
    	String attrName = evt.getName();
        if("userInfo".equals(attrName)){
        	Object u = evt.getValue();
        	List list = (List) evt.getSession().getServletContext().getAttribute("adminList");
        	list.add(u);
        }
    }

	
    public void attributeRemoved(HttpSessionBindingEvent evt)  { 
         String attrName = evt.getName();
         if("userInfo".equals(attrName)) {
        	 Object o = evt.getValue();
        	 ServletContext app = evt.getSession().getServletContext();
        	 List list = (List) app.getAttribute("adminList");
        	 list.remove(o);
         }
         System.out.println("-----------attributeRemoved---------------");
    }

	
    public void attributeReplaced(HttpSessionBindingEvent evt)  { 
         System.out.println("---------------attributeReplaced-----------------");
    }
	
}
