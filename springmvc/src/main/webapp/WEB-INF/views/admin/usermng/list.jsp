<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>list</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
</style>
<script type="text/javascript">
$(document).ready(function () {
	$('#btnNew').click(function() {
		location.href = '<c:url value="/admin/usermng/form.do"/>';
	});
});
</script>
</head>
<body>
<div class="container-fluid">
	<div class="col-lg-12">
		<table class="table table-hover table-bordered">
		<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>등급</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>상태</th>
			<th>최근로그인</th>
			<th>등록일시</th>
		</tr>
		</thead>
		<c:forEach var="resultVO" items="${resultVOList }">
		<tr>
			<td><c:out value="${resultVO.userId }"/></td>
			<td><a href="<c:url value="/admin/usermng/form.do"/>?userId=<c:out value="${resultVO.userId }"/>"><c:out value="${resultVO.userNm }"/></a></td>
			<td><c:out value="${resultVO.userLv }"/></td>
			<td><c:out value="${resultVO.phone }"/></td>
			<td><c:out value="${resultVO.email }"/></td>
			<td><c:out value="${resultVO.status }"/></td>
			<td><c:out value="${resultVO.lastDt }"/></td>
			<td><c:out value="${resultVO.regDt }"/></td>
		</tr>
		</c:forEach>
		</table>
	</div>
	<div class="text-right"><button id="btnNew" class="btn btn-primary">등록</button></div>
</div>
</body>
</html>