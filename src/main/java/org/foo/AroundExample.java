package org.foo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundExample {

	@Pointcut("execution(* org.foo.Some.doSomething(..))")
	public void log() {
	}

	@Around("doSomething()")
	// @Around("org.foo.Some.doSomething()")
	public Object doBasicProfiling2(ProceedingJoinPoint pjp) throws Throwable {
		System.err.println("==========================================");
		Object retVal = pjp.proceed();
		return retVal;
	}

}
