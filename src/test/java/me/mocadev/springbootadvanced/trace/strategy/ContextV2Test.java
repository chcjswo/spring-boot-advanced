package me.mocadev.springbootadvanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.strategy.code.ContextV2;
import me.mocadev.springbootadvanced.trace.strategy.code.StrategyLogic1;
import me.mocadev.springbootadvanced.trace.strategy.code.StrategyLogic2;
import org.junit.jupiter.api.Test;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-03
 **/
@Slf4j
public class ContextV2Test {

	@Test
	void strategyTest() {
		final ContextV2 context = new ContextV2();
		context.execute(new StrategyLogic1());
		context.execute(new StrategyLogic2());
	}

	@Test
	void strategy2Test() {
		final ContextV2 context = new ContextV2();
		context.execute(() -> log.info("비즈니스 로직1"));
		context.execute(() -> log.info("비즈니스 로직2"));
	}

}
