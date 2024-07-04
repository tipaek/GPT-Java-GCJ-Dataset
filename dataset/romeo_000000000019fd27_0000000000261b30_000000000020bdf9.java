import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] intervals = new int[N][2];
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				intervals[i][0] = Integer.parseInt(str[0]);
				intervals[i][1] = Integer.parseInt(str[1]);
			}
			Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
			String result = "";

			int[][] assignMatrix = new int[2][2];
			for (int i = 0; i < N; i++) {
				if (intervals[i][0] >= assignMatrix[0][1]) {
					result += "C";
					assignMatrix[0][0] = intervals[i][0];
					assignMatrix[0][1] = intervals[i][1];
				} else if (intervals[i][0] >= assignMatrix[1][1]) {
					result += "J";
					assignMatrix[1][0] = intervals[i][0];
					assignMatrix[1][1] = intervals[i][1];
				} else {
					result = "";
					break;
				}
			}

			if (result.equals(""))
				result = "IMPOSSIBLE";
			System.out.println("Case #" + t + ": " + result);
		}
	}

}
