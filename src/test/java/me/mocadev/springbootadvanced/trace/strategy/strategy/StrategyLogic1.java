package me.mocadev.springbootadvanced.trace.strategy.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-02
 **/
@Slf4j
public class StrategyLogic1 implements Strategy {

	@Override
	public void call() {
		log.info("비즈니스 로직1");
	}

}
