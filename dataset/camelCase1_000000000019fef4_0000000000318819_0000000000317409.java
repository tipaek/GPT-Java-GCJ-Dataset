import java.util.*;
import java.io.*;
public class Fan {

	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = nextInt();
		int l = 1;
		PrintWriter out = new PrintWriter(System.out);
		outer:
		while(t --> 0) {
			int x = nextInt();
			int y = nextInt();
			String str = next();
			int x1 = 0, y1 = 0;
			for(int i = 0; i < str.length(); i++) {
				switch(str.charAt(i)) {
				case 'S': y--; break;
				case 'N': y++; break;
				case 'E': x++; break;
				case 'W': x--; break;
				}
				if(Math.abs(x1 - x) + Math.abs(y1 - y) <= i + 1) {
					out.println("Case #" + (l++) + ": " + (i + 1));
					continue outer;
				}
			}
			out.println("Case #" + (l++) + ": IMPOSSIBLE");
		}
		out.close();
	}

	public static String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				throw new IOException();
			tokenizer = new StringTokenizer(line);
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
