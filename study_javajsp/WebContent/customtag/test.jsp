<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/tlds/mytag.tld" %>
<%
	String str = "가나다라\n마바사아자차\n동해물과";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<mytag:strcut len="10" value="가나다라마바사아자차"/><br>
<mytag:cr2br value="<%=str %>"/><br>
<select name="selectedTag">
<%
	String selVal = "2";
	for (int i=0; i<10; i++) {
%>
<option value="<%=i %>" <mytag:selected compareValue="<%=selVal %>" value="<%=String.valueOf(i) %>"/>><%=i %></option>
<%
	}
%>
</select>
</body>
</html>