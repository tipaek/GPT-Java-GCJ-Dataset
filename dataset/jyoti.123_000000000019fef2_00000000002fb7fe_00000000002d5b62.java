import java.math.*;
import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = sc.nextInt();
		int lp = 0;
		//HashSet<Pair> use = new HashSet<>();
		while (t-->0) {
			lp++;
			long x = sc.nextLong(), y = sc.nextLong();
			if(x==y || x==-y){
				bw.write("Case #"+lp+": IMPOSSIBLE\n");
				continue;
			}
			Queue<Pair> q = new LinkedList<>();
			q.add(new Pair(0L,0L,-1,' ',null));
			//use.add(new Pair(0L,0L,-1,' ',null));
			boolean ok = false;
			Pair last = null;
			while (!q.isEmpty()) {
				Pair p = q.poll();
				//if(use.contains(p)) continue;
				if(p.a==x && p.b==y){
					ok = true;
					last = p;
					break;
				}
				if(p.a-(1<<(p.p+1))>x-200) q.add(new Pair(p.a-(1<<(p.p+1)),p.b,p.p+1,'W',p));
				if(p.b-(1<<(p.p+1))>y-200) q.add(new Pair(p.a,p.b-(1<<(p.p+1)),p.p+1,'S',p));
				if(p.a+(1<<(p.p+1))<x+200) q.add(new Pair(p.a+(1<<(p.p+1)),p.b,p.p+1,'E',p));
				if(p.b+(1<<(p.p+1))<y+200) q.add(new Pair(p.a,p.b+(1<<(p.p+1)),p.p+1,'N',p));
			}
			if (!ok) {
				bw.write("Case #"+lp+": IMPOSSIBLE\n");
				continue;
			}
			StringBuilder ans = new StringBuilder();
			while (last!=null) {
				ans = ans.append(last.s);
				last = last.prev;
			}
			ans = ans.reverse();
			bw.write("Case #"+lp+": "+ans.toString().trim()+"\n");
		}
		bw.close();
	}
	static class Pair{
		long  b;
		long a;
		int p;
		char s;
		Pair prev = null;
		public Pair(long c, long d, int p1, char s1, Pair p2){
			a = c;
			b = d;
			p = p1;
			s = s1;
			prev = p2;
		}
		public boolean equals(Pair p){
			return (b==p.b && a==p.a);
		}
	}
	static int gcd(int a, int b){
	    if(b==0) return a;
	    return gcd(b,a%b);
	}
	static long power(long a, long b, long c){
	    if(b==0) return 1L;
	    if(b==1) return a;
	    long temp = power(a, b/2, c);
	    if(b%2==0) return (temp*temp)%c;
	    else return (((temp*temp)%c)*a)%c;
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