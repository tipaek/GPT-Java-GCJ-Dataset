//package nestingdepth;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
	
	private static String nestingDepth(Scanner scanner) {
		char[] split = scanner.next().toCharArray();
		int[] digits = new int[split.length];
		for (int i = 0; i < split.length; i++)
			digits[i] = split[i] - '0';
		
		StringBuilder result = new StringBuilder();
		int curDepth = 0;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == curDepth) {
				result.append(digits[i]);
			}
			else if (digits[i] > curDepth) {
				result.append(repeat("(", digits[i] - curDepth));
				result.append(digits[i]);
				curDepth = digits[i];
			}
			else {
				result.append(repeat(")", curDepth - digits[i]));
				result.append(digits[i]);
				curDepth = digits[i];
			}
		}
		
		if (curDepth > 0)
			result.append(repeat(")", curDepth));
		
		return result.toString();
	}
	
	private static String repeat(String str, int num) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < num; i++) {
			result.append(str);
		}
		return result.toString();
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
			String result = nestingDepth(scanner);
			out.printf("Case #%d: %s\n", testCase, result);
		}
	}
}
