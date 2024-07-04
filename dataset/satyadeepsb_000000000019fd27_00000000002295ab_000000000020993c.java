import java.io.*;
import java.util.*;

public class Solution {

	public static int dupicateRowCount =0;
	public static int dupicateColCount =0;
	
	public static Map<String, String> getLatinSquareMap(int[][] array) {
		long diagonalSum = 0;
		boolean isLatin= true;
		for (int i = 0; i<array.length ;i++) {
			// create a column array
			int[] column = new int[array[i].length]; 
			for(int j = 0; j<array.length; j++) {
				column[j] = array[j][i]; 
				if(i == j) {
					diagonalSum += array[j][i];
				}
				// could throw an exception if the input file isn't square 3x3, 2x2, 4x4, etc
			}
			// check for duplicates in each row
			if(isDuplicates(array[i], true) && isLatin){
					isLatin  = false;
			}
			// check for duplicates in each column
			if(isDuplicates(column, false) && isLatin){
					isLatin  = false;
			}
		}
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("isLatin", Boolean.toString(isLatin));
		resultMap.put("diagonalSum", Long.toString(diagonalSum));
		resultMap.put("rowCount", Integer.toString(dupicateRowCount));
		resultMap.put("colCount", Integer.toString(dupicateColCount));
		dupicateColCount = 0;
		dupicateRowCount = 0;
		return resultMap;
	}

	public static boolean isDuplicates(int[] array, boolean isRow){
		for (int i = 0; i<array.length; i++) {
			for(int j = 0; j<array.length; j++){
				if (i != j && array[i] == array[j]){
					if(isRow) {
						dupicateRowCount++;
					} else {
						dupicateColCount++;
					}
					return true;
				}
			}    
		}
		return false;
	}

	public static void parseData(int matrix[][], Scanner in){
		for(int r = 0; r < matrix.length; r++) {
			String splitLine[] = in.nextLine().split(" ");
			matrix[r] = new int[splitLine.length];
			for(int c = 0; c < matrix[r].length; c++){
				matrix[r][c] = Integer.parseInt(splitLine[c]);
			}
		}
	}


	public static void main(String[] args) {
		int matrix[][];
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String t = in.nextLine();
		for (int i = 1; i <= Long.parseLong(t); ++i) {
			String n = in.nextLine();
			int numRows = Integer.parseInt(n);
			matrix = new int[numRows][];
			parseData(matrix, in);
			Map<String,  String> resultMap = getLatinSquareMap(matrix);
			 System.out.println("\n Case #" + i + ": " + resultMap.get("diagonalSum") + " " + resultMap.get("rowCount") + " " + resultMap.get("colCount"));
		}
	}
}