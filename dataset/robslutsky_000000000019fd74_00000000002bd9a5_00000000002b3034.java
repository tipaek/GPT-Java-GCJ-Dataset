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
				w[] pat = new w[n];
				ArrayList<String> afters = new ArrayList<String>();
				for(int i=0;i<n;i++) {
					pat[i]=new w(fs.next());
					afters.add(pat[i].aa);
				}
				Arrays.sort(pat);
				StringBuilder ans = new StringBuilder("");
				String beg =pat[0].ba;
				int lf = pat[0].ap;
				boolean works = true;
				ans.append(beg);
				for(int i = 0; i < pat.length; i++) {
					w tt= pat[i];
					if(beg.indexOf(tt.ba)!=0) {
						works = false; 
						break;
					}
					ans.append(tt.ba+tt.btw);

				}
				if(works) {
					Collections.sort(afters);
					Collections.reverse(afters);
					String end = afters.get(0);
					for(int i =0;i<afters.size();i++) {
						if(end.indexOf(afters.get(i)) != 0) {
							works=false;
							break;
						}
					}
					StringBuilder sb = new StringBuilder(end);
					sb = sb.reverse();
					ans.append(sb);
					
				}
				if(works) {
					System.out.println("Case #"+cas+": "+ans);
				}
				else {
					System.out.println("Case #"+cas+": *");
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
class w implements Comparable{
String p,ba,aa, btw="";
int ap;
public w(String a) {
	p=a;
	ap=a.indexOf("*");
	ba=a.substring(0, ap);
	aa = a.substring(a.lastIndexOf("*")+1);
	if(ap != a.lastIndexOf("*"))
		btw = a.substring(ap+1,a.lastIndexOf("*"));
	btw=btw.replace('*', 'A');
	StringBuilder sb = new StringBuilder(aa);
	sb=sb.reverse();
	aa=sb.toString();
}
@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	w a = (w)o;
	if(ap-a.ap !=0)
		return a.ap-ap;
	else
		return a.ba.length()-ba.length();				
}
public String toString() {
	return p;
}

}