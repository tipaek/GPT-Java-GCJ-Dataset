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
					sb.append(2+" "+ 2 +" \n");
					int sum = 4;
					int row = 3;
					while(sum < n) {
						sb.append(row+" "+ 1 +" \n");
						sum++;
						row++;
					}
				}
				else {
					int[][] moves = new int[500][2];
					moves[0][0] = 1;
					moves[0][1] = 1;
					moves[1][0] = 2;
					moves[1][1] = 1;					
					moves[2][0] = 3;
					moves[2][1] = 2;
					moves[3][0] = 3;
					moves[3][1] = 1;
					int sum = 5;
					int mov = 4;
					int atr = 3;
					while(sum < (n-5)/2+2) {
						moves[mov][0]=atr+1;
						moves[mov][1]=1;
						sum++;
						mov++;
						atr++;
					}
					System.out.println(sum+" "+atr);
					if(sum * 2 ==n) {
//						sb.append((atr+1)+" "+2+"\n");
						moves[mov][0]=atr+1;
						moves[mov][1]=2;
						sum+=atr+1;
					}
					else {
						moves[mov][0]=atr+1;
						moves[mov][1]=1;
						mov++;
						moves[mov][0]=atr+1;
						moves[mov][1]=2;
						mov++;
						sum+=atr+2;

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