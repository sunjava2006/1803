<%@ page language="java" contentType="text/html; charset=UTF-8" 
    import="com.thzhima.eye025.service.UserService, com.thzhima.eye025.bean.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    System.out.print("---------------login.jsp---------------------");
    String adminName = request.getParameter("adminName");
    String password = request.getParameter("password");
    
    Sysadmin u = UserService.login(adminName, password);

    if(u != null){
%>
     <jsp:forward page="admin_manage.html"></jsp:forward>
<%    	
    }else{
%>
      <jsp:forward page="index.jsp">
          <jsp:param value="login 失败。" name="msg" />
      </jsp:forward>   	
<%  	   
    }
%>
</body>
</html>