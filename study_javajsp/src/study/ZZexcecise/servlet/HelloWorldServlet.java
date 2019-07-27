package study.ZZexcecise.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");

		PrintWriter out = resp.getWriter();

		// url 구분에 따라 jsp 선택
		String url = req.getRequestURI();

		out.println("getServletContext : " + req.getServletContext()+"<br>");
		out.println("getServerName : " + req.getServerName()+"<br>");
		out.println("getContextPath : " + req.getContextPath()+"<br>");
		out.println("getRequestURL : " + req.getRequestURL()+"<br>");
		out.println("getRequestURI : " + req.getRequestURI()+"<br>");

	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

}
