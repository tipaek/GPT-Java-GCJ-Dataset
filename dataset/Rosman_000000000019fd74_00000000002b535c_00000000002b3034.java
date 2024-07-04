import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

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
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			sc.nextLine();
			Pattern[] p = new Pattern[n];
			String[] l = new String[n];
			for (int j = 0; j < n; j++) {
				l[j] = sc.nextLine();

			}

			Arrays.sort(l, new Comparator<String>() {

				@Override
				public int compare(final String o1, final String o2) {
					return o2.length() - o1.length();
				}
			});

			for (int j = 0; j < n; j++) {
				p[j] = Pattern.compile(l[j].replaceAll("\\*", ".*"));
			}

			boolean ok = true;
			for (int j = 1; j < n; j++) {
				if (!p[j].matcher(l[j - 1]).matches()) {
					ok = false;
				}
			}

			if (ok) {
				System.out.println("Case #" + (i + 1) + ": " + l[0].replaceAll("\\*", "A"));
			} else {
				System.out.println("Case #" + (i + 1) + ": *");
			}
		}
	}

}
