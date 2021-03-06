<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
${username}
<c:if test="${username!=null }">
	<a href="${pageContext.request.contextPath }/verify/logout.action">退出</a>
</c:if>
	<form action="">
		<table width="100%" border="1">
			<tr>
				<td>ID</td>
				<td>用户名</td>
				<td>订单ID</td>
				<td>创建日期</td>
				<td>操作</td>
			</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.orderid }</td>
				<td><fmt:formatDate value = "${user.createdate }" pattern = "yyyy-MM-dd"/></td>
				<td>
					<a href="${pageContext.request.contextPath}/user/findUserById.action?id=${user.id }">编辑</a>||
					<a href="${pageContext.request.contextPath}/user/deleteUserById.action?id=${user.id }">删除</a>
				</td>
			</tr>		
		</c:forEach>
			<tr>
				<td>
					<a href="http://192.168.106.13:6690/vod/20141015/17389e838b92a66f.mp4">video</a>
				</td>
				<td>
					<input type="button"  onclick = "addUser()"  value="添加">
				</td>
			</tr>
		</table>
	</form>

</body>
<script type="text/javascript">
	function addUser(){
		window.location.href="${pageContext.request.contextPath}/user/inserUserForm.action";
	}
</script>
</html>