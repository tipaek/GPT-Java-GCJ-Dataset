import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			EarliestActivity strategy = new EarliestActivity();
			PriorityQueue<Activity> pQ = new PriorityQueue<Activity>(2, strategy);
			for (int r=0; r < N; r++) {
				pQ.add(new Activity(in.nextInt(), in.nextInt()));
			}
			StringBuffer assignment = new StringBuffer();
			Activity curJ = pQ.remove();
			assignment.append('J');
			Activity curC = pQ.remove();
			assignment.append('C');
			boolean isPossible = true;
			while(!pQ.isEmpty() && isPossible) {
				Activity curActivity = pQ.remove();
				if (curJ.endTime <= curActivity.startTime) {
					curJ = curActivity;
					assignment.append('J');
				} else {
					if (curC.endTime <= curActivity.startTime) {
						curC = curActivity;
						assignment.append('C');
					} else {
						isPossible = false;
					}
				}
			}
			if (!isPossible) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + i + ": " + assignment.toString());
			}
		}
	}
}

class Activity {
	int startTime;
	int endTime;
	
	public Activity(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}

class EarliestActivity implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		Activity a1 = (Activity) o1;
		Activity a2 = (Activity) o2;
		return a1.startTime - a2.startTime;
	}
}