<%@ page language="java" contentType="text/html; charset=UTF-8" 
import="java.util.List, com.thzhima.eye025.bean.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table>
<%
    List<Abstract> list = (List<Abstract>)request.getAttribute("list");
    if(null != list){
    	for(int i=0;i<list.size();i++){
    	    Abstract a = list.get(i);
%>    	
    	<tr>
    		<td><%=a.getContent() %></td>
    		<td><%=a.isPublishStatus()?"是":"否"%></td>
    		<td><button>发布</button></td>
    	</tr>
<%
       }


    }
%>    	
    </table>
</body>
</html>