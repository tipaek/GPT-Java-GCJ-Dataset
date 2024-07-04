import java.math.*;
import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] adj;
    static boolean[] marked;
    static boolean[] ans;
    static boolean ok;
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner(System.in);
		int t = sc.nextInt();
		int lp = 0;
		while (t-->0) {
		    lp++;
		    int n = sc.nextInt();
		    adj = new ArrayList[n];
		    marked = new boolean[n];
		    ans = new boolean[n];
		    ok = true;
		    Pair[] p = new Pair[n];
		    for (int i=0;i<n ;i++ ){
		        adj[i] = new ArrayList<>();
		        p[i] = new Pair(sc.nextInt(), sc.nextInt());
		    }
		    for (int i=0;i<n ;i++ ){
		        for (int j=i+1;j<n ;j++ ){
		            if(p[j].a<p[i].b && p[j].a>=p[i].a){
		                adj[i].add(j);
		                adj[j].add(i);
		            }
		            else if (p[i].a<p[j].b && p[i].a>=p[j].a){
		                adj[i].add(j);
		                adj[j].add(i);
		            } 
		        } 
		    }
		    for (int i=0;i<n ;i++ ){
		        if(!marked[i]){
		            dfs(i);
		        }
		    } 
		    if(!ok){
		        System.out.println("Case #"+lp+": IMPOSSIBLE");
		    }
		    else{
		        StringBuilder b = new StringBuilder();
		        for (int i=0;i<n ;i++ ){
		            if(ans[i]) b.append("J");
		            else b.append("C");
		        }
		        System.out.println("Case #"+lp+": "+b.toString());
		    }
		}
	}
	static void dfs(int u){
	    marked[u] = true;
	    for(int i : adj[u]){
	        if (!marked[i]){
	            ans[i] = !ans[u];
	            dfs(i);
	        }
	        else{
	            if(ans[u]==ans[i]){
	                ok = false;
	                break;
	            }
	        }
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