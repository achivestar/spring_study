<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Context initContext = new InitialContext();
Context envContext  = (Context)initContext.lookup("java:/comp/env");
DataSource ds = null;
Connection conn = null;
Statement stmt = null;  // Or PreparedStatement if needed
ResultSet rs = null;
String userId = "";
String userNm = "";
try {
	ds = (DataSource)envContext.lookup("jdbc/study");
	conn = ds.getConnection();
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
<title>JNDI를 이용한 DB접속2</title>
</head>
<body>

    USER_ID <%=userId %><br/>
    USER_NM <%=userNm %><br/>


</body>
</html>


