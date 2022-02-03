package me.mocadev.springbootadvanced.trace.strategy.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-04
 **/
@Slf4j
public class TimeLogTemplate {

	public void execute(Callback callback) {
		long startTime = System.currentTimeMillis();
		callback.call();
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime = {}", resultTime);
	}

}
