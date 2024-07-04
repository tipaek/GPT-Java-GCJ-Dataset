import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/* Interactive notes:
 * 
 * $ set path='%path%;C:\Program Files\Java\jdk1.8.0_121\bin;C:\Program Files (x86)\Python\Python36'
 * $ cd "C:\Users\Owner\workspace\2020 - Qualification_round\src"
 * $ javac SolutionD.java
 * $ python interactive_runner.py python local_testing_tool.py 1 -- java SolutionD
 * 
 * Misc commandline commands:
 * $ dir
 * $ cd <path>
 * $ echo %path%
 * 
 * Tips:
 * - writer.println instead of writer.print
 * - writer.flush() after every print
 * - might want to read full lines instead of single chars (not sure)
 * - end with:
 *		writer.println(result);
 *		writer.flush();
 *		assert(scanner.next() == "Y");
 * 		scanner.next();
 */

public class Solution {
	
	public static Boolean debug = false;
	public static Boolean fromFile = false;
	public static String inputFile = "testB.in";
	
	public static PrintWriter writer;
	public static Scanner scanner;
	
	public static void debugPrintln(String s) {
		if (debug) {
			writer.println(s);
		}
	}
	
	public static void debugPrint(String s) {
		if (debug) {
			writer.print(s);
		}
	}
	
	public static long now() {
		return System.nanoTime();
	}
	
	public static double round(double d, int sigDigits) {
		double q = Math.pow(10, sigDigits);
		
		return Math.round(d * q) / q;
	}
	
	public static void printTime(long start, long stop) {
		long elapsed = stop - start;
		double msPerNs = Math.pow(10,-6);
		
		debugPrintln("Ms elapsed: " + round(elapsed*msPerNs,4) + " (" + round(start*msPerNs,4) + ", " + round(stop*msPerNs,4) + ")");
	}
	
	public static void nextCase(int a, int b) {
		boolean found = false;
		
		for (long i = (long) (Math.pow(10, 9) - 10); i <= Math.pow(10, 9) + 10; i++) {
			for (long j = (long) (Math.pow(10, 9) - 10); j <= Math.pow(10, 9) + 10; j++) {
				writer.println(i + " " + j);
				writer.flush();
				String response = scanner.next();
				
				if (response == "CENTER") {
					found = true;
					break;
				}
			}
			
			if (found) break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
		writer = new PrintWriter(System.out);
		
		int t = scanner.nextInt();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
			nextCase(a, b);
		}
		
		writer.close();
		scanner.close();
	}
}
