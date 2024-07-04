import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

import static java.lang.Math.*;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class Solution {
	public static boolean diag(boolean[] used, int k, int rem) {
		if(k == 0) 
			return rem == 0;
		for(int i = 0; i < used.length; i ++) {
			if(used[i] || k < 2 * (i + 1))
				continue;
			used[i] = true;
			if(diag(used, k - 2 * (i + 1), rem - 1))
				return true;
			used[i] = false;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		int t = in.nextInt();
		for(int tc = 1; tc <= t; tc ++) {
			int n = in.nextInt();
			int k = in.nextInt();
			if(k % n == 0) {
				// n 0 0 0 ... 0 0
				System.out.println("Case #" + tc + ": POSSIBLE");
				int[] fl = new int[n];
				for(int i = 0; i < n; i ++)
					fl[i] = i + 1;
				fl[k / n - 1] = 1;
				fl[0] = k / n;
				for(int j = 0; j < n; j ++)
					System.out.print(fl[j] + " ");
				System.out.println();
				for(int i = 1; i < n; i ++) {
					for(int j = 0; j < n; j ++) 
						System.out.print(fl[(n - i + j) % n] + " ");
					System.out.println();
				}
				continue;
			}
			if(n % 2 == 0) {
				// 2 0 2 0 ... 2 0
				boolean[] used = new boolean[n];
				if(diag(used, k, n / 2)) {
					System.out.println("Case #" + tc + ": POSSIBLE");
					int[] fl = new int[n];
					int cnt = 0;
					for(int i = 0; i < n; i ++) {
						if(!used[i])
							continue;
						fl[cnt] = i + 1;
						cnt += 2;
					}
					cnt = 1;
					for(int i = 0; i < n; i ++) {
						if(used[i])
							continue;
						fl[cnt] = i + 1;
						cnt += 2;
					}
					for(int j = 0; j < n; j ++)
						System.out.print(fl[j] + " ");
					System.out.println();
					for(int i = 1; i < n; i ++) {
						for(int j = 0; j < n; j ++) 
							System.out.print(fl[(i + j) % n] + " ");
						System.out.println();
					}
				} else {
					System.out.println("Case #" + tc + ": IMPOSSIBLE");
				}
			} else {
				// 1 1 1 1 ... 1 1
				if(k == n * (n + 1) / 2) {
					System.out.println("Case #" + tc + ": POSSIBLE");
					int[] fl = new int[n];
					for(int i = 0; i < n; i ++)
						fl[i] = i + 1;
					for(int j = 0; j < n; j ++)
						System.out.print(fl[j] + " ");
					System.out.println();
					for(int i = 1; i < n; i ++) {
						for(int j = 0; j < n; j ++) 
							System.out.print(fl[(i + j) % n] + " ");
						System.out.println();
					}
				} else {
					System.out.println("Case #" + tc + ": IMPOSSIBLE");
				}
			}
		}
    } 
 
    public static FastReader in = new FastReader();
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
}
 
class FastReader {
    BufferedReader br;
    StringTokenizer st;
 
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException  e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    public char nextChar() {
        return next().charAt(0);
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
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    
    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for(int i = 0; i < n; i ++)
            a[i] = nextInt();
        return a;
    }
    
    public Integer[] nextIntegerArray(int n) {
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i ++)
            a[i] = nextInt();
        return a;
    }
    
    public long[] nextLongArray(int n) {
        long[] a = new long[n];
        for(int i = 0; i < n; i ++)
            a[i] = nextLong();
        return a;
    }
    
    public double[] nextDoubleArray(int n) {
        double[] a = new double[n];
        for(int i = 0; i < n; i ++)
            a[i] = nextDouble();
        return a;
    }
    
    public String[] nextStringArray(int n) {
        String[] a = new String[n];
        for(int i = 0; i < n; i ++)
            a[i] = next();
        return a;
    }
}