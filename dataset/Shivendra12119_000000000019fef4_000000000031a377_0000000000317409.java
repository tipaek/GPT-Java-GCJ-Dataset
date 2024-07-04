import java.util.*;
import java.io.*;

public class Solution {
	static FastReader sc;
	static BufferedWriter bufferedWriter;
	static String yes = "YES";
	static String no = "IMPOSSIBLE";

	public static void main(String[] args) throws IOException {
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		sc = new FastReader();
		int tp = sc.nextInt();
		for (int i_t = 0; i_t < tp; i_t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String s = sc.next();
			String ans = solve(x, y, s);
			bufferedWriter.write("Case #" + (i_t + 1) + ": " + ans + "\n");
		}
		bufferedWriter.flush();

	}

	private static String solve(int x, int y, String s) {
		int time = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			time++;
			char ch = s.charAt(i);
			if (ch == 'N')
				y++;
			if (ch == 'S')
				y--;
			if (ch == 'E')
				x++;
			if (ch == 'W')
				x--;
			if (time >= (Math.abs(x) + Math.abs(y))) {
				return Integer.toString(time);
			}
		}
		return "IMPOSSIBLE";
	}

}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br=new  BufferedReader(new InputStreamReader(System.in));
		
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
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

	String nextLine() {
		String s = "";
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}
