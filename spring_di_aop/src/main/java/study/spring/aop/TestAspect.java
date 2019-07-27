package study.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class TestAspect {
	public void beforeProcess(){
		System.out.println("TestAspect.beforeProcess");
	}
	
	public void afterProcess(){
		System.out.println("TestAspect.afterProcess");
	}
	
	public void afterReturingProcess(){
		System.out.println("TestAspect.afterReturingProcess");
	}
	
	public void afterThrowingProcess(){
		System.out.println("TestAspect.afterThrowingProcess");
	}
	
	public void aroundProcess(ProceedingJoinPoint jp){
		try {
			System.out.println("TestAspect.aroundProcess before");
			jp.proceed();	// 빼면 대상 메소드 실행이 되지 않음
			System.out.println("TestAspect.aroundProcess after");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
