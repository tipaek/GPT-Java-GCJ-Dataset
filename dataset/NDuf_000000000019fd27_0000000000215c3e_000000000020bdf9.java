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
		//Read activity and organize it by their end
		final int activityCount = sc.nextInt();
		final List<Activity> activities = new ArrayList<>();
		for(int activity = 0 ; activity < activityCount ; ++activity) {
			activities.add(
				new Activity(sc.nextInt(), sc.nextInt())
			);
		}
		Collections.sort(activities, (a1, a2) -> a1.end - a2.end);
		
		//Check for resources
		StringBuilder output = new StringBuilder();
		Activity c = null;
		Activity j = null;
		for(Activity current : activities) {
			//Clean
			if(c != null && current.beg >= c.end) {
				c = null;
			}
			if(j != null && current.beg >= j.end) {
				j = null;
			}
			//Allocate
			if(c == null) {
				c = current;
				output.append("C");
			} else if(j == null) {
				j = current;
				output.append("J");
			} else {
				break;
			}
		}
		return output.length() != activities.size() ? "IMPOSSIBLE" : output.toString();
	}
	
	private static class Activity {
		public final int beg, end;
		public Activity(int beg, int end) {
			this.beg = beg;
			this.end = end;
		}
	}
	
}
