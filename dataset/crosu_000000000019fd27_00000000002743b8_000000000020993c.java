import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static Boolean debug = false;
	public static Boolean fromFile = false;
	public static String inputFile = "testA.in";
	
	public static PrintWriter writer;
	public static Scanner scanner;
	
	public static void debugPrintln(String s) {
		if (debug) {
			writer.println(s);
		}
	}
	
	public static void debugPrint(String s) {
		if (debug) {
			writer.print(s);
		}
	}
	
	public static long now() {
		return System.nanoTime();
	}
	
	public static double round(double d, int sigDigits) {
		double q = Math.pow(10, sigDigits);
		
		return Math.round(d * q) / q;
	}
	
	public static void printTime(long start, long stop) {
		long elapsed = stop - start;
		double msPerNs = Math.pow(10,-6);
		
		debugPrintln("Ms elapsed: " + round(elapsed*msPerNs,4) + " (" + round(start*msPerNs,4) + ", " + round(stop*msPerNs,4) + ")");
	}
	
	public static void nextCase(int caseNum) {
		
		int n = scanner.nextInt();
		int trace = 0;
		int[][] matrix = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int value = scanner.nextInt();
				matrix[i][j] = value;
				if (i == j) {
					trace += value;
				}
			}
		}
		
		int duplicate_row_num = 0;
		int duplicate_col_num = 0;
		HashSet<Integer> values = new HashSet<Integer>();
		
		for (int i = 0; i < n; i++) {
			values.clear();
			
			for (int j = 0; j < n; j++) {
				int row_value = matrix[i][j];
				
				if (values.contains(row_value)) {
					duplicate_row_num++;
					break;
				}
				
				values.add(row_value);
			}

			values.clear();
			for (int j = 0; j < n; j++) {
				int col_value = matrix[j][i];

				if (values.contains(col_value)) {
					duplicate_col_num++;
					break;
				}
				
				values.add(col_value);
			}
		}
		
		writer.print("Case #" + caseNum + ": " + trace + " " + duplicate_row_num + " " + duplicate_col_num);
	}
	
	public static void main(String[] args) throws Exception {
		scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
		writer = new PrintWriter(System.out);
		
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
			nextCase(i+1);
			
			if (i < t - 1) {
				writer.println("");
			}
		}
		
		writer.close();
		scanner.close();
	}
}








