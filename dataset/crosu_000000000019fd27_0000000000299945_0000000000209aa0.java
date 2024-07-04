import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Solution {
	
	public static Boolean debug = false;
	public static Boolean fromFile = false;
	public static String inputFile = "testE.in";
	
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
	
	public static HashMap<Integer, Integer> to_trace_info(Vector<Integer> trace) {
		HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < trace.size(); i++) {
			int n = trace.get(i);
			if(values.containsKey(n)) {
				values.put(n, values.get(n) + 1);
			} else {
				values.put(n, 1);
			}
		}
		
		return values;
	}

	public static HashSet<Integer> to_trace_sig(Vector<Integer> trace) {
		HashMap<Integer, Integer> values = to_trace_info(trace);
		return new HashSet<Integer>(values.values());
	}
	
	public static int to_trace_sum(Vector<Integer> trace) {
		int sum = 0;

		for (int i = 0; i < trace.size(); i++) {
			sum += trace.get(i);
		}
		
		
		return sum;
	}
	
	public static class LatinSquare {
		ArrayList<Integer> content;
		int n;
		
		public LatinSquare(int n0) {
			n = n0;
			content = new ArrayList<Integer>(n*n);
			
			for (int i = 0; i < n*n; i++) {
				content.add(null);
			}
		}

		public LatinSquare(LatinSquare l) {
			content = new ArrayList<Integer>(l.content);
			n = l.n;
		}

		public int get(int k) {
			return content.get(k);
		}
		
		public int get(int i, int j) {
			return get(i*n+j);
		}
		
		public void set(int k, Integer value) {
			content.set(k, value);
		}
		
		public void set(int i, int j, Integer value) {
			set(i*n+j, value);
		}
		
		public String toString() {
			String ans = "";
			
			for (int i = 0; i < n; i++) {
				ans += "\n";
				
				for (int j = 0; j < n; j++) {
					ans += get(i,j);
					
					if (j < n - 1) {
						ans += " ";
					}
				}
			}
			
			return ans;
		}
		
		public boolean is_valid_set(int i, int j, int value) {
			for (int k = 0; k < i; k++) {
				if (get(k, j) == value) {
					return false;
				}
			}
			
			for (int k = 0; k < j; k++) {
				if (get(i, k) == value) {
					return false;
				}
			}
			
			return true;
		}
		
		public boolean is_valid_set(int k, int value) {
			int j = k % n;
			int i = k / n;
			return is_valid_set(i, j, value);
		}
		
		public Vector<Integer> trace() {
			Vector<Integer> trace = new Vector<Integer>();
			
			for (int i = 0; i < n; i++) {
				trace.add(get(i, i));
			}
			
			return trace;
			
		}
		
		public HashSet<Integer> trace_sig() {
			return to_trace_sig(trace());
		}
	}
	
	public static void advance(LatinSquare l, int next, HashMap<Set<Integer>, LatinSquare> latin_squares) {
		boolean last_step = next == (l.n * l.n - 1);
		
		for (int i = 0; i < l.n; i++) {
			if (l.is_valid_set(next, i+1))
			{
				l.set(next, i+1);
				
				if (last_step) {
					Set<Integer> trace_sig = l.trace_sig();
					
					if (!latin_squares.containsKey(trace_sig)) {
						latin_squares.put(trace_sig, new LatinSquare(l));
					}
				} else {
					advance(l, next + 1, latin_squares);
				}
			}
		}
		
		l.set(next, null);
	}
	
	
	
	public static HashMap<Set<Integer>, LatinSquare> generate_latin_squares(int n) {
		HashMap<Set<Integer>, LatinSquare> latin_squares = new HashMap<Set<Integer>, LatinSquare>();
		LatinSquare base = new LatinSquare(n);
		
		for (int i = 0; i < n; i++) {
			base.set(0, i, i+1);
		}
		
		advance(base, n, latin_squares);
		
		return latin_squares;
	}
	
	public static Vector<Integer> ith_trace(int i, int n) {
		Vector<Integer> digits = new Vector<Integer>(n);
		
		for (int j = 0; j < n; j++) {
			digits.add((i % n) + 1);
			i = i / n;
		}
		
		return digits;
	}
	
	
	public static Vector<Vector<Integer>> all_traces(int n) {
		Vector<Vector<Integer>> traces = new Vector<Vector<Integer>>(n);
		
		for (int i = 0; i < n * n; i++) {
			traces.add(ith_trace(i, n));
		}
		
		return traces;
	}
	
	public static LatinSquare convertLatinSquare(LatinSquare base, Vector<Integer> trace) {
		int[] mapping = new int[base.n];
		
		HashMap<Integer, Integer> base_trace_info = to_trace_info(base.trace());
		HashMap<Integer, Integer> this_trace_info = to_trace_info(trace);
		
		HashSet<Integer> unused_base = new HashSet<Integer>();
		
		for (int i = 0; i < base.n; i++) {
			unused_base.add(i+1);
		}
		
		for (int i = 0; i < trace.size(); i++) {
			int target_count = this_trace_info.get(i);
			
			for (int unused : unused_base) {
				if (base_trace_info.get(unused) == target_count) {
					mapping[unused] = i;
					unused_base.remove(unused);
					break;
				}
			}
		}
		
		LatinSquare ans = new LatinSquare(base);
		
		for (int i = 0; i < base.n; i++) {
			for (int j = 0; j < base.n; j++) {
				ans.set(i, j, mapping[base.get(i, j)]);
			}
		}
		
		return ans;
	}
	
	public static HashMap<Integer, LatinSquare> solve_for_n(int n) {
		HashMap<Set<Integer>, LatinSquare> latin_squares = generate_latin_squares(n);
		HashMap<Integer, LatinSquare> solutions = new HashMap<Integer, LatinSquare>(); 
		Vector<Vector<Integer>> traces = all_traces(n);
		
		for (int i = 0; i < traces.size(); i++) {
			Vector<Integer> trace = traces.get(i);
			HashSet<Integer> trace_sig = to_trace_sig(trace);
			int trace_sum = to_trace_sum(trace);
			if (latin_squares.containsKey(trace_sig)) {
				// properly convert here
				LatinSquare base_latin_square = latin_squares.get(trace_sig);
				
				solutions.put(trace_sum, base_latin_square);
			}
		}
		
		return solutions;	
	}
	
	public static void nextCase(int caseNum, HashMap<Integer, HashMap<Integer, LatinSquare>> solutions) {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		HashMap<Integer, LatinSquare> solutions_for_n = solutions.get(n);
		
		String result;
		
		if (!solutions_for_n.containsKey(k)) {
			result = "IMPOSSIBLE";
		} else {
			result = "POSSIBLE";
			LatinSquare answer = solutions_for_n.get(k);
			result += answer;
		}
		
		writer.print("Case #" + caseNum + ": " + result);
	}
	
	public static void main(String[] args) throws Exception {
		scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
		writer = new PrintWriter(System.out);
		
		int t = scanner.nextInt();
		
		HashMap<Integer, HashMap<Integer, LatinSquare>> solutions = new HashMap<Integer, HashMap<Integer, LatinSquare>>();
		
		for (int i = 2; i <= 5; i++) {
			solutions.put(i, solve_for_n(i));
		}

		debugPrintln("Solution is\n" + solutions);
		
		for (int i = 0; i < t; i++) {
			nextCase(i+1, solutions);
			
			if (i < t - 1) {
				writer.println("");
			}
		}
		
		writer.close();
		scanner.close();
	}
}
