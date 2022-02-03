package me.mocadev.springbootadvanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.strategy.template.Callback;
import me.mocadev.springbootadvanced.trace.strategy.template.TimeLogTemplate;
import org.junit.jupiter.api.Test;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-04
 **/
@Slf4j
public class TemplateCallbackTest {

	@Test
	void callbackV1() {
		TimeLogTemplate template = new TimeLogTemplate();
		template.execute(new Callback() {
			@Override
			public void call() {
				log.info("비즈니스 로직1 실행");
			}
		});
		template.execute(new Callback() {
			@Override
			public void call() {
				log.info("비즈니스 로직2 실행");
			}
		});
	}

	@Test
	void callbackV2() {
		TimeLogTemplate template = new TimeLogTemplate();
		template.execute(() -> log.info("비즈니스 로직1 실행"));
		template.execute(() -> log.info("비즈니스 로직2 실행"));
	}

}
