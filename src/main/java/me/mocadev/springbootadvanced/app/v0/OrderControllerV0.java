package me.mocadev.springbootadvanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-01-23
 **/
@RestController
@RequiredArgsConstructor
public class OrderControllerV0 {

	private final OrderServiceV0 orderServiceV0;

	@GetMapping("/v0/request")
	public String request(String itemId) {
		orderServiceV0.orderItem(itemId);
		return "ok";
	}
}
