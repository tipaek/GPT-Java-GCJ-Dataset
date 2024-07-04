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
			String alpha ="QWERTYUIOPASDFGHJKLZXCVBNM";
			char[] gg = alpha.toCharArray();
			for(int cas=1; cas<=t;cas++) {
				boolean [] zg = new boolean [26];
				long u = fs.nextInt();
				int [] k = new int[26];

				for(int i = 0;i<10000;i++) {
					long q = fs.nextLong();
					char[] c = fs.next().toCharArray();
					for(int m = 0;m<c.length;m++) {
						k[alpha.indexOf(c[m])]++;
						if(m == 0) {
							zg[alpha.indexOf(c[m])] = true;
						}
					}
				}
				HashMap<Integer, Character> hs = new HashMap<Integer,Character>();
				for(int i = 0; i < k.length;i++) {
					hs.put(k[i],alpha.charAt(i));
				}
				String ans ="";
				Character cc = null;
				for(int i = 0; i <26;i++) {
					if(!zg[i] && k[i] != 0) {
						ans+=alpha.charAt(i);
						cc = new Character(alpha.charAt(i));
						break;
					}
				}
				Arrays.sort(k);
				int done = 1;
				int pos = k.length-1;
				while(done < 10) {
					if(!hs.get(k[pos]).equals(cc)) {
						done++;
						ans += hs.get(k[pos]);
					}
					pos--;
				}
				System.out.println("Case #"+cas+": "+ans);
				
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




