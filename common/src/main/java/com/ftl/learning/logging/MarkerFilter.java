package com.ftl.learning.logging;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;

public class MarkerFilter extends AbstractMatcherFilter {

	Marker markerToMatch;

	@Override
	public FilterReply decide(Object event) {
		Marker marker = ((LoggingEvent) event).getMarker();

		if (marker == null) {
			return onMismatch;
		}

		if (markerToMatch.contains(marker)) {
			return onMatch;
		}

		return onMismatch;
	}

	public void setMarker(String markerStr) {
		if (markerStr != null) {
			markerToMatch = MarkerFactory.getMarker(markerStr);
		}
	}

}
