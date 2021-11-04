package com.devcamp.urlshortener.util;

import org.springframework.stereotype.Component;

@Component
public class Base62 {
	private static final int BASE = 64;
	private static final char[] CODEC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	public String encode(int number) {
		StringBuilder encoded = new StringBuilder();
		while (number > 0) {
			encoded.append(CODEC[number % BASE]);
			number /= BASE;
		}
		return encoded.toString();
	}
}
