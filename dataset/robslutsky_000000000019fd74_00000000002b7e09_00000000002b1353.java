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
			for(int cas =1;cas<= cases;cas++) {
				int n = fs.nextInt();
				StringBuilder sb = new StringBuilder("");
				if(n <= 500) {
					for(int i = 1; i<=n; i++) {
						sb.append(i+" "+ 1 +" \n");
					}
				}
				else if(n==501) {
					sb.append(1+" "+ 1 +" \n");
					sb.append(2+" "+ 1 +" \n");
					sb.append(3+" "+ 2 +" \n");
					sb.append(3+" "+ 1 +" \n");
					int sum = 5;
					int row = 4;
					while(sum < n) {
						sb.append(row+" "+ 1 +" \n");
						sum++;
						row++;
					}
				}
				System.out.println("Case #"+cas+": ");
				System.out.print(sb);
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