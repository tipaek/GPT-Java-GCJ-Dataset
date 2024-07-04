
import java.io.*;
import java.util.*;

public class Solution {

	static class Activity implements Comparable<Activity> {
		Integer si;
		Integer ei;

		public Activity(Integer si, Integer ei) {
			super();
			this.si = si;
			this.ei = ei;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((ei == null) ? 0 : ei.hashCode());
			result = prime * result + ((si == null) ? 0 : si.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Activity other = (Activity) obj;
			if (ei == null) {
				if (other.ei != null)
					return false;
			} else if (!ei.equals(other.ei))
				return false;
			if (si == null) {
				if (other.si != null)
					return false;
			} else if (!si.equals(other.si))
				return false;
			return true;
		}

		@Override
		public int compareTo(Activity o) {
			return this.si.compareTo(o.si);
		}

		@Override
		public String toString() {
			return "Activity [si=" + si + ", ei=" + ei + "]";
		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(br);
	}


	public static void solve(BufferedReader br) throws IOException {
		int numberOfTestCases = Integer.parseInt(br.readLine());
		System.err.println("numberOfTestCases : " + numberOfTestCases);
		outer: for (int i = 0; i < numberOfTestCases; i++) {
			int activities = Integer.parseInt(br.readLine());
			System.err.println("activities : " + activities);
			Map<String, Integer> CJactivityMap = new HashMap<String, Integer>();
			CJactivityMap.put("c", 0);
			CJactivityMap.put("j", 0);
			StringBuilder output = new StringBuilder();

			List<Activity> activitiesList = new ArrayList<Activity>();
			Map<Activity, String> activityMapper = new HashMap<Solution.Activity, String>();

			for (int r = 0; r < activities; r++) {

				String[] times = br.readLine().split(" ");
				int si = Integer.parseInt(times[0]);
				int ei = Integer.parseInt(times[1]);

				activitiesList.add(new Activity(si, ei));
			}

			List<Activity> sortedActivitiesList = new ArrayList<Activity>(activitiesList);

			Collections.sort(sortedActivitiesList);

			for (int r = 0; r < activities; r++) {
				Activity activity = sortedActivitiesList.get(r);

				int si = activity.si;
				int ei = activity.ei;
				if (si >= CJactivityMap.get("c")) {
					CJactivityMap.put("c", ei);
					// output.append("C");
					activityMapper.put(activity, "C");
					// continue inner;
				} else if (si >= CJactivityMap.get("j")) {
					CJactivityMap.put("j", ei);
					// output.append("J");
					activityMapper.put(activity, "J");
					// continue inner;
				} else {
					output = new StringBuilder("IMPOSSIBLE");
					// output.append("IMPOSSIBLE");
					System.out.println("Case #" + (i + 1) + ": " + output);
					continue outer;
				}

			}
			for (int r = 0; r < activities; r++) {
				Activity activity = activitiesList.get(r);
				output.append(activityMapper.get(activity));
			}

			System.out.println("Case #" + (i + 1) + ": " + output);
		}
	}

}
