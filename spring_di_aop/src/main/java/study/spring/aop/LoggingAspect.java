package study.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public void logging(ProceedingJoinPoint jp){
		try {
			long time = System.currentTimeMillis();
			jp.proceed();	// 빼면 대상 메소드 실행이 되지 않음
			
			System.out.println(jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName() + " " + (System.currentTimeMillis() - time) + " milli seconds elapsed");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
