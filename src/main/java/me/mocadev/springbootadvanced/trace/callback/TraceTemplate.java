package me.mocadev.springbootadvanced.trace.callback;

import me.mocadev.springbootadvanced.trace.TraceStatus;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-04
 **/
public class TraceTemplate {

	private final LogTrace trace;

	public TraceTemplate(LogTrace trace) {
		this.trace = trace;
	}

	public <T> T execute(String message, TraceCallback<T> traceCallback) {
		TraceStatus status = null;
		try {
			status = trace.begin(message);

			final T result = traceCallback.call();

			trace.end(status);
			return result;
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}

}
