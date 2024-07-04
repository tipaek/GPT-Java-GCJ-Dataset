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
		public static void main(String[] args) throws IOException {
			FastScanner fs=new FastScanner(System.in);
			int cases=fs.nextInt();
			for(int cas=1;cas<=cases;cas++) {
				int n = fs.nextInt();
				int sum = 0;
				int [][] m = new int[n][n];
				for(int i = 0; i < n; i++) {
					for(int j =0;j<n;j++) {
						m[i][j]=fs.nextInt();
						if(i==j) {
							sum+=m[i][j];
						}
					}
				}
				int rows = 0;
				for(int i = 0; i < n; i++) {
					HashSet<Integer> hs = new HashSet<Integer>();
					for(int j =0;j<n;j++) {
						hs.add(m[i][j]);
					}
					if(hs.size()!=n) {
						rows++;
					}
				}
				int cols = 0;
				for(int i = 0; i < n; i++) {
					HashSet<Integer> hs = new HashSet<Integer>();
					for(int j =0;j<n;j++) {
						hs.add(m[j][i]);
					}
					if(hs.size()!=n) {
						cols++;
					}
				}
				
				System.out.println("Case #" + cas +": "+sum+" "+rows+" "+cols);

			}

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


