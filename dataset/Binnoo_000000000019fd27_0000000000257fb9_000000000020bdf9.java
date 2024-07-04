import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Activity implements Comparable<Activity> {
	int start;
	int end;
	int id;
	String assignee;

	public Activity(int start, int end, int id) {
		super();
		this.start = start;
		this.end = end;
		this.id = id;
	}

	@Override
	public int compareTo(Activity o) {
		return start - o.start;
	}
}

public class Solution {

	int t;
	Scanner s;
	ArrayList<Activity> activities = new ArrayList<>();

	public Solution(int t, Scanner s) {
		super();
		this.t = t;
		this.s = s;
	}

	public void solve() {
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			activities.add(new Activity(s.nextInt(), s.nextInt(), i));
		}
		Collections.sort(activities);

		
		int freeTime[] = new int[2];
		String parents[] = { "J", "C" };
		boolean impossible = false;
		for (int i = 0; i < n && !impossible; i++) {
			for (int p = 0; p < 3; p++) {
				if(p==2) {
					impossible = true;
					break;
				}
				if(freeTime[p] <= activities.get(i).start) {
					activities.get(i).assignee = parents[p];
					freeTime[p] = activities.get(i).end;
					break;
				}
 			}
		}
		
		Collections.sort(activities, (o1, o2) -> o1.id - o2.id);
		
		StringBuilder res = new StringBuilder();
		if(impossible) {
			res = new StringBuilder("IMPOSSIBLE");
		} else {
			for(Activity a:activities) {
				res.append(a.assignee);
			}
		}
		System.out.println("Case #" + t + ": " + res);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for (int i = 0; i < testCases; i++) {
			new Solution(i + 1, s).solve();
		}

		s.close();
	}

}
