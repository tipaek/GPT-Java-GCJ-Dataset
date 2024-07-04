import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Vestigium {

	private static final boolean DEBUG = false;

	public static void main(String[] args) throws FileNotFoundException {
		long beginTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("vestigium.txt") : System.in;
		try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
			int testCount = scanner.nextInt();
			for (int testNumber = 1; testNumber <= testCount; testNumber++) {
				int arrayLength = scanner.nextInt();
				int[][] myArray = new int[arrayLength][arrayLength]; 
				for (int i = 0; i < arrayLength; i++) {
					
				}
				String result = solve(arrayLength,myArray);
				System.out.println("Case #" + testNumber + ": " + result);
			}
		}
		System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
	}

	private static String solve(int arrayLength, int[][] myArray) {
		
		return " 1 2 3";
	}

	
}
