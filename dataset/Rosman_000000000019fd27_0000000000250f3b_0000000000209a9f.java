import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		new Solution().start();
	}

	private InputStream in;

	public Solution() {
		in = System.in;
	}

	public Solution(final String fileName) {
		try {
			in = new FileInputStream(fileName);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		Scanner sc = new Scanner(in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < t; i++) {
			String line = sc.nextLine();
			int l = line.length();
			int[] vs = new int[l];
			for (int j = 0; j < l; j++) {
				vs[j] = Integer.parseInt(line.substring(j, j + 1));
			}

			int level = 0;
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < l; j++) {
				while (level < vs[j]) {
					sb.append("(");
					level++;
				}
				while (level > vs[j]) {
					sb.append(")");
					level--;
				}
				sb.append(vs[j]);
			}

			while (level > 0) {
				sb.append(")");
				level--;
			}

			System.out.println("Case #" + i + ": " + sb.toString());
		}
	}
}
