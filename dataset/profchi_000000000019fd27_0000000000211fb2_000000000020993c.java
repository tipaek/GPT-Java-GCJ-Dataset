import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < testCases; ++i) {
			processInput(i + 1);
		}
	}
	
	public static void printResult(int current, int diag, int row, int col) {
		System.out.println("Case #" + current + ": " + diag + " " + row + " " + col);
	}
	
	public static void processInput(int testCase) {
		int matrixSize = Integer.parseInt(in.nextLine());
		
		int [][] array = new int [matrixSize][];
		int diag = 0;
		for (int i = 0; i < matrixSize; ++i) {
			String s = in.nextLine();
			String [] line = s.split(" ");
			array[i] = new int [matrixSize];
			for (int j = 0; j < line.length; ++j) {
				array[i][j] = Integer.parseInt(line[j]);
				if (i == j)
					diag += array[i][j];
			}
		}
		solve(array, testCase, diag);
	}
	
	public static void solve( int [] [] array, int testCase , int diag) {
		int size = array.length;
		int row = 0, col = 0;
		Set<Integer> checker;
		for (int i = 0; i < size; ++i) {
			checker = new HashSet<>();
			for (int j = 0 ; j < size; ++j) {
				if (!checker.add(array[i][j])) {
					++row;
					break;
				}
			}
		}
		
		for (int i = 0; i < size; ++i) {
			checker = new HashSet<>();
			for (int j = 0 ; j < size; ++j) {
				if (!checker.add(array[j][i])) {
					++col;
					break;
				}
			}
		}
		
		printResult(testCase, diag, row, col);
		
	}
	
	public static void helper() {
		
	}


}