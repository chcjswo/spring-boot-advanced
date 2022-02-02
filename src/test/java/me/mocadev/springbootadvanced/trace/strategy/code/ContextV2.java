package me.mocadev.springbootadvanced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-03
 **/
@Slf4j
public class ContextV2 {

	public void execute(Strategy strategy) {
		long startTime = System.currentTimeMillis();
		strategy.call();
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime = {}", resultTime);
	}

}
