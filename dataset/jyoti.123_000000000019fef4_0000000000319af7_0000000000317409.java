import java.math.*;
import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = sc.nextInt();
		for (int lp=1;lp<=t ;lp++ ) {
			int x = sc.nextInt(), y = sc.nextInt();
			String s = sc.next();
			ArrayList<Pair> path = new ArrayList<>();
			path.add(new Pair(0,0));
			int x1 = 0, y1 = 0;
			for (int i=0;i<s.length();i++ ) {
				if (s.charAt(i)=='N') {
					x1--;
				}
				if (s.charAt(i)=='S') {
					x1++;
				}
				if (s.charAt(i)=='E') {
					y1--;
				}
				if (s.charAt(i)=='W') {
					y1--;
				}
				path.add(new Pair(x1,y1));
			}
			int ans = -1;
			for (int i=0;i<path.size() ;i++ ) {
				int p = Math.abs(path.get(i).a-y)+Math.abs(path.get(i).b-x);
				if(p<=i){
					ans = i;
					break;
				}
			}
			if (ans==-1) {
				bw.write("Case #"+lp+": IMPOSSIBLE\n");
			}
			else{
				bw.write("Case #"+lp+": "+ans+"\n");
			}
		}
		bw.close();
	}
	static class Pair{
		int a,b;
		public Pair(int c, int d){
			a = c;
			b = d;
		}
	}
	static class FastRandom {
	    long x = 123456789, y = 362436069, z = 521288629;
        public int nextInt(int min, int max) {
            return (int)(min+xorshf96()%(max - min + 1));
        }
        public long xorshf96() {
            long t;
            x ^= x << 16;
            x ^= x >> 5;
            x ^= x << 1;
            t = x;
            x = y;
            y = z;
            z = t ^ x ^ y;
            return z;
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