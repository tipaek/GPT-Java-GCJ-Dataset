import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
		static HashMap<BigDecimal, BigDecimal> map = new HashMap<BigDecimal, BigDecimal> ();
		public static void main(String[] args) throws IOException {
			FastScanner fs=new FastScanner(System.in);
			int t=fs.nextInt();
			for(int cas=1; cas<=t;cas++) {
				long l = fs.nextLong();
				long r = fs.nextLong();
				long tr = 1;
				while(tr <=l || tr <=r) {
					if(r > l) {
						r -= tr;
					}
					else {
						l -= tr;
					}
					tr++;
				}
				System.out.println("Case #"+cas+": "+(tr-1)+" "+l+" "+r);
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
