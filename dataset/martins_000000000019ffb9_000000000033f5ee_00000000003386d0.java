import java.util.*;
import java.io.*;
import java.math.*;
public class Solution {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int test = 1;
		while(T-- > 0) {
			int n = sc.nextInt();
			long[] x = new long[n];
			long[] y = new long[n];
			for(int i = 0; i < n; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			int res = 1;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(i == j) continue;
					long a = y[i] - y[j];
					long b = x[i] - x[j];
					Fraction f = new Fraction(a, b);
					HashMap<Fraction, ArrayList<Integer>> map = new HashMap<>();
					//get max in this case:
					if(b == 0) { // check x
						for(int k = 0; k < n; k++) {
							Fraction xf = (new Fraction(x[k], 1));
							if(!map.containsKey(xf)) {
								map.put(xf, new ArrayList());
							}
							map.get(xf).add(k);
						}
					}
					else {
						for(int k = 0; k < n; k++) {
							Fraction yinter = (new Fraction(y[k], 1)).subtract(f.mult(x[k]));
							if(!map.containsKey(yinter)) {
								map.put(yinter, new ArrayList());
							}
							map.get(yinter).add(k);
						}
					}
					int sumevs = 0;
					int countodsb1 = 0;
					int countones = 0;
					for(Fraction g: map.keySet()) {
						int s = map.get(g).size();
						if(s % 2 == 1) {
							if(s > 1) {
								countodsb1++;
								sumevs += s-1;
							}
							else{
								countones++;
							}
						}
						else {
							sumevs += s;
						}
					}
					int curr = sumevs;
					if(countodsb1 % 2 == 0) {
						curr += countodsb1;
						if(countones >= 2) curr += 2;
						else if(countones >= 1) curr++;
					}
					else {
						curr += countodsb1;
						if(countones >= 1) curr++;
					}
					res = Math.max(res, curr);
				}
			}
			System.out.printf("Case %d: %d\n", test++, res);
		}
	}
	
	static class Fraction{
		long a, b;
		public Fraction(long a, long b) {
			this.a = a; this.b = b;
//			long g = gcd(a, b);
//			a /= g; b /= g;
		}
		public Fraction add(Fraction f) {
			return new Fraction(a*f.b + f.a*b, b*f.b);
		}
		public Fraction subtract(Fraction f) {
			return add(f.mult(-1));
		}
		public Fraction mult(long x) {
			return new Fraction(a*x, b);
		}
		public Fraction mult(Fraction f) {
			return new Fraction(a*f.a, b*f.b);
		}
		public Fraction inv(Fraction f) {
			return new Fraction(b, a);
		}
		public Fraction div(Fraction f) {
			return mult(inv(f));
		}
		public int hashCode() {
			return (int)((a + b) % 1000000007);
		}
		public boolean equals(Object o) {
			Fraction f = (Fraction)o;
			return f.a * b == f.b * a;
		}
		static long gcd(long a, long b) {
			if(b > a) return gcd(b, a);
			else if(b == 0) return a;
			else return gcd(b, a % b);
		}
		public String toString() {
			return a+" "+b;
		}
	}
	
	static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
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
        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        public String nextLine() {
        	try {
        		return reader.readLine();
        	} catch(IOException e) {
        		throw new RuntimeException(e);
        	}
        }
    }

}
