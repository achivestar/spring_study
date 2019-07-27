package study.ZZexcecise.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteController implements Controller {

	public String proessRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {


		return "/WEB-INF/view/write.jsp";
	}

}
