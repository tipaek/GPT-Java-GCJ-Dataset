import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < testCases; ++i) {
			processInput(i + 1);
		}
	}
	
	public static void printResult(int current, String result) {
		System.out.println("Case #" + current + ": " + result);
	}
	
	public static void processInput(int testCase) {
		int total = Integer.parseInt(in.nextLine());
		
		Activity [] activities = new Activity[total];
		
		for (int i = 0; i < total; ++i) {
			String s = in.nextLine();
			String [] line = s.split(" ");
			activities[i] = new Activity( Integer.parseInt(line[0]) , Integer.parseInt(line[1]) );
		}
		
		
		solve(activities, testCase);
	}
	
	public static void solve(Activity [] activities, int testCase) {
		
		Arrays.sort(activities);
		StringBuilder result = new StringBuilder();
		
		int Cmax = 0;
		int jMax = 0;
		
		for (Activity activity: activities) {
			if (Cmax <= activity.start) {
				Cmax = activity.end;
				result.append('C');
			} 
			else if (jMax <= activity.start) {
				jMax = activity.end;
				result.append('J');
			} else {
				result = new StringBuilder("IMPOSSIBLE");
			}
		}
		printResult(testCase, result.toString());
		
	}
	
	public static void helper() {
		
	}


}
class Activity implements Comparable<Activity> {
	public int start;
	public int end;
	
	public Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int compareTo(Activity activity) {
		return this.start - activity.start;
	}
}
