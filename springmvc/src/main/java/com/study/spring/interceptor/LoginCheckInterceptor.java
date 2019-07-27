package com.study.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.study.spring.common.GlobalConst;
import com.study.spring.security.AuthorityUtil;
import com.study.spring.security.LoginInfo;

public class LoginCheckInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("LoginCheckInterceptor preHandle");
		
		HttpSession session = request.getSession();
		LoginInfo loginInfo = (LoginInfo)session.getAttribute(GlobalConst.LOGIN_SESSION_KEY);
		
		if (!AuthorityUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/login/login.do");
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("LoginCheckInterceptor postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("LoginCheckInterceptor afterCompletion");
	}

}
