package me.mocadev.springbootadvanced.app.v4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;
import me.mocadev.springbootadvanced.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-02
 **/
@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderControllerV4 {

	private final OrderServiceV4 orderServiceV4;
	private final LogTrace trace;

	@GetMapping("/v4/request")
	public String request(String itemId) {
		final AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
			@Override
			protected String call() {
				orderServiceV4.orderItem(itemId);
				return "ok";
			}
		};
		return template.execute("OrderControllerV4.request()");
	}
}
