

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Solution {
	
	public static List<int[]> Result = new ArrayList<>();
	
	public static void main(String args[]) throws Exception	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 0; i < n; i++) {
			int size = scan.nextInt();
			int[][] mat = new int[size][size];
			for(int k = 0; k < size; k++) {
				for(int m = 0; m < size; m++) {
					mat[k][m] = scan.nextInt();
				}
			}
			int[] sol = Solve(mat, size);
			Result.add(sol);
			
			}
		
		for(int i = 0; i < n; i++) {
			System.out.println("Case #" + i + ": " + Result.get(i)[0] + " " + Result.get(i)[1] + " " + Result.get(i)[2]);		
		}
		
		scan.close();
		}
	
	
	public static int[] Solve(int[][] matrix, int size) {
		int[] result = {0, 0 ,0};
		for(int i = 0; i < size; i++) {
			result[0] += matrix[i][i];
		}
		boolean[] check = new boolean[size];
		
		for(int i = 0 ; i < size; i++) {
			check[i] = false;
		}
		
		boolean topdown = false;
		
		
		for(int k = 0; k < size; k++) {
			for(int m = 0; m < size-1; m++) {
				if(matrix[k][m] == matrix[k][m+1] && (check[m] == false || check[m+1] == false)) {
					check[m] = true;
					check[m+1] = true;
					result[1] += 1;	
					
				}	
			}
			if(matrix[k][0] == matrix[k][size-1] && topdown == false) {
				topdown = true;
				result[1] += 1;	
			}
			
		}
		
		for(int i = 0 ; i < size; i++) {
			check[i] = false;
		}
		topdown = false;
		
		for(int k = 0; k < size; k++) {
			for(int m = 0; m < size-1; m++) {
				if(matrix[m][k] == matrix[m+1][k] && (check[m] == false || check[m+1] == false)) {
					check[m] = true;
					check[m+1] = true;
					result[2] += 1;
				}				
			}
			if(matrix[0][k] == matrix[size-1][k] && topdown == false) {
				topdown = true;
				result[2] += 1;	
			}
			
			
		}
		
		
		return result;
	}
	
}