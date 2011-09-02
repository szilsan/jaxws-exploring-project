package com.ftl.learning.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WsRouteBuilder extends RouteBuilder {

	String WS_URI = "cxf://http://localhost:8080/jaxws/testService?serviceClass=com.example.customerservice&dataFormat=MESSAGE";

	private static Logger logger = LoggerFactory.getLogger(WsRouteBuilder.class);

	@Override
	public void configure() throws Exception {
		getContext().setTracing(true);
		errorHandler(deadLetterChannel("mock:error"));
		from("jetty://http://localhost:9080/jaxws/testService"). // honnan
				to("log:input"). // log request
				process(new Processor() { // do something
					@Override
					public void process(Exchange exchange) throws Exception {
						logger.debug("");
					}
				}).to("http://localhost:8080/jaxws/testService?bridgeEndpoint=true"). // call real ws
				to("log:output"); // log response
	}
}
