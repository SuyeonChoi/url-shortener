package com.devcamp.urlshortener.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devcamp.urlshortener.service.UrlService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

	private final UrlService urlService;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/{shorten}")
	public void redirect(@PathVariable(value = "shorten") String shorten, HttpServletResponse httpServletResponse)
		throws IOException {
		String originUrl = urlService.restoreUrl(shorten);
		log.info("[origin URL] " + originUrl);
		httpServletResponse.sendRedirect(originUrl);
	}

}
