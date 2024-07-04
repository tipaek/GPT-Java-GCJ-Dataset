import java.math.*;
import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = sc.nextInt();
		for (int lp=1;lp<=t ;lp++ ) {
			int n = sc.nextInt(), d = sc.nextInt();
			long[] a = new long[n];
			HashMap<Long,Integer> map = new HashMap<>();
			long max = 0;
			for (int i=0;i<n ;i++ ) {
				a[i] = sc.nextLong();
				if (map.containsKey(a[i])) {
					map.put(a[i], map.get(a[i])+1);
				}
				else{
					map.put(a[i], 1);
				}
				max = Math.max(max, a[i]);
			}
			if (n==1) {
				bw.write("Case #"+lp+": "+(d-1)+"\n");
				continue;
			}
			if (n==2 && d==3) {
				if (a[0]==a[1]) {
					bw.write("Case #"+lp+": 2\n");
				}
				else{
					if (2*a[0]==a[1] || 2*a[1]==a[0]) {
						bw.write("Case #"+lp+": 1\n");
					}
					else {
						bw.write("Case #"+lp+": 2\n");
					}
				}
				continue;
			}
			boolean three = false, two = false, twice = false;
			ArrayList<Long> two2 = new ArrayList<>();
			for (Map.Entry<Long,Integer> e : map.entrySet()) {
				int p = e.getValue();
				long p2 = e.getKey();
				if (map.containsKey(2*p2)) {
					twice = true;
				}
				if (p>=3) {
					three = true;
					break;
				}
				else if (p==2) {
					two = true;
					two2.add(p2);
				}
			}
			if (d==2) {
				if (two || three) {
					bw.write("Case #"+lp+": 0\n");
				}
				else {
					bw.write("Case #"+lp+": 1\n");
				}
				continue;
			}
			if (three) {
				bw.write("Case #"+lp+": 0\n");
			}
			else if (twice) {
				bw.write("Case #"+lp+": 1\n");
			}
			else if(two2.size()==0){
			    bw.write("Case #"+lp+": 2\n");	
			}
			else{
				boolean ok = false;
				for (int i=0;i<two2.size() ;i++ ) {
					if (max!=two2.get(i)) {
						ok = true;
						break;
					}
				}
				bw.write("Case #"+lp+": "+(ok?1:2));
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