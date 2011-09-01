package com.ftl.learning.camel;

import org.apache.camel.builder.RouteBuilder;

public class WsRouteBuilder extends RouteBuilder {

	String WS_URI = "cxf://http://localhost:8080/jaxws/testService?serviceClass=com.example.customerservice&dataFormat=MESSAGE";

	@Override
	public void configure() throws Exception {
		getContext().setTracing(true);
		errorHandler(deadLetterChannel("mock:error"));
		from("jetty://http://localhost:9080/jaxws/testService"). // honnan
				to("log:input"). // log request
				to("http://localhost:8080/jaxws/testService?bridgeEndpoint=true"). // call real ws
				to("log:output"); // log response
	}
}
