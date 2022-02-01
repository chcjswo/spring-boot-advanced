package me.mocadev.springbootadvanced.trace.template;

import me.mocadev.springbootadvanced.trace.TraceStatus;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-01
 **/
public abstract class AbstractTemplate<T> {

	private final LogTrace trace;

	protected AbstractTemplate(LogTrace trace) {
		this.trace = trace;
	}

	public T execute(String message) {
		TraceStatus status = null;
		try {
			status = trace.begin(message);

			final T result = call();

			trace.end(status);
			return result;
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}

	protected abstract T call();

}
