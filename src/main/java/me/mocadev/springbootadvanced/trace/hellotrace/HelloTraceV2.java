package me.mocadev.springbootadvanced.trace.hellotrace;

import lombok.extern.slf4j.Slf4j;
import me.mocadev.springbootadvanced.trace.TraceId;
import me.mocadev.springbootadvanced.trace.TraceStatus;
import org.springframework.stereotype.Component;

/**
 * @author chcjswo
 * @version 1.0.0
 * @blog https://mocadev.tistory.com
 * @github https://github.com/chcjswo
 * @since 2022-01-23
 **/
@Slf4j
@Component
public class HelloTraceV2 {

	private static final String START_PREFIX = "-->";
	private static final String COMPLETE_PREFIX = "<--";
	private static final String EX_PREFIX = "<X-";

	public TraceStatus begin(String message) {
		TraceId traceId = new TraceId();
		final long startTimeMs = System.currentTimeMillis();
		log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
		return new TraceStatus(traceId, startTimeMs, message);
	}

	public TraceStatus beginSync(TraceId beforeTraceId, String message) {
		TraceId nextId = beforeTraceId.createNextId();
		final long startTimeMs = System.currentTimeMillis();
		log.info("[{}] {}{}", nextId.getId(), addSpace(START_PREFIX, nextId.getLevel()), message);
		return new TraceStatus(nextId, startTimeMs, message);
	}

	public void end(TraceStatus status) {
		complete(status, null);
	}

	public void exception(TraceStatus status, Exception e) {
		complete(status, e);
	}

	private void complete(TraceStatus status, Exception e) {
		Long stopTimeMs = System.currentTimeMillis();
		long resultTimeMs = stopTimeMs - status.getStartTimeMs();
		TraceId traceId = status.getTraceId();
		if (e == null) {
			log.info("[{}] {}{} time={}ms", traceId.getId(),
				addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs);
		} else {
			log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
				addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
				e.toString());
		}
	}

	private static String addSpace(String prefix, int level) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < level; i++) {
			sb.append((i == level - 1) ? "|" + prefix : "|   ");
		}

		return sb.toString();

	}

}
