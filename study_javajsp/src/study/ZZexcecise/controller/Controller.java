package study.ZZexcecise.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String proessRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
