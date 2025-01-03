import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while(st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch(IOException e) {
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

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		FastReader reader = new FastReader();
		int t = reader.nextInt();
		for(int i = 1; i <= t; i++) {
			String out = "";
			int n = reader.nextInt();
			int[] c = { 0, 0 };
			int[] j = { 0, 0 };
			boolean valid = true;
			for(int i1 = 0; i1 < n; i1++) {
				int s = reader.nextInt();
				int e = reader.nextInt();
				if(valid) {
					if(c[1] <= s || c[0] >= e) {
						out += "C";
						c[0] = s;
						c[1] = e;
					} else if(j[1] <= s || c[0] >= e) {
						out += "J";
						j[0] = s;
						j[1] = e;
					} else {
						out = "IMPOSSIBLE";
						valid = false;
					}
				}
			}
			System.out.println("Case #" + i + ": " + out);
		}
	}
}