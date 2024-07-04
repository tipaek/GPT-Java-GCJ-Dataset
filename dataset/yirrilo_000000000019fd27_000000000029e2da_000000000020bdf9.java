

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public class Activity{
		public int start;
		public int end;
		public Activity(String definition) {
			int[] interval = Arrays.stream(definition.split(" ")).mapToInt(Integer::valueOf).toArray();
			start = interval[0];
			end = interval[1];
		}
		public boolean overlap(List<Activity> cList) {
			return cList.parallelStream().anyMatch(x -> this.overlap(x));
		}
		public boolean overlap(Activity other) {
			return this.start < other.end && other.start < this.end;
		}
	}

	public static void main( String[] argv ) throws Exception {
		InputStream inputStream = System.in;
		CodeJam2020C solver = new CodeJam2020C();
		String response = solver.doJob(inputStream);
		System.out.print(response);
	}

	public String doJob(InputStream inputStream) {
		Scanner sc = new Scanner(inputStream);
		StringBuilder solution = new StringBuilder();
		int testCaseNumber = Integer.valueOf(sc.nextLine());
		for(int i = 0; i< testCaseNumber; i++) {
			int numberOfActivities = Integer.valueOf(sc.nextLine());
			List<Activity> activities = new ArrayList<>();
			for (int j = 0; j< numberOfActivities; j++){
				String line = sc.nextLine();
				activities.add(new Activity(line));
			}
			String result = solve(activities);
			solution.append("Case #"+(i+1)+": "+result+"\n");
		}
		
		return solution.toString();
	}

	private String solve(List<Activity> activities) {
		String result = "";
		List<Activity> cList = new ArrayList<>();
		List<Activity> jList = new ArrayList<>();
		for (Activity activity : activities) {
			if(addToList(activity, cList)) {
				result += "C";
			} else if (addToList(activity, jList)) {
				result += "J";
			} else {
				return "IMPOSSIBLE";
			}
		}
		return result;
	}

	private boolean addToList(Activity activity, List<Activity> cList) {
		if(activity.overlap(cList)) {
			return false;
		}
		cList.add(activity);
		return true;
	}
}