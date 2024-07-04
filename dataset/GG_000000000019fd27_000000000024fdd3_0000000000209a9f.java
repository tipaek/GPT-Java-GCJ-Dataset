import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			for (int k = 1; k <= t; k++) {
				String s = sc.next();
				StringBuilder builder = new StringBuilder();
				int opened = 0;
				int last = 0;
				for (char c : s.toCharArray()) {
					int ic = c - 48;
					if (opened != ic) {
						int tmp = last - ic;
						int nTmp = -1 * tmp;
						for (int i = 0; i < tmp; i++) {
							builder.append(')');
							opened--;
						}
						for (int i = 0; tmp < 0 && i < nTmp; i++) {
							builder.append('(');
							opened++;
						}
					}
					builder.append(c);
					last = ic;
				}

				for (int i = 0; i < opened; i++) {
					builder.append(')');
				}

				System.out.printf("Case #%d: %s%n", k, builder);

			}

		}

	}
}