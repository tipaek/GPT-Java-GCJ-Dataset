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
			String s = reader.nextLine();
			String[] arr = s.split("");
			String out = "";
			for(int j = 0; j < arr.length; j++) {
				int num = Integer.parseInt(arr[j]);
				for(int n = 0; n < num; n++)
					out += "(";
				out += arr[j];
				for(int n = 0; n < num; n++)
					out += ")";
			}
			int index;
			while((index = out.indexOf(")(")) != -1)
				out = out.substring(0, index) + out.substring(index + 2);

			System.out.println("Case #" + i + ": " + out);
		}
	}
}