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
			List<Activity> list = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				int start = input.nextInt();
				int end = input.nextInt();
				list.add(new Activity(start, end));
			}
			Collections.sort(list, new ActivityComparator());
			Activity first = list.get(0);
			int start = first.getStart();
			int end = first.getEnd();
			boolean prevOverlap = false;
			//int overlapEnd = -1;
			StringBuilder sb = new StringBuilder("C");
			int CEnd = end;
			int JEnd = -1;
			for (int j = 1; j < list.size(); j++) {
				Activity next = list.get(j);
				int nextStart = next.getStart();
				int nextEnd = next.getEnd();
				if (prevOverlap && (nextStart < end)) {
					sb = new StringBuilder("IMPOSSIBLE");
					break;
				}
				if (nextStart < end) {
					prevOverlap = true;
					if (CEnd > JEnd) {
						sb.append("J");
						JEnd = nextEnd;
					} else {
						sb.append("C");
						CEnd = nextEnd;
					}

				} else {
					prevOverlap = false;
					end = nextEnd;
					if (CEnd > JEnd) {
						sb.append("J");
						JEnd = nextEnd;
					} else {
						sb.append("C");
						CEnd = nextEnd;
					}

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

class ActivityComparator implements Comparator<Activity> {
	public int compare(Activity i1, Activity i2) {
		return i1.getEnd() - i2.getEnd();
	}
}
