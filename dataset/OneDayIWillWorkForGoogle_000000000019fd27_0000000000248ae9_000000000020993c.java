import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt(); 
		
		for(int times = 0; times < cases; times++) {
			int size = scanner.nextInt();
			int diagnol = 0;
			int row = 0; 
			int col = 0; 
			int[][] matrix = new int[size][size];
			for(int i = 0; i < size; i++) {
				Map<Integer, Integer> rowmap = new HashMap<>();
				boolean rowseen = true; 
				for(int j = 0; j < size; j++) {
					matrix[i][j] = scanner.nextInt(); 
					if(i == j)
						diagnol += matrix[i][j]; 
					
					if(rowseen && rowmap.containsKey(matrix[i][j])) {
						row++;
						rowseen = false; 
					}
					else
						rowmap.put(matrix[i][j], 1);
				}
			} 
			
			for(int i = 0; i < size; i++) {
				Map<Integer, Integer> colmap = new HashMap<>();
				boolean colseen = true; 
				for(int j = 0; j < size; j++) {
					if(colseen && colmap.containsKey(matrix[j][i])) {
						col++;
						colseen = false; 
					}
					else
						colmap.put(matrix[j][i], 1);
				}
			}
			
			System.out.println("Case #" + (times + 1) + ": " + diagnol + " " + row + " " + col);	
		}	
	}
}
