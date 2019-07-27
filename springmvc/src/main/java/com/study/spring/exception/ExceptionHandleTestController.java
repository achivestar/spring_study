package com.study.spring.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionHandleTestController {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandleTestController.class);
	
	@RequestMapping("/innerExceptionHandle.do")
	public String innerExceptionHandle() throws InnerHandlerTestException {
		if (1==1) throw new InnerHandlerTestException("inner exception throw");
		return "home";
	}	
	
	@RequestMapping("/globalExceptionHandle.do")
	public String globalExceptionHandle() throws GlobalHandlerTestException {
		if (1==1) throw new GlobalHandlerTestException("global exception throw");
		return "home";
	}
	
	@RequestMapping("/defaultExceptionHandle.do")
	public String defaultExceptionHandle() throws Exception {
		if (1==1) throw new Exception("default exception throw");
		return "home";
	}
		
	@RequestMapping("/selectedExceptionHandle.do")
	public String selectedExceptionHandle() throws ExceptionViewTestException {
		if (1==1) throw new ExceptionViewTestException("error view test exception throw");
		return "home";
	}
	
	@ExceptionHandler(InnerHandlerTestException.class)
	public String exceptionHandle(Exception e) {
		logger.debug("exception handler process for Exception : "+e.getMessage());
		return "error/error";
	}
}
