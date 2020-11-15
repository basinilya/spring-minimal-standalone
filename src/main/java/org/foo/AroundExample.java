package org.foo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AroundExample {

	public Object aroundDoSomething(ProceedingJoinPoint pjp, String param1, String param2) throws Throwable {
		System.err.println("aroundDoSomething: " + param1);
		Object retVal = pjp.proceed();
		return retVal;
	}

	public void afterDoSomething(
			// JoinPoint jp,
			Some target, String retval, String param) throws Throwable {
		// jp.getThis();
		System.err.println("afterDoSomething: " + param + " " + retval);
	}

}
