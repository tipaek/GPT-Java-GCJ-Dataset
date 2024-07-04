
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num_test_cases = in.nextInt();
		int N;
		String s;
		Activity curr;
		
		for (int i = 1; i <= num_test_cases; i++) {
			N = in.nextInt();
			ArrayList<Activity> availableJ = new ArrayList<Activity>(N);
			ArrayList<Activity> availableC = new ArrayList<Activity>(N);
			ArrayList<Activity> left = new ArrayList<Activity>(N);
			
			for (int j = 0; j < N; j++) {
				Activity a = new Activity(in.nextInt(), in.nextInt());
				availableJ.add(a);
				availableC.add(a);
				left.add(a);
			}
			
			s = "";
			while (!left.isEmpty()) {
				curr = left.remove(0);
				if (availableJ.contains(curr)) {
					s += "J";
					availableJ.remove(curr);
					
					Iterator<Activity> iter = availableJ.iterator();
					while (iter.hasNext()) {
						Activity a = iter.next();
						if (a.overlapsWith(curr)) {
							iter.remove();
						}
					}
				} else if (availableC.contains(curr)) {
					s += "C";
					availableC.remove(curr);
					
					Iterator<Activity> iter = availableC.iterator();
					while (iter.hasNext()) {
						Activity a = iter.next();
						if (a.overlapsWith(curr)) {
							iter.remove();
						}
					}
				} else {
					s = "IMPOSSIBLE";
					break;
				}
			}
			

			System.out.printf("Case #%d: %s\n", i, s);
		}
		in.close();
	}

}

class Activity {
	private int start, end;
	private boolean remove;
	// private ArrayList<Activity> overlaps;

	public Activity(int start, int end) {
		this.start = start;
		this.end = end;
		this.remove = false;
		// overlaps = new ArrayList<Activity>();
	}

	public int getStart() {
		return this.start;
	}

	public int getEnd() {
		return this.end;
	}

	public boolean overlapsWith(Activity a) {
		boolean c1 = a.start > this.start && a.start < this.end;
		boolean c2 = this.start > a.start && this.start < a.end;
		return c1 || c2;
	}
	
	public boolean getRemove() {
		return this.remove;
	}
	
	public void setRemove() {
		this.remove = true;
	}
	
	public boolean equals(Activity a) {
		return a.getStart() == this.start && a.getEnd() == this.end;
	}
}