package study.ZZexcecise.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.ZZexcecise.controller.Controller;
import study.ZZexcecise.controller.ListController;
import study.ZZexcecise.controller.ViewController;
import study.ZZexcecise.controller.WriteController;

/**
 * Servlet implementation class DispacherServlet
 */
public class DispacherServlet extends HttpServlet {
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
		// dispacher :: 요청 url을 처리할 controller에게 처리를 위임한다.
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		System.out.println("uri : " + uri);
		System.out.println("context : " + context);

		Controller controller = null;
		if (uri.indexOf(context+"/list.do") == 0) {

			controller = new ListController();

		} else if (uri.indexOf(context+"/write.do") == 0) {
			controller = new WriteController();
		} else if (uri.indexOf(context+"/view.do") == 0) {
			controller = new ViewController();
		} else {
			controller = new ListController();
		}

		String view;
		try {
			view = controller.proessRequest(request, response);
		} catch (Exception e) {
			request.setAttribute("exception", e);
			view = "/WEB-INF/view/error.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
