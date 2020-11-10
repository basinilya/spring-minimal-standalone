package org.foo;

public class SomeImpl implements Some {

	@Override
	public String doSomething(String param) {
		System.err.println("doSomething: " + param);
		return "testret";
	}

}
