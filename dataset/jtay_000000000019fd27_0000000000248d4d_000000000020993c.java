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

    public static void main(String []args){
       Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
       int input = in.nextInt();
	    for (int i = 0; i < input; ++i) {
			int t = 0;
			int r = 0;
			int c = 0;
			int dimensions = in.nextInt();
			int[][] arr = new int[dimensions][dimensions];

			for (int j = 0; j < dimensions; j++) {
				boolean match = false;
				for (int k = 0; k < dimensions; k++) {
					boolean rowRepeat = false;
					arr[j][k] = in.nextInt();

					if (j == k) {
						t += arr[j][k];
					}
				}
				match = checkDuplicatesWithinK(arr[j], dimensions);
				if (match) {
				    r++;
				}
			}

			int[][] swapped = swapMatrix(arr);
			for (int j = 0; j < dimensions; j++) {
				boolean match = false;
				match = checkDuplicatesWithinK(swapped[j], dimensions);
				if (match) {
				    c++;
				}
			}
			
			System.out.println("Case #" + (i + 1) + ": " + t + " " + r + " " + c);
		}
    }
    
}