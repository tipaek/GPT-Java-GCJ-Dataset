import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution {
	
	static boolean checkDuplicatesWithinK(int arr[], int k) { 
		
		HashSet<Integer> set = new HashSet<>(); 
  
		
		for (int i=0; i<arr.length; i++) 
		{ 
			
			if (set.contains(arr[i])) 
			   return true; 
  
			 
			set.add(arr[i]); 
  
			
			if (i >= k) 
			  set.remove(arr[i-k]); 
		} 
		return false; 
	}

	
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
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();	
		for (int i = 1; i <= t; ++i) {
			int trace = 0;
			int rowRepeatCount = 0;
			int colRepeatCount = 0;
			int tt = in.nextInt();
			int[][] matrix = new int[tt][tt];

		
			for (int j = 0; j < tt; j++) {
				boolean match = false;

				
				for (int k = 0; k < tt; k++) {
					boolean rowRepeat = false;
					matrix[j][k] = in.nextInt();

					
					if (j == k) {
						trace += matrix[j][k];
					}
				}

				
				match = checkDuplicatesWithinK(matrix[j], tt);
				rowRepeatCount += match ? 1 : 0;
			}

			
			int[][] swapped = swapMatrix(matrix);
			for (int j = 0; j < tt; j++) {
				boolean match = false;
				match = checkDuplicatesWithinK(swapped[j], tt);
				colRepeatCount += match ? 1 : 0;
			}

			if (debug) {
				System.out.println(Arrays.deepToString(matrix));
				System.out.println(Arrays.deepToString(swapped));
			}
			System.out.println("Case #" + i + ": " + trace + " " + rowRepeatCount + " " + colRepeatCount);
		}
	}
}
