<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<body>
	<form action="" id = "userEditForm">
		<table width="100%" border="1">
			<tr>
				<td>ID</td>
				<td><input value="${user.id }"></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input value="${user.name }"></td>
			</tr>
			<tr>
				<td>订单ID</td>
				<td><input value="${user.orderid }"></td>
			</tr>
			<tr>
				<td>创建日期</td>
				<td><input value="<fmt:formatDate value = "${user.createdate }" pattern = "yyyy-MM-dd"/>"></td>
			</tr>
			<tr>
				<td>
					<a href="http://192.168.106.13:6690/vod/20141015/17389e838b92a66f.mp4">video</a>
				</td>
				<td>
					<input value="保存" type="button" onclick="subUserEdit()">
				</td>
			</tr>
		</table>
	</form>

</body>

<script type="text/javascript">
	function subUserEdit(){
		$("#userEditForm").submit();
	}
</script>
</html>