package study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HangeulTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		/** get submit시 한글 깨짐 처리 **/
		
		// 방법1(8859_1의 문자열을 utf-8로 재구성)
		// name = new String(name.getBytes("8859_1"), "utf-8");
		
		// 방법2(server.xml 설정 및 request에서 파라메터 참조전 encoding 지정)
		// <Connector> 태그에 useBodyEncodingForURI="true" 
		// req.setCharacterEncoding("utf-8");
		
		// 방법3(server.xml) 추천
		// tomcat의 경우 Server.xml 에서 <Connector>태그에 URIEncoding="utf-8" 추가
		
		res.setContentType("text/html; charset=utf-8");
        PrintWriter out = res.getWriter();
        
		out.println("hello servlet");
		out.println("안녕! "+name);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		//req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		name = new String(name.getBytes("8859_1"), "utf-8");
		
		/** post submit시 한글 깨짐 처리 **/
		// 방법1(8859_1의 문자열을 utf-8로 재구성)
		// name = new String(name.getBytes("8859_1"), "utf-8");
		
		// 방법2(request에서 파라메터 참조전 encoding 지정)
		// <Connector> 태그에 useBodyEncodingForURI="true" 
		// req.setCharacterEncoding("utf-8");
		
		res.setContentType("text/html; charset=utf-8");
        PrintWriter out = res.getWriter();
        
		out.println("hello servlet");
		out.println("안녕! "+name);
	}

	@Override
	public void destroy() {
		System.out.println("destory");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
		super.init();
	}

}
