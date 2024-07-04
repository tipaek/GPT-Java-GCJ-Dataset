import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);	
	        
	        int T = input.nextInt();
	        
	        ArrayList<String> results = new ArrayList<String>();
	        
	        for (int ks = 1; ks <= T; ks++) {
	            results.add(String.format("Case #%d: %s", ks, solve(input)));
	        }
	        
	        for (int i = 0; i < results.size();i++) {
	        	System.out.println(results.get(i));
	        }
	}
	
	public static String solve(Scanner input) {
		int dimension = input.nextInt();
		
		int trace = 0;
		int rowDuplicates = 0;
		int columnDuplicates = 0;
		
		int[][] matrix = new int[dimension][dimension];
		int[][] flippedMatrix = new int[dimension][dimension];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int val = input.nextInt();
				matrix[i][j] = val;
				flippedMatrix[j][i] = val;
				if (i == j) {
					trace += matrix[i][j];
				}
			}
		}
		
		
		for (int i = 0; i < matrix.length; i++) {
			int[] row = matrix[i];
			Set<Integer> set = new HashSet<Integer>();
			
			for (int num: row) {
              if (set.add(num) == false) {
            	  rowDuplicates +=1;
            	  break;
              }
			}

		}
		
		for (int i = 0; i < flippedMatrix.length; i++) {
			int[] row = flippedMatrix[i];
			Set<Integer> set = new HashSet<Integer>();
			
			for (int num: row) {
              if (set.add(num) == false) {
            	  columnDuplicates +=1;
            	  break;
              }
			}

		}
		
		return "" + trace + " " + rowDuplicates + " " + columnDuplicates;
   }

}
