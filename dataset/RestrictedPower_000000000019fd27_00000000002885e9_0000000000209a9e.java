import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;
/*
    Solution Created: 22:34:20 04/04/2020
    Custom Competitive programming helper.
*/

public class Main {
	static Writer out;
	static Reader in;
	public static void solve(Reader inx, Writer o) {
		out = o;
		in = inx;
		int t = in.nextInt(),b = in.nextInt();
		for(int i = 1; i<=t; i++) {
			solveCase(in, out, b);
		}
	}
	static void solveCase(Reader in, Writer out, int n) {
		int[] a = new int[n];
		Arrays.fill(a, -1);
		int l = 0;
		int both1Idx = -1,both0Idx = -1, zeroOneIdx = -1, oneZeroIdx=-1;
		int i = 1;
		while(true) {
			if(i%10!=1||i==1) {
				int[] A = ask(l, n-l-1);
				a[l] = A[0];
				a[n-l-1] = A[1];
				if(A[0]==0&&A[1]==0) both0Idx = l;
				else if(A[0]==1&&A[1]==1) both1Idx = l;
				else if(A[0]==1&&A[1]==0) oneZeroIdx = l;
				else if(A[0]==0&&A[1]==1) zeroOneIdx = l;
				l++;
				i+=2;
				if(l>=n-l-1) break;
			}else {
				int change = -1;
				//start of statement
				if(both1Idx!=-1 && zeroOneIdx!=-1) {
					int[] res = new int[3];
					int[] A = ask(both1Idx, n-both1Idx-1);
					if(A[0]==0&&A[1]==0) {
						res[0]++;
						res[2]++;
					}else {
						res[1]++;
						res[3]++;
					}
					A = ask(zeroOneIdx, n-zeroOneIdx-1);
					if(A[0]==1&&A[1]==0) {
						res[0]++;
						res[1]++;
					}else {
						res[2]++;
						res[3]++;
					}
					int mx = 0;
					for(int m = 1; m<4; m++) if(res[m]>res[mx]) mx = m;
					change = mx;
					i+=4;
				}else if(both0Idx!=-1 && oneZeroIdx != -1) {
					
					int[] res = new int[3];
					int[] A = ask(both0Idx, n-both0Idx-1);
					if(A[0]==1&&A[1]==1) {
						res[0]++;
						res[2]++;
					}else {
						res[1]++;
						res[3]++;
					}
					A = ask(oneZeroIdx, n-oneZeroIdx-1);
					if(A[0]==0&&A[1]==1) {
						res[0]++;
						res[1]++;
					}else {
						res[2]++;
						res[3]++;
					}
					int mx = 0;
					for(int m = 1; m<4; m++) if(res[m]>res[mx]) mx = m;
					change = mx;
					i+=4;
				}else if(both1Idx!=-1) {
					int[] A = ask(both1Idx, n-both1Idx-1);
					if(A[0]==0&&A[1]==0) {
						change = 0;
					}
					i+=2;
				}else if(both0Idx!=-1) {
					int[] A = ask(both0Idx, n-both0Idx-1);
					if(A[0]==1&&A[1]==1) {
						change = 0;
					}
					i+=2;
				}else if(zeroOneIdx!=-1) {
					int[] A = ask(zeroOneIdx, n-zeroOneIdx-1);
					if(A[0]==1&&A[1]==0) {
						change = 0;
					}
					i+=2;
				}else if(oneZeroIdx!=-1) {
					int[] A = ask(oneZeroIdx, n-oneZeroIdx-1);
					if(A[0]==0&&A[1]==1) {
						change = 0;
					}
					i+=2;
				}
				//end of statement
				if(change==-1) continue;
				int[] t = {both1Idx,both0Idx,zeroOneIdx,oneZeroIdx};
				if(change == 0) {
					both0Idx = t[0];
					both1Idx = t[1];
					oneZeroIdx = t[2];
					zeroOneIdx = t[3];
					o1(a);
					out.println("swap det");
					out.flush();
				}else if(change==1) {
					oneZeroIdx = t[2];
					zeroOneIdx = t[3];
					out.println("rev det");
					out.flush();
				}else if(change==2) {
					both0Idx = t[0];
					both1Idx = t[1];
					out.println("both det");
					out.flush();
				}
			}
		}
		for(int j = 0; j<n; j++) out.print(a[j]);
		out.println();
		out.flush();
		String cor = in.next();
		if(cor.equalsIgnoreCase("N")) System.exit(0);
		
	}
	public static int[] ask(int i, int j) {
		out.println(i+1);
		out.flush();
		int lA = in.nextInt();
		out.println(j+1);
		out.flush();
		int rA = in.nextInt();
		return new int[]{lA,rA};
	}
	public static void o1(int[] a) { //swap
		for(int i = 0; i<a.length; i++) a[i] = a[i]==1?0:1;
	}
	public static void o2(int[] a) { //reverse
		Util.reverse(a);
	}
	public static void o3(int[] a) { //both
		o1(a);
		o2(a);
	}
	public static void main(String[] args) {
		Reader in = new Reader();
		Writer out = new Writer();
		solve(in, out);
		out.exit();
	}

static class Graph {
	private ArrayList<Integer> con[];
	private boolean[] visited;

