import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	Scanner input;
	PrintStream output;

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		PrintStream output = System.out;
		int numCases = input.nextInt();

		for (int t = 0; t < numCases; t++) {
			output.printf("Case #%d: ", t + 1);
			output.println(new Solution(input, output).solve());
		}

		input.close();
		output.close();

		System.exit(0);
	}
	
	public Solution(Scanner input, PrintStream output) {
		this.input = input;
		this.output = output;
	}

	public String solve() {
		int n = input.nextInt();
		int [][] matrix = getMatrix(n);
		
		return getTrace(matrix) + " " + getRepeatedRows(matrix) + " " + getRepeatedCols(matrix);
	}

	private int[][] getMatrix(int n) {
		int [][] matrix = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = input.nextInt();
			}
		}
		
		return matrix;
	}
	
	private int getTrace(int [][] matrix) {
		int trace = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			trace += matrix[i][i];
		}
		
		return trace;
	}
	
	private int getRepeatedRows(int [][] matrix) {
		int r = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			List <Integer> numbers = new ArrayList<>();
			
			for (int j = 0; j < matrix.length; j++) {
				int value = matrix[i][j];
				
				if (numbers.contains(value)) {
					r++;
					break;
				}
				
				numbers.add(value);
			}
		}
		
		return r;
	}
	
	private int getRepeatedCols(int [][] matrix) {
		int c = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			List <Integer> numbers = new ArrayList<>();
			
			for (int j = 0; j < matrix.length; j++) {
				int value = matrix[j][i];
				
				if (numbers.contains(value)) {
					c++;
					break;
				}
				
				numbers.add(value);
			}
		}
		
		return c;
	}
}