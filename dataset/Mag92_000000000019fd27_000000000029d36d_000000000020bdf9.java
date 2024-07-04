
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Activity {
	int start;
	int end;
	Person ass;
}

class Person {
	int minBusy;
	int maxBusy;
	String name;
	Person() {
		this.minBusy = 0;
		this.maxBusy = 0;
	}
}
class ActivityComparator implements Comparator<Activity> {

	@Override
	public int compare(Activity o1, Activity o2) {
		
		return Integer.compare(o1.start, o2.start);
	}
	
}

public class Solution {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
		int T = scanner.nextInt();
		List<Activity> activities = new ArrayList<>();
		
		
		
		
		
		for(int t = 0; t < T; t++) {
			// number of activities:
			int N = scanner.nextInt();
			for(int n = 0; n < N; n++) {
				Activity activity = new Activity();
				activity.start = scanner.nextInt(); // S_i
				activity.end = scanner.nextInt(); // E_i
				
				activities.add(activity);
				
			}
			Collections.sort(activities, new ActivityComparator());
			Person C = new Person();
			Person J = new Person();
			J.name = "J";
			C.name = "C";
				// Assign:
				for(int i = 0; i < activities.size(); i++) {
					Activity currentActivity = activities.get(i);

					// check to see if the next one can be given to C:
					if ((currentActivity.start < C.minBusy && currentActivity.end <= C.minBusy) || 
							(currentActivity.start >= C.maxBusy && currentActivity.end > C.maxBusy)) {
						// can be added to C's queue
						currentActivity.ass = C;
						if (i == 0)
							C.minBusy = currentActivity.start;
						if (currentActivity.end > C.maxBusy)
							C.maxBusy = currentActivity.end;
						
						continue;
					}
					
					// Do the same with J
					// check to see if the next one can be given to J:
					else if ((currentActivity.start < J.minBusy && currentActivity.end <= J.minBusy) || 
							(currentActivity.start >= J.maxBusy && currentActivity.end > J.maxBusy)) {
						// can be added to J's queue
						currentActivity.ass = J;
						if (i == 0)
							J.minBusy = currentActivity.start;
						if (currentActivity.end > J.maxBusy)
							J.maxBusy = currentActivity.end;
					}
				}
			
		
		
		StringBuilder str = new StringBuilder();
		boolean possible = true;
		
		for(Activity a : activities) {
			
			if (a.ass == null) {
				possible = false;
				break;
			}
			str.append(a.ass.name);
		}
		
		if (possible) System.out.println("Case #" + (t+1) + ": " + str);
		else System.out.println("Case #" + (t+1) + ": IMPOSSIBLE");
		activities.clear();
	}
	}
}
