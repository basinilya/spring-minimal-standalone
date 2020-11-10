package org.foo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeBean {

	public SomeBean(@Autowired Some some) {
		some.doSomething();
	}

}
