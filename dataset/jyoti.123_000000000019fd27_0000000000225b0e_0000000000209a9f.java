import java.math.*;
import java.io.*;
import java.util.*;

class Solution {
    static int[] opening, closing;
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner(System.in);
		int t = sc.nextInt();
		int lp = 0;
		while (t-->0) {
		    lp++;
		    String s = sc.nextLine();
		    opening = new int[s.length()];
		    closing = new int[s.length()];
		    func(s,0);
		    System.out.print("Case #"+lp+": ");
		    for (int i=0;i<s.length() ;i++ ){
		        for (int j=0;j<opening[i] ;j++ ) System.out.print("(");
		        System.out.print(s.charAt(i));
		        for (int j=0;j<closing[i] ;j++ ) System.out.print(")");
		    } 
		    System.out.println();
		}
	}
	static void func(String s, int start){
	    String[] p = s.split("0");
	    int s1 = 0;
	    for (int i=0;i<p.length ;i++ ){
	        if(p[i].length()==0) continue;
	        StringBuilder b = new StringBuilder();
	        opening[start+s1+i]++;
	        closing[start+s1+i+p[i].length()-1]++;
	        func(change(p[i]), start+s1+i);
	        s1+=p[i].length();
	    } 
	}
	static String change(String s){
	    StringBuilder p = new StringBuilder();
	    for (int i=0;i<s.length() ;i++ ){
	        int l = Integer.parseInt(s.charAt(i)+"");
	        l--;
	        p.append(l);
	    }
	    return p.toString();
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