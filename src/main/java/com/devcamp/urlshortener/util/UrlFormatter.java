package com.devcamp.urlshortener.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlFormatter {
	@Value("${server.port}")
	private String port;

	@Value("${server.host}")
	private String host;

	public String format(String encoded) {
		return "http://" + host + ":" + port + "/" + encoded;
	}
}
