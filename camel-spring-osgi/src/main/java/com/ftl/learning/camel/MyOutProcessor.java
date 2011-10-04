package com.ftl.learning.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyOutProcessor implements Processor {

	private static Logger logger = LoggerFactory.getLogger(MyOutProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.debug("Response is:  " + exchange.getIn());
	}
}
