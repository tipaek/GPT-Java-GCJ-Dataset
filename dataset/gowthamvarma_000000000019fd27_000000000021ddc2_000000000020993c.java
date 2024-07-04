import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	private static final boolean DEBUG = false;

	public static void main(String[] args) throws FileNotFoundException {
		long beginTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("vestigium.txt") : System.in;
		try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
			int testCount = scanner.nextInt();
			//System.out.println("testCount :: " + testCount);
			for (int testNumber = 1; testNumber <= testCount; testNumber++) {
				int arrayLength = scanner.nextInt();
				//System.out.println("arrayLength :: " + arrayLength);
				int[][] myArray = new int[arrayLength][arrayLength]; 
				for (int i = 0; i < arrayLength; i++) {
					for (int j = 0; j < myArray.length; j++) {
						myArray[i][j] = scanner.nextInt();
					}
				}
				String result = solve(arrayLength,myArray);
				System.out.println("Case #" + testNumber + ": " + result);
			}
		}
		System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
	}

	private static String solve(int arrayLength, int[][] myArray) {
		int trace = 0;
		int repeatedRows = 0;
		int repeatedColumns = 0;
		for (int i = 0; i <arrayLength; i++) {
			trace += myArray[i][i];
		}
		
		for (int i = 0; i < arrayLength; i++) {
			Set<Integer> rowSet = new HashSet<Integer>();
			for (int j = 0; j < arrayLength; j++) {
				 boolean isAdded = rowSet.add(myArray[i][j]);
				 if(!isAdded) {
					 repeatedRows++;
					 break;
				 }
			}
			Set<Integer> colSet = new HashSet<Integer>();
			for (int j = 0; j < arrayLength; j++) {
				 boolean isAdded = colSet.add(myArray[j][i]);
				 if(!isAdded) {
					 repeatedColumns++;
					 break;
				 }
			}
		}
		
		return trace + " " + repeatedRows + " " + repeatedColumns;
	}

	
}
