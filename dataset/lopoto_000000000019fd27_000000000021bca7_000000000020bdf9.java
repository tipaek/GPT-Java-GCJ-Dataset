import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();

		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			String result = "";
			List<Activity> activities = new ArrayList<>();

			for (int j = 0; j < N; j++) {
				int start = in.nextInt();
				int end = in.nextInt();
				Activity a = new Activity(start, end);

				activities.add(a);
			}

			Person pJ = new Person("J");
			Person pC = new Person("C");
			boolean stopped = false;
			for (Activity a : activities) {
				if (!pJ.isOverlapping(a)) {
					result += "J";
					pJ.addActivity(a);
				} else if (!pC.isOverlapping(a)) {
					result += "C";
					pC.addActivity(a);
				} else {
					System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
					stopped = true;
					break;
				}
			}

			if (!stopped) {
				System.out.println("Case #" + (i + 1) + ": " + result);
			}
		}

	}

}

class Activity {

	public int start;
	public int end;

	Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}

}

class Person {

	public List<Activity> act;
	public String name;

	Person(String name) {
		this.name = name;
		act = new ArrayList<>();
	}

	public boolean isOverlapping(Activity n) {
		for (Activity a : this.act) {
			if (a.start < n.end && a.end > n.start) {
				return true;
			}
		}
		return false;
	}

	public void addActivity(Activity a) {
		this.act.add(a);
	}
}
