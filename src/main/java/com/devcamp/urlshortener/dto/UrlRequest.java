package com.devcamp.urlshortener.dto;

import org.hibernate.validator.constraints.URL;

import com.devcamp.urlshortener.domain.Url;

import lombok.Getter;

@Getter
public class UrlRequest {
	private String originUrl;

	public Url toUrl() {
		return Url.builder()
			.originUrl(originUrl)
			.build();
	}
}
