<%@ page language="java" contentType="text/html; charset=UTF-8" session="true"
    pageEncoding="UTF-8" %>

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
		width: 900px;
		font-size: 2em;
		background: #EDDCDC;
	}
	td{
	   width:300px;
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
	function login (f) {
		var adminNameMsg = document.getElementById("adminNameMsg");
		var passwordMsg = document.getElementById('passwordMsg');
		adminNameMsg.innerText = '';
		passwordMsg.innerText = '';
		
		var ok = true;
		// 校验登录名
		var adminName = f.adminName.value;
		var regexpName = /^[A-Za-z]{2,20}$/;
		if(!regexpName.test(adminName)){
			ok = false;
			adminNameMsg.innerText = '登录名格式不正确';
		}
		
		// 校验密码
		var pwd = f.password.value;
		var regexpPWD = /^[0-9a-zA-Z]{6,12}$/;
		if(!regexpPWD.test(pwd)){
			ok = false;
			passwordMsg.innerText = '密码格式不正确';
		}
		return ok;
	}
</script>
</head>
<body>
   <%=this==page %>
   <div class="panel">
   	   <h1>
   	   	EyE眼科后台管理系统
   	   </h1>
   	   <form action="./login" method="post" onsubmit="return login(this);">
	   	   <table>
	   	   	<tr>
	   	   		<td>登录名</td>
	   	   		<td><input class="input"
	   	   			type="text" name="adminName" id="adminName" placeholder="登录名为2-20字符"></td>
	   	   		<td id="adminNameMsg"></td>
	   	   	</tr>
	   	   	<tr>
	   	   		<td>密码</td>
	   	   		<td><input class="input" type="password" name="password" id="password" placeholder="6-12位字母或数字"></td>
	   	   		<td id="passwordMsg" ></td>
	   	   	</tr>
	   	   	<tr>
	   	   		<td colspan="3">
	   	   		   ${msg }
                  <input type="submit" value="登录" class="btn" />
	   	   		</td> 
	   	   		
	   	   	</tr>
	   	   </table>
   	   </form>
   </div>
   访问人数：  <%=application.getAttribute("count") %>
</body>
</html>