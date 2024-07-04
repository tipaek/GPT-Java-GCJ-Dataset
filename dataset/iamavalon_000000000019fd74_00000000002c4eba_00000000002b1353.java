
import java.io.*;
import java.util.*;

public class Solution {

	private void solve() throws Exception {
		int T = nextInt();
		for(int tt = 1; tt <= T; tt++) {
			long N = nextLong();
			long NN = N;
			int size = 0;
			while(NN>0) {
				NN/=2L;
				size++;
			}
			TreeMap<Long, long[]> small = doit(0,size/2, false);
			TreeMap<Long, long[]> large = doit(size/2+1,size, true);
			boolean found = false;
			String res = "";
			long bestS = 0;
			long bestL = 0;
			for(long x : small.keySet()) {
				if(large.floorKey(N-x)!=null) {

					long val = large.floorKey(N-x);
					if(bestS+bestL < x+val) {
						bestS = x;
						bestL = val;
					}
					
				}
					
			}
			

			long[] sm = small.get(bestS);
			long[] lg = large.get(bestL);
			res = res + "1 1\n";
			boolean begin = true;
			for(int i = 1; i < sm.length; i++) {
				if(sm[i] == 1) {
					res = res + (i+1) + " " + (begin?1:(i+1)) + "\n";
				} else {
					if(begin) {
						for(int side = 1 ;side <= i+1; side++) {
							res = res + (i+1) + " " + side + "\n";
						}
						begin = false;
					} else {
						for(int side = i+1;side >= 1; side--) {
							res = res + (i+1) + " " + side + "\n";
						}
						begin = true;
					}
				}
			}
			for(int j = 0; j < lg.length; j++) {
				if(lg[j] == 1) {
					res = res + (sm.length+j+1) + " " + (begin?1:(sm.length+j+1)) + "\n";
				} else if(lg[j] > 0){
					if(begin) {
						for(int side = 1 ;side <= (sm.length+j+1); side++) {
							res = res + (sm.length+j+1) + " " + side + "\n";
						}
						begin = false;
					} else {
						for(int side = (sm.length+j+1);side >= 1; side--) {
							res = res + (sm.length+j+1) + " " + side + "\n";
						}
						begin = true;
					}
				}
				
			}
			if(bestS+bestL < N) {
				long sum = bestS+bestL;
				int base = sm.length+lg.length;
				int idx = 0;
				for(;sum <= N; sum++) {
					if(begin) {
						res = res + (base+1+idx) + " " + "1\n";
					} else {
						res = res + (base+1+idx) + " " + (base+1+idx) +"\n";
					}
					idx++;
					sum++;
				}
				System.out.println(sum);
			}
			System.out.println("Case #" + tt + ": " + res);
		}
	}
	
	
	TreeMap<Long, long[]> doit(int l, int r, boolean empty){
		int range = r-l+1;
		TreeMap<Long, long[]> res = new TreeMap<Long, long[]>();
		if(empty) res.put(0L, new long[0]);
		long base = 1<<l;
		for(int t = 0; t < (1L<<range); t++) {
			int tt = t;
			long sum = 0L;
			int steps = 0;
			long[] cur = new long[range];
			for(int i = 0; i < range; i++) {
				if(tt%2 == 0) {
					sum += 1;
					steps++;
					cur[i] = 1;
				} else {
					sum += base*(1L<<i);
					steps += (l+i);
					cur[i] = base*(1L<<i);
				}
				tt/=2;
				if(empty) res.put(sum, cur);
			}
			if(!empty)res.put(sum, cur);
		}
		return res;
	}
	
	


	public static void main(String[] args) {
		new Solution().run();
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer tokenizer;

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
//			in = new BufferedReader(new FileReader("polynomial_factoring.txt"));
			tokenizer = null;
			out = new PrintWriter(System.out);
//			out = new PrintWriter(new File("output.txt"));
			solve();
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	private float nextFloat() throws IOException {
		return Float.parseFloat(nextToken());
	}

	private String nextLine() throws IOException {
		return new String(in.readLine());
	}

	private String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(in.readLine());
		}
		return tokenizer.nextToken();
	}


}
