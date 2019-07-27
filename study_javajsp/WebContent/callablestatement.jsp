<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.PreparedStatement"%>
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
CallableStatement stmt = null;  // Or PreparedStatement if needed
String userId = "admin";
String userNm = "";
try {
	ds = (DataSource)envContext.lookup("jdbc/study");
	conn = ds.getConnection();
	String sql = "{call getName (?, ?)}";
	stmt = conn.prepareCall(sql);
	stmt.setString(1, userId);
	stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
	stmt.execute();
	userNm = stmt.getString(2);
} catch (SQLException e) {
	e.printStackTrace();
} finally {
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
<title>callable statment를 통한 프로시저호출</title>
</head>
<body>

    USER_ID <%=userId %><br/>
    USER_NM <%=userNm %><br/>

</body>
</html>


