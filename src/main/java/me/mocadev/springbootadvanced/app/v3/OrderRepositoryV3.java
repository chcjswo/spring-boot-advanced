package me.mocadev.springbootadvanced.app.v3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.TraceStatus;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-01-22
 **/
@Repository
@RequiredArgsConstructor
@Slf4j
public class OrderRepositoryV3 {

	private final LogTrace trace;

	public void save(String itemId) {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderRepositoryV3.save()");
			if (itemId.equals("ex")) {
				throw new IllegalStateException("예외 발생");
			}
			sleep(1000);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
