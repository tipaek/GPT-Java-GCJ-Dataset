
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num_test_cases = in.nextInt();
		int N;
		String s;
		ArrayList<String> perms;

		for (int i = 1; i <= num_test_cases; i++) {
			N = in.nextInt();
			s = "IMPOSSIBLE";
			ArrayList<Activity> acts = new ArrayList<Activity>(N);
			
			for (int j = 0; j < N; j++) {
				Activity a = new Activity(in.nextInt(), in.nextInt());
				acts.add(a);
			}

			perms = new ArrayList<String>((int) Math.pow(2, N));
			for (int j = 0; j < (int) Math.pow(2, N); j++) {
				String bin = String.format("%" + N + "s", Integer.toBinaryString(j)).replace(" ", "0");
				String p = "";
				for (int k = 0; k < bin.length(); k++) {
					p += bin.charAt(k) == '1' ? "J" : "C";
				}
				perms.add(p);
			}
			
			boolean skip;
			for (String p : perms) {
				skip = false;
				for (int j = 0; j < p.length(); j++) {
					char currChar = p.charAt(j);
					Activity currActivity = acts.get(j);
					for (int k = j+1; k<p.length(); k++) {
						if (p.charAt(k) == currChar && acts.get(k).overlapsWith(currActivity)) {
							skip = true;
							break;
						}
					}
					if (skip) {
						break;
					}
				}
				if (!skip) {
					s = p;
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