package me.mocadev.springbootadvanced.trace.hellotrace;

import me.mocadev.springbootadvanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-01-23
 **/
class HelloTraceV1Test {

	@Test
	void begin_end() {
		final HelloTraceV1 trace = new HelloTraceV1();
		final TraceStatus status = trace.begin("hello");
		trace.end(status);
	}

	@Test
	void begin_exception() {
		final HelloTraceV1 trace = new HelloTraceV1();
		final TraceStatus status = trace.begin("hello");
		trace.exception(status, new IllegalStateException("exception"));
	}

}
