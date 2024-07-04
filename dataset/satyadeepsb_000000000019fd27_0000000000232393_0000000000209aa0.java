import java.io.*;
import java.util.*;

public class Solution {


	public static String isLatinSquare(int[][] array) {
		long diagonalSumLeftToRight = 0;
		long diagonalSumRightToLeft = 0;
		boolean isLatin= true;
		for (int i = 0; i<array.length ;i++) {
			// check for duplicates in each row
			if(isDuplicates(array[i], true) && isLatin){
				isLatin  = false;
			}
			// create a column array
			int[] column = new int[array[i].length]; 
			for(int j = 0; j<array.length; j++) {
				column[j] = array[j][i]; 
				if(i == j) {
					diagonalSumLeftToRight += array[j][i];
				}
				if(j == (array.length - 1 - i)) {
					diagonalSumRightToLeft += array[j][i];
				}
				// could throw an exception if the input file isn't square 3x3, 2x2, 4x4, etc
			}
			// check for duplicates in each column
			if(isDuplicates(column, false) && isLatin){
				isLatin  = false;
			}
		}
		if(isLatin && (diagonalSumLeftToRight == diagonalSumRightToLeft)) {
			return "POSSIBLE";
		}
		return "IMPOSSIBLE";
	}

	public static boolean isDuplicates(int[] array, boolean isRow){
		for (int i = 0; i<array.length; i++) {
			for(int j = 0; j<array.length; j++){
				if (i != j && array[i] == array[j]){
					return true;
				}
			}    
		}
		return false;
	}

	public static int[][] parseData(Scanner in){
		int matrix[][];
		int lineCount = 0;
		String firstLine[] = in.nextLine().split(" ");
		int size  = firstLine.length;
		matrix = new int[size][];
		lineCount = 1;
		String splitLine[] = new String[size];
		for(int r = 0; r < matrix.length; r++) {
			if(lineCount > 1) {
				splitLine = in.nextLine().split(" ");
			}
			matrix[r] = new int[size];
			for(int c = 0; c < matrix[r].length; c++){
				if(lineCount == 1) {
					matrix[r][c] = Integer.parseInt(firstLine[c]);
				} else {
				matrix[r][c] = Integer.parseInt(splitLine[c]);
				}
			}
			lineCount++;
		}
		return matrix;
	}

	public static void printData(int matrix[][]){
		for(int r = 0; r < matrix.length; r++){
			for(int c = 0; c < matrix[r].length; c++){
				System.out.print(matrix[r][c] + " ");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String testCases = in.nextLine();
		for (int i = 1; i <= Long.parseLong(testCases); ++i) {
			System.out.println("\n Case #" + i + ": " + isLatinSquare(parseData(in)));
		}
	}
}