/*
ID: brianch4
LANG: JAVA
TASK: Solution
*/
import java.io.*;
import java.util.*;

class Solution {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

    int numCases = Integer.parseInt(f.readLine()); 

    for(int i = 0; i < numCases; i++) {
    	int n = Integer.parseInt(f.readLine()); 
    	int[][] matrix = new int[n][n]; 
    	for(int j = 0; j < n; j++) {
    		String[] temp = f.readLine().split(" "); 
    		for(int k = 0; k < n; k++) {
    			matrix[j][k]=Integer.parseInt(temp[k]); 
    		}
    	}
    	boolean[] used = new boolean[n]; 
    	Arrays.fill(used,false); 
    	int rowCount = 0; 
    	for(int j = 0; j < matrix.length; j++) {
    		for(int k = 0; k < matrix[0].length; k++) {
    			if(used[matrix[j][k]-1]!=false) 
    			{
    				rowCount++; 
    				break; 
    			}
    			used[matrix[j][k]-1]=true; 
    			
    		}
    		Arrays.fill(used,false); 
    	}

    	Arrays.fill(used,false); 
    	int colCount = 0; 
    	for(int j = 0; j < matrix[0].length; j++) {
    		for(int k = 0; k < matrix.length; k++) {
    			if(used[matrix[k][j]-1]!=false) 
    				{
    					colCount++; 
    					break; 
    				}
    			used[matrix[k][j]-1]=true; 
    		}
    		Arrays.fill(used,false); 
    	}

    	int trace = 0; 
    	int counter = 0; 
    	for(int j = 0; j < matrix.length; j++) {
    		trace+=matrix[j][counter]; 
    		counter++; 
    	}

    	System.out.printf("Case #%d: %d %d %d\n", i+1,trace,rowCount,colCount); 
    }


    f.close(); 
  }
}