package me.mocadev.springbootadvanced.app.v4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;
import me.mocadev.springbootadvanced.trace.template.AbstractTemplate;
import org.springframework.stereotype.Service;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-02
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceV4 {

	private final OrderRepositoryV4 orderRepositoryV4;
	private final LogTrace trace;

	public void orderItem(String itemId) {
		final AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
			@Override
			protected Void call() {
				orderRepositoryV4.save(itemId);
				return null;
			}
		};
		template.execute("OrderServiceV4.orderItem()");
	}

}
