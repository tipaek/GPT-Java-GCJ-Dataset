import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {
	
	public static Boolean debug = false;
	public static Boolean fromFile = false;
	public static String inputFile = "testA.in";
	
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
	
	public static class Path {
		ArrayDeque<Character> path;
		long currentX;
		long currentY;
		
		public Path(long startX, long startY) {
			currentX = startX;
			currentY = startY;
			path = new ArrayDeque<>();
		}

		public Path(long x, long y, ArrayDeque<Character> p) {
			currentX = x;
			currentY = y;
			path = p;
		}
		
		public Path addStep(char dir, long stepSize) {
			long x = currentX;
			long y = currentY;
			ArrayDeque<Character> p = new ArrayDeque<Character>(path);
			
			switch (dir) {
				case 'N': y += stepSize; break;
				case 'S': y -= stepSize; break;
				case 'E': x += stepSize; break;
				case 'W': x -= stepSize; break;	
			}
			
			p.add(dir);
			
			return new Path(x, y, p);
		}
		
		public String toString() {
			String s = "";
			
			for (char c : path) {
				s += c;
			}
			
			return s;
		}
	}
	
	public static void nextCase(int caseNum) {
		long x = scanner.nextLong();
		long y = scanner.nextLong();
		String path = scanner.next();
		String answer = "IMPOSSIBLE";
		
		if (x + y == 0) {
			answer = "" + 0;
		} else {
			for (int i = 1; i <= path.length(); i++) {
				switch (path.charAt(i-1)) {
				case 'N': y++; break;
				case 'E': x++; break;
				case 'S': y--; break;
				case 'W': x--; break;
				}
				
				if (Math.abs(x) + Math.abs(y) <= i) {
					answer = "" + i;
					break;
				}
			}
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








