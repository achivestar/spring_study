<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var message = '${message}';
if (message != '') {
	alert(message);
}
function checkLogin() {
	var f = document.form1;
	// TODO value check
	f.action = '<c:url value="/login/actionLogin.do"/>';
	return true;
}
</script>
</head>
<body>
<form name="form1" method="post" onsubmit="javascript:return checkLogin()">
<input type="text" name="userId"/><br>
<input type="password" name="userPw"/><br>
<input type="submit" value="로그인"/>
</form>
</body>
</html>