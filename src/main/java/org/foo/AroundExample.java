package org.foo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundExample {

	@Around(value = "execution(* org.foo.Some.doSomething(..)) && args(param1,param2,..)", argNames = "param1,param2")
	public Object aroundDoSomething(ProceedingJoinPoint pjp, String param1, String param2) throws Throwable {
		System.err.println("aroundDoSomething: " + param1);
		Object retVal = pjp.proceed();
		return retVal;
	}

	@AfterReturning(pointcut = "execution(* org.foo.Some.doSomething(..)) && args(param,..)", returning = "retval", argNames = "retval,param")
	public void afterDoSomething(JoinPoint jp, String retval, String param) throws Throwable {
		System.err.println("afterDoSomething: " + param + " " + retval);
	}

}
