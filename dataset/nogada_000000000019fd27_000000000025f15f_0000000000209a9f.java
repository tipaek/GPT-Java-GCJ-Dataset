import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int caseNumber = Integer.parseInt(reader.readLine());
		int caseIterater = 0;
		while (caseNumber != caseIterater++) {
			String origin = reader.readLine();
			StringBuilder builder = new StringBuilder();
			int depth = 0;
			for (int i = 0; i < origin.length(); i++) {
				int cur = Integer.parseInt(origin.charAt(i)+"");
				if (cur > depth) {
					while (depth < cur) {
						builder.append('(');
						depth++;
					}
				} else {
					while (depth > cur) {
						builder.append(')');
						depth--;
					}
				}
				builder.append(cur);
			}
			if (0 > depth) {
				while (depth < 0) {
					builder.append('(');
					depth++;
				}
			} else {
				while (depth > 0) {
					builder.append(')');
					depth--;
				}
			}
			System.out.println(String.format("Case #%d: %s",caseIterater,builder.toString()));
		}
	}
}
