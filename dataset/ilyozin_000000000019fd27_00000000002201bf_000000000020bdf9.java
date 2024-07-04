import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream stream = Solution.class.getName().equals("year2020.qr.task3.Solution") ?
				new FileInputStream("C:\\Users\\One\\eclipse-workspace\\Test\\src\\year2020\\qr\\task3\\in.txt") :
					System.in;
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(stream)))) {
			int T = in.nextInt();

			for (int t = 1; t <= T; t++) {
				int N = in.nextInt();
				int[][] a = new int[N][3];
				for (int i = 0; i < N; i++) {
					a[i][0] = in.nextInt();
					a[i][1] = in.nextInt();
					a[i][2] = i;
				}
				
				Arrays.sort(a, new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						int r = o1[0] - o2[0];
						return r == 0 ? o1[1] - o2[1] : r;
					}
				});

				char[] s = new char[N];
				int c = 0;
				int j = 0;
				for (int i = 0; i < N; i++) {
					if (c <= a[i][0]) {
						s[a[i][2]] = 'C';
						c = a[i][1];
					} else if (j <= a[i][0]) {
						s[a[i][2]] = 'J';
						j = a[i][1];
					} else {
						s = null;
						break;
					}
				}

				System.out.println("Case #" + t + ": " + (s == null ? "IMPOSSIBLE" : String.copyValueOf(s)));
			}
		}
	}
}
