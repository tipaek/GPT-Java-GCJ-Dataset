import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufread.readLine());
		for (int counter = 0; counter < t; counter++) {
			int activityNum = Integer.parseInt(bufread.readLine());
			Activity[] activities = new Activity[activityNum];
			for (int i = 0; i < activityNum; i++) {
				StringTokenizer st = new StringTokenizer(bufread.readLine());
				activities[i] = new Activity(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			}
			Arrays.sort(activities);
			Activity c = new Activity(-1, -1, -1);
			Activity j = new Activity(-1, -1, -1);
			char[] schedule = new char[activityNum];
			for (int i = 0; i < activityNum; i++) {
				Activity next = activities[i];
				if (next.start >= c.end) {
					c = next;
					schedule[next.index] = 'C';
					continue;
				}
				if (next.start >= j.end) {
					j = next;
					schedule[next.index] = 'J';
					continue;
				}
				schedule = null;
				break;
			}
			if (schedule == null) {
				System.out.println("Case #" + (counter + 1) + ": IMPOSSIBLE");
				continue;
			}
			System.out.println("Case #" + (counter + 1) + ": " + String.valueOf(schedule));
		}
		bufread.close();
	}

}

class Activity implements Comparable<Activity> {
	int start;
	int end;
	int index;

	public Activity(int start, int end, int index) {
		this.start = start;
		this.end = end;
		this.index = index;
	}

	public int compareTo(Activity other) {
		if (this.start != other.start) {
			return this.start - other.start;
		} else {
			return this.end - other.end;
		}
	}
}