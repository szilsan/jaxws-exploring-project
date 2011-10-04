package com.ftl.learning.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyInProcessor implements Processor {

	private static Logger logger = LoggerFactory.getLogger(MyInProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.debug("Request is: " + exchange.getIn());
	}
}
