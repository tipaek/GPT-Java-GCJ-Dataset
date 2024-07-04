import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int numberOfBits = in.nextInt();
		if(numberOfBits > 10) {
			System.exit(0);
		}
		for (int i = 1; i <= t; ++i) {
			solveTestCase(i + 1, in, numberOfBits);
		}
		
		in.close();
		System.exit(0);
	}
	
	public static void solveTestCase(int testCaseId, Scanner in, int numberOfBits) {		
		int caseBits[] = new int[numberOfBits];
		
		for(int i = 0; i < numberOfBits; i++) {
			System.out.println(i+1);
			System.out.flush();
			caseBits[i] = in.nextInt();
		}
		
		String output = "";
		
		for (int i : caseBits) {
			output = output + i;
		}
		
		System.out.println(output);
		System.out.flush();
		
		String judgeResponse = in.next();
		
		if(judgeResponse.equalsIgnoreCase("N")) {
			System.exit(0);
		}
		
	}
	
}
