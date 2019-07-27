package study.ZZexcecise.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.ZZexercise.usermng.UserVO;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		System.out.println("uri : " + uri);
		System.out.println("context : " + context);

		String view = "";
		if (uri.indexOf(context+"/list.do") == 0) {

			List list = new ArrayList();
			UserVO userVO = new UserVO();
			userVO.setUserId("test1");
			list.add(userVO);
			userVO = new UserVO();
			userVO.setUserId("test2");
			list.add(userVO);
			userVO = new UserVO();
			userVO.setUserId("test3");
			list.add(userVO);

			request.setAttribute("resultVOList", list);

			view = "/WEB-INF/view/list.jsp";
		} else if (uri.indexOf(context+"/write.do") == 0) {
			view = "/WEB-INF/view/write.jsp";
		} else if (uri.indexOf(context+"/view.do") == 0) {
			view = "/WEB-INF/view/view.jsp";
		} else {
			view = "/WEB-INF/view/list.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
