import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int testCase = Integer.valueOf(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			List<Activity> originalList = new ArrayList<>();

			Integer n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String data = br.readLine();
				originalList.add(
						new Activity(i, Integer.parseInt(data.split(" ")[0]), Integer.parseInt(data.split(" ")[1])));
			}

			List<Activity> c = new ArrayList<>();
			List<Activity> j = new ArrayList<>();
			boolean isPossible = true;
			Collections.sort(originalList);
			for (Activity activity : originalList) {
				if (j.isEmpty()) {
					activity.setName("J");
					j.add(activity);
				} else if (doesNotOverlap(j, activity)) {
					activity.setName("J");
					j.add(activity);
				} else if (c.isEmpty()) {
					activity.setName("C");
					j.add(activity);
				} else if (doesNotOverlap(c, activity)) {
					activity.setName("C");
					j.add(activity);
				} else {
					isPossible = false;
					break;
				}
			}

			String result = null;
			if (!isPossible) {
				result = "IMPOSSIBLE";
			} else {
				result = getResult(originalList);
			}
			
			System.out.println("Case #" + test + ": " + result);

		}
	}

	private static String getResult(List<Activity> originalList) {
		Collections.sort(originalList, new ActivityIDComparator());
		String result = "";
		for (Activity activity : originalList) {
			result += activity.getName();
		}
		return result;
	}

	private static boolean doesNotOverlap(List<Activity> activityList, Activity activity) {
		return activity.getStartTime() >= activityList.get(activityList.size() - 1).getEndTime();
	}

}

class Activity implements Comparable<Activity> {
	private int id;
	private int startTime;
	private int endTime;
	private String name;

	public Activity(int id, int startTime, int endTime) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	@Override
	public int compareTo(Activity o) {
		// TODO Auto-generated method stub
		return this.startTime - o.getStartTime();
	}

}

class ActivityIDComparator implements Comparator<Activity> {

	@Override
	public int compare(Activity arg0, Activity arg1) {
		// TODO Auto-generated method stub
		return arg0.getId() - arg1.getId();
	}

}
