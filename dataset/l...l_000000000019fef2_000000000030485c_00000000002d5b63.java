import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {

	static long A, B;
	static boolean done = false;
	static Random gen = new Random();
	static final int LIM = 1_000_000_000;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static String ans;
	static long L, R, ARR, ABA;
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		for (int t = 1; t <= T; t++) {
			solve();
		}
	}	
	
	static void solve() throws Exception {
		long[] xy = first_point();
		long x = xy[0];
		long y = xy[1];
		if (done) return;
		L = x;
		bs_l(y);
		if (done) return;
		R = x;
		bs_r(y);
		if (done) return;
		
		x = (L+R)/2;
		
		ARR = y;
		bs_arr(x);
		if (done) return;
		
		ABA = y;
		bs_aba(x);
		if (done) return;
		
		y = (ARR+ABA)/2;
		
		guess(x,y);			
	}
	
	static void bs_arr(long x) throws Exception {
		long p = -LIM;
		long q = ARR;
		long m;
		while (p<=q) {
			m = (p+q)/2;
			guess(x, m);
			if (center()) {
				done = true;
				return;
			}
			if (miss()) {
				p = m+1;
			}else {
				if (m<ARR) ARR = m;
				q = m-1;			
			}
		}
	}
	
	static void bs_aba(long x) throws Exception {
		long p = ABA;
		long q = LIM;
		long m;
		while (p<=q) {
			m = (p+q)/2;
			guess(x, m);
			if (center()) {
				done = true;
				return;
			}
			if (miss()) {
				q = m-1;
			}else {
				if (m>ABA) ABA = m;
				p = m+1;			
			}
		}
	}

	static void bs_r(long y) throws Exception {
		long p = R;
		long q = LIM;
		long m;
		while (p<=q) {
			m = (p+q)/2;
			guess(m, y);
			if (center()) {
				done = true;
				return;
			}
			if (miss()) {
				q = m-1;
			}else {
				if (m>R) R = m;
				p = m+1;			
			}
		}
	}

	static void bs_l(long y) throws Exception {
		long p = -LIM;
		long q = L;
		long m;
		while (p<=q) {
			m = (p+q)/2;
			guess(m, y);
			if (center()) {
				done = true;
				return;
			}
			if (miss()) {
				p = m+1;
			}else {
				if (m<L) L = m;
				q = m-1;			
			}
		}
	}
	
	static long[] first_point() throws Exception {
		long x, y;
		while(true) {
			x = rndint();
			y = rndint();
			guess(x, y);
			if (miss()) continue;
			if (center()) done = true;
			return new long[] {x, y};
		}
	}
	
	static boolean miss() {
		return ans.equals("MISS");
	}
	
	static boolean center() {
		return ans.equals("CENTER");
	}
	
	static boolean hit() {
		return ans.equals("HIT");
	}
	
	static int cont=0;
	
	static void guess(long x, long y) throws Exception {
		System.out.println(x + " " + y);
		System.out.flush();
		ans = in.readLine();
		cont++;
	}

	static long rndint() {
		long x = gen.nextInt(LIM*2+1);
		return x-LIM;
	}
}