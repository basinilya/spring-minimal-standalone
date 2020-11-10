package org.foo;

import org.springframework.stereotype.Repository;

@Repository
public class SomeImpl implements Some {

	@Override
	public String notIntercepted(String param, String param2) {
		return null;
	}

	@Override
	public String doSomething(String param1, String param2) {
		System.err.println("doSomething: " + param1);
		return "testret";
	}

}
