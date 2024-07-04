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
	
	public static int getNth(int n) {
		writer.println(""+(n+1));
		writer.flush();
		int x = Integer.parseInt(scanner.next());
		return x;
	}
	
	public static void solve_for_10() {
		String result = "";
		
		for (int i = 0; i < 10; i++) {
			int x = getNth(i);
			result += x;
		}
		writer.println(result);
		writer.flush();
		assert(scanner.next() == "Y");
		scanner.next();
	}
	
	public static int[] extractByIndices(int[] full, int[] indices) {
		int n = indices.length;
		int[] result = new int[n];
		
		for(int i = 0; i < n; i++) {
			result[i] = full[indices[i]];
		}
		
		return result;
	}
	
	public static void insertByIndices(int[] full, int[] indices, int[] byIndex) {
		int n = indices.length;
		
		for (int i = 0; i < n; i++) {
			full[indices[i]] = byIndex[i]; 
		}
	}
	
	public static int[] updateForFlipsAndComplements(int[] original, int[] indices) {
		int n = indices.length;
		int[] updated = new int[n];
		
		Integer same_i = null;
		Integer different_i = null;
		
		for (int i = 0; i < n; i++) {
			if (original[i] == original[n-i-1]) {
				same_i = i;
			} else {
				different_i = i;
			}			
		}
		
		boolean is_flipped;
		boolean is_complement;
		
		if (same_i == null) {
			is_complement = false;
		} else {
			int x = getNth(indices[same_i]);
			is_complement = x != original[same_i];
		}
		
		if (different_i == null) {
			is_flipped = false;
		} else {
			int x = getNth(indices[different_i]);
			is_flipped = 
					(!is_complement && x != original[different_i]) 
					|| (is_complement && x == original[different_i]);
		}
		
		if (is_flipped) {
			for (int i = 0; i < n; i++) {
				updated[i] = original[n - i - 1];
			}
		} else {
			for (int i = 0; i < n; i++) {
				updated[i] = original[i];
			}
		}
		
		if (is_complement) {
			for (int i = 0; i < n; i++) {
				updated[i] = (updated[i] == 0 ? 1 : 0);
			}
		}
		
		return updated;
	}

	public static void solve_for_20() {
		int[] values = new int[20];
		int[] final_values = new int[20];
		int[] middle_indices = new int[10];
		int[] outer_indices = new int[10];
		
		for (int i = 0; i < 10; i++) {
			middle_indices[i] = i + 5;
			
			if (i < 5) {
				outer_indices[i] = i;
			} else {
				outer_indices[i] = i + 10;
			}
		}
		
		for (int i : middle_indices) {
			values[i] = getNth(i);
		}

		for (int i : outer_indices) {
			values[i] = getNth(i);
		}
		
		int[] middle = extractByIndices(values, middle_indices);
		int[] outside = extractByIndices(values, outer_indices);
		
		int[] final_middle = updateForFlipsAndComplements(middle, middle_indices);
		int[] final_outside = updateForFlipsAndComplements(outside, outer_indices);
		
		insertByIndices(final_values, middle_indices, final_middle);
		insertByIndices(final_values, outer_indices, final_outside);
		
		String result = "";
		
		for (int i = 0; i < 20; i++) {
			result += final_values[i];
		}
		writer.println(result);
		writer.flush();
		assert(scanner.next() == "Y");
		scanner.next();
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
