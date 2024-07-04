import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	
	public static Boolean debug = false;
	public static Boolean fromFile = false;
	public static String inputFile = "testC.in";
	
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
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		long[] sizes = new long[n];
		HashMap<Long, Integer> counts = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			Long l = scanner.nextLong();
			sizes[i] = l;
			
			if (counts.containsKey(l)) {
				counts.put(l, counts.get(l) + 1);
			} else {
				counts.put(l, 1);
			}
		}
		
		String answer = "";
		
		boolean foundEqual = false;
		boolean foundDouble = false;
		
		for (int i : counts.values()) {
			if (i >= d) {
				foundEqual = true;
				break;
			}
		}
		
		if (!foundEqual) {
		for (long l : counts.keySet()) {
			if (counts.containsKey(l * 2)) {
				foundDouble = true;
				break;
			}
		}
		}
		
		if (foundEqual) {
			answer = "0";
		} else if (d == 2 || foundDouble) {
			answer = "1";
		} else {
			answer = "2";
		}
		
		writer.print("Case #" + caseNum + ": " + answer);
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








