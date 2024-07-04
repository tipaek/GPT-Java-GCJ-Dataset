import java.util.*;
import java.math.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			testCase(scan, i + 1);
		}
	}

	public static void testCase(Scanner scan, int t) {
		int n = scan.nextInt();
		int minStart = 0;
		int maxEnd = 0;
		ArrayList<Activity> acts = new ArrayList<Activity>();
//		String assignment = "";
		for (int i = 0; i < n; i++) {
			Activity act = new Activity();
			act.start = scan.nextInt();
			act.end = scan.nextInt();
			act.index = i;
			minStart = (act.start < minStart) ? act.start : minStart; 
			maxEnd = (act.end>maxEnd) ? act.end : maxEnd;
			acts.add(act);
		}
		boolean times [][] = new boolean [2][maxEnd-minStart];
		char[] assignments = new char[n];
		Collections.sort(acts);
		for (int i = 0; i < n; i++) {
			if(times[0][acts.get(i).start-minStart]) {
				
				if(times[1][acts.get(i).start-minStart]) {
					System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
					return;
				}
					
				for (int j = acts.get(i).start-minStart; j < acts.get(i).end-minStart; j++) {
					times[1][j] = true;
				}
				assignments[acts.get(i).index] = 'J';
				
			} else {
			
				for (int j = acts.get(i).start-minStart; j < acts.get(i).end-minStart; j++) {
					times[0][j] = true;
				}
				assignments[acts.get(i).index] = 'C';
			}
		}
		System.out.println("Case #" + t + ": " + new String(assignments));
	}
}
class Activity implements Comparable<Activity>{
	int start;
	int end;
	int index;
	public int compareTo(Activity a) {
		if(this.start < a.start) {
			return -1;
		} else if(this.start > a.start){
			return 1;
		}
		return 0;
	}
}
