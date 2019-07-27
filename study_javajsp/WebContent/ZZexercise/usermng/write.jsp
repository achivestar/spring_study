<%@page import="study.ZZexercise.usermng.UserMngManager"%>
<%@page import="study.ZZexercise.usermng.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");	// utf8 encoding

	String method = request.getMethod();

	if (!"post".equalsIgnoreCase(method)) {
%>
<script type="text/javascript">
		alert('잘못된 접근입니다.');
		history.back();
</script>
<%
		return;
	}

	String userId = request.getParameter("userId");
	String userNm = request.getParameter("userNm");
	System.out.println(userNm);
	String userPw = request.getParameter("userPw");

	if (userId == null || "".equals(userId.trim())
			|| userNm == null || "".equals(userNm.trim())
			|| userPw == null || "".equals(userPw.trim())) {
%>
<script type="text/javascript">
		alert('잘못된 접근입니다.');
		history.back();
</script>
<%
		return;
	}

	UserVO userVO = new UserVO();
	userVO.setUserId(userId);
	userVO.setUserNm(userNm);
	userVO.setUserPw(userPw);
	userVO.setUserLv(9);
	userVO.setStatus("00");

	UserMngManager manager = UserMngManager.getInstance();
	boolean result = manager.insertUser(userVO);

	if (result) {
%>
<script type="text/javascript">
		alert('정상 등록되었습니다.');
		location.replace('list.jsp');
</script>
<%
		return;
	} else {
%>
<script type="text/javascript">
		alert('등록되지 않았습니다.');
		history.back();
</script>
<%
	}
%>
</script>