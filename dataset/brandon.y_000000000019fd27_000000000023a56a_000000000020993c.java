import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution {
	// https://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
	static boolean checkDuplicatesWithinK(int arr[], int k) { 
		// Creates an empty hashset 
		HashSet<Integer> set = new HashSet<>(); 
  
		// Traverse the input array 
		for (int i=0; i<arr.length; i++) 
		{ 
			// If already present n hash, then we found  
			// a duplicate within k distance 
			if (set.contains(arr[i])) 
			   return true; 
  
			// Add this item to hashset 
			set.add(arr[i]); 
  
			// Remove the k+1 distant item 
			if (i >= k) 
			  set.remove(arr[i-k]); 
		} 
		return false; 
	}

	// https://stackoverflow.com/questions/44433489/switch-rows-and-columns-2d-array
	private static int[][] swapMatrix(int[][] pField) {
		int originalTotalRows = pField.length;
		int originalTotalColumns = pField[0].length;

		int[][] newMatrix = new int[originalTotalColumns][originalTotalRows];

		for(int i=0; i< originalTotalRows; i++){
		    for(int j=0; j < originalTotalColumns; j++){
			newMatrix[j][i] = pField[i][j];
		    }
		}
		return newMatrix;
	    }

	public static void main (String[] args) {
		boolean debug = false;
		// ArrayList matrix = new ArrayList ();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();	// Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int trace = 0;
			int rowRepeatCount = 0;
			int colRepeatCount = 0;
			int tt = in.nextInt();
			int[][] matrix = new int[tt][tt];

			// Iterate through each column
			for (int j = 0; j < tt; j++) {
				boolean match = false;

				// Iterate through a row
				for (int k = 0; k < tt; k++) {
					boolean rowRepeat = false;
					matrix[j][k] = in.nextInt();

					// Trace
					if (j == k) {
						trace += matrix[j][k];
					}
				}

				// Check for Row Repeats
				match = checkDuplicatesWithinK(matrix[j], tt);
				rowRepeatCount += match ? 1 : 0;
			}

			// Check for Column Repeats
			int[][] swapped = swapMatrix(matrix);
			for (int j = 0; j < tt; j++) {
				boolean match = false;
				match = checkDuplicatesWithinK(swapped[j], tt);
				colRepeatCount += match ? 1 : 0;
			}

			// System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
			if (debug) {
				System.out.println(Arrays.deepToString(matrix));
				System.out.println(Arrays.deepToString(swapped));
			}
			System.out.println("Case #" + i + ": " + trace + " " + rowRepeatCount + " " + colRepeatCount);
		}
	}
}
