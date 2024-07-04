import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

import static java.lang.Math.*;

public class Solution {
	public static long bin(long n, long k) {
		if(n - k >= 10)
			return (long)1E9;
		long ans = 1;
		long e = n - k + 1;
		while(n >= e) 
			ans *= n --;
		while(k >= 2)
			ans /= k --;
		return ans;
	}
	
	public static boolean dfs(int rc, int kc, boolean[][] used, long rem, int s, ArrayList <String> path) {
		if(rem == 0)
			return true;
		if(s == 0)
			return rem == 0;
		for(int dr = -1; dr <= 1; dr ++) {
			for(int dk = -1; dk <= 1; dk ++) {
				if(dr == 0 && dk == 0)
					continue;
				if(rc + dr < 1)
					continue;
				if(kc + dk < 1 || kc + dk > rc + dr)
					continue;
				long b = bin(rc + dr, kc + dk);
				if(b > rem || used[rc + dr][kc + dk])
					continue;
				used[rc + dr][kc + dk] = true;
				path.add((rc + dr) + " " + (kc + dk));
				if(dfs(rc + dr, kc + dk, used, rem - b, s - 1, path))
					return true;
				used[rc + dr][kc + dk] = false;
				path.remove(path.size() - 1);
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		int t = in.nextInt();
		for(int tc = 1; tc <= t; tc ++) {
			long n = in.nextLong();
			boolean[][] used = new boolean[50][50];
			ArrayList <String> path = new ArrayList <> ();
			path.add("1 1");
			used[1][1] = true;
			n --;
			dfs(1, 1, used, n, 500, path);
			System.out.println("Case #" + tc + ":");
			for(String s : path)
				System.out.println(s);
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