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
public class SubClassLogic1 extends AbstractTemplate {

	@Override
	protected void call() {
		log.info("비즈니스 로직1 실행");
	}

}
