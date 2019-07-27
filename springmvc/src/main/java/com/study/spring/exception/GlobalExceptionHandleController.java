package com.study.spring.exception;

/**
 * ControllerAdvice 애너테이션을 통한 global exception handler 사용
 * xml의 simpleMappingExceptionResolver와 동일 exception에 대한 handle시 simpleMappingExceptionResolver이 우선함 
 */
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandleController {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandleController.class);
	
	@ExceptionHandler(GlobalHandlerTestException.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error/error");
		return mav;
	}
}
