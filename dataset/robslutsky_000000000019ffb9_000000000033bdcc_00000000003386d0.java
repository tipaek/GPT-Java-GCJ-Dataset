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
		static int [][] points;
		public static void main(String[] args) throws IOException {
			FastScanner fs=new FastScanner(System.in);
			int t=fs.nextInt();
			for(int cas=1; cas<=t;cas++) {
				int p = fs.nextInt();
				points = new int[p][3];
				for(int i =0;i<p;i++) {
					points[i][0] =fs.nextInt();
					points[i][1] =fs.nextInt();
				}
				if(p == 1) {
					System.out.println("Case #"+cas+": "+p);
					continue;
				}
				ArrayList<Slope> s = new ArrayList<Slope>();
				ArrayList<Integer> sint = new ArrayList<Integer>();
				for(int i = 0; i < p; i++) {
					for(int j = 0;j<i;j++) {
						Slope ns = new Slope(points[i][0]-points[j][0],points[i][1]-points[j][1]);
						boolean found = false;
						for(int q = 0;q<s.size();q++) {
							if(s.get(q).equals(ns)) {
								sint.set(q, sint.get(q)+1);
								found = true;
								break;
							}
						}
						if(!found) {
							s.add(ns);
							sint.add(1);
						}
					}
				}
				int max = Collections.max(sint);
				int eextra = max % 2;
				int j = p - max;
				max+= Math.min(2, j);
				if(max < p) {
					max += eextra;
				}
				System.out.println("Case #"+cas+": "+max);

				
			}
				
		}
		public int dfs(int pos) {
			int max = 0;
			for(int i = 0; i < points.length;i++) {
				if(i==pos) {
					continue;
				}
				max=Math.max(max, dfs(pos, points[i][0]-points[pos][0], points[i][1]-points[pos][1]));
			}
			return max;
			
		}
		public int dfs(int pos, long x, long y) {
			return 0;
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
class Slope{
long x,y;
public Slope(int x, int y) {
	this.x=x;
	this.y=y;
}
public boolean equals(Object o) {
	Slope s=(Slope) o;
	return x*s.y == s.x*y;
}
}
