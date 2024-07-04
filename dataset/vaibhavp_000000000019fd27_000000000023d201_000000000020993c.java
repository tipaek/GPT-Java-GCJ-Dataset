import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	private static int[] input, inputArray;
	private static int rows, cols, trace, cases;
	private static int[][] latinSquare;
	
	private static BufferedReader br;
    private static PrintWriter pw;
	
	private static void setIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
    }
	
	private static void input(int numCase) throws IOException {
		String line;
		StringTokenizer data;
		
		line = br.readLine();
		data = new StringTokenizer(line);
		
		int size = Integer.parseInt(data.nextToken());
		
		latinSquare = new int[size][size]; 
		
	
		for (int i = 0; i < size; i++) {
			line = br.readLine();
			data = new StringTokenizer(line);
			for (int j = 0; j < size; j++) {
				latinSquare[i][j] = Integer.parseInt(data.nextToken());
			}
		}
	}
	
	private static void work() {
		trace = 0; rows = 0; cols = 0;
		trace = computeTrace();
		
		int[][] newMatrix = new int[latinSquare.length][latinSquare.length];
		for (int i = 0; i < latinSquare.length; i++) {
			for (int j = 0; j < latinSquare.length; j++) {
				newMatrix[i][j] = latinSquare[i][j];
			}
		}
		
		rows = checkRows(latinSquare);
		cols = checkColumns(newMatrix);
	}
	
	private static int computeTrace() {
		trace = 0;
		for (int i = 0; i < latinSquare.length; i++) {
			trace += latinSquare[i][i];
		}
		return trace;
	}
	
	private static int checkRows(int[][] matrix) {
		int repeatedRows = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			if (isRepetition(matrix[i]) == true) repeatedRows++;
		}
		
		return repeatedRows;
	}
	
	private static int checkColumns(int[][] matrix) {
		int repeatedColumns = 0;
		int[] columnArray;
		
		for (int i = 0; i < matrix.length; i++) {
			columnArray = new int[matrix.length];
			for (int j = 0; j < matrix.length; j++) {
				columnArray[j] = matrix[j][i]; 
			}
			if (isRepetition(columnArray) == true) repeatedColumns++;
		}
		
		return repeatedColumns;
	}
	
	private static boolean isRepetition(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[Math.abs(array[i]) - 1] > 0) {
				array[Math.abs(array[i]) - 1] = -1 * array[Math.abs(array[i]) - 1]; 
			}
			else return true;
		}
		return false;
	}
	
	private static void output(int caseNum) throws IOException {
		pw.println("Case #" + caseNum + ": " + trace + " " + rows + " " + cols);
	}
	
	public static void main(String[] args) throws IOException {
		setIO();
		
		cases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= cases; i++) {
        	input(i);
            work();
            output(i);
        }

        br.close();
        pw.close();
	}
}
