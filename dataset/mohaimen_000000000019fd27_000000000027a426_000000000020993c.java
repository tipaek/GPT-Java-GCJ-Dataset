
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static int checkColumn(int [][] matrix, int col, int n) {
		Map<Integer , Integer> nums = new HashMap<Integer , Integer>();
		for(int i= 0; i < n; i++) {
			if(nums.containsKey(matrix[i][col])) {
				return 1;
			}else {
				nums.put(matrix[i][col], 0);
			}
		}
		
		return 0;
	}
	
	public static int checkRow(int [][] matrix, int row, int n) {
		Map<Integer , Integer> nums = new HashMap<Integer , Integer>();
		for(int i= 0; i < n; i++) {
			if(nums.containsKey(matrix[row][i])) {
				return 1;
			}else {
				nums.put(matrix[row][i], 0);
			}
		}
		
		return 0;
	}
	
	public static int sumDiagonal(int [][] matrix,int n) {
		
		int sum = 0;
		
		for(int i= 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) {
					sum+= matrix[i][j];
				}			 
			}
		}
		
		return sum;
	}
	
	public static void main(String [] args) {
			
			Scanner scanner = new Scanner(System.in);
			int tests = scanner.nextInt();
		
			for(int t = 0; t< tests; t++) {
				
				int n = scanner.nextInt();
				int rows = 0,colms = 0, sum = 0;
				int [][] matrix = new int[n][n];
				
				for(int i= 0; i < n; i++) {
					matrix[i] = new int[n];
				}
				
				for(int i= 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						matrix[i][j] = scanner.nextInt();
					}
				}
				
				sum = sumDiagonal(matrix, n);
				for(int i= 0; i < n; i++) {
					rows+= checkRow(matrix, i, n);
					colms+= checkColumn(matrix, i, n);
				}
				
				System.out.println("Case #" + t + ": " + sum + " " + rows + " " + colms);
				
			}
		
	}
}
