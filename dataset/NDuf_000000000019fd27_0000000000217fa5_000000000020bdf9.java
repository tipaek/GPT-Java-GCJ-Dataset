import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int nbTestCases = sc.nextInt();
		for(int t = 1 ; t <= nbTestCases ; ++t) {
			System.out.println(
				"Case #" + t + ": " + testCase(sc)
			);
		}
		sc.close();
	}
	
	public static String testCase(Scanner sc) throws Exception {
		//Read activities and order them
		final int activityCount = sc.nextInt();
		final List<Activity> activities = new ArrayList<>();
		for(int activity = 0 ; activity < activityCount ; ++activity) {
			activities.add(
				new Activity(sc.nextInt(), sc.nextInt(), activity)
			);
		}
		Collections.sort(activities, (a1, a2) -> a1.beg - a2.beg);
		
		//Check for resources
		Activity c = null;
		Activity j = null;
		for(Activity current : activities) {
			//Allocate
			if(c == null || current.beg >= c.end) {
				(c = current).who = "C";
			} else if(j == null || current.beg >= j.end) {
				(j = current).who = "J";
			} else {
				return "IMPOSSIBLE";
			}
		}
		
		//Order back to original and output results
		Collections.sort(activities, (a1, a2) -> a1.pos - a2.pos);
		StringBuilder output = new StringBuilder();
		for(Activity current : activities) {
			output.append(current.who);
		}
		
		return output.toString();
	}
	
	private static class Activity {
		public final int beg, end, pos;
		public String who;
		public Activity(int beg, int end, int pos) {
			this.beg = beg;
			this.end = end;
			this.pos = pos;
			this.who = null;
		}
	}
	
}
