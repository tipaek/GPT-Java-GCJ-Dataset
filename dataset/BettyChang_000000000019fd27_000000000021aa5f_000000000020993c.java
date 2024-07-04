import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //test cases
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        // read test cases
		for (int i = 1; i <= t; ++i) {
			int size = in.nextInt();
			int[][] matrix = new int[size][size];
			int k = 0;
			int r_duplicate = 0;
			int c_duplicate = 0;
			//read matrix
			for(int r = 0; r < size; r++) {
				for(int c = 0; c < size; c++) {
					matrix[r][c] = in.nextInt();
				}
			}
			//compute k
			for(int j = 0; j < size; j++) {
				k += matrix[j][j];
			}
			
			//compute r_duplicate
			for(int r = 0; r < size; r++) {
				ArrayList<Integer> row = new ArrayList<>();
				boolean done = false;
				for(int c = 0; c < size; c++) {
					if(!done) {
						//check if value exists in arraylist
						if(row.contains(matrix[r][c])) {
							r_duplicate ++;
							done = true;
						}else {
							row.add(matrix[r][c]);
						}
					}
				}
			}
			
			//compute c_duplicate
			for(int c = 0; c < size; c++) {
				ArrayList<Integer> column = new ArrayList<>();
				boolean done = false;
				for(int r = 0; r < size; r++) {
					if(!done) {
						//check if value exists in arraylist
						if(column.contains(matrix[r][c])) {
							c_duplicate ++;
							done = true;
						}else {
							column.add(matrix[r][c]);
						}
					}
				}
			}
			System.out.println("Case #" + i + ": " + k + " " + r_duplicate + " " + c_duplicate);
        }
	}

}
