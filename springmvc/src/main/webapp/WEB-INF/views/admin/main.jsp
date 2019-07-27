<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="float:right"><a href="<c:url value="/login/actionLogout.do"/>">로그아웃</a></div>
<div style="clear:both">
	<ul>
		<li><a href="<c:url value="/admin/usermng/list.do"/>">사용자관리</a></li>
	</ul>
</div>
</body>
</html>