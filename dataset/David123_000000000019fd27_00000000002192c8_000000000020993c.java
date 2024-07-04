import java.util.*;
import java.io.*;

public class Solution 
{
	
	public static String findSolution(int n, int[][] matrix)
	{
		int trace = 0;
		ArrayList<HashSet<Integer>> rowHashSets = new ArrayList<HashSet<Integer>>(n);
		ArrayList<HashSet<Integer>> colHashSets = new ArrayList<HashSet<Integer>>(n);
		
		boolean[] rowDup = new boolean[n];
		boolean[] colDup = new boolean[n];
		
		for (int i=0; i<n; i++)
		{
			rowHashSets.add(new HashSet<Integer>());
			colHashSets.add(new HashSet<Integer>());
		}
		
		for (int row=0; row < n; row++)
    	{
    		for (int col=0; col < n; col++)
    		{
    			int val = matrix[row][col];
    			
    			if (row == col)
    				trace += val;
    			
    			HashSet<Integer> rowHashSet = rowHashSets.get(row);
    			HashSet<Integer> colHashSet = colHashSets.get(col);
    			
    			if (rowHashSet.contains(val))
    			{
    				rowDup[row] = true;
    			}
    			else
    			{
    				rowHashSet.add(val);
    			}
    			
    			if (colHashSet.contains(val))
    			{
    				colDup[col] = true;
    			}
    			else
    			{
    				colHashSet.add(val);
    			}
    		}
    	}
		
		int numRowDup = 0;
		int numColDup = 0;
		
		for (int i=0; i<n; i++) {
			if (rowDup[i])
				numRowDup++;
			
			if (colDup[i])
				numColDup++;
		}
		
		return String.valueOf(trace) + " " + String.valueOf(numRowDup) + " " + String.valueOf(numColDup);
	}
	
	public static void main(String[] args) 
	{
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numTestCase = in.nextInt(); 
	
	    for (int i = 1; i <= numTestCase; ++i) 
	    {
	    	int n = in.nextInt();
	    	int[][] matrix = new int[n][n];
	    	 
	    	for (int row=0; row < n; row++)
	    	{
	    		for (int col=0; col < n; col++)
	    		{
	    			int m = in.nextInt();
	    			matrix[row][col] = m;
	    		}
	    	}
	    	
	    	String solution = Solution.findSolution(n, matrix);
	    	System.out.println("Case #" + i + ": " + solution);
	    }
	}
}