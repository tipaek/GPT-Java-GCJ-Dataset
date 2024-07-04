import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
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
		static HashMap<BigDecimal, BigDecimal> map = new HashMap<BigDecimal, BigDecimal> ();
		public static void main(String[] args) throws IOException {
			Scanner fs=new Scanner(System.in);
			int t=fs.nextInt();
			for(int cas=1; cas<=t;cas++) {
				int n = fs.nextInt();
				int d = fs.nextInt();
				ArrayList<Long> arr = new ArrayList<Long>();
				HashMap<Long, Integer> hmcounts = new HashMap<Long, Integer>();
//				HashMap<Long, Integer> hmbt = new HashMap<Long, Integer>();
				
				for(int i = 0; i < n;i++) {
					long j = fs.nextLong();
					if(hmcounts.containsKey(j)) {
						hmcounts.put(j, hmcounts.get(j)+1);
					}
					else {
						hmcounts.put(j, 1);
						arr.add(j);
					}

				}
				Collections.sort(arr);
//				long ans = 75;
//				for(int i = 0; i <arr.length; i++) {
//					long cut = 0;
//					long pm = 0;
//					long rem = d - hmcounts.get(arr[i]);
//					for(int q = i+1; q < arr.length; i++) {
//						long um = arr[q]/arr[i];
//						long pg = hmcounts.get(arr[q])*um;
//						if(arr[q] % arr[i] == 0L) {
//							pm += hmcounts.get(arr[q]);
//						}
//						if(rem == 0) {
//							continue;
//						}
//						if(pg >= rem) {
//							cut +=rem;
//							rem = 0;
//						}
//						else {
//							cut += pg;
//							rem -= pg;
//						}
//					}
//				}
				if(d==2) {
					int ans = 1;
					for(int i = 0; i<arr.size();i++) {
						if(hmcounts.get(arr.get(i))>=d) {
							ans = 0;
							break;
						}
					}
					System.out.println("Case #"+ cas+": "+ans);
				}
				else if(d==3) {
					int ans = 2;
					for(int i = 0; i<arr.size();i++) {
						if(hmcounts.get(arr.get(i))>=d) {
							ans = 0;
							break;
						}
						else if(hmcounts.get(arr.get(i))==2 && i != arr.size() -1) {
							ans = 1;
						}
						else if(hmcounts.get(arr.get(i))==1 && hmcounts.containsKey(arr.get(i)*2)) {
							ans = 1;
						}
					}
					System.out.println("Case #"+ cas+": "+ans);

				}
				
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




