package com.study.spring.admin.usermng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring.admin.usermng.service.UserMngService;
import com.study.spring.user.vo.UserVO;

@Controller
@RequestMapping("/admin/usermng")
public class UserMngController {
	@Autowired
	private UserMngService userMngService;

	@RequestMapping("/list.do")
	public String list(Model model) throws Exception {

		List<UserVO> list = userMngService.selectUserList();


		model.addAttribute("resultVOList", list);

		return "admin/usermng/list";
	}

	@RequestMapping("/form.do")
	public String form(@RequestParam(required=false) String userId, Model model) throws Exception {

		UserVO userVO = null;
		if (userId != null && !userId.trim().isEmpty()) {
			userVO = userMngService.selectUser(userId);
		}

		model.addAttribute("resultVO", userVO);

		return "admin/usermng/form";
	}

	@RequestMapping("/save.do")
	public String form(UserVO userVO, Model model) throws Exception {
		String userId = userVO.getUserId();

		if (userId != null || !userId.trim().isEmpty()) {
			userMngService.updateUser(userVO);
		} else {
			userMngService.insertUser(userVO);
		}

		return "redirect:/admin/usermng/list.do";
	}
}
