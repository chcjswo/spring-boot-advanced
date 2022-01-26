package me.mocadev.springbootadvanced.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.threadlocal.code.ThreadLocalService;
import org.junit.jupiter.api.Test;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-01-26
 **/
@Slf4j
public class ThreadLocalServiceTest {

	private final ThreadLocalService service = new ThreadLocalService();

	@Test
	void threadLocal() {
		log.info("main start");
		Runnable userA = () -> service.logic("userA");
		Runnable userB = () -> service.logic("userB");

		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");
		Thread threadB = new Thread(userB);
		threadB.setName("thread-B");

		threadA.start();
		sleep(100);
		threadB.start();
		sleep(2000);
		log.info("main exit");
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
