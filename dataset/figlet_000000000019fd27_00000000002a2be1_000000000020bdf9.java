
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	private static boolean isOverLapping(ArrayList<Activity> activityList, Activity activity) {
		int len = activityList.size();
		Activity aux = null;
		for (int i = 0; i < len; i++) {
			aux = activityList.get(i);
			if (aux.s < activity.s) {
				if (aux.e > activity.s) {
					return true;
				}
			}
			if (activity.s < aux.s) {
				if (activity.e > aux.s) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			int n = 0, s = 0, e = 0;
			String data[] = null;
			StringBuilder result = new StringBuilder();
			ArrayList<Activity> cameron = new ArrayList<Activity>();
			ArrayList<Activity> jamie = new ArrayList<Activity>();
			for (int i = 1; i <= t; i++) {
				cameron.clear();
				jamie.clear();
				n = Integer.parseInt(br.readLine());
				result = result.delete(0, result.capacity());
				for (int j = 0; j < n; j++) {
					if (result.toString().trim().equals("IMPOSSIBLE")) {
						String aux = br.readLine();
						continue;
					}
					data = br.readLine().split(" ");
					s = Integer.parseInt(data[0]);
					e = Integer.parseInt(data[1]);
					Activity activity = new Activity(s, e);

					if (!isOverLapping(cameron, activity)) {
						cameron.add(activity);
						result.append("C");
					} else {
						if (!isOverLapping(jamie, activity)) {
							jamie.add(activity);
							result.append("J");
						} else {
							result = result.delete(0, result.capacity());
							result.append("IMPOSSIBLE");
						}
					}
				}
				System.out.println("Case #" + i + ": " + result.toString());
				result = result.delete(0, result.capacity());
				cameron.clear();
				jamie.clear();
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Activity {
	int s = 0, e = 0;

	Activity(int s, int e) {
		this.s = s;
		this.e = e;
	}

	public String toString() {
		return s + ":" + e;
	}
}