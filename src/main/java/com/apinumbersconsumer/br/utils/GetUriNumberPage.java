package com.apinumbersconsumer.br.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import com.apinumbersconsumer.br.model.Numbers;

@Component
public class GetUriNumberPage {

	public static Numbers getNumberWithUriAndPage(UriComponents uri, RestTemplate restTemplate) {
		Numbers number = restTemplate.getForObject(uri.toString(), Numbers.class);
		return number;
	};
}
