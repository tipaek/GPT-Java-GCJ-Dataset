import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private static final boolean DEBUG = false;
	
	private static String solve(String str) {
		StringBuilder result = new StringBuilder();
		int openParCount = 0;
		for(int i = 0; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			if(n > openParCount ) {
				for(int k = 0; k < n - openParCount; k++)
					result.append("(");
				openParCount+= n - openParCount;				
			}else if(n < openParCount) {
				for(int k = 0; k < openParCount - n; k++)
					result.append(")");
				openParCount-= openParCount - n;
			}
			result.append(n);
		}
		for(int i = 0; i < openParCount; i++) {
			result.append(")");
		}
		return result.toString();
	}

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("resources/matchpar.in") : System.in;
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
		int testCount = scanner.nextInt();
		for(int testNum = 1;  testNum <= testCount; testNum++) {
			String n = scanner.next();		
			String result = solve(n);
			System.out.println("Case #" + testNum + ": " + result);			
		}		
		scanner.close();
		//System.err.println("Solved in: " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
	}



}
