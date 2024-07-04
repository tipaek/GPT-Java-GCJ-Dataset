import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
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
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int d = sc.nextInt();

			ArrayList<Long> as = new ArrayList<Long>();
			for (int j = 0; j < n; j++) {
				as.add(sc.nextLong());
			}
			as.sort(null);

			int cuts = -1;
			if (d == 2) {
				for (int k = 0; k < as.size(); k++) {
					for (int j = k + 1; j < as.size(); j++) {
						if (as.get(k) == as.get(j)) {
							cuts = 0;
							break;
						}
					}
					if (cuts >= 0) {
						break;
					}
				}
				if (cuts == -1) {
					cuts = 1;
				}
			} else {
				for (int k = 0; k < as.size(); k++) {
					for (int j = k + 1; j < as.size(); j++) {
						for (int l = j + 1; l < as.size(); l++) {
							if ((as.get(k) == as.get(j)) && (as.get(l) == as.get(j))) {
								cuts = 0;
								break;
							}
						}
						if (cuts >= 0) {
							break;
						}
					}
					if (cuts >= 0) {
						break;
					}
				}
				for (int k = 0; k < as.size(); k++) {
					for (int j = k + 1; j < as.size(); j++) {
						if (as.get(j) == (2 * as.get(k))) {
							cuts = 1;
							break;
						}
					}
					if (cuts >= 0) {
						break;
					}
				}
				if (cuts == -1) {
					cuts = 2;
				}
			}

			System.out.println("Case #" + (i + 1) + ": " + cuts);
		}
	}

}
