import java.util.*;
import java.io.*;

public class Solution {
	
	public static class Activity {
		public int index;
		public int begin;
		public int end;
		public char person;
		
		public Activity(int index, int begin, int end) {
			this.index = index;
			this.begin = begin;
			this.end = end;
		}
		
	}
	
	public static class ActivityTimeComparator<Activity> implements Comparator<Activity> {

		@Override
		public int compare(Object arg0, Object arg1) {
			Solution.Activity a0 = (Solution.Activity)arg0;
			Solution.Activity a1 = (Solution.Activity)arg1;
			
			return a0.begin - a1.begin;
		}
		
	}
	
	public static class ActivityIndexComparator<Activity> implements Comparator<Activity> {

		@Override
		public int compare(Object arg0, Object arg1) {
			Solution.Activity a0 = (Solution.Activity)arg0;
			Solution.Activity a1 = (Solution.Activity)arg1;
			
			return a0.index - a1.index;
		}
		
	}

	
	public static void parentingPartneringReturns(int caseNum, Scanner in) {
		System.out.print("Case #" + caseNum +": ");
		
		int activities = in.nextInt();
		
		int cameronAvailable = 0;
		int jamieAvailable = 0;
		
		boolean possible = true;
		
		List<Activity> activityList = new ArrayList<Activity>();
		
		for (int i = 0; i < activities; i++) {
			int begin = in.nextInt();
			int end = in.nextInt();
			
			activityList.add(new Activity(i, begin, end));
			
		}
		
		activityList.sort(new ActivityTimeComparator<Activity>());
		
		for (int i = 0; i < activities; i++) {
			int begin = activityList.get(i).begin;
			int end = activityList.get(i).end;
						
			if (cameronAvailable <= begin) {
				activityList.get(i).person = 'C';
				cameronAvailable = end;
			} else if (jamieAvailable <= begin) {
				activityList.get(i).person = 'J';
				jamieAvailable = end;
			} else {
				possible = false;
			}
		}
		
		activityList.sort(new ActivityIndexComparator<Activity>());

		if(possible) {
			for(int i = 0; i < activityList.size(); i++) {
				System.out.print(activityList.get(i).person);
			}
			System.out.println();
		} else {
			System.out.println("IMPOSSIBLE");	
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int cases = in.nextInt(); 
	    for (int i = 1; i <= cases; i++) {
	    	parentingPartneringReturns(i, in);
	    }
	    in.close();
	}
}
