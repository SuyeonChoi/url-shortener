package com.devcamp.urlshortener.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import com.devcamp.urlshortener.domain.Url;

import lombok.Getter;

@Getter
public class UrlRequest {
	@URL
	@NotBlank
	private String originUrl;

	public Url toUrl() {
		return Url.builder()
			.originUrl(originUrl)
			.build();
	}
}
