package com.apinumbersconsumer.br.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apinumbersconsumer.br.service.NumbersService;
import com.apinumbersconsumer.br.utils.SortListNumbers;

@RestController
@RequestMapping("/api")
public class ApiConsumerController {

	@Autowired
	private NumbersService numbersService;

	@GetMapping("/numbers")
	public ResponseEntity<List<Double>> getNumbersPages() throws Exception {

		int page = 1;
//		Numbers numbers = new Numbers();
		List<Double> numbersList = new ArrayList<>();
		numbersList = numbersService.getNumbersPages(page);

		if (!numbersList.isEmpty()) {
			List<Double> numbersListOneSorted = SortListNumbers.sortNumbers(numbersList, 0, numbersList.size() - 1);
			return ResponseEntity.ok(numbersListOneSorted);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
