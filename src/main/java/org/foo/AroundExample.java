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

	@Around("execution(* org.foo.Some.doSomething(..)) && args(param,..)")
	public Object aroundDoSomething(ProceedingJoinPoint pjp, String param) throws Throwable {
		System.err.println("aroundDoSomething: " + param);
		Object retVal = pjp.proceed();
		return retVal;
	}

	@AfterReturning(pointcut = "execution(* org.foo.Some.doSomething(..)) && args(param,..)", returning = "retval", argNames = "retval,param")
	public void afterDoSomething(JoinPoint jp, String retval, String param) throws Throwable {
		System.err.println("afterDoSomething: " + param + " " + retval);
	}

}
