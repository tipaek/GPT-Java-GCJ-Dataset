import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	private static boolean isOverlapping(ArrayList<Activity> activities, Activity newActivity) {
		for (Activity activity : activities) {
			if ((activity.s == newActivity.s && activity.e == newActivity.e) ||
				(activity.s <= newActivity.s && activity.e >= newActivity.e) ||
				(newActivity.s <= activity.s && newActivity.e >= activity.e) ||
				(activity.s < newActivity.s && activity.e > newActivity.s) ||
				(newActivity.s < activity.s && newActivity.e > activity.s)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			StringBuilder result = new StringBuilder();

			for (int i = 1; i <= t; i++) {
				int n = Integer.parseInt(br.readLine());
				ArrayList<Activity> cameron = new ArrayList<>();
				ArrayList<Activity> jamie = new ArrayList<>();
				boolean impossible = false;

				for (int j = 0; j < n; j++) {
					String[] data = br.readLine().split(" ");
					int s = Integer.parseInt(data[0]);
					int e = Integer.parseInt(data[1]);
					Activity activity = new Activity(s, e);

					if (impossible) {
						continue;
					}

					if (!isOverlapping(cameron, activity)) {
						cameron.add(activity);
						result.append("C");
					} else if (!isOverlapping(jamie, activity)) {
						jamie.add(activity);
						result.append("J");
					} else {
						result.setLength(0);
						result.append("IMPOSSIBLE");
						impossible = true;
					}
				}

				System.out.println("Case #" + i + ": " + result.toString());
				result.setLength(0);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}

class Activity {
	int s, e;

	Activity(int s, int e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public String toString() {
		return s + ":" + e;
	}
}