import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = input.nextInt();
			List<Activity> listStart = new ArrayList<>();
			List<Activity> listEnd = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				int start = input.nextInt();
				int end = input.nextInt();
				listStart.add(new Activity(start, end));
				listEnd.add(new Activity(start, end));
			}
			Collections.sort(listStart, new ActivityComparatorStart());
			Collections.sort(listEnd, new ActivityComparatorEnd());
			int endIndex = 0;
			int 	overlapEnd = listEnd.get(0).getEnd();
			List<Activity> overlapped = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			int CEnd = -1;
			int JEnd = -1;
			
			for (int j = 0; j < listStart.size(); j++) {
				Activity nextActivity = listStart.get(j);
				
				if(endIndex==-1) {
					sb.append("C");
				}
				else if(nextActivity.getStart()<overlapEnd) {
					overlapped.add(nextActivity);
				}else {
					int k= endIndex+1;
					endIndex = -1;
					for(;k<listEnd.size();k++) {
						overlapEnd = listEnd.get(k).getEnd();
						if(nextActivity.getStart()<overlapEnd) {
							overlapped.add(nextActivity);
							endIndex = k;
							overlapped = new ArrayList<>();
							overlapped.add(nextActivity);
							break;
						}
					}
					
				}
				if(overlapped.size()>2) {
					sb = new StringBuilder("IMPOSSIBLE");
					break;
				}
				if (CEnd > JEnd) {
					sb.append("J");
					JEnd = nextActivity.getEnd();
				} else {
					sb.append("C");
					CEnd = nextActivity.getEnd();
				}
			}
			System.out.println("Case #" + i + ": " + sb.toString());
		}
		input.close();

	}

}

class Activity {
	private int start;
	private int end;

	public Activity(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}

class ActivityComparatorStart implements Comparator<Activity> {
	public int compare(Activity i1, Activity i2) {
		return i1.getStart() - i2.getStart();
	}
}

class ActivityComparatorEnd implements Comparator<Activity> {
	public int compare(Activity i1, Activity i2) {
		return i1.getEnd() - i2.getEnd();
	}
}
