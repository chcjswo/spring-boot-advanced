package me.mocadev.springbootadvanced.app.v5;

import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.callback.TraceCallback;
import me.mocadev.springbootadvanced.trace.callback.TraceTemplate;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-04
 **/
@RestController
@Slf4j
public class OrderControllerV5 {

	private final OrderServiceV5 orderServiceV5;
	private final TraceTemplate traceTemplate;

	public OrderControllerV5(OrderServiceV5 orderServiceV5,
							 LogTrace trace) {
		this.orderServiceV5 = orderServiceV5;
		this.traceTemplate = new TraceTemplate(trace);
	}

	@GetMapping("/v5/request")
	public String request(String itemId) {
		return traceTemplate.execute("OrderControllerV5.request()", new TraceCallback<>() {
			@Override
			public String call() {
				orderServiceV5.orderItem(itemId);
				return "ok";
			}
		});
	}
}
