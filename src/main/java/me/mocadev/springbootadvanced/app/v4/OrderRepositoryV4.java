package me.mocadev.springbootadvanced.app.v4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;
import me.mocadev.springbootadvanced.trace.template.AbstractTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-02
 **/
@Repository
@RequiredArgsConstructor
@Slf4j
public class OrderRepositoryV4 {

	private final LogTrace trace;

	public void save(String itemId) {
		final AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
			@Override
			protected Void call() {
				if (itemId.equals("ex")) {
					throw new IllegalStateException("예외 발생");
				}
				sleep(1000);
				return null;
			}
		};
		template.execute("OrderRepositoryV4.save()");
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
