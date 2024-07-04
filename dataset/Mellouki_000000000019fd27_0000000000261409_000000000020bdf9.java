import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
        	int N = in.nextInt();
        	Activity[] activities = new Activity[N];
        	for(int a = 0; a < N; a++) {
        		Activity activity = new Activity();
        		activity.start = in.nextInt();
        		activity.end   = in.nextInt();
        		activity.i     = a;
        		activities[a] = activity;
        	}
        	Arrays.sort(activities);
        	Solution solution = new Solution(activities);
        	System.out.println("Case #" + i + ": "+ solution.getSolution());
        }
    }
	
	private Activity[] activities;
	
	public Solution(Activity[] activities) {
		this.activities = activities;
		solve();
	}
	
	private void solve() {
		Activity cActivity = null, jActivity = null;
		String[] schedule = new String[activities.length];
		
		for(Activity a: activities) {
			if(cActivity == null || cActivity.end <= a.start) {
				cActivity = a;
				schedule[a.i] = "C";
				continue;
			}
			
			if(jActivity == null || jActivity.end <= a.start) {
				jActivity = a;
				schedule[a.i] = "J";
				continue;
			}
			solution = "IMPOSSIBLE";
			return;
		}
		for(String s: schedule) solution += s;
	}
	
	public String getSolution() {return solution;}
	private String solution = "";
	
	static class Activity implements Comparable{
		int start;
		int end;
		int i;

		@Override
		public int compareTo(Object that) {
			return this.start - ((Activity)that).start;
		}
	}
}
