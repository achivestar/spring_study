<%@page import="study.ZZexercise.usermng.UserVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List list = (List)request.getAttribute("resultVOList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
<body>
<table>
	<tr>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
	</tr>
<%
	for (int i=0; i<list.size(); i++) {
		UserVO userVO = (UserVO)list.get(i);
%>
	<tr>
		<td><%=userVO.getUserId() %></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>