package org.foo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@EnableAspectJAutoProxy
@ImportResource("classpath:org/foo/springstandaloneappconfig.xml")
public class SpringStandaloneAppConfig {
	public SpringStandaloneAppConfig() {
		System.err.println("SpringStandaloneAppConfig");
	}

}
