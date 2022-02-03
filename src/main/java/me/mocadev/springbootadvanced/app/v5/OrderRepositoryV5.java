package me.mocadev.springbootadvanced.app.v5;

import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.callback.TraceTemplate;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-05
 **/
@Repository
@Slf4j
public class OrderRepositoryV5 {

	private final TraceTemplate traceTemplate;

	public OrderRepositoryV5(LogTrace trace) {
		this.traceTemplate = new TraceTemplate(trace);
	}

	public void save(String itemId) {
		traceTemplate.execute("OrderRepositoryV5.save()", () -> {
			if (itemId.equals("ex")) {
				throw new IllegalStateException("예외 발생");
			}
			sleep(1000);
			return null;
		});
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
