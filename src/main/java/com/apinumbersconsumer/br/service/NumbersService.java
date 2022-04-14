package com.apinumbersconsumer.br.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import com.apinumbersconsumer.br.model.Numbers;
import com.apinumbersconsumer.br.utils.GetUriNumberPage;
import com.apinumbersconsumer.br.utils.SetUriBase;

@Service
public class NumbersService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Double> getNumbersPages(Integer page) {
		UriComponents uri = null;
		Numbers numbers = null;
		List<Double> allNumbersPages = new ArrayList<Double>();
		
		do {
		try {
			uri = SetUriBase.setUriWithPage(page);
			numbers = GetUriNumberPage.getNumberWithUriAndPage(uri, restTemplate);
			allNumbersPages.addAll(numbers.getNumbers());
			page++;
		} catch (Exception e) {
			System.out.println("Service Error: " + e.getMessage());
			e.printStackTrace();
		}
		} while (!numbers.getNumbers().isEmpty());

		return allNumbersPages;
	}
//
//	public Numbers getNumbersPage(Integer page) {
//
//		UriComponents uri = setUriBase.setUriWithPage(page);
//		Numbers numbers = getUriNumberPage.getNumberWithUriAndPage(uri, restTemplate);
//
//		return numbers;
//	}
}
