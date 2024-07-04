import java.math.*;
import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner(System.in);
		int t = sc.nextInt();
		int lp = 0;
		while (t-->0) {
		    lp++;
		    int n = sc.nextInt();
		    String[] s = new String[n];
		    StringBuilder ans = new StringBuilder();
		    int len = 0;
		    for (int i=0;i<n ;i++ ){
		        s[i] = sc.nextLine();
		        len = Math.max(len,s[i].length());
		    }
		    for (int i=0;i<n ;i++ ){
		        StringBuilder temp = new StringBuilder();
		        for (int j=0;j<len-s[i].length() ;j++ ) temp = temp.append("*");
		        s[i] = temp.append(s[i]).toString();
		    } 
		    boolean ok = true; 
		    for (int i=0;i<len ;i++ ){
		        boolean done = false;;
		        char c = ' ';
		        for (int j=0;j<n ;j++ ){
		            
		            if(s[j].charAt(i)!='*'){
		                if(c!=' ' && c!=s[j].charAt(i)){
		                    ok = false;
		                    break;
		                }
		                c = s[j].charAt(i);
		                if(!done) ans = ans.append(c);
		                done = true;
		                continue;
		            }
		            if(c!=' '){
		                if(!done) ans = ans.append(c);
		                done = true;
		            }
		        }
		        if(!ok) break;
		    }
		    System.out.println("Case #"+lp+": "+(!ok?"*":ans.toString()));
		}
	}
	static int gcd(int a, int b){
	    if(b==0) return a;
	    return gcd(b,a%b);
	}
	static class Pair implements Comparable<Pair>{
		int a, b;
		public Pair(int c, int d){
			a = c;
			b = d;
		}
		public int compareTo(Pair p){
		    return a-p.a;
		}
	}
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		FastScanner(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		FastScanner(InputStream f) {
			br = new BufferedReader(new InputStreamReader(f));
		}
		String nextLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				return null;
			}
		}
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}