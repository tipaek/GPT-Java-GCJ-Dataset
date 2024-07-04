import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

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

			List<List<Integer>> act = new ArrayList<>();

			for (int j = 0; j < N; j++) {
				act.add(Arrays.asList(activities.get(j).start, -1, j));
				act.add(Arrays.asList(activities.get(j).end, 1));
			}

			act.sort((x,y) -> Integer.compare(x.get(0), y.get(0)));

			Stack<List<Integer>> st = new Stack<>();

			for (int j = 0; j < act.size(); j++) {
				List<Integer> curr = act.get(j);

				if (curr.get(1) == -1) {
					st.push(curr);
				} else {
					st.pop();
				}
				
				if (st.size() > 2) {
					result = "IMPOSSIBLE";
					break;
				}
			}
			
			if (result.equals("IMPOSSIBLE")) {
				System.out.println("Case #" + (i + 1) + ": " + result);
			} else {
				Person previous = null;
				Person pJ = new Person("J");
				Person pC = new Person("C");
				for (Activity a : activities) {
					if (previous == null) {
						result += "J";
						pJ.addActivity(a);
						previous = pJ;
					} else {
						if (!pJ.isOverlapping(a)) {
							result += "J";
							pJ.addActivity(a);
						} else if (!pC.isOverlapping(a)){
							result += "C";
							pC.addActivity(a);
						}
					}
				}
				
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
		for (Activity a : act) {
			if (a.start < n.end && n.start < a.end) {
				return true;
			}
		}
		return false;
	}
	
	public void addActivity(Activity a) {
		this.act.add(a);
	}
}
