
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private static final boolean DEBUG = false;

	public static void main(String[] args) throws FileNotFoundException {
		long beginTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("parenting.txt") : System.in;
		try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
			int testCount = scanner.nextInt();
			// System.out.println("testCount :: " + testCount);
			for (int testNumber = 1; testNumber <= testCount; testNumber++) {
				int arrayLength = scanner.nextInt();
				// System.out.println("arrayLength :: " + arrayLength);
				int[][] myArray = new int[arrayLength][2];
				for (int i = 0; i < arrayLength; i++) {
					for (int j = 0; j < 2; j++) {
						myArray[i][j] = scanner.nextInt();
					}
				}
				String result = solve(arrayLength, myArray);
				System.out.println("Case #" + testNumber + ": " + result);
			}
		}
		System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
	}

	private static String solve(int arrayLength, int[][] myArray) {
		boolean possible = true;
		
		char[] result = new char[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			result[i] = 'C';
		}
		
		outer: for (int i = 0; i <= 1440; i++) {
			int count = 0;
			for (int j = 0; j < arrayLength; j++) {
				if (myArray[j][0] <= i && myArray[j][1] > i) {
					count++;
				}
				if (count > 2) {
					possible = false;
					break outer;
				}
			}
		}
		if (possible) {
			for (int i = 1; i < arrayLength; i++) {
				for (int j = 0; j  < i; j++) {
					if(i != j) {
						if(result[j] == 'C') {
							if(overlap(myArray[i][0],myArray[i][1],myArray[j][0],myArray[j][1])) {
								result[i] = 'J';
								break;
							}
						}
					}
				}
			}
			return new String(result);
		}
		return "IMPOSSIBLE";
	}

	private static boolean overlap(int x1, int y1, int x2, int y2) {
		//System.out.println(x1 + " - " + y1 );
		//System.out.println(x2 + " - " + y2 );
		boolean result = false;
		if(x1 == x2) {
			result = true;
		} else if (x1 < x2) {
			result =  y1 > x2;
		}  else {
			result = y2 > x1;
		}
		//System.out.println("result :: " + result);
		return result;
	}

}
