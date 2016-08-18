<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<form action="../j_spring_security_check" method="post">
		<table width="100%" border="1">
		 <tr>  
			<td><label for="j_username">用户名</label> </td>
            <td><input id="j_username"  name="j_username" type="text" />   </td>
          </tr>  
  
        <tr>  
            <td><label for="j_password">密码</label></td>
            <td><input id="j_password"   name="j_password" type="password" /></td>  
        </tr>  
  
        <tr><td><input type="submit" value="Login" /></td></tr>  
		</table>
	</form>

</body>

<script type="text/javascript">
	function subUserEdit(){
		$("#userEditForm").submit();
	}
</script>
</html>