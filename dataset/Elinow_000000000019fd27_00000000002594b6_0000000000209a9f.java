import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
        	String input = in.next();
        	String res = solve(input);
        	System.out.println(String.format("Case #%d: %s", t, res));
        }
	}

    private static String solve(String input) {
		StringBuilder res = new StringBuilder(input.length() * 3);
		int opened = 0;
		for (int i = 0; i < input.length(); i++) {
			int curValue = input.charAt(i) - '0';
			while (curValue < opened) {
				res.append(')');
				opened--;
			}
			while (curValue > opened) {
				res.append('(');
				opened++;
			}
			res.append(input.charAt(i));
		}
		while (opened > 0) {
			res.append(')');
			opened--;
		}
		return res.toString();
	}

	public static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
