package sortElementary;

import java.util.Random;

public class TestElementarySorts {
	private static Random rand = new Random();
	
	public static Integer[] randomArray(int from, int to, int numberOfElements) {
		Integer[] numbers = new Integer[numberOfElements];
		
		for (int i = 0; i < numberOfElements; i++) {
			numbers[i] = rand.nextInt(to - from) + from;
		}
		
		return numbers;
	}

}
