import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = scan.nextInt();
		scan.nextLine();
		for (int c = 1; c <= numCases; c++) {
			int currentN = scan.nextInt();
			scan.nextLine();
			ArrayList<Activity> currentActivities = new ArrayList<Activity>();
			for (int i = 0; i < currentN; i++) {
				int start = scan.nextInt();
				int end = scan.nextInt();
				currentActivities.add(new Activity(i, start, end));
				scan.nextLine();
			}
			currentActivities.sort(null);
			solution(c, currentN, currentActivities);
		}
		scan.close();

	}
	
	public static void solution(int c, int n, List<Activity> activities) {
		char[] answer = new char[n];
		boolean cFree = true, jFree = true;
		int cEnd = -1, jEnd = -1;
		int curTime = -1;
		for (int i = 0; i < n; i++) {
			curTime = activities.get(i).start;
			if (curTime >= cEnd) cFree = true;
			if (curTime >= jEnd) jFree = true;
			if(cFree) {
				answer[activities.get(i).index] = 'C';
				cEnd = activities.get(i).end;
				cFree = false;
			} else if (jFree) {
				answer[activities.get(i).index] = 'J';
				jEnd = activities.get(i).end;
				jFree = false;
			} else {
				System.out.printf("Case #%d: IMPOSSIBLE\n", c);
				return;
			}
		}
		System.out.printf("Case #%d: %s\n", c, String.valueOf(answer));
	}
	
	static class Activity implements Comparable<Activity>{
		int index;
		int start;
		int end;
		public Activity(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Activity o) {
			// TODO Auto-generated method stub
			return this.start - o.start;
		}
		
	}
}
