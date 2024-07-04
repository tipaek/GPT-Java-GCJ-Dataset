import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int     t  = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			List<String> activity = new ArrayList<String>();
			for (int j = 0; j < n; j++) {
				int start = sc.nextInt();
				int end   = sc.nextInt();
				activity.add(start + ":" + end);
			}
			List<String> activityTemp = new ArrayList<String>();
			activityTemp.addAll(activity);
			activityTemp.sort(Comparator.comparing(Solution::startTime).thenComparing(Solution::endTime));
			int          C     = 0;
			int          J     = 0;
			List<String> cList = new ArrayList<String>();
			List<String> jList = new ArrayList<String>();
			int          flag  = 0;
			for (int j = 0; j < activityTemp.size(); j++) {
				if (C <= Solution.startTime(activityTemp.get(j))) {
					C = Solution.endTime(activityTemp.get(j));
					cList.add(activityTemp.get(j));
				} else if (J <= Solution.startTime(activityTemp.get(j))) {
					J = Solution.endTime(activityTemp.get(j));
					jList.add(activityTemp.get(j));
				} else {
					flag = 1;
					System.out.println("Case #" + i + ": IMPOSSIBLE");
				}
			}
			if (flag == 0) {
				String out = "";
				for (int j = 0; j < activity.size(); j++) {
					if (cList.contains(activity.get(j))) {
						out += "C";
					} else {
						out += "J";
					}
				}
				System.out.println("Case #" + i + ": " + out);
			}
		}
		sc.close();
	}
	public static int startTime(String str) {
		return Integer.parseInt(str.split(":")[0]);
	}

	public static int endTime(String str) {
		return Integer.parseInt(str.split(":")[1]);
	}
	
}
