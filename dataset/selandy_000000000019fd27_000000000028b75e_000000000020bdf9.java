import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {

			int T = Integer.parseInt(in.nextLine());
			for (int testCase = 1; testCase <= T; testCase++) {
				int N = in.nextInt();

				TreeMap<Integer, List<Activity>> activities = new TreeMap<>();
				for (int i = 0; i < N; i++) {
					int start = in.nextInt();
					int end = in.nextInt();
					List<Activity> innerList = activities.containsKey(start) ?
							activities.get(start) : new ArrayList<Activity>();
					innerList.add(new Activity(start, end, i));
					activities.put(start, innerList);
				}

				Comparator<Activity> comparator = new Comparator<Activity>() {
					@Override
					public int compare(Activity a1, Activity a2) {
						return a1.end - a2.end;
					}
				};

				int jamieFreeAt = 0;
				int cameronFreeAt = 0;
				String[] order = new String[N];
				boolean isImpossible = false;
				for (List<Activity> innerList : activities.values()) {
					innerList.sort(comparator);
					for (Activity activity : innerList) {
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
