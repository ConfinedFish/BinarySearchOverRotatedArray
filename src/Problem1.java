import java.util.Arrays;
import java.util.Collections;

@SuppressWarnings("ALL")
public class Problem1 {
	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		// must be in sorted order, allowing rotation, and contain no duplicates

		for (int i = 0; i < arr.length; i++) {
			System.out.print(Arrays.toString(arr));
			int maxIndex = findMax(arr);
			System.out.println(" Max is " + arr[maxIndex] + " at " + maxIndex);
			Collections.rotate(Arrays.asList(arr), 1);
		}
	}
	private static int findMax(Integer[] arr){
//		int low = 0;
//		int high = arr.length - 1;
//		if (arr[low] < arr[high])
//			return high;
//		while (low < high) {
//			int mid = (low + high) >>> 1;
//			if (arr[low] < arr[mid]) {
//				low = mid;
//			} else {
//				high = mid;
//			}
//		}
//
//		return low;
		return 0;
	}
}
