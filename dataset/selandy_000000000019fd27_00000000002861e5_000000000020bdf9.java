import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {

			int T = Integer.parseInt(in.nextLine());
			for (int testCase = 1; testCase <= T; testCase++) {
				int N = in.nextInt();

				TreeMap<Integer, Activity> activities = new TreeMap<>();
				for (int i = 0; i < N; i++) {
					int start = in.nextInt();
					int end = in.nextInt();
					activities.put(start, new Activity(start, end, i));
				}

				int jamieFreeAt = 0;
				int cameronFreeAt = 0;
				String[] order = new String[N];
				boolean isImpossible = false;
				for(Activity activity : activities.values()) {
					if (cameronFreeAt <= activity.start) {
						cameronFreeAt = activity.end;
						order[activity.index] = "C";
					} else if (jamieFreeAt <= activity.start) {
						jamieFreeAt = activity.end;
						order[activity.index] = "J";
					} else {
						isImpossible = true;
						break;
					}
				}

				StringBuilder sb = new StringBuilder();
				if (isImpossible) {
					sb.append("IMPOSSIBLE");
				} else {
					for (int i = 0; i < order.length; i++) {
						sb.append(order[i]);
					}
				}

				System.out.println("Case #" + testCase + ": " + sb.toString());
			}
		}
	}
	
	private static class Activity {
		int start;
		int end;
		int index;

		Activity(int start, int end, int index) {
			this.start = start;
			this.end = end;
			this.index = index;
		}
	}

}
