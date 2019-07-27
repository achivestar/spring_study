<%@page import="java.util.Date"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Connection conn = null;
Statement stmt = null;  // Or PreparedStatement if needed
ResultSet rs = null;
String userId = "";
String userNm = "";
try {
	Class.forName("com.mysql.jdbc.Driver");  
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study","study","qkrruddhks");
	
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select user_id, user_nm from test1 limit 1");	
	if (rs != null) {
		rs.next();
		userId = rs.getString(1);
		userNm = rs.getString(2);
	}
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	if (rs != null) {
		try { rs.close(); } catch (SQLException e) { ; }
		rs = null;
	}
	if (stmt != null) {
		try { stmt.close(); } catch (SQLException e) { ; }
		stmt = null;
	}
	if (conn != null) {
		try { conn.close(); } catch (SQLException e) { ; }
		conn = null;
	}
}
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    USER_ID <%=userId %><br/>
    USER_NM <%=userNm %><br/>
</body>
</html>