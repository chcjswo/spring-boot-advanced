package me.mocadev.springbootadvanced.app.v3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.TraceStatus;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-01-23
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceV3 {

	private final OrderRepositoryV3 orderRepositoryV3;
	private final LogTrace trace;

	public void orderItem(String itemId) {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderServiceV3.orderItem()");
			orderRepositoryV3.save(itemId);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}

}
