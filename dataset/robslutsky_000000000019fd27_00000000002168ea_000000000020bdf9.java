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
				int k = fs.nextInt();
				ArrayList<b> t = new ArrayList<b>();
				b[] orig = new b[k];
				for(int i = 0; i <k; i++) {
					b temp = new b(fs.nextInt(), fs.nextInt());
					t.add(temp);
					orig[i] = temp;
				}
				Collections.sort(t);
				StringBuilder sb = new StringBuilder("Case # "+ cas +": " );
				b con = null;
				b jon = null;
				boolean works = true;
				for(int i = 0; i < t.size(); i++) {
					if(con == null || con.e<=t.get(i).s) {
						con = t.get(i);
						con.db="C";
					}
					else if(jon == null || jon.e<=t.get(i).s) {
						jon = t.get(i);
						jon.db = "J";
					}
					else {
						works = false;
						break;
					}
				}
				if(!works) {
					System.out.println(sb.append("IMPOSSIBLE"));
				}
				else {
					for(int i =0; i< orig.length; i++) {
						sb=sb.append(orig[i].db);
					}
					System.out.println(sb);
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
class b implements Comparable{
public int s, e;
public String db ="";
public b(int s, int e) {
	this.s=s;
	this.e=e;
}
@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	b um = (b)o;
	return s - um.s;
}

}


