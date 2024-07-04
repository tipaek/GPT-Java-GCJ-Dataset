//package parenting;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	private static String parenting(Scanner scanner) {
		int numActs = scanner.nextInt();
		Activity[] acts = new Activity[numActs];
		for (int i = 0; i < numActs; i++) {
			acts[i] = new Activity(scanner.nextInt(), scanner.nextInt(), i);
		}
		Arrays.sort(acts);
		
		int p1 = -1, p2 = -1;
		String[] order = new String[numActs];
		for (int i = 0; i < numActs; i++) {
			int start = acts[i].start, end = acts[i].end;
			if (start > p1) {
				order[acts[i].num] = "C";
				p1 = end - 1;
			}
			else if (start > p2) {
				order[acts[i].num] = "J";
				p2 = end - 1;
			}
			else {
				return "IMPOSSIBLE";
			}
		}
		
		return String.join("", order);
	}
	
	static class Activity implements Comparable<Activity> {
		int start;
		int end;
		int num;
		
		public Activity(int s, int e, int n) {
			start = s;
			end = e;
			num = n;
		}

		@Override
		public int compareTo(Activity other) {
			if (start < other.start) return -1;
			if (start > other.start) return 1;
			if (end < other.end) return -1;
			if (end > other.end) return 1;
			return 0;
		}
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
			String result = parenting(scanner);
			out.printf("Case #%d: %s\n", testCase, result);
		}
	}
}
