import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    in.nextLine();
	    //System.out.println("# of test cases:" + t);
	    
	    int rRowCount =0;
	    int []ans = null;
	    for (int i = 1; i <= t; ++i) {
	        rRowCount =0;
	    	int rowCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    	Integer[][]matrix = new Integer[rowCount][rowCount];
		    in.nextLine();
	    	for (int row = 0; row < rowCount; row++) {
	  	      	String rowVal = in.nextLine();
	  	      	String[] c = rowVal.split(" ");
		    	matrix[row] = getIntArray(c);
		    	if(rowHasRepeated(matrix[row]))
		    		rRowCount++;
	    	}
	    	ans = computeMatrixInfo(matrix);
	    	System.out.println("Case #" + i + ": " + ans[0] + " " + rRowCount + " " + ans[1]);
	    }
	  }
	
		private static boolean rowHasRepeated(Integer[] row) {
			List<Integer>numList = Arrays.asList(row);
			Set<Integer>numSet = new HashSet<>(numList);
			return numSet.size() < row.length;
		}
		
		private static boolean rowHasRepeated1(List<Integer> row) {
			Set<Integer>numSet = new HashSet<>(row);
			return numSet.size() < row.size();
		}
	
		private static int[] computeMatrixInfo(Integer[][]matrix) {
			int [] ans = new int [2];
			List<Integer>colnList = null;
			int diagonalSum = 0;
			int diagonalCounter = 0;
			int colnCounter = 0;
			for(int coln=0; coln < matrix.length; coln++) {
				colnList = new ArrayList<>();
				for(int row=0; row<matrix.length; row++) {
					colnList.add(matrix[row][coln]);
				}

		    	if(rowHasRepeated1(colnList))
		    		colnCounter++;
				diagonalSum += matrix[coln][diagonalCounter];
				diagonalCounter++;
			}
			ans[0] = diagonalSum;
			ans[1] = colnCounter;
			return ans;
		}
	
		private static Integer[] getIntArray(String[] e) {
		  Integer [] arr = new Integer [e.length];
	      for(int i=0; i<e.length; i++) {
	         arr[i] = Integer.parseInt(e[i]);
	      }
	      return arr;
	  }
}
