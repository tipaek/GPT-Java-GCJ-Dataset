import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
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
	
	public static class Task {
		int start_time;
		int end_time;
		int id;
		char assigned = 'x';
		
		public Task(int i, int st, int et) {
			id = i;
			start_time = st;
			end_time = et;
		}
		
		public void setAssigned(char a) {
			assigned = a;
		}
	}
	
	public static class TaskSorterByStartTime implements Comparator<Task> {
		@Override
		public int compare(Task t1, Task t2) {
			return Integer.compare(t1.start_time, t2.start_time);
		}
	}

	public static class TaskSorterById implements Comparator<Task> {
		@Override
		public int compare(Task t1, Task t2) {
			return Integer.compare(t1.id, t2.id);
		}
	}
	public static void nextCase(int caseNum) {
		int task_num = scanner.nextInt();
		Task[] tasks = new Task[task_num];
		
		for (int i = 0; i < task_num; i++) {
			int start_time = scanner.nextInt();
			int end_time = scanner.nextInt();
			
			tasks[i] = new Task(i, start_time, end_time);
		}
		
		Arrays.sort(tasks, new TaskSorterByStartTime());
		
		Integer c_end_time = null;
		Integer j_end_time = null;
		boolean impossible = false;
		
		for (Task t : tasks) {
			if (c_end_time == null || c_end_time <= t.start_time) {
				c_end_time = t.end_time;
				t.setAssigned('C');
			} else if (j_end_time == null || j_end_time <= t.start_time) {
				j_end_time = t.end_time;
				t.setAssigned('J');
			} else {
				impossible = true;
				break;
			}
		}
		
		String result = "";
		
		if (impossible) {
			result = "IMPOSSIBLE";
		} else {
			Arrays.sort(tasks, new TaskSorterByStartTime());
			
			for (Task t : tasks) {
				result += t.assigned;
			}
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
