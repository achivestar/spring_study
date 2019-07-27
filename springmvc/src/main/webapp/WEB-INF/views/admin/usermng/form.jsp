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
	$('#btnSave').click(function() {
		document.form1.submit();
	});
});
</script>
</head>
<body>
<div class="container-fluid">
	<div class="col-lg-12">
		<form name="form1" method="post" action="<c:url value="/admin/usermng/save.do"/>">
			<div class="form-group">
				<label for="userId">아이디</label>
				<input type="text" class="form-control" id="userId" name="userId" placeholder="아이디" value="${resultVO.userId }">
			</div>
			<div class="form-group">
				<label for="userNm">이름</label>
				<input type="text" class="form-control" id="userNm" name="userNm" placeholder="이름" value="${resultVO.userNm }">
			</div>
			<c:if test="${empty resultVO.userId }">
			<div class="form-group">
				<label for="userPw">비밀번호</label>
				<input type="password" class="form-control" id="userPw" name="userPw" placeholder="비밀번호">
			</div>
			</c:if>
			<div class="form-group">
				<label for="phone">전화번호</label>
				<input type="text" class="form-control" id="phone" name="phone" placeholder="전화번호" value="${resultVO.phone }">
			</div>
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="email" class="form-control" id="email" name="email" placeholder="이메일" value="${resultVO.email }">
			</div>
			<div class="form-group">
				<label for="userLv">회원등급</label>
				<select class="form-control" id="userLv" name="userLv" placeholder="회원등급">
				<option value="5" <c:if test="${resultVO.userLv eq 5}">selected="selected"</c:if>>회원</option>
				<option value="0" <c:if test="${resultVO.userLv eq 0}">selected="selected"</c:if>>관리자</option>
				</select>
			</div>
			<div class="form-group">
				<label for="status">상태</label>
				<select class="form-control" id="status" name="status" placeholder="상태">
				<option value="00" <c:if test="${resultVO.status eq '00'}">selected="selected"</c:if>>정상</option>
				<option value="01" <c:if test="${resultVO.status eq '01'}">selected="selected"</c:if>>보류</option>
				</select>
			</div>
		</form>
	</div>
	<div class="text-right"><button id="btnSave" class="btn btn-primary">저장</button></div>
</div>
</body>
</html>