package org.foo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStandaloneApp {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan(SpringStandaloneApp.class.getPackage().getName());
		ctx.refresh();
		System.err.println("refreshed");

		Some obj = ctx.getBean(Some.class);
		obj.doSomething("testval");

		System.err.println("stopping");
		ctx.close();
		System.err.println("stopped");
	}

}
