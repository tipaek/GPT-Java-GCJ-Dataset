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
			StringBuilder result = new StringBuilder("");
			for (int j = 0; j < N; j++) {
				result.append("W");
			}
			List<Activity> activities = new ArrayList<>();

			for (int j = 0; j < N; j++) {
				int start = in.nextInt();
				int end = in.nextInt();
				Activity a = new Activity(start, end, j);

				activities.add(a);
			}
			
			activities.sort((a, b) -> Integer.compare(a.start, b.start));

			Person pJ = new Person("J");
			Person pC = new Person("C");
			boolean stopped = false;
			for (Activity a : activities) {
				if (!pC.isOverlapping(a)) {
					result.setCharAt(a.index, 'C');
					pC.addActivity(a);
				} else if (!pJ.isOverlapping(a)) {
					result.setCharAt(a.index, 'J');
					pJ.addActivity(a);
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
	public int index;

	Activity(int start, int end, int index) {
		this.start = start;
		this.end = end;
		this.index = index;
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
