package com.study.spring.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.study.spring.common.GlobalConst;

public class AuthorityUtil {
	/**
	 * 로그인체크
	 * @param request
	 * @throws InvalidLoginException
	 */
	public static void checkLogin(HttpServletRequest request) throws InvalidLoginException {
		if(!isLogin(request)) throw new InvalidLoginException();
	}

	/**
	 * 로그인여부
	 * @param request
	 * @return
	 */
	public static boolean isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute(GlobalConst.LOGIN_SESSION_KEY) == null) return false;

		LoginInfo loginInfo = (LoginInfo)session.getAttribute(GlobalConst.LOGIN_SESSION_KEY);

		return (loginInfo != null && loginInfo.isValidId());
	}

	/**
	 * 로그인세션정보저장
	 * @param request
	 * @param loginInfo
	 */
	public static void login(HttpServletRequest request, LoginInfo loginInfo) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.setAttribute(GlobalConst.LOGIN_SESSION_KEY, loginInfo);
		}
	}

	/**
	 * 로그인세션정보제거
	 * @param request
	 */
	public static void logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute(GlobalConst.LOGIN_SESSION_KEY);
		}
	}
}
