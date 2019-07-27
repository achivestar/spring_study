package com.study.spring.admin.usermng.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public Object logging(ProceedingJoinPoint jp) throws Throwable {
		Object obj = null;
		long time = System.currentTimeMillis();
		obj = jp.proceed();	// 빼면 대상 메소드 실행이 되지 않음

		System.out.println(jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName() + " " + (System.currentTimeMillis() - time) + " milli seconds elapsed");
		return obj;
	}
}
