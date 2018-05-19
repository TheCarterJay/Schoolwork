package quickSortCE;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;
import sortElementary.TestElementarySorts;

/**
 * Demonstrates the scalability of the Quick and Selection sorts
 * based on arrays of a specified size and digit length.
 * 
 * @author Carter Timpson
 *
 */
public class DemoSortingPerformance {
	
	public static void main(String[] args) {
		int numberOfIterations = 9;
		int startingArraySize = 500;
		int numberOfDigits = 7;
		final double BILLION = 1000000000d;
		
		StdOut.println("#Elements.. Selection  Quick");
		
		for (int i = 0; i < numberOfIterations; i++) {
			Integer[] numbers1 = getRandomNumberArray(startingArraySize, numberOfDigits);
			Integer[] numbers2 = numbers1.clone();
			startingArraySize *= 2;
			
			long start = System.nanoTime();
			Selection.sort(numbers1);
			long stop = System.nanoTime();
			long duration1 = stop - start;
			
			start = System.nanoTime();
			Quick.sort(numbers2);
			stop = System.nanoTime();
			long duration2 = stop - start;
			
			StdOut.printf("%-8d .. %7.3fs %7.3fs\n",
					startingArraySize, (duration1 / BILLION), (duration2 / BILLION));
		}

	}
	
	/**
	 * Creates an array of the specified sizes and fills it with random numbers.
	 * Each of the array elements has the same number of digits as specified in the
	 * second argument.
	 * 
	 * @param arraySize number of elements in the array
	 * @param numberOfDigits number of digits of the elements
	 * @return
	 */
	private static Integer[] getRandomNumberArray (int arraySize, int numberOfDigits) {
		if (numberOfDigits < 1 || numberOfDigits > 8) {
			throw new IllegalArgumentException("The number of digits needs to be between 1 and 8.");
		}
		int min = (int) Math.pow(10, numberOfDigits - 1);
		int max = (int) Math.pow(10, numberOfDigits);		
		
		return TestElementarySorts.randomArray(min, max, arraySize);
	}

}
