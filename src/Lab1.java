import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("ALL")
public class Lab1 {
	
	/**
	 * Problem 1: Finds the largest number in a sorted but shifted array in O(log n) time.
	 */
	private static int problem1(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		if (arr[low] < arr[high])
			return arr[high];
		while (low < high) {
			int mid = (low + high) >>> 1;
			if (arr[low] < arr[mid]) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return arr[low];
	}
	
	/**
	 * Problem 2: Finds the smallest missing number in a sorted array in O(log n) time.
	 */
	private static int problem2(int[] arr) {
		if (arr[0] != 0)
			return 0;
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if ((arr[mid] - arr[start]) != (mid - start)) {
				if ((mid - start) == 1 && (arr[mid] - arr[start] > 1))
					return (mid);
				end = mid;
			} else if ((arr[end] - arr[mid]) != (end - mid)) {
				if ((end - mid) == 1 && (arr[end] - arr[mid] > 1))
					return (mid + 1);
				start = mid;
			} else
				return arr.length;
		}
		return arr.length;
	}
	
	// ---------------------------------------------------------------------
	// Do not change any of the code below!
	
	private static final int LabNo = 1;
	private static final String quarter = "Winter 2019";
	
	private static final Random rng = new Random(866298);
	
	public static void main(String args[]) {
		System.out.println("CS 302 -- " + quarter + " -- Lab " + LabNo);
		
		testProblems(1);
		testProblems(2);
	}
	
	private static void testProblems(int prob) {
		int result = 0;
		int solution = 0;
		int noOfLines = 1000000;
		
		System.out.println("-- -- -- -- --");
		System.out.println(noOfLines + " test cases from file for problem " + prob + ".");
		
		boolean passedAll = true;
		
		for (int i = 1; i <= noOfLines; i++) {
			boolean passed = false;
			boolean exce = false;
			
			try {
				int[][] line = null;
				
				switch (prob) {
					case 1:
						line = createProblem1();
						break;
					
					case 2:
						line = createProblem2();
						break;
				}
				
				int[] arr = line[0];
				solution = line[1][0];
				
				switch (prob) {
					case 1:
						result = problem1(arr);
						break;
					
					case 2:
						result = problem2(arr);
						break;
				}
				
				passed = (result == solution);
			} catch (Exception ex) {
				passed = false;
				exce = true;
			}
			
			if (!passed) {
				System.out.println("Test " + i + " failed! " + solution + " expected but got " + result + (exce ? " (Exception)" : ""));
				passedAll = false;
			}
		}
		
		if (passedAll) {
			System.out.println("All test passed.");
		}
		
	}
	
	private static int[][] createProblem1() {
		int size = rng.nextInt(500) + 1;
		int[] numbers = getRandomNumbers(size);
		
		int negPercent = rng.nextInt(50);
		for (int i = 0; i * 100 < numbers.length * negPercent; i++) {
			numbers[i] *= -1;
		}
		
		Arrays.sort(numbers);
		int max = numbers[size - 1];
		
		// Shifting
		int shift = rng.nextInt(size);
		int[] numShifted = new int[size];
		
		for (int i = 0; i < size; i++) {
			numShifted[i] = numbers[(i + shift) % size];
		}
		
		return new int[][]{numShifted, new int[]{max}};
	}
	
	private static int[][] createProblem2() {
		int size = rng.nextInt(500) + 1;
		int missing = rng.nextInt(size + 1);
		
		int[] numbers = new int[size];
		for (int i = 0; i < missing; i++) {
			numbers[i] = i;
		}
		
		int[] rndNumbers = getRandomNumbers(size + 1);
		Arrays.sort(rndNumbers);
		
		for (int i = missing, j = 0; i < numbers.length; j++) {
			if (rndNumbers[j] <= missing) continue;
			
			numbers[i] = rndNumbers[j];
			i++;
		}
		
		return new int[][]{numbers, new int[]{missing}};
	}
	
	private static int[] getRandomNumbers(int size) {
		int maxSize = size * 10;
		
		int[] integers = new int[maxSize];
		for (int i = 0; i < maxSize; i++) {
			integers[i] = i;
		}
		
		// Shuffle
		for (int i = 0; i < maxSize; i++) {
			int rndInd = rng.nextInt(maxSize - i) + i;
			
			int tmp = integers[i];
			integers[i] = integers[rndInd];
			integers[rndInd] = tmp;
		}
		
		return Arrays.copyOf(integers, size);
	}
}
