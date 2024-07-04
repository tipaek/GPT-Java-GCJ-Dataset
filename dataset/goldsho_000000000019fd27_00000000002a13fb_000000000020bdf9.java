import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Activity implements Comparable<Activity> {
	public int start;
	public int end;

	public Activity(int s, int e) {
		this.start = s;
		this.end = e;
	}


	@Override
	public int compareTo(Activity o) {
		if (this.start < o.start) {
			return -1;
		}

		if (this.start > o.start) {
			return 1;
		}

		return 0;
	}
}

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(scan.readLine());

		for (int i = 1; i <= t; i++) {
			List<Activity> actList = new ArrayList<>();

			int n = Integer.parseInt(scan.readLine());

			while (n > 0) {
				String[] activities = scan.readLine().split(" ");
				int s = Integer.parseInt(activities[0]);
				int e = Integer.parseInt(activities[1]);
				actList.add(new Activity(s, e));
				n--;
			}

			Collections.sort(actList);

			StringBuilder sb = new StringBuilder();
			boolean imp = false;

			Map<String, Integer[]> JCMap = new HashMap<>();

			for (Activity act : actList) {
				int s = act.start;
				int e = act.end;

				if (JCMap.containsKey("J")) {
					Integer[] sej = JCMap.get("J");
					if (sej[0] <= s && s < sej[1]) {
						if (JCMap.containsKey("C")) {
							Integer[] sec = JCMap.get("C");
							if (sec[0] <= s && s < sec[1]) {
								imp = true;
								break;
							} else {
								Integer[] _sec = new Integer[2];
								_sec[0] = s;
								_sec[1] = e;
								JCMap.put("C", _sec);
								sb.append("C");
							}
						} else {
							Integer[] sec = new Integer[2];
							sec[0] = s;
							sec[1] = e;
							JCMap.put("C", sec);
							sb.append("C");
						}
					} else {
						Integer[] _sej = new Integer[2];
						_sej[0] = s;
						_sej[1] = e;
						JCMap.put("J", _sej);
						sb.append("J");
					}
				} else {
					Integer[] sej = new Integer[2];
					sej[0] = s;
					sej[1] = e;
					JCMap.put("J", sej);
					sb.append("J");
				}

			}

			if (imp) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + i + ": " + sb.toString());
			}
		}
	}
}
