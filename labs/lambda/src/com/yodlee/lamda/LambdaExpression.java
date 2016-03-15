package com.yodlee.lamda;

import java.util.Arrays;
import java.util.List;

public class LambdaExpression {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		// final int sum = 0;
		numbers.forEach(e -> {
			System.out.println(e);
		});
	}
}
