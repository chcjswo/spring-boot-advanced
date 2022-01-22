package me.mocadev.springbootadvanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-01-22
 **/
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

	public void save(String itemId) {
		if (itemId.equals("ex")) {
			throw new IllegalStateException("예외 발생");
		}
		sleep(1000);
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
