import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
		static StringBuilder sb;
		public static void main(String[] args) throws IOException {
			FastScanner fs=new FastScanner(System.in);
			int cases=fs.nextInt();
			for(int cas=1;cas<=cases;cas++) {
				String[] a = fs.next().split("");
				int[] vals = new int[a.length];
				for(int i = 0; i <a.length; i++)
					vals[i] = Integer.parseInt(a[i]);
				int [] o = vals.clone();
				sb = new StringBuilder();
				System.out.print("Case #" + cas +": ");
				System.out.println(doStuff(0,a.length-1, vals, o));
			}

		}

		public static String doStuff(int b, int e, int[] a, int[] v) {
			if(b > e)
				return "";
			if(b>= a.length)
				return "";

			if(a[b] != 0) {
				boolean works = true;
				String beg = "";
				String end = "";
				while(works) {
					int bpos = 0;
					for(int k = b; k <= e; k++) {
						if(a[k] == 0) {
							works = false;
							bpos = k;
							break;
						}
					}
					if(works) {
						for(int k = b; k <= e; k++) {
							a[k] --;
						}
						beg+="(";
						end +=")";
					}
					else if(a[b] != 0){
						return beg + doStuff(b, bpos - 1, a,v)+v[bpos] + doStuff(bpos+ 1, e, a,v)+end;
					}
					else {
						return beg+""+v[b]+doStuff(bpos + 1, e,a, v)+end;
					}
				}
			}
			return v[b]+doStuff(b+1,e,a,v);
			
		}
		
		static class FastScanner {
		    BufferedReader br;
		    StringTokenizer st;
		    public FastScanner(InputStream i){
		        br = new BufferedReader(new InputStreamReader(i));
		        st = new StringTokenizer("");
		    }
		    public String next() throws IOException{
		        if(st.hasMoreTokens()) return st.nextToken();
		        else st = new StringTokenizer(br.readLine());
		        return next();
		    }
		    public long nextLong() throws IOException{ return Long.parseLong(next()); }
		    public int nextInt() throws IOException { return Integer.parseInt(next()); }
		    public double nextDouble() throws IOException { return Double.parseDouble(next()); }
		    public String nextLine() throws IOException {
		        if(!st.hasMoreTokens()) 
		            return br.readLine();
		        String ret = st.nextToken();
		        while(st.hasMoreTokens()) 
		            ret += " " + st.nextToken();
		        return ret;
		    }
		}
	}


