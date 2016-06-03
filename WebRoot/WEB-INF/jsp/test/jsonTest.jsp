<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json交互</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jquery/jquery-2.0.3.min.js"></script>
<script type="text/javascript">
function request(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/user/requestJson.action',
		contentType:'application/json;charset=utf-8',
		data:'{"name":"手机","price":"998"}',
		success:function(data){
			alert(data);
		}
	});
}
function response(){
	
}

</script>
<body>
<table>
	<tr>
		<td><input type="button" value="请求json,输出json" onclick="request()"></td>
	</tr>
	<tr>
		<td><input type="button" value="请求key/value,输出json" onclick="response()"></td>
	</tr>
</table.>
</body>
</html>