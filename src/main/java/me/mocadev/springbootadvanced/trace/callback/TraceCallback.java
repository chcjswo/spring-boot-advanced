package me.mocadev.springbootadvanced.trace.callback;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-04
 **/
public interface TraceCallback<T> {

	T call();

}
