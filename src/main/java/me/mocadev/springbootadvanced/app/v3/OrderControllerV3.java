package me.mocadev.springbootadvanced.app.v3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.TraceStatus;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;
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
@Slf4j
public class OrderControllerV3 {

	private final OrderServiceV3 orderServiceV3;
	private final LogTrace trace;

	@GetMapping("/v3/request")
	public String request(String itemId) {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderControllerV3.request()");
			orderServiceV3.orderItem(itemId);
			trace.end(status);
			return "ok";
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}
}
