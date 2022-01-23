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
class HelloTraceV2Test {

	@Test
	void begin_end() {
		final HelloTraceV2 trace = new HelloTraceV2();
		final TraceStatus status1 = trace.begin("hello");
		final TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
		trace.end(status2);
		trace.end(status1);
	}

	@Test
	void begin_exception() {
		final HelloTraceV2 trace = new HelloTraceV2();
		final TraceStatus status1 = trace.begin("hello");
		final TraceStatus status2 = trace.beginSync(status1.getTraceId(),  "hello");
		trace.exception(status2, new IllegalStateException("exception"));
		trace.exception(status1, new IllegalStateException("exception"));
	}

}
