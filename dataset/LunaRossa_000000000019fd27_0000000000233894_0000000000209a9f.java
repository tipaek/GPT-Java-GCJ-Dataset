import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		final boolean STD_IO = true;
		final String INPUT_FILE = "A-small-attempt0.in";
		InputStream inStream = STD_IO ? System.in : new FileInputStream(new File(INPUT_FILE));
		OutputStream outStream = STD_IO ? System.out : new FileOutputStream(new File("GCJ.out"));
		Scanner input = new Scanner(inStream);
		PrintWriter out = new PrintWriter(outStream);

		while (input.hasNext()) {
			int T = input.nextInt();

			for (int t = 1; t <= T; ++t) {
				char[] S = input.next().toCharArray();
				StringBuilder ans = new StringBuilder();
				int depth = S[0] - '0';

				for (int i = 0; i < depth; ++i) {
					ans.append('(');
				}
				ans.append(S[0]);

				for (int i = 1; i < S.length; ++i) {
					if (S[i] > S[i - 1]) {
						int d = S[i] - '0';

						while (depth < d) {
							ans.append('(');
							++depth;
						}
					} else if (S[i] < S[i - 1]) {
						int d = S[i] - '0';

						while (depth > d) {
							ans.append(')');
							--depth;
						}
					}
					ans.append(S[i]);

				}

				while (depth > 0) {
					ans.append(')');
					--depth;
				}

				out.printf("Case #%d: %s\n", t, ans.toString());
			}
		}

		out.close();
		input.close();
	}

}
