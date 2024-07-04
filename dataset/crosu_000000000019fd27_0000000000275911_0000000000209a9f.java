import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

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
	
	public static void nextCase(int caseNum) {
		String sequence = scanner.next();
		int n = sequence.length();
		String result = "";
		int current = 0;
		
		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt("" + sequence.charAt(i));
			
			if (next > current) {
				for (int j = 0; j < next - current; j++) {
					result += "(";
				}
			} else if (next < current) {
				for (int j = 0; j < current - next; j++) {
					result += ")";
				}
			}
			
			result += next;
			current = next;
		}
		
		for (int i = 0; i < current; i++) {
			result += ")";
		}
		
		writer.print("Case #" + caseNum + ": " + result);
	}
	
	public static void main(String[] args) throws Exception {
		scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
		writer = new PrintWriter(System.out);
		
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
			nextCase(i+1);
			
			if (i < t - 1) {
				writer.println("");
			}
		}
		
		writer.close();
		scanner.close();
	}
}
