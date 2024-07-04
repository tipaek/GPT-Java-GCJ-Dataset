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
	public static void main(String[] args) throws IOException {
		int t = in.nextInt();
		int b = in.nextInt();
		final int Q = 10;
		for(int tc = 1; tc <= t; tc ++) {
			int[] arr = new int[b];
			int found = 0, done = 0;
			while(found < b) {
				if(done % 10 == 0 && done != 0) {
					int ans = -1;
					int eq = -1;
					for(int i = 0; i < found / 2 && eq == -1; i ++)
						if(arr[i] == arr[b - 1 - i])
							eq = i;
					if(eq != -1) {
						System.out.println(eq + 1);
						System.out.flush();
						ans = in.nextInt();
						if(ans != arr[eq])
							for(int i = 0; i < found / 2; i ++) {
								arr[i] ^= 1;
								arr[b - 1 - i] ^= 1;
							}
						System.out.println(b - eq); // just to maintain parity
						System.out.flush();
						in.nextInt();
						done += 2;
					}
					int diff = -1;
					for(int i = 0; i < found / 2 && diff == -1; i ++)
						if(arr[i] != arr[b - 1 - i])
							diff = i;
					if(diff != -1) {
						System.out.println(diff + 1);
						System.out.flush();
						ans = in.nextInt();
						if(ans != arr[diff])
							for(int i = 0; i < found / 2; i ++) {
								int s = arr[i];
								arr[i] = arr[b - 1 - i];
								arr[b - 1 - i] = s;
							}
						System.out.println(b - diff); // just to maintain parity
						System.out.flush();
						in.nextInt();
						done += 2;
					}
				}
				System.out.println(found / 2 + 1);
				System.out.flush();
				arr[found / 2] = in.nextInt();
				System.out.println(b - found / 2);
				System.out.flush();
				arr[b - 1 - found / 2] = in.nextInt();
				found += 2;
				done += 2;
			}
			StringBuilder s = new StringBuilder();
			for(int bi : arr)
				s.append(bi);
			System.out.println(s);
			System.out.flush();
			if(in.next().equals("N"))
				return;
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