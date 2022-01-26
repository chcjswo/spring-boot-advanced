package me.mocadev.springbootadvanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-01-26
 **/
@Slf4j
public class FieldService {

	private String nameStore;

	public String logic(String name) {
		log.info("저장 name = {} -> nameStore = {}", name, nameStore);
		nameStore = name;
		sleep(1000);
		log.info("조회 nameStore = {}", nameStore);
		return nameStore;
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
