import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][] tasks;
		StringTokenizer st;
		int[] timeline;
		loop: for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			tasks = new int[n][3];
			timeline = new int[1441];
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				tasks[j][0] = Integer.parseInt(st.nextToken());
				tasks[j][1] = Integer.parseInt(st.nextToken());
				tasks[j][2] = j;
			}
			Arrays.sort(tasks, new Comparator<int[]>() {

				@Override
				public int compare(int[] arg0, int[] arg1) {
					return Integer.compare(arg0[0], arg1[0]);
				}

			});
			// System.out.println(Arrays.deepToString(tasks));
			if (i == 2) {
				System.out.println();
			}
			String[] out = new String[n];
			boolean cworking = false;
			int[] ctask = { -1, -1 };
			boolean jworking = false;
			int[] jtask = { -1, -1 };
			int currtask = 0;
			loop1: for (int j = 0; j <= 1440; j++) {
				if (currtask >= n) {
					break;
				}
				if (j == ctask[1]) {
					cworking = false;
				}
				if (j == jtask[1]) {
					jworking = false;
				}

				while (j == tasks[currtask][0]) {
					if (!cworking) {
						cworking = true;
						ctask = tasks[currtask];
						out[tasks[currtask][2]] = "C";
						currtask++;
						if (currtask >= n) {
							break loop1;
						}
					} else if (!jworking) {
						jworking = true;
						jtask = tasks[currtask];
						out[tasks[currtask][2]] = "J";
						currtask++;
						if (currtask >= n) {
							break loop1;
						}
					} else {
						System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
						continue loop;
					}
				}
			}
			String out1 = "";
			for (int j = 0; j < n; j++) {
				out1 += out[j];
			}
			System.out.println("Case #" + (i + 1) + ": " + out1);
		}
	}

}
