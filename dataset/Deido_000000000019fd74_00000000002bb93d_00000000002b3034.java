import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

import static java.lang.Math.*;

public class Solution {
	public static String solve(int n, String[] p) {
		int[] ast = new int[n];
		int imax = 0;
		for(int i = 0; i < n; i ++) {
			ast[i] = p[i].indexOf('*');
			if(ast[i] > ast[imax])
				imax = i;
		}
		boolean ok = true;
		for(int i = 0; i < n; i ++)
			ok &= p[imax].startsWith(p[i].substring(0, ast[i]));
		if(!ok)
			return null;
		StringBuilder ans = new StringBuilder(p[imax].substring(0, ast[imax]));
		int[] last = new int[n];
		while(true) {
			boolean found = false;
			for(int i = 0; i < n; i ++) {
				int next = p[i].indexOf('*', ast[i] + 1);
				if(next == -1) {
					last[i] = ast[i];
					continue;
				}
				found = true;
				ans.append(p[i].substring(ast[i] + 1, next));
				ast[i] = next;
			}
			if(!found)
				break;
		}
		imax = 0;
		for(int i = 0; i < n; i ++) 
			if(p[i].length() - last[i] - 1 > p[imax].length() - last[imax] - 1)
				imax = i;
		for(int i = 0; i < n; i ++)
			if(last[i] != p[i].length() - 1)
				if(!p[imax].endsWith(p[i].substring(last[i] + 1)))
					return null;
		ans.append(p[imax].substring(last[imax] + 1));
		return ans.toString();
	}
	
	public static void main(String[] args) throws IOException {
		int t = in.nextInt();
		for(int tc = 1; tc <= t; tc ++) {
			int n = in.nextInt();
			String[] p = in.nextStringArray(n);
			String ans = solve(n, p);
			if(ans == null)
				System.out.println("Case #" + tc + ": *");
			else
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