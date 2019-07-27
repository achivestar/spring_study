package com.study.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class ConfigPropertyOutputServlet
 */
public class ConfigPropertyOutputServlet extends HttpServlet {
	private final static Logger logger = LogManager.getLogger(ConfigPropertyOutputServlet.class);
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
		// listener에서 읽어온 properties 내용을 출력 한다.
		logger.info(ConfigLoadListener.getProperty("database.driver"));
		PrintWriter out = response.getWriter();
		out.print(ConfigLoadListener.getProperty("database.driver"));
	}

}
