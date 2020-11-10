package org.foo;

import org.bar.ThreadPoolTaskExecutorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStandaloneApp {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ThreadPoolTaskExecutorConfig.class);
		ctx.scan(SpringStandaloneApp.class.getPackage().getName());
		ctx.refresh();
		System.err.println("refreshed");

		for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
			System.err.println(beanDefinitionName);
		}

		Thread.sleep(1_000);
		System.err.println("stopping");
		ctx.close();
		System.err.println("stopped");
	}

}
