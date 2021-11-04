package com.devcamp.urlshortener.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.urlshortener.dto.UrlRequest;
import com.devcamp.urlshortener.service.UrlService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/shorten")
@RestController
public class UrlController {

	private final UrlService urlService;

	@PostMapping
	public ResponseEntity<String> shortenUrl(@RequestBody @Valid UrlRequest urlRequest) {
		String response = urlService.shortenUrl(urlRequest);
		log.info("[encoded URL] " + response);

		return ResponseEntity.ok(response);
	}
}
