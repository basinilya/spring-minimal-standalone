package org.foo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundExample2 {

	@Around(value = "execution(* org.foo.Some.doSomething(..)) && args(param1,param2,..)", argNames = "param1,param2")
	public Object aroundDoSomething(ProceedingJoinPoint pjp, String param1, String param2) throws Throwable {
		System.err.println("aroundDoSomething: " + param1);
		Object retVal = pjp.proceed();
		return retVal;
	}

	@AfterReturning(pointcut = "execution(* " + "org.foo.Some.doSomething" + "(..))" //
	// + " && bean(someImpl)" //
			+ " && target(target) && args(param,..)", returning = "retval" //
			, argNames = "target,retval,param" //
	)
	public void afterDoSomething(
			// JoinPoint jp,
			Some target, String retval, String param) throws Throwable {
		// jp.getThis();
		System.err.println("afterDoSomething: " + param + " " + retval);
	}

}
