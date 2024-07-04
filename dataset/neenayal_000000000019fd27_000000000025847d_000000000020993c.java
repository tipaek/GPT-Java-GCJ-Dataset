import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tc = in.nextInt();
		for (int test = 1; test <= tc; ++test) {
			int num = in.nextInt();
			int trace = 0;
			int matrix[][] = new int[num][num];
			
			
			for (int row = 0; row < num; row++) {
				for (int col = 0; col < num; col++) {
					int val = in.nextInt();					
					matrix[row][col] = val;
					if (row == col) {
						trace += val;
					}
				}
			}
			
			int duplicateRow = 0;
			for(int row = 0; row < num; row++) {
				Set<Integer> uniqueRowSet = new HashSet<Integer>();
				for (int col = 0; col < num; col++) {
					if(uniqueRowSet.contains(matrix[row][col])) {
						duplicateRow++;
						break;
					} else {
						uniqueRowSet.add(matrix[row][col]);
					}			
				}
			}
			
			int duplicateCol = 0;
			for(int col = 0; col < num; col++) {
				Set<Integer> uniqueColSet = new HashSet<Integer>();
				for (int row = 0; row < num; row++) {
					if(uniqueColSet.contains(matrix[row][col])) {
						duplicateCol++;
						break;
					} else {
						uniqueColSet.add(matrix[row][col]);
					}			
				}
			}
			
			
	        System.out.println("Case #" + test + ": " + trace + " " + duplicateRow + " " + duplicateCol);
		}
	}
}
