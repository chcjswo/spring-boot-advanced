package me.mocadev.springbootadvanced.trace.logtrace;

import me.mocadev.springbootadvanced.trace.TraceStatus;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-01-24
 **/
public interface LogTrace {

	TraceStatus begin(String message);
	void end(TraceStatus status);
	void exception(TraceStatus status, Exception e);

}
