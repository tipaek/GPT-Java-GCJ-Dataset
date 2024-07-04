import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out, false);

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {

			char[] x = br.readLine().toCharArray();
			StringBuilder sb = new StringBuilder();
			int lastInsertedIndex = 0;
			if (x[0] != '0') {
				for (int k = 0; k < (int) (x[0] - '0'); k++) {
					sb.append("(");
					lastInsertedIndex++;
				}
				sb.append(x[0]);
				for (int k = 0; k < (int) (x[0] - '0'); k++) {
					sb.append(")");
				}
			} else {

				sb.append('0');
				lastInsertedIndex = 1;
			}
			char last = x[0];
			for (int j = 1; j < x.length; j++) {
				if (x[j] == last) {
					sb.insert(lastInsertedIndex, x[j]);
					lastInsertedIndex += 1;
					continue;
				}

				if (x[j] < last) {
					if (x[j] == '0') {
						sb.append('0');
						last = x[j];
						lastInsertedIndex = sb.length();
					} else {
						// no of items to skip
						// sb.insert(sb.length() - lastInsertedIndex + (int) (x[j] - '0') + 1, x[j]);
						String y = sb.toString();
						int e = sb.length() - 1;
						int count = 0;
						while (e >= 0 && y.charAt(e) == ')') {
							e--;
							count++;
							if (count == (int) (x[j] - '0')) {
								sb.insert(e + 1, x[j]);
								lastInsertedIndex = e + 1;
								last = x[j];
								break;
							}
							continue;
						}
						last = x[j];
						// lastInsertedIndex = sb.length() - lastInsertedIndex + (int) (x[j] - '0') + 1;
					}
					continue;
				}

				if (x[j] > last) {
					StringBuilder s1 = new StringBuilder();
					for (int k = 0; k < (int) (x[j] - '0') - (int) (last - '0'); k++) {
						s1.append("(");
					}
					s1.append(x[j]);
					for (int k = 0; k < (int) (x[j] - '0') - (int) (last - '0'); k++) {
						s1.append(")");
					}
					if (last != '0') {
						sb.insert(lastInsertedIndex + 1, s1.toString());
						last = x[j];
						lastInsertedIndex += s1.length() / 2 + 1;
					} else {
						sb.insert(lastInsertedIndex, s1.toString());
						last = x[j];
						lastInsertedIndex += s1.length() / 2;
					}

					continue;
				}

			}

			pw.println("Case #" + i + ": " + sb.toString());
		}
		pw.flush();
	}
}
