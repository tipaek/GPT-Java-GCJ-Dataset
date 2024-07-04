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
			int n = in.nextInt();
			int k = in.nextInt();
			StringBuilder sb = null;
			for(int z = 1; z <= n && z * n <= k; z ++) {
				int[][] ans = new int[n][n];
				for(int i = 0; i < n; i ++)
					ans[0][i] = i + 1;
				ans[0][z - 1] = 1;
				ans[0][0] = z;
				for(int i = 1; i < n; i ++)
					for(int j = 0; j < n; j ++)
						ans[i][j] = ans[0][(n - i + j) % n];
				int kk = k - z * n;
				for(int i = 0; i < n; i ++) {
					for(int j = i + 1; j < n; j ++) {
						int d = ans[i][j] + ans[j][i] - ans[i][i] - ans[j][j];
						if(d <= 0 || d > kk)
							continue;
						int[] s = ans[i];
						ans[i] = ans[j];
						ans[j] = s;
						kk -= d;
					}
				}
				if(kk != 0)
					continue;
				sb = new StringBuilder("Case #" + tc + ": POSSIBLE\n");
				for(int i = 0; i < n; i ++) {
					for(int j = 0; j < n; j ++)
						sb.append(ans[i][j] + " ");
					sb.append("\n");
				}
				break;
			}
			if(sb == null) {
				System.out.println("Case #" + tc + ": IMPOSSIBLE");
				continue;
			}
			System.out.print(sb);
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