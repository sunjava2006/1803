<%@ page language="java" contentType="text/html; charset=UTF-8" 
import="java.util.List, com.thzhima.eye025.bean.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	img{
		width: 100px;
	}
</style>
</head>
<body>
    <table border="1">
<%
    List<Abstract> list = (List<Abstract>)request.getAttribute("list");
    if(null != list){
    	for(int i=0;i<list.size();i++){
    	    Abstract a = list.get(i);
%>    	
    	<tr>
    		<td><%=a.getContent() %></td>
    		<td>
<%
            if(a.getPicture1()!=null){
%>    		
    		    <img src=".<%=a.getPicture1()%>">
<%
            }
%>
    		</td>
    		<td>
<%
            if(a.getPicture2()!=null){
%>    		
    		    <img src=".<%=a.getPicture2()%>">
<%
            }
%>          </td>
    		<td>
<%
            if(a.getPicture3()!=null){
%>    		
    		    <img src=".<%=a.getPicture3()%>">
<%
            }
%>			</td>
    		<td><%=a.isPublishStatus()?"是":"否"%></td>
    		<td>
    		    <button onclick="location.href='chStatus?absId=<%=a.getId()%>'">发布</button>
    		    <button onclick="location.href='delAbs?absId=<%=a.getId() %>'">删除</button>
    		</td>
    	</tr>
<%
       }


    }
%>    	
    </table>
</body>
</html>