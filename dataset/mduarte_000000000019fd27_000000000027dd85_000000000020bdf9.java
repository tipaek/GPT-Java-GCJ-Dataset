import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {


	static List<int[][]> testCases;
	
	public static void main(String[] args) {
		testCases = new ArrayList<int[][]>();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int testCase = 1; testCase <= t; ++testCase) {
			int num = in.nextInt();
			int[][] activities = new int[num][2];
			for (int i = 0 ; i < num; i++) {
				activities[i][0] = in.nextInt();
				activities[i][1] = in.nextInt();
			}
			testCases.add(activities);
		}
		for (int testCase = 0; testCase < testCases.size(); testCase++) {
			int[][] activities = testCases.get(testCase);
			char[] arr = new char[activities.length];
			String ans = null;
			if (distribute(activities, arr)) {
				ans = new String(arr);
			} else {
				ans = "IMPOSSIBLE";
			}
			
			System.out.println("Case #" + testCase + 1 + ": " + ans);
		}
		in.close();

	}

	
	
	
	private static boolean canAssignTask(int start, int end, boolean[] p) {
		for (int i = start; i < end; i++) {
			if (p[i]) {
				return false;
			}
		}
		return true;
			
	}	
	
	private static void assignTask(int start, int end, boolean[] p, boolean value) {
		for (int i = start; i < end; i++) {
			p[i] = value;
		}
	}
	
	char[] arr = new char[] {'C', 'E'};
	
	private static boolean distribute(int[][] act, int index, char[] ans, boolean[] jamie, boolean[] cameron) {
		if (index == act.length) {
			return true;
		}
		int start = act[index][0];
		int end = act[index][1];

		// try cam
		if (canAssignTask(start, end, cameron)) { 
			ans[index] = 'C';
			assignTask(start, end, cameron, true);
			
			boolean ok = distribute(act, index+1, ans, jamie, cameron);
			if (!ok) {
				assignTask(start, end, cameron, false);
			} else {
				return ok;
			}
		} 
		
		if (canAssignTask(start, end, jamie)) { 
			ans[index] = 'J';
			assignTask(start, end, jamie, true);
			
			boolean ok = distribute(act, index+1, ans, jamie, cameron);
			if (!ok) {
				assignTask(start, end, jamie, false);
			} else {
				return ok;
			}
			
		} 
	
		
		return false;
		
	}

	private static boolean distribute(int[][] act, char[] ans) {

		return distribute(act, 0, ans, new boolean[60*24], new boolean[60*24]);
		//return distribute(act, 0, new char[act.length], -1, -1);
	}
	
}
