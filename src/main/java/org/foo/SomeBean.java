package org.foo;

import java.util.concurrent.ThreadPoolExecutor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class SomeBean {

	private final ThreadPoolExecutor executor;

	public SomeBean(@Autowired ThreadPoolTaskExecutor taskExecutor) {
		this.executor = taskExecutor.getThreadPoolExecutor();
	}

	public void doIt() {
		executor.submit(() -> {
			System.err.println("background task BEGIN");
			for (int i = 0; i < 2; i++) {
				try {
					Thread.sleep(10_000);
				} catch (InterruptedException e) {
					System.err.println("interrupted");
				}

			}
			System.err.println("background task END");
		});
	}

	@PostConstruct
	public void aaa() {
		System.err.println("SomeBean");
		doIt();
	}

	@PreDestroy
	public void bbb() throws Exception {
		System.err.println("SomeBean @PreDestroy");
	}

}
