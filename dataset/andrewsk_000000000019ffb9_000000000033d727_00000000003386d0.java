import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			long[] x = new long[n];
			long[] y = new long[n];
			for (int j = 0; j < n; j++) {
				x[j] = in.nextLong();
				y[j] = in.nextLong();
			}
			long res = process(x,y);
			System.out.println("Case #" + i + ": " + res);
		}
	}

	private static long process(long[] x, long[] y) {
		Map<Ratio, Set<Integer>> freq = new HashMap<>();
		int n = x.length;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				long dx = x[i] - x[j];
				long dy = y[i] - y[j];
				Ratio r = new Ratio(dx, dy);
				if (!freq.containsKey(r)) {
					freq.put(r, new HashSet<>());
				}
				freq.get(r).add(i);
				freq.get(r).add(j);
			}
		}
		int maxR = freq.values().stream().mapToInt(Set::size).max().orElse(-1);
		int res = Math.min(maxR + 2, n);
		return res;
	}

	static class Ratio {
		long num;
		long den;

		public Ratio() { }

		public boolean isInt() {
			return den == 1;
		}

		public Ratio(long num, long den) {
			this.num = num;
			this.den = den;
			simplify();
		}

		public void simplify() {
			long g = gcd(Math.abs(num), Math.abs(den));
			num = num / g;
			den = den / g;
			if (num < 0) {
				num *= -1;
				den *= -1;
			}
		}

		public Ratio clone() {
			Ratio c = new Ratio();
			c.num = num;
			c.den = den;
			return c;
		}

		public long gcd(long a, long b) {
			if (b==0) {
				return a;
			}
			return  gcd(b, a%b);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Ratio ratio = (Ratio) o;

			if (num != ratio.num) return false;
			return den == ratio.den;
		}

		@Override
		public int hashCode() {
			int result = (int) (num ^ (num >>> 32));
			result = 31 * result + (int) (den ^ (den >>> 32));
			return result;
		}

		public boolean lessOrEq(long x) {
			return num <= x * den;
		}

		@Override
		public String toString() {
			return "Ratio{" + num + "/" + den + '}';
		}
	}


}
