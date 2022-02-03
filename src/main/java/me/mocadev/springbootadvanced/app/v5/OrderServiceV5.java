package me.mocadev.springbootadvanced.app.v5;

import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.callback.TraceTemplate;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-05
 **/
@Service
@Slf4j
public class OrderServiceV5 {

	private final OrderRepositoryV5 orderRepositoryV5;
	private final TraceTemplate traceTemplate;

	public OrderServiceV5(OrderRepositoryV5 orderRepositoryV5,
							 LogTrace trace) {
		this.orderRepositoryV5 = orderRepositoryV5;
		this.traceTemplate = new TraceTemplate(trace);
	}

	public void orderItem(String itemId) {
		traceTemplate.execute("OrderServiceV5.orderItem()", () -> {
			orderRepositoryV5.save(itemId);
			return null;
		});
	}

}
