import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int T = Integer.parseInt(br.readLine());
			for (int testCase = 1; testCase <= T; testCase++) {

				String[] row = br.readLine().split("");
				int level = 0;
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < row.length; j++) {
					int num = Integer.parseInt(row[j]);
					int levelDiff = level - num;
					if (levelDiff < 0) {
						for (int i = 0; i < Math.abs(levelDiff); i++) {
							sb.append("(");
							level++;
						}
					} else if (levelDiff > 0) {
						for (int i = 0; i < levelDiff; i++) {
							sb.append(")");
							level--;
						}
					}
					sb.append(num);
				}

				for (int i = 0; i < level; i++) {
					sb.append(")");
				}

				System.out.println("Case #" + testCase + ": " + sb.toString());
			}
		}

	}

}
