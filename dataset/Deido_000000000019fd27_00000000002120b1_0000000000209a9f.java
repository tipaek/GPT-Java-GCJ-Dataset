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
		for(int tc = 1; tc <= t; tc ++) {
			char[] s = in.next().toCharArray();
			int n = s.length;
			StringBuilder ans = new StringBuilder();
			int d = 0;
			for(int i = 0; i < n; i ++) {
				if(d > s[i] - '0') {
					while(d > s[i] - '0') {
						ans.append(")");
						d --;
					}
				} else {
					while(d < s[i] - '0') {
						ans.append("(");
						d ++;
					}
				}
				ans.append(s[i]);
			}
			for(int j = 0; j < d; j ++)
				ans.append(")");
			System.out.println("Case #" + tc + ": " + ans);
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