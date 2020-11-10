package org.foo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class SpringStandaloneAppConfig {
	public SpringStandaloneAppConfig() {
		System.err.println("SpringStandaloneAppConfig");
	}

	@Bean
	public Some getSome() {
		return new SomeImpl();
	}
}
