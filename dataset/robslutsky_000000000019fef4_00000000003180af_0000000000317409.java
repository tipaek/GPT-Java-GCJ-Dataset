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
				int x = fs.nextInt();
				int y = fs.nextInt();
				char[] k = fs.next().toCharArray();
				int ans = -1;
				for(int i = 0; i < k.length; i++) {
					char c = k[i];
					if(c=='N') {
						y++;
					}
					else if(c=='S') {
						y--;
					}					
					else if(c=='E') {
						x++;
					}
					else if(c=='W') {
						x--;
					}
					if(Math.abs(x)+Math.abs(y) <= i + 1) {
						ans = i+1;
						break;
					}
				}
				if(ans != -1)
					System.out.println("Case #"+cas+": "+ans);
				else {
					System.out.println("Case #"+cas+": IMPOSSIBLE");

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




