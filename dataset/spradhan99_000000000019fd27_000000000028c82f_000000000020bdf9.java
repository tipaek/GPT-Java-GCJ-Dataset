import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		TestCase[] inputs = new TestCase[t];
		String[] outputs = new String[t];
		Solution solution = new Solution();

		for (int i = 0; i < t; i++) {
			int rows = Integer.valueOf(br.readLine().trim());
			TestCase tc = solution.new TestCase(rows);
			inputs[i] = tc;

			for (int j = 0; j < tc.rows; j++) {
				String[] activityTimes = br.readLine().trim().split(" ");
				Activity activity = solution.new Activity(activityTimes[0], activityTimes[1]);
				tc.addActivity(activity);
			}
		}
		br.close();

		for (int i = 0; i < t; i++) {
			TestCase tc = inputs[i];
			Activity[] activities = tc.activities;
			Map<Integer, Activity> sequenceMap = new HashMap<>();

			for (int j = 0; j < activities.length; j++) {
				sequenceMap.put(j, activities[j]);
			}
			Arrays.sort(activities);
			Map<Activity, Character> resultMap = new HashMap<>();
			StringBuilder sb = new StringBuilder("Case #" + (i + 1) + ": ");

			for (int j = 0; j < activities.length; j++) {
				Activity activity = activities[j];

				Character res = tc.checkCompatibility(activity);
				if (res == null) {
					tc.isImpossible = true;
					sb = new StringBuilder("Case #" + (i + 1) + ": IMPOSSIBLE");
					break;
				}
				resultMap.put(activity, res);
			}

			if (!tc.isImpossible) {
				for (int j = 0; j < activities.length; j++) {
					Activity act = sequenceMap.get(j);
					Character res = resultMap.get(act);
					sb.append(res);
				}
			}
			outputs[i] = sb.toString();
		}

		for (int i = 0; i < outputs.length; i++) {
			System.out.println(outputs[i]);
		}
	}

	class TestCase {
		public int rows;
		public Activity[] activities;
		public int size = 0;
		public boolean isImpossible = false;

		Activity lastPoolC, lastPoolJ;

		public TestCase(int rows) {
			this.rows = rows;
			this.activities = new Activity[rows];
		}

		public void addActivity(Activity a) {
			activities[size] = a;
			size++;
		}

		public Character checkCompatibility(Activity a) {
			Character result = null;
			if (lastPoolC == null || (a.startTime >= lastPoolC.endTime && a.endTime >= lastPoolC.endTime)) {
				lastPoolC = a;
				result = 'C';
			} else if (lastPoolJ == null || a.startTime >= lastPoolJ.endTime && a.endTime >= lastPoolJ.endTime) {
				lastPoolJ = a;
				result = 'J';
			}

			return result;
		}

	}

	class Activity implements Comparable<Solution.Activity> {
		int startTime;
		int endTime;

		Activity(String startTime, String endTime) {
			this.startTime = Integer.valueOf(startTime);
			this.endTime = Integer.valueOf(endTime);
		}

		@Override
		public int compareTo(Solution.Activity a) {
			try {
				return Integer.compare(this.startTime, a.startTime);
			} catch (Exception e) {
				return 0;
			}
		}

		@Override
		public boolean equals(Object o) {
			try {
				Activity a = (Activity) o;
				return this.startTime == a.startTime && this.endTime == a.endTime;
			} catch (Exception e) {
				return false;
			}
		}
	}

}