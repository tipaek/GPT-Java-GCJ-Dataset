//package vestigium;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	private static String vestigium(Scanner scanner) {
		int size = scanner.nextInt();
		int[][] matrix = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				matrix[i][j] = scanner.nextInt();
		
		int trace = 0;
		int repRows = 0, repCols = 0;
		HashSet<Integer> valsSeen = new HashSet<Integer>();
		
		for (int i = 0; i < size; i++) {
			valsSeen.clear();
			trace += matrix[i][i];
			
			for (int j = 0; j < size; j++) {
				if (valsSeen.contains(matrix[i][j])) {
					repRows++;
					break;
				}
				valsSeen.add(matrix[i][j]);
			}
		}
		
		for (int j = 0; j < size; j++) {
			valsSeen.clear();
			
			for (int i = 0; i < size; i++) {
				if (valsSeen.contains(matrix[i][j])) {
					repCols++;
					break;
				}
				valsSeen.add(matrix[i][j]);
			}
		}
		
		return String.format("%d %d %d", trace, repRows, repCols);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		run();
		//run("template.in");
		//run("A-small.in", "A-small.out");
	}
	
	private static void run() {
		run(System.in, System.out);
	}
	
	private static void run(String inFile) throws FileNotFoundException {
		run(new FileInputStream(inFile), System.out);
	}
	
	private static void run(String inFile, String outFile) throws FileNotFoundException {
		run(new FileInputStream(inFile), new PrintStream(outFile));
	}
	
	private static void run(InputStream in, PrintStream out) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
		int testCases = scanner.nextInt();
		for (int testCase = 1; testCase <= testCases; testCase++) {
			String result = vestigium(scanner);
			out.printf("Case #%d: %s\n", testCase, result);
		}
	}
}
