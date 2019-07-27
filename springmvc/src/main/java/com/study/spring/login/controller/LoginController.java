package com.study.spring.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.spring.login.service.LoginService;
import com.study.spring.security.AuthorityUtil;
import com.study.spring.security.LoginInfo;
import com.study.spring.user.vo.UserVO;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	/**
	 * 로그인화면
	 * @param request
	 * @return
	 */
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) {
		if (AuthorityUtil.isLogin(request)) {
			return "redirect:/admin/main.do";
		}
		return "/login/login";
	}
	
	/**
	 * 로그인처리
	 * @param request
	 * @return
	 */
	@RequestMapping("/actionLogin.do")
	public String actionLogin(HttpServletRequest request, @Required String userId, @Required String userPw, final RedirectAttributes redirectAttributes) throws Exception {
		UserVO userVO = loginService.selectUser(userId, userPw);
		
		if (userVO == null) {
			redirectAttributes.addFlashAttribute("message", "일치하는 회원이 없습니다.");
			return "redirect:/login/login.do";
		}
		
		// 로그인정보 세션 저장
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setId(userId);
		loginInfo.setName(userVO.getUserNm());
		loginInfo.setLevel(userVO.getUserLv());
		AuthorityUtil.login(request, loginInfo);
		
		return "redirect:/admin/main.do";
	}
	
	/**
	 * 로그아웃처리
	 * @return
	 */
	@RequestMapping("/actionLogout")
	public String actionLogout(HttpServletRequest request) {
		AuthorityUtil.logout(request);
		return "redirect:/";
	}
}
