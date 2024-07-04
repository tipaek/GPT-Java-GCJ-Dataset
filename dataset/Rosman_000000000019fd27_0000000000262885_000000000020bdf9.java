import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
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

			int[][] data = new int[n][4];
			for (int j = 0; j < n; j++) {
				data[j][0] = sc.nextInt();
				data[j][1] = sc.nextInt();
				data[j][2] = j;
			}

			Arrays.sort(data, new Comparator<int[]>() {

				@Override
				public int compare(final int[] o1, final int[] o2) {
					return o1[0] - o2[0];
				}
			});

			BitSet bc = new BitSet(60 * 24);
			BitSet bj = new BitSet(60 * 24);

			boolean imposible = false;
			for (int j = 0; j < n; j++) {
				if (bc.get(data[j][0], data[j][1]).isEmpty()) {
					data[j][3] = 1;
					bc.set(data[j][0], data[j][1]);
				} else if (bj.get(data[j][0], data[j][1]).isEmpty()) {
					data[j][3] = 2;
					bj.set(data[j][0], data[j][1]);
				} else {
					imposible = true;
					break;
				}
			}

			StringBuffer sb = new StringBuffer();
			if (!imposible) {
				Arrays.sort(data, new Comparator<int[]>() {

					@Override
					public int compare(final int[] o1, final int[] o2) {
						return o1[2] - o2[2];
					}
				});
			}
			for (int j = 0; j < n; j++) {
				sb.append(data[j][3] == 1 ? "C" : "J");
			}

			System.out.println("Case #" + (i + 1) + ": " + (imposible ? "IMPOSSIBLE" : sb.toString()));
		}
	}
}
