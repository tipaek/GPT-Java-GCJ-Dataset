import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

import static java.lang.Math.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		int t = in.nextInt();
		for(int tc = 1; tc <= t; tc ++) {
			int n = in.nextInt(), d = in.nextInt();
			long[] a = in.nextLongArray(n);
			if(n == 1) {
				System.out.println("Case #" + tc + ": " + (d - 1));
				continue;
			}
			TreeMap <Long, Integer> map = new TreeMap <> ();
			for(long ai : a) {
				if(!map.containsKey(ai))
					map.put(ai, 0);
				map.put(ai, map.get(ai) + 1);
			}
			int mink = Integer.MAX_VALUE;
			for(long size : map.keySet()) {
				// All of size
				// k <= d - map.get(size)
				int k = 0, rem = d - map.get(size);
				for(long size1 : map.tailMap(size + 1).keySet()) {
					for(int i = 0; i < map.get(size1) && rem > 0; i ++) {
						if(size1 % size != 0)
							continue;
						if(size1 / size > rem) {
							k += rem;
							rem = 0;
						} else {
							k += size1 / size - 1;
							rem -= size1 / size;
						}
					}
				}
				if(rem == 0)
					mink = min(mink, k);
			}
			System.out.println("Case #" + tc + ": " + mink);
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