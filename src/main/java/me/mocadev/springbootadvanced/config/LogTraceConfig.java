package me.mocadev.springbootadvanced.config;

import me.mocadev.springbootadvanced.trace.logtrace.FieldLogTrace;
import me.mocadev.springbootadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-01-24
 **/
@Configuration
public class LogTraceConfig {

	@Bean
	public LogTrace logTrace() {
		return new FieldLogTrace();
	}

}
