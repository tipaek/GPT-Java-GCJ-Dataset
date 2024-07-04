import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static String newline = System.getProperty("line.separator");
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int T = Integer.parseInt(in.nextLine());
		
		for (int t=1; t<=T; t++){
			int size = Integer.parseInt(in.nextLine());
			int[][] matrix = new int[size][size];
			for (int i = 0; i<size; i++) {
				String line = in.nextLine();
				String[] values = line.split(" ");
				int col = 0;
				for (String value : values) {
					matrix[i][col++] = Integer.parseInt(value);
				}
			}
			
			int k = getTrace(matrix, size);
			int r = getRowRepeats(matrix, size);
			int c = getColRepeats(matrix, size);
			
			System.out.printf("Case #%d: %d %d %d%n", t, k, r, c);
		}
	}
	
	private static int getColRepeats(int[][] matrix, int size) {
		Set<Integer> colVals = new HashSet<Integer>();
		int result = 0;
		for (int i = 0; i< size; i++) {
			for (int j = 0; j<size; j++) {
				if (!colVals.add(matrix[j][i])) {
					result++;
					break;
				}
			}
			colVals.clear();
		}
		
		return result;
	}

	private static int getRowRepeats(int[][] matrix, int size) {
		Set<Integer> rowVals = new HashSet<Integer>();
		int result = 0;
		for (int i = 0; i< size; i++) {
			for (int j = 0; j<size; j++) {
				if (!rowVals.add(matrix[i][j])) {
					result++;
					break;
				}
			}
			rowVals.clear();
		}
		
		return result;
	}

	private static int getTrace(int[][] matrix, int size) {
		int result = 0;
		for (int i =0; i< size; i++) {
			result += (matrix[i][i]);
		}
		return result;
	}

}