	public Graph(int n) {
		con = new ArrayList[n];
		for (int i = 0; i < n; ++i)
			con[i] = new ArrayList();
		visited = new boolean[n];
	}

	public void reset() {
		Arrays.fill(visited, false);
	}

	public void addEdge(int v, int w) {
		con[v].add(w);
	}

	public void dfs(int cur) {
		visited[cur] = true;
		for (Integer v : con[cur]) {
			if (!visited[v]) {
				dfs(v);
			}
		}
	}

	public void bfs(int cur) {
		Queue<Integer> q = new LinkedList<>();
		q.add(cur);
		visited[cur] = true;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (Integer v : con[cur]) {
				if (!visited[v]) {
					visited[v] = true;
					q.add(v);
				}
			}
		}
	}
}

static class Reader {
	static BufferedReader br;
	static StringTokenizer st;
	private int charIdx = 0;
	private String s;

	public Reader() {
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Reader(String f){
		try {
			this.br = new BufferedReader(new FileReader(f));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	public double[] nd(int n) {
		double[] a = new double[n];
		for (int i = 0; i < n; i++)
			a[i] = nextDouble();
		return a;
	}

	public char nextChar() {
		if (s == null || charIdx >= s.length()) {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			s = st.nextToken();
			charIdx = 0;
		}
		return s.charAt(charIdx++);
	}

	public long[] nl(int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nextLong();
		return a;
	}

	public char[] nca() {
		return next().toCharArray();
	}

	public String[] nS(int n) {
		String[] a = new String[n];
		for (int i = 0; i < n; i++)
			a[i] = next();
		return a;
	}

	public int nextInt() {
		if (st == null || !st.hasMoreTokens())
			try {
				readLine();
			} catch (Exception e) {
			}
		return Integer.parseInt(st.nextToken());
	}

	public double nextDouble() {
		if (st == null || !st.hasMoreTokens())
			try {
				readLine();
			} catch (Exception e) {
			}
		return Double.parseDouble(st.nextToken());
	}

	public Long nextLong() {
		if (st == null || !st.hasMoreTokens())
			try {
				readLine();
			} catch (Exception e) {
			}
		return Long.parseLong(st.nextToken());
	}

	public String next() {
		if (st == null || !st.hasMoreTokens())
			try {
				readLine();
			} catch (Exception e) {
			}
		return st.nextToken();
	}

	public static void readLine() {
		try {
			st = new StringTokenizer(br.readLine());
		} catch (Exception e) {
		}
	}
}

static class Util{
		private static Random random = new Random();
		
		//##################################################################################################################
		//# Factorial computation algorithm																				   #
		//##################################################################################################################
		static long[] fact;
		public static void initFactorial(int n, long mod) {
			fact = new long[n+1];
			fact[0] = 1;
			for (int i = 1; i < n+1; i++) fact[i] = (fact[i - 1] * i) % mod;
		}
		
		//##################################################################################################################
		//# Mod inverse algorithm																						   #
		//##################################################################################################################
		public static long modInverse(long a, long MOD) {
			long[] gcdE = gcdExtended(a, MOD);
			if (gcdE[0] != 1) return -1; // Inverted doesn't exist
			long x = gcdE[1];
			return (x % MOD + MOD) % MOD;
		}

		//##################################################################################################################
		//# Euclid's gcd extended algorithm																				   #
		//##################################################################################################################
		public static long[] gcdExtended(long p, long q) {
			if (q == 0) return new long[] { p, 1, 0 };
			long[] vals = gcdExtended(q, p % q);
			long tmp = vals[2];
			vals[2] = vals[1] - (p / q) * vals[2];
			vals[1] = tmp;
			return vals;
		}
		
		//##################################################################################################################
		//# nCr computation algorithms.																					   #
		//##################################################################################################################
		public static long nCr(int n, int r, long MOD) {
			if (r == 0) return 1;
			return (fact[n] * modInverse(fact[r], MOD) % MOD * modInverse(fact[n - r], MOD) % MOD) % MOD;
		}
		public static long nCr(int n, int r) {
			return (fact[n]/fact[r])/fact[n-r];
		}
		
		//##################################################################################################################
		//# nPr computation algorithms.																					   #
		//##################################################################################################################
		public static long nPr(int n, int r, long MOD) {
			if (r == 0) return 1;
			return (fact[n] * modInverse(fact[n - r], MOD) % MOD) % MOD;
		}
		public static long nPr(int n, int r) {
			return fact[n]/fact[n-r];
		}
		
		//##################################################################################################################
		//# Checks if the given integer is Prime																		   #
		//##################################################################################################################
		public static boolean isPrime(int n) { 
	        if (n <= 1) return false; 
	        if (n <= 3) return true; 
	        if (n % 2 == 0 || n % 3 == 0) return false; 
	        for (int i = 5; i * i <= n; i = i + 6) 
	            if (n % i == 0 || n % (i + 2) == 0) 
	            return false; 
	        return true; 
	    }
		
		//##################################################################################################################
		//# Returns the smallest index i such that a[i]>=val, for int and long values									   #
		//##################################################################################################################
	    public static int lowerBound(int[] a, int v) {
	    	int l = 0, h = a.length;
	    	while(l<h) {
	    		int mid = (l+h)/2;
	    		if(v<=a[mid]) h = mid;
	    		else l = mid+1;
	    	}
	    	return l;
	    }
	    public static int lowerBound(long[] a, long v) {
	    	int l = 0, h = a.length;
	    	while(l<h) {
	    		int mid = (l+h)/2;
	    		if(v<=a[mid]) h = mid;
	    		else l = mid+1;
	    	}
	    	return l;
	    }
	    
		//##################################################################################################################
		//# Returns the smallest index i such that a[i]>val, for int and long values									   #
		//##################################################################################################################
	    public static int upperBound(int[] a, int v) {
	    	int l = 0, h = a.length;
	    	while(l<h) {
	    		int mid = (l+h)/2;
	    		if(a[mid]<=v) l = mid+1;
	    		else h = mid;
	    	}
	    	return l;
	    }
	    public static int upperBound(long[] a, long v) {
	    	int l = 0, h = a.length;
	    	while(l<h) {
	    		int mid = (l+h)/2;
	    		if(a[mid]<=v) l = mid+1;
	    		else h = mid;
	    	}
	    	return l;
	    }
		
		//##################################################################################################################
		//# Returns the sieve of eratosthenes up to a value n.				   											   #
		//##################################################################################################################
	    public static boolean[] getSieve(int n) {
	        boolean[] isPrime = new boolean[n+1];
	        for (int i = 2; i <= n; i++) isPrime[i] = true;
	        for (int i = 2; i*i <= n; i++) if (isPrime[i]) 
	                for (int j = i; i*j <= n; j++) isPrime[i*j] = false;
	        return isPrime;
	    }
	    
		//##################################################################################################################
		//# Gcd algorithms for long and int values.							   											   #
		//##################################################################################################################
	    public static int gcd(int a, int b) { 
	    	int tmp = 0;
	    	while(b != 0) {
	    		tmp = b;
	    		b = a%b;
	    		a = tmp;
	    	}
	    	return a;
	    }
	    public static long gcd(long a, long b) { 
	    	long tmp = 0;
	    	while(b != 0) {
	    		tmp = b;
	    		b = a%b;
	    		a = tmp;
	    	}
	    	return a;
	    }
	    
	    //##################################################################################################################
	    //# Random number generator, from min to max.											   						   #
	    //##################################################################################################################
	    public static int random(int min, int max) {
	    	return random.nextInt(max-min+1)+min;
	    }
	    
	    //##################################################################################################################
	    //# Helper function for debug.															   						   #
	    //##################################################################################################################
		public static void dbg(Object... o) { 
			System.out.println(Arrays.deepToString(o)); 
		}
		
		//##################################################################################################################
		//# Reverse functions for int, long, float, double, char data types and for objects. 							   #
		//##################################################################################################################
		public static void reverse(int[] s, int l , int r) {
			for(int i = l; i<=(l+r)/2; i++) {
				int tmp = s[i];
				s[i] = s[r+l-i];
				s[r+l-i] = tmp;
			}
	    }
		public static void reverse(int[] s) {
			reverse(s, 0, s.length-1);
	    }
		public static void reverse(long[] s, int l , int r) {
			for(int i = l; i<=(l+r)/2; i++) {
				long tmp = s[i];
				s[i] = s[r+l-i];
				s[r+l-i] = tmp;
			}
	    }
		public static void reverse(long[] s) {
			reverse(s, 0, s.length-1);
	    }
		public static void reverse(float[] s, int l , int r) {
			for(int i = l; i<=(l+r)/2; i++) {
				float tmp = s[i];
				s[i] = s[r+l-i];
				s[r+l-i] = tmp;
			}
	    }
		public static void reverse(float[] s) {
			reverse(s, 0, s.length-1);
	    }
		public static void reverse(double[] s, int l , int r) {
			for(int i = l; i<=(l+r)/2; i++) {
				double tmp = s[i];
				s[i] = s[r+l-i];
				s[r+l-i] = tmp;
			}
	    }
		public static void reverse(double[] s) {
			reverse(s, 0, s.length-1);
	    }
		public static <T> void reverse(T[] s, int l , int r) {
			for(int i = l; i<=(l+r)/2; i++) {
				T tmp = s[i];
				s[i] = s[r+l-i];
				s[r+l-i] = tmp;
			}
	    }
		public static <T> void reverse(T[] s) {
			reverse(s, 0, s.length-1);
	    }
		
		//##################################################################################################################
		//# Shuffle functions for int, long, float, double, char data types and for objects. 							   #
		//##################################################################################################################
		public static void shuffle(int[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            int t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
	    public static void shuffle(long[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            long t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
	    public static void shuffle(float[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            float t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
	    public static void shuffle(double[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            double t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
	    public static void shuffle(char[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            char t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
	    public static <T> void shuffle(T[] s) {
	        for (int i = 0; i < s.length; ++i) {
	            int j = random.nextInt(i + 1);
	            T t = s[i];
	            s[i] = s[j];
	            s[j] = t;
	        }
	    }
		
		//##################################################################################################################
		//# Sort functions for int, long, float, double, char data types and for Objects that implement comparable. 	   #
	    //# The reason that we shuffle all the data types except the Object one, is that java uses merge sort for 		   #
	    //# Objects and quickSort for the other data types. QuickSort can go up to O(n^2) for some anti-java testcases,	   #
	    //# so we need to shuffle the array to prevent that.															   #
		//##################################################################################################################
		public static void sortArray(int[] a) {
	        shuffle(a);
	        Arrays.sort(a);
	    }
		public static void sortArray(long[] a) {
			shuffle(a);
	        Arrays.sort(a);
	    }
		public static void sortArray(float[] a) {
			shuffle(a);
	        Arrays.sort(a);
	    }
		public static void sortArray(double[] a) {
			shuffle(a);
	        Arrays.sort(a);
	    }
		public static void sortArray(char[] a) {
			shuffle(a);
	        Arrays.sort(a);
	    }
		public static <T extends Comparable<T>> void sortArray(T[] a) {
	        Arrays.sort(a);
	    }
	}

static class Writer {
	private PrintWriter pw;
	public Writer(){
		pw = new PrintWriter(System.out);
	}
	
	public Writer(String f){
		try {
			pw = new PrintWriter(new FileWriter(f));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printArray(int[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
	}
	public void printlnArray(int[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
		pw.println();
	}
	public void printArray(long[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
	}
	public void printlnArray(long[] a) {
		for(int i = 0; i<a.length; i++) print(a[i]+" ");
		pw.println();
	}
	public void print(Object o) {
		pw.print(o.toString());
	}
	public void println(Object o) {
		pw.println(o.toString());
	}
	public void println() {
		pw.println();
	}
	public void flush() {
		pw.flush();
	}
	public void exit() {
		pw.close();
	}
}
}
