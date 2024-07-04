import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int cases = 1; cases <= t; cases++) {
			int n = sc.nextInt();
			Activity[] act = new Activity[n];
			String output = "";
			int end_c = 0, end_j = 0;
			for (int i = 0; i < n; i++) {
				act[i] = new Activity(sc.nextInt(), sc.nextInt(), i);
				output += "C";
			}
			Arrays.sort(act, new Comparator<Activity>() {
				@Override
				public int compare(Activity o1, Activity o2) {
					if (o1.start < o2.start) {
						return -1;
					} else if (o1.start > o2.start) {
						return 1;
					}
					return 0;
				}
			});
			if (n == 1) {
				System.out.println("Case #" + cases + ": " + output);
				continue;
			}
			for (int i = 0; i < n; i++) {
				if (end_c <= act[i].start) {
					end_c = act[i].end;
					output = Solution.replaceChar(output, "C", i);
				} else if (end_j <= act[i].start) {
					end_j = act[i].end;
					output = Solution.replaceChar(output, "J", i);
				} else {
					output = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #" + cases + ": " + output);
		}
		sc.close();
	}

	private static String replaceChar(String output, String actBy, int i) {
		if (i == 0) {
			return actBy + output.substring(1);
		} else if (i == output.length() - 1) {
			return output.substring(0, i) + actBy;
		}
		return output.substring(0, i) + actBy + output.substring(i + 1);
	}

	public static class Activity {
		int start = 0, end = 0, index = 0;

		public Activity(int s, int e, int i) {
			this.start = s;
			this.end = e;
			this.index = i;
		}
	}
}