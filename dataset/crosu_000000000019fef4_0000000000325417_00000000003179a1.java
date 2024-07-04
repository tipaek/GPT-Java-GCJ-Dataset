import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
	
	public static class Digit implements Comparable<Digit> {
		char c;
		Integer count;
		HashSet<Integer> possibilities;
		
		public Digit(char c_) {
			c = c_;
			count = 1;
			possibilities = new HashSet<>();
			
			for (int i = 0; i <= 9; i++) {
				possibilities.add(i);
			}
		}
		
		@Override
		public String toString() {
			return "" + c;
		}
		
		@Override
		public int compareTo(Digit d) {
			return count.compareTo(d.count);
		}
		
		public void cannotBeAboveX(int x) {
			possibilities.remove(0);
			
			for (int i = x + 1; i <= 9; i++) {
				possibilities.remove(i);
			}
		}
		
		public void cannotBeX(int x) {
			possibilities.remove(x);
		}
		
		public void incr() {
			count++;
		}
		
		public boolean canBeX(int x) {
			return possibilities.contains(x);
		}
		
		public boolean mustBeX(int x) {
			return canBeX(x) && possibilities.size() == 1;
		}
	}
	
	public static String sol1() {
		HashMap<Character, Digit> counts = new HashMap<>();
		
		for (int i = 0; i < 10000; i++) {
			if (i > 0) {
				long q = scanner.nextLong();
			}
			String m = scanner.next();
			
			for (int j = 0; j < m.length(); j++) {
				char c = m.charAt(j);
				
				if (counts.containsKey(c)) {
					counts.get(c).incr();
				} else {
					counts.put(c, new Digit(c));
				}
			}
		}
		
		ArrayList<Digit> digits = new ArrayList<>();
		
		for (Digit d : counts.values()) {
			digits.add(d);
		}
		
		Collections.sort(digits);
		
		String answer = "";
		
		answer += digits.get(0);
		
		for (int i = 9; i >= 1; i--) {
			answer += digits.get(i);
		}		
		
		return answer;
	}
	
	public static int getFirstDigit(long l) {
		String s = "" + l;
		char c = s.charAt(0);
		return Integer.parseInt("" + c);
	}
	
	public static int intLen(long l) {
		String s = "" + l;
		return s.length();
	}
	
	public static String sol2(long q) {
		HashMap<Character, Digit> counts = new HashMap<>();
		
		for (int i = 0; i < 10000; i++) {
			if (i > 0) {
				q = scanner.nextLong();
			}
			
			String m = scanner.next();
			
			for (int j = 0; j < m.length(); j++) {
				char c =  m.charAt(j);
				Digit d;
				if (counts.containsKey(c)) {
					d = counts.get(c);
				} else {
					d = new Digit(c);
					counts.put(c, d);
				}
				
				if (j == 0) {
					d.cannotBeX(0);
					if (m.length() == intLen(q)) d.cannotBeAboveX(getFirstDigit(q));
				}
			}
		}
		
		HashSet<Integer> unmatched = new HashSet<>();
		
		for (int i = 0; i <= 9; i++) {
			unmatched.add(i);
		}

		char[] ans = new char[10];
		
		while (!unmatched.isEmpty()) {
			boolean foundMatch = false;
			int matchedInt = -1;
			char matchedChar = ' ';
			
			for (int x : unmatched) {
				HashSet<Character> set = new HashSet<>();
				for (Digit d : counts.values()) {
					if (d.canBeX(x)) {
						set.add(d.c);
					}
				}
				
				if (set.size() == 1) {
					matchedInt = x;
					matchedChar = set.iterator().next();
					foundMatch = true;
					break;
				}
			}
			
			if (!foundMatch) {
				for (Digit d : counts.values()) {
					if (d.possibilities.size() == 1) {
						matchedChar = d.c;
						matchedInt = d.possibilities.iterator().next();
						foundMatch = true;
						break;
					}
				}
			}
			
			if (foundMatch) {
				ans[matchedInt] = matchedChar;
				unmatched.remove(matchedInt);
				counts.remove(matchedChar);

				for (Digit d : counts.values()) {
					d.cannotBeX(matchedInt);
				}
			}
			
		}
		
		String answer = "";
		
		for (int i = 0; i < ans.length; i++) {
			answer += ans[i];
		}
		
		
		return answer;
	}
	
	public static void nextCase(int caseNum) {
		int u = scanner.nextInt();
		long q = scanner.nextLong();
		String answer;
		
		if (q == -1) {
			answer = sol1();
		} else {
			answer = sol2(q);
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








