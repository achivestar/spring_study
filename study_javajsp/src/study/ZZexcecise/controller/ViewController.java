package study.ZZexcecise.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.ZZexercise.usermng.UserVO;

public class ViewController implements Controller {

	public String proessRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		UserVO userVO = new UserVO();

		request.setAttribute("resultVO", userVO);
		return "/WEB-INF/view/view.jsp";
	}

}
