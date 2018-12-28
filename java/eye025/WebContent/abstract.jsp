<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body style=" width: 100%">
	<h1>简介</h1>
	<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>

	<form action="publishAbs" method="post" enctype="multipart/form-data">
		<table border="0">
			<tr>
				<td>照片1</td>
				<td><input type="file" name="picture1"></td>
				<td >
					<button type="button" onclick="location='abstractList'">简介列表</button>
				</td>
			</tr>
			<tr>
				<td>照片2</td>
				<td><input type="file" name="picture2"></td>
				<td rowspan="5" ></td>
			</tr>
			<tr>
				<td>照片3</td>
				<td><input type="file" name="picture3"></td>
			</tr>
			<tr>
				<td>简介</td>
				<td><textarea rows="20" cols="100" name="content"></textarea></td>
			</tr>
			<tr>
				<td>表布状态</td>
				<td><input type="checkbox" name="publishStatus" ></td>
			</tr>
			<tr>
				<td><input type="reset" value="清空"></td>
				<td><input type="submit" value="发布"></td>
			</tr>
		</table>
	</form>
</body>
</html>