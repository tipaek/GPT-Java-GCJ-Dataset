import java.util.*;
import java.io.*;

public class Solution {

	public static class Activity {
		int start, end;
		public Activity() {
			
		}
	}
    
	public static Comparator<Activity> actComparator = new Comparator<Activity>() {

		public int compare(Activity a1, Activity a2) {
			return a1.start < a2.start ? -1:1;
    }};
	public static void main(String[] args) {
		int N;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0 ; i<N ; i++) {
			List<Activity> activities = new ArrayList();
			int A = sc.nextInt();
			for(int j=0 ; j<A ; j++) {
				Activity newActivity = new Activity();
				newActivity.start = sc.nextInt();
				newActivity.end = sc.nextInt();
				activities.add(newActivity);
			}
			Collections.sort(activities, actComparator);
			String result = "";
			int cstart = -1, cend = -1, jstart = -1, jend = -1;
			boolean impossible = false;
			for(int j=0 ; j<A; j++) {
				Activity cur = activities.get(j);
				if(cstart == -1 || (cur.start >= cend) ) {
					cstart = cur.start;
					cend = cur.end;
					result += "C";
				}
				else if(jstart == -1 || (cur.start >= jend) ) {
					jstart = cur.start;
					jend = cur.end;
					result += "J";
				}
				else {
					impossible = true;
					break;
				}
			}
			String pr = "Case #" + Integer.toString(i+1) + ": ";
			pr += impossible ? "IMPOSSIBLE" : result;
			System.out.println(pr);
		} 
	}
}
