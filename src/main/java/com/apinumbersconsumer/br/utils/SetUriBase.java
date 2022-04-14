package com.apinumbersconsumer.br.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class SetUriBase {

	public static UriComponents setUriWithPage(Integer page) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("challenge.dienekes.com.br")
				.path("api/numbers")
				.queryParam("page", page)
				.build();
		return uri;
	}
}
