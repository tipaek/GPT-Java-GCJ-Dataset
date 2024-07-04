
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) throws IOException {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    
	    int numCases = in.nextInt();
	    int[] sums = new int[numCases];
	    int[] rows = new int[numCases];
	    int[] cols = new int[numCases];
	    
	    for(int i = 0; i < numCases; i++) {
	   
	    	int numRows = in.nextInt();
	    	int[][] arr = new int[numRows][numRows];
	    	for(int j=0; j<numRows; j++) {
	    		for(int k=0; k<numRows;k++) {
	    			arr[j][k] = in.nextInt();
	    		}
	    	}
	    	int [][] countRows = new int[numRows][numRows];
	    	int [][] countCols = new int[numRows][numRows];
	    	HashMap<Integer, Boolean> hasMoreRows = new HashMap<>();
	    	HashMap<Integer, Boolean> hasMoreCols = new HashMap<>();
	    	int sum = 0;
	    	for(int j=0; j<numRows; j++) {
	    		for(int k=0; k<numRows;k++) {
	    			int val = arr[j][k];
	    			if(j==k)
	    				sum+=val;
	    			countRows[j][val-1]++; 
	    			countCols[k][val-1]++;
	    			if(countRows[j][val-1]>1 && !hasMoreRows.containsKey(j)) 
	    			{
	    				hasMoreRows.put(j, true);
	    			}
	    			if(countCols[k][val-1]>1 && !hasMoreCols.containsKey(k)) 
	    			{
	    				hasMoreCols.put(k, true);
	    			}
	    		}
	    	}
	    	sums[i] = sum;
	    	rows[i] = hasMoreRows.size();
	    	cols[i] = hasMoreCols.size();
	    }
	    in.close();
	    for(int i = 0; i < numCases; i++) {
	    	System.out.println(sums[i] + " " + rows[i] + " " + cols[i]);
	    }
	}
}