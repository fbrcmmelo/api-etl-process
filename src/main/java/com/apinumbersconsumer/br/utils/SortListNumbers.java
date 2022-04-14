package com.apinumbersconsumer.br.utils;

import java.util.List;
import java.util.Random;

public class SortListNumbers {

	public static List<Double> sortNumbers(List<Double> numbers, int lowerIndex, int higherIndex) {

		if (lowerIndex >= higherIndex) {
			return numbers;
		}
		
		int pivotIndex = new Random().nextInt(higherIndex - lowerIndex) + lowerIndex;
		Double pivot = numbers.get(pivotIndex);

		try {
			
			swap(numbers, pivotIndex, higherIndex);
			int leftPointer = partition(numbers, lowerIndex, higherIndex, pivot);
			sortNumbers(numbers, lowerIndex, leftPointer - 1);
			sortNumbers(numbers, leftPointer + 1, higherIndex);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return numbers;
	}

	private static int partition(List<Double> numbers, int lowerIndex, int higherIndex, Double pivot) {
		int leftPointer = lowerIndex;
		int rightPonter = higherIndex;

		while (leftPointer < rightPonter) {

			while (numbers.get(leftPointer) <= pivot && leftPointer < rightPonter) {
				leftPointer++;
			}

			while (numbers.get(rightPonter) >= pivot && leftPointer < rightPonter) {
				rightPonter--;
			}

			swap(numbers, leftPointer, rightPonter);

		}

		swap(numbers, leftPointer, higherIndex);
		return leftPointer;
	}

	private static void swap(List<Double> numbers, int index1, int index2) {
		Double temp = numbers.get(index1);
		numbers.set(index1, numbers.get(index2));
		numbers.set(index2, temp);
	}

}
