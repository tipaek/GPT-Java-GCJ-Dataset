import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			pw.print("Case #" + t + ": ");
			char n = '0';
			char[] s = br.readLine().toCharArray();
			for (char c : s) {
				while (n < c) { pw.print('('); n++; }
				while (n > c) { pw.print(')'); n--; }
				pw.print(c);
			}
			while (n > '0') { pw.print(')'); n--; }
			pw.println();
			pw.flush();
		}
	}
}
