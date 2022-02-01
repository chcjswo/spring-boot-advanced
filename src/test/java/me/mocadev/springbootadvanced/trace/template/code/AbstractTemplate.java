package me.mocadev.springbootadvanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-01
 **/
@Slf4j
public abstract class AbstractTemplate {

	public void execute() {
		long startTime = System.currentTimeMillis();
		call();
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime = {}", resultTime);
	}

	protected abstract void call();

}
