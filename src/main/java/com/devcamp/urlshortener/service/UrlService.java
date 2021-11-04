package com.devcamp.urlshortener.service;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devcamp.urlshortener.domain.Url;
import com.devcamp.urlshortener.domain.UrlRepository;
import com.devcamp.urlshortener.dto.UrlRequest;
import com.devcamp.urlshortener.util.Base62;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UrlService {

	private final UrlRepository urlRepository;
	private final Base62 base62;

	public String shortenUrl(UrlRequest urlRequest) {
		int id = Optional.ofNullable(urlRepository.findByOriginUrl(urlRequest.getOriginUrl()))
			.map(Url::getId)
			.orElseGet(() -> save(urlRequest));

		return base62.encode(id);
	}

	public int save(UrlRequest urlRequest) {
		Url url = urlRequest.toUrl();
		urlRepository.save(url);

		return url.getId();
	}
}
