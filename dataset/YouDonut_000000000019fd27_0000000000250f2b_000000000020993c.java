import java.util.*;
import java.io.*;
/**
Timo Hromadka
*/
public class SolutionOne {
  
    public static void main(String[] args) {
      
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
			int trace = 0;
			int repRow = 0;
			int repCol = 0;
			
			int amt = in.next();
			int[][] matrix = new int[amt][amt];
			
			for (int row = 0; row < amt; row++) {
				int[] rowVals = in.next();
				for (int j = 0; j<rowVals.length; j++) {
					matrix[row][j] = rowVals[j]; // populate entire matrix
				}
			}
			
			for (int xx = 0; xx<matrix[0].length; xx++) {
				trace += matrix[xx][xx];
			}
			
			// find amt of rows with duplicate elements
			for (int y = 0; y < matrix[0].length; y++) { // rows
				for (int x = 0; x < matrix[1].length; x++) { // cols
					Set<Integer> uniqueRow = new HashSet<>();
					if (!uniqueRow.add(matrix[y][x])) repRow++;
				}
			}
			
			// find amt of cols with duplicate elements
			for (int x = 0; x < matrix[0].length; x++) { // cols
				for (int y = 0; y < matrix[1].length; y++) { // rows
					Set<Integer> uniqueCol = new HashSet<>();
					if (!uniqueCol.add(matrix[x][y])) repCol++;
				}
			}
			
			
			System.out.println("Case #" + count + ": " + trace + " " + repRow + " " + repCol);
			
		}
	}
}