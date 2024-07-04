
import java.io.*;
import java.util.*;

public class Solution {

	private void solve() throws Exception {
		int T = nextInt();
		for(int tt = 1; tt <= T; tt++) {
			int N = nextInt();
			String[] P = new String[N];
			String[] pre = new String[N];
			String[] mid = new String[N];
			String[] suf = new String[N];
			for(int i = 0; i < N; i++) {
				P[i] = nextToken();
				String[] cur = P[i].split("\\*");
				int start = 0;
				int end = cur.length-1;
				if(P[i].startsWith("*")) {
					pre[i] = "";
				} else {
					pre[i] = cur[0];
					start++;
				}
				if(P[i].endsWith("*")) {
					suf[i] = "";
				} else {
					suf[i] = cur[end];
					end--;
				}
				mid[i] = "";
				for(int j = start; j <= end; j++) {
					mid[i] = mid[i] + cur[j];
				}
			}
			String p = "";
			String s = "";
			boolean ok = true;
			for(int i = 0; i < N; i++) {
				if(pre[i].length() > p.length()) p = pre[i];
				for(int j = i+1; j < N; j++) {
					if(pre[i].startsWith(pre[j]) || pre[j].startsWith(pre[i]) ) {
						
					}else {
						ok = false;
					}
				}
			}
			for(int i = 0; i < N; i++) {
				if(suf[i].length() > s.length()) s = suf[i];
				for(int j = i+1; j < N; j++) {
					if(suf[i].endsWith(suf[j]) || suf[j].endsWith(suf[i]) ) {
						
					}else {
						ok = false;
					}
				}
			}
			String m = "";
			for(int i = 0; i < N; i++) {
				m = m + mid[i];
			}
			if(ok) {
				System.out.println("Case #" + tt + ": " + p + m + s);
			} else {
				System.out.println("Case #" + tt + ": *");
			}
		}
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
