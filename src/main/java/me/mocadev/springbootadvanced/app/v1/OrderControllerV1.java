package me.mocadev.springbootadvanced.app.v1;

import lombok.RequiredArgsConstructor;
import me.mocadev.springbootadvanced.trace.TraceStatus;
import me.mocadev.springbootadvanced.trace.hellotrace.HelloTraceV1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-01-23
 **/
@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

	private final OrderServiceV1 orderServiceV1;
	private final HelloTraceV1 trace;

	@GetMapping("/v1/request")
	public String request(String itemId) {
		final TraceStatus status = trace.begin("OrderControllerV1.request()");
		try {
			orderServiceV1.orderItem(itemId);
			trace.end(status);
			return "ok";
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}
}
