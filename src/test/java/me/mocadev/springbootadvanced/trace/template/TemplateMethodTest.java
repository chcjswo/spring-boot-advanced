package me.mocadev.springbootadvanced.trace.template;

import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.template.code.AbstractTemplate;
import me.mocadev.springbootadvanced.trace.template.code.SubClassLogic1;
import me.mocadev.springbootadvanced.trace.template.code.SubClassLogic2;
import org.junit.jupiter.api.Test;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-02-01
 **/
@Slf4j
public class TemplateMethodTest {

	@Test
	void test() {
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
	void templateMethodV1() {
		AbstractTemplate template1 = new SubClassLogic1();
		template1.execute();;
		AbstractTemplate template2 = new SubClassLogic2();
		template2.execute();;
	}

}
