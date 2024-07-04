import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		int numberOfCases = sc.nextInt();
		for (int caze = 1; caze <= numberOfCases; caze++) {
			long l = sc.nextLong();
			long r = sc.nextLong();
			boolean first = l >= r;
			long dif = first ? l - r : r - l - 1;
			long got = complete(dif, t -> calc(t), 0);
			if (first) {
				l -= calc(got);
			} else {
				r -= calc(got);
			}
			//System.err.println(got + " => " + l + " " + r);
			if (got + 1 <= (first ? l : r)) {
				got++;
				if (first) l-= got;
				else r -= got;
				
				//System.err.println(got + " => " + l + " " + r);
				
				long finalGot = got + 1;
				long next = complete(first ? r : l, t -> calc2(finalGot, t, false), -1);
				if (first) {
					r -= calc2(finalGot, next, false);
				} else {
					l -= calc2(finalGot, next, false);
				}
				long next2 = complete(first ? l : r, t -> calc2(finalGot, t, true), -1);
				if (first) {
					l -= calc2(finalGot, next2, true);
				} else {
					r -= calc2(finalGot, next2, true);
				}
				if (Math.abs(next - next2) > 1) throw new RuntimeException();
				got += next + 1 + next2 + 1;
			}
			
			out.println("Case #" + caze + ": " + got + " " + l + " " + r);
			
			out.flush();
		}
	}
	
	static long complete(long total, Function<Long, Long> calc, long from) {
		long left = from, right = 1500000000;
		while (left + 1 < right) {
			long med = (left + right) / 2;
			if (calc.apply(med) > total) {
				right = med;
			} else {
				left = med;
			}
		}
		return left;
	}
	
	static long calc(long pan) {
		return pan * (pan + 1) / 2;
	}
	
	static long calc2(long k, long t, boolean plus) {
		return (k + (plus ? 1 : 0)) * (t + 1) + t * (t + 1);
	}
	
	static class MyScanner {
		private BufferedReader br;
		private StringTokenizer tokenizer;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
