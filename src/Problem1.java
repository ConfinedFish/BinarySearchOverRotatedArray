import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("ALL")
public class Problem1 {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < 5090; i++){
			arr.add(i);
		}
		Integer[] intarr = new Integer[arr.size()];
		intarr = arr.toArray(intarr);
		int missingIndex = findMissing(intarr);
		System.out.println("Missing number is " + missingIndex);
	}
	
	private static int findMissing(Integer[] arr){
		int first, middle, last;
		first = 0;
		last = arr.length - 1;
		middle = (first + last)/2;
		
		while (first < last) {
			if ((arr[middle] - arr[first]) != (middle - first)) {
				/* there is a hole in the first half */
				if ((middle - first) == 1 && (arr[middle] - arr[first] > 1)) {
					return (arr[middle] - 1);
				}
				
				last = middle;
			} else if ((arr[last] - arr[middle]) != (last - middle)) {
				/* there is a hole in the second half */
				if ((last - middle) == 1 && (arr[last] - arr[middle] > 1)) {
					return (arr[middle] + 1);
				}
				
				first = middle;
			} else {
				/* there is no hole */
				return -1;
			}
			
			middle = (first + last)/2;
		}
		
		/* there is no hole */
		return -1;
	}
}
