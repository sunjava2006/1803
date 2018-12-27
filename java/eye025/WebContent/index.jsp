<%@page import="com.sun.jndi.toolkit.url.UrlUtil, com.thzhima.eye025.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    import="java.util.Enumeration"
    pageEncoding="UTF-8" errorPage="err.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EyE眼科</title>
<style>
	html, body{
		width: 100%;
		height: 100%;
		font-size: 12px;
	}
	body{
		display: flex; /*弹性布局*/
		flex-direction: column;  /*弹性布局的方向是"行"*/
		align-items: center; /*次方向对齐*/
		justify-content: center; /*主方向分布*/
	}
	.panel{
		width: 80%;
		height: 80%;
		/*border: solid red 1px;*/
	}
	table{
		width: 100%;
		font-size: 2em;
		background: #EDDCDC;
	}
	td{
		height: 3em;
	}
	input{
		height: 2em;
	}
	td:nth-child(1){
		text-align: right;
	}
	.input{
		width: 300px;
	}
	.btn{
		font-size: 1em;
		margin: 10px;
		padding: 10px;
		border-radius: 5px;
	}
</style>
<script>
	function login (argument) {
		return true;
	}
</script>
</head>
<body>
   <div class="panel">
   	   <h1>
   	   	EyE眼科后台管理系统
   	   </h1>
   	   <form action="login.jsp" method="post" onsubmit="return login();">
	   	   <table>
	   	   	<tr>
	   	   		<td>登录名</td>
	   	   		<td><input class="input"
	   	   			type="text" name="adminName" id="adminName"></td>
	   	   		<td id="adminNameMsg"></td>
	   	   	</tr>
	   	   	<tr>
	   	   		<td>密码</td>
	   	   		<td><input class="input" type="password" name="password" id="password"></td>
	   	   		<td id="passwordMsg" ></td>
	   	   	</tr>
	   	   	<tr>
	   	   		<td colspan="3">
	<% String msg = request.getParameter("msg") ;
	if (null != msg){
		msg = new String(msg.getBytes("iso-8859-1"), "utf-8");
		msg = UrlUtil.decode(msg, "utf-8");
	    out.print(msg);
	}
	   
	%>
	<input type="submit" value="登录" class="btn" />
	   	   		</td> 
	   	   		
	   	   	</tr>
	   	   </table>
   	   </form>
   </div>
   
 <jsp:useBean id="user" class="com.thzhima.eye025.bean.Sysadmin" scope="request">
 </jsp:useBean>
 <jsp:setProperty property="name" value="XIE" name="user" />
 <%
 Sysadmin u = new Sysadmin();
 request.setAttribute("user", u);
 
 u.setName("XIE");
 %>
 
 
<%=((Sysadmin)request.getAttribute("user")).getName() %>
   
</body>
</html>