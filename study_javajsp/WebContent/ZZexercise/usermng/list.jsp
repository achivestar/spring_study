<%@page import="study.ZZexercise.usermng.UserMngManager"%>
<%@page import="study.ZZexercise.usermng.UserVO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserMngManager mngr = UserMngManager.getInstance();
	List<UserVO> userVOList = mngr.getUserList(null, null);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
</style>
<script type="text/javascript">
</script>
</head>
<body>
<div class="container">
	<table class="table table-hover table-bordered">
	<thead>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>등급</th>
		<th>최근로그인</th>
		<th>갱신일시</th>
		<th>등록일시</th>
	</tr>
	</thead>
	<tbody>
	<%
		if (userVOList == null || userVOList.size() == 0) {
	%>
	<tr>
		<td colspan="8" class="text-center">데이터가 존재하지 않습니다.</td>
	</tr>
	<%
		} else {
			UserVO vo = null;
			for(int i=0; i<userVOList.size(); i++) {
				vo = userVOList.get(i);
	%>
	<tr>
		<td><%=vo.getUserId() %></td>
		<td><%=vo.getUserNm() %></td>
		<td><%=vo.getPhone() %></td>
		<td><%=vo.getEmail() %></td>
		<td><%=vo.getUserLv() %></td>
		<td><%=vo.getLastDt() %></td>
		<td><%=vo.getUpdDt() %></td>
		<td><%=vo.getRegDt() %></td>
	</tr>
	<%
			}
		}
	%>
	</tbody>
	</table>
	<div class="text-right"><a href="form.jsp" class="btn btn-default">등록</a></div>
</div>
<%
%>
</body>
</html>