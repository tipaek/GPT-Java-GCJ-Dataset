import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
	
	public static BigInteger gcd(BigInteger a, BigInteger b) {
		BigInteger max = a.max(b);
		BigInteger min = a.min(b);
		BigInteger rem = max.mod(min);
		BigInteger zero = BigInteger.valueOf(0);
		
		while (!rem.equals(zero)) {
			max = min;
			min = rem;
			rem = max.mod(min);
		}
	
		return min;
	}
	
	public static HashSet<BigInteger> arrayToHashSet(BigInteger[] array) {
		HashSet<BigInteger> set = new HashSet<BigInteger>();
		
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}
		
		return set;
	}
	
	public static HashMap<BigInteger, Character> convertCodesToLetters(HashSet<BigInteger> codes){
		BigInteger[] sortedCodes = new BigInteger[codes.size()];
		int c = 0;
		for (BigInteger code : codes) {
			sortedCodes[c] = code;
			c++;
		}
		Arrays.sort(sortedCodes);
		
		HashMap<BigInteger, Character> mapping = new HashMap<BigInteger, Character>();
		char ch = 'A';
		for (int i = 0; i < sortedCodes.length; i++) {
			mapping.put(sortedCodes[i], ch);
			ch++;
		}
		
		return mapping;
	}
	
	public static void solve_for_10() {
		String result = "";
		
		for (int i = 0; i < 10; i++) {
			writer.println(""+(i+1));
			writer.flush();
			int x = Integer.parseInt(scanner.next());
			//System.err.println(x);
			result += x;
		}
		writer.println(result);
		writer.flush();
		assert(scanner.next() == "Y");
		scanner.next();
	}

	public static void solve_for_20() {
	}

	public static void solve_for_100() {
	}
	
	public static void nextCase(int b) {
		switch(b) {
			case 10: 
				solve_for_10();
				break;
			case 20:
				solve_for_20();
				break;
			case 100:
				solve_for_100();
				break;
			default:
		}
	}
	
	public static void main(String[] args) throws Exception {
		scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
		writer = new PrintWriter(System.out);
		
		int t = scanner.nextInt();
		int b = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
			nextCase(b);
		}
		
		writer.close();
		scanner.close();
	}
}
