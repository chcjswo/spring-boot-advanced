package me.mocadev.springbootadvanced.app.v1;

import lombok.RequiredArgsConstructor;
import me.mocadev.springbootadvanced.trace.TraceStatus;
import me.mocadev.springbootadvanced.trace.hellotrace.HelloTraceV1;
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
public class OrderServiceV1 {

	private final OrderRepositoryV1 orderRepositoryV1;
	private final HelloTraceV1 trace;

	public void orderItem(String itemId) {
		final TraceStatus status = trace.begin("OrderServiceV1.orderItem()");
		try {
			orderRepositoryV1.save(itemId);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}

}
