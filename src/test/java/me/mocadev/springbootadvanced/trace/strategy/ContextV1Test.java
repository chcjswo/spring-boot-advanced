package me.mocadev.springbootadvanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.strategy.code.ContextV1;
import me.mocadev.springbootadvanced.trace.strategy.code.StrategyLogic1;
import me.mocadev.springbootadvanced.trace.strategy.code.StrategyLogic2;
import org.junit.jupiter.api.Test;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-02
 **/
@Slf4j
public class ContextV1Test {

	@Test
	void strategyTest() {
		logic1();
		logic2();
	}

	private void logic1() {
		long startTime = System.currentTimeMillis();
		log.info("비즈니스 로직1 실행");
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime = {}", resultTime);
	}

	private void logic2() {
		long startTime = System.currentTimeMillis();
		log.info("비즈니스 로직2 실행");
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime = {}", resultTime);
	}

	@Test
	void strategyV1() {
		final StrategyLogic1 strategyLogic1 = new StrategyLogic1();
		final ContextV1 context1 = new ContextV1(strategyLogic1);
		context1.execute();

		final StrategyLogic2 strategyLogic2 = new StrategyLogic2();
		final ContextV1 context2 = new ContextV1(strategyLogic2);
		context2.execute();
	}

}
