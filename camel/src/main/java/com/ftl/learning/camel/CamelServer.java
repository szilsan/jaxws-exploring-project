package com.ftl.learning.camel;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Main;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelServer {
	private Main main;

	public static void main(String[] args) throws Exception {
		CamelServer example = new CamelServer();
		example.boot();
	}

	public void boot() throws Exception {
		// create a Main instance
		main = new Main();
		// enable hangup support so you can press ctrl + c to terminate the JVM
		main.enableHangupSupport();

		// add routes
		// main.addRouteBuilder(new MyRouteBuilder());
		main.addRouteBuilder(new WsRouteBuilder());

		// run until you terminate the JVM
		System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
		main.run();
	}

	private static class MyRouteBuilder extends RouteBuilder {
		@Override
		public void configure() throws Exception {
			from("timer:foo?delay=10000").process(new Processor() {
				public void process(Exchange exchange) throws Exception {
					System.out.println("Invoked timer at " + new Date());
				}
			});
		}
	}

}
