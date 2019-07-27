package study.ZZexcecise.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.ZZexercise.usermng.UserVO;

public class ListController implements Controller {

	public String proessRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<UserVO> list = new ArrayList<UserVO>();

		request.setAttribute("resultVOList", list);
		return "/WEB-INF/view/list.jsp";
	}

}
