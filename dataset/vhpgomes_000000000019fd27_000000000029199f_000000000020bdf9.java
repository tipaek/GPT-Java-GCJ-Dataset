import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static class Activity {
		int id;
		int start;
		int end;
		char assignedTo;
		
		Activity(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}
		
		public String toString() {
			return new StringBuilder()
					.append("[")
					.append(this.start)
					.append(" - ")
					.append(this.end)
					.append("]")
					.toString();
		}
	}

	
	
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int T = in.nextInt();
			for (int t = 1; t <= T; ++t) {
				int N = in.nextInt();
				
				List<Activity> activities = new ArrayList<>(N);

				for (int n = 0; n < N; ++n) {
					int start = in.nextInt();
					int end = in.nextInt();
					activities.add(new Activity(n, start, end));
				}
				
				Activity C = null, J = null;
				boolean impossible = false;

				activities.sort((a, b) -> a.start - b.start);
				for (int i = 0; i < N; ++i) {
					Activity a = activities.get(i);
					
					if (C == null || C.end <= a.start) {
						a.assignedTo = 'C';
						C = a;
					}
					else if (J == null || J.end <= a.start) {
						a.assignedTo = 'J';
						J = a;
					}
					else {
						impossible = true;
						break;
					}
				}
				
				StringBuilder sb = new StringBuilder();
				if (impossible)
					sb.append("IMPOSSIBLE");
				else {
					activities.sort((a, b) -> a.id - b.id);
					activities.forEach(a -> sb.append(a.assignedTo));
				}

				System.out.println("Case #" + t + ": " + sb.toString());
			}
		}
	}
}