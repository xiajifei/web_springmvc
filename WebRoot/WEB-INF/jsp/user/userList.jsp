<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<table width="100%" border="1">
			<tr>
				<td>ID</td>
				<td>用户名</td>
				<td>订单ID</td>
				<td>创建日期</td>
			</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.orderid }</td>
				<td><fmt:formatDate value = "${user.createdate }" pattern = "yyyy-MM-dd"/></td>
			</tr>		
		</c:forEach>
			<tr>
				<td>
					<a href="http://192.168.106.13:6690/vod/20141015/17389e838b92a66f.mp4">video</a>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>