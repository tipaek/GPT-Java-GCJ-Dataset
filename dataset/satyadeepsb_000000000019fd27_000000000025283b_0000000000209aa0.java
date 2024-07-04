import java.io.*;
import java.util.*;

public class Solution {


	public static String isLatinSquare(long[][] array) {
		long diagonalSumLeftToRight = 0;
		long diagonalSumRightToLeft = 0;
		boolean isLatin= true;
		for (int i = 0; i<array.length ;i++) {
			// check for duplicates in each row
			if(isDuplicates(array[i]) && isLatin){
				isLatin  = false;
			}
			// create a column array
			long[] column = new long[array[i].length]; 
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
			if(isDuplicates(column) && isLatin){
				isLatin  = false;
			}
		}
		if(isLatin && (diagonalSumLeftToRight == diagonalSumRightToLeft)) {
			return "POSSIBLE";
		}
		return "IMPOSSIBLE";
	}

	public static boolean isDuplicates(long[] array){
		for (int i = 0; i<array.length; i++) {
			for(int j = 0; j<array.length; j++){
				if (i != j && array[i] == array[j]){
					return true;
				}
			}    
		}
		return false;
	}

	public static long[][] parseD(Scanner in) {
		long matrix[][];
		String splitLine[] = in.nextLine().split(" ");
		List<int[]> rowList = new ArrayList<>();
		rowList.add(Arrays.stream(splitLine).mapToInt(Integer::parseInt).toArray());
		matrix = new long[splitLine.length][];
		for(int r = 1; r < matrix.length; r++) {
			splitLine = in.nextLine().split(" ");
			rowList.add(Arrays.stream(splitLine).mapToInt(Integer::parseInt).toArray());
		}
		for(int r =0; r < rowList.size(); r++) {
			int[] ac = rowList.get(r);
			matrix[r] = new long[ac.length];
			for(int c = 0 ; c < ac.length; c++) {
				matrix[r][c] = ac[c];
			}
		}
		return matrix;
	}

	public static long[][] parseData(Scanner in){
		long matrix[][];
		int lineCount = 0;
		String firstLine[] = in.nextLine().split(" ");
		int size  = firstLine.length;
		matrix = new long[size][];
		lineCount = 1;
		System.out.println("\n matrix.length = " + matrix.length);
		String splitLine[] = new String[size];
		for(int r = 0; r < matrix.length; r++) {
			if(lineCount > 1) {
				splitLine = in.nextLine().split(" ");
			}
			matrix[r] = new long[size];
			System.out.println("\n row length = " + matrix[r].length);
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

	public static boolean isMatrixOfEqualSize(long matrix[][]){
		boolean isEqual = true;
		for(int r = 0; r < matrix.length; r++){
			if(matrix[r].length != matrix.length) {
				isEqual = false;
			}
		}
		System.out.println(" \n isEqual " + isEqual ) ;
		return isEqual;
	}

	public static void printData(long matrix[][]){
		for(int r = 0; r < matrix.length; r++){
			for(int c = 0; c < matrix[r].length; c++){
				System.out.print(matrix[r][c] + " ");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		long matrix[][];
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String testCases = in.nextLine();
		for (int i = 1; i <= Long.parseLong(testCases); ++i) {
			String result = "IMPOSSIBLE" ;
			matrix = parseD(in);	
			//printData(matrix);
			if(isMatrixOfEqualSize(matrix)) {
				result = isLatinSquare(matrix);
			}
			System.out.println("\n Case #" + i + ": " + result);	
		}
	}
}