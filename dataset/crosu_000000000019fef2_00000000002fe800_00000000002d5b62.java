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
		int currentX;
		int currentY;
		
		public Path(int startX, int startY) {
			currentX = startX;
			currentY = startY;
			path = new ArrayDeque<>();
		}

		public Path(int x, int y, ArrayDeque<Character> p) {
			currentX = x;
			currentY = y;
			path = p;
		}
		
		public Path addStep(char dir, int stepSize) {
			int x = currentX;
			int y = currentY;
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
		int targetX = scanner.nextInt();
		int targetY = scanner.nextInt();
		ArrayDeque<Path> options = new ArrayDeque<Path>();
		ArrayDeque<Path> prevOptions = new ArrayDeque<Path>();
		int stepSize = 1;
		Path solution = null;
		
		options.add(new Path(0, 0));
		
		while (solution == null && !options.isEmpty()) {
			prevOptions = options;
			options = new ArrayDeque<Path>();
			
			// debugPrintln("Options: " + prevOptions);
			
			for (Path path : prevOptions) {
				if (path.currentX == targetX && path.currentY == targetY) {
					solution = path;
					break;
				}
				
				int xMod = Math.abs(path.currentX - targetX) % (2 * stepSize);
				int yMod = Math.abs(path.currentY - targetY) % (2 * stepSize);
				
				if (xMod == 0 && yMod == stepSize) {
					options.add(path.addStep('N', stepSize));
					options.add(path.addStep('S', stepSize));
				} else if (xMod == stepSize && yMod == 0) {
					options.add(path.addStep('W', stepSize));
					options.add(path.addStep('E', stepSize));
				}
			}
			
			stepSize *= 2;
		}
		
		String answer = solution == null ? "IMPOSSIBLE" : solution.toString();
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








