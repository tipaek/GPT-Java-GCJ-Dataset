import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    
	    int numCases = in.nextInt();
	    int[] sums = new int[numCases];
	    int[] rows = new int[numCases];
	    int[] cols = new int[numCases];
	    
	    for(int i = 0; i < numCases; i++) {
	    	int numRows = in.nextInt();
	    	int[][] arr = new int[numRows][numRows];
	    	int[][] arr_t = new int[numRows][numRows];
	    	for(int j=0; j<numRows; j++) {
	    		for(int k=0; k<numRows;k++) {
	    			arr[j][k] = in.nextInt();
	    			arr_t[k][j] = arr[j][k]; 
	    			if(j==k)
	    				sums[i]+=arr[j][k];
	    		}
	    	}
	    	for(int j=0; j<numRows; j++) {
    			if(hasDuplicates(arr[j])) {
    				rows[i]++;
    			}
    			if(hasDuplicates(arr_t[j])) {
    				cols[i]++;
    			}
	    	}
	    } 
	    
	    for(int i = 0; i < numCases; i++) {
	    	System.out.println(sums[i] + " " + rows[i] + " " + cols[i]);
	    }
	    in.close();
	}
	
	public static boolean hasDuplicates(int[] arr) {
		HashMap<Integer, Integer> counts = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(!counts.containsKey(arr[i])) {
				counts.put(arr[i], 0);
			} else {
				return true;
			}
		}
		return false;
	}
}
