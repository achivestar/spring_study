package study.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * aop:advisor 테스트를 위한 advice
 * @author Park
 *
 */
public class CustomArroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		try {
			System.out.println("CustomArroundAdvice before");
			Object result = methodInvocation.proceed();
			System.out.println("CustomArroundAdvice after");

			return result;

		} catch (IllegalArgumentException e) {

			System.out.println("CustomArroundAdvice : Throw exception arround!");
			throw e;
		}
	}

}
