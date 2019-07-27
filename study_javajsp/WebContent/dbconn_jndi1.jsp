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
DataSource ds = (DataSource)envContext.lookup("jdbc/study");
Connection conn = ds.getConnection();
%>    
<sql:update var="updated" dataSource="jdbc/study">
insert into test1 (USER_ID, USER_NM) values ('admin', 'test')
</sql:update>
<sql:query var="rs" dataSource="jdbc/study">
select * from test1
</sql:query>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JNDI를 이용한 DB접속1</title>
</head>
<body>

<c:forEach var="row" items="${rs.rows}">
    USER_ID ${row.USER_ID}<br/>
    USER_NM ${row.USER_NM}<br/>
</c:forEach>

</body>
</html>