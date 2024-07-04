import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static class Task implements Comparable<Task> {
		
		public int s;
		public int e;

		private Task() {}
		
		public Task(int s, int e) {
			this.s = s;
			this.e = e;
		}
		
		@Override
		public int compareTo(Task o) {

			int result;
			
			if (s < o.s || (s == o.s && e < o.e)) {
				result = -1;
			} else if (s > o.s || (s == o.s && e > o.e)) {
				result = 1;
			} else {
				result = 0;
			}
			
			return result;
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N;
		StringBuilder result;
		Task[] ar;
		int cEnd, jEnd;
				
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			ar = new Task[N];

			for (int n = 0; n < N; n++) {
				ar[n] = new Task(sc.nextInt(), sc.nextInt());
			}
			
			Arrays.sort(ar);
			
			result = new StringBuilder();

			cEnd = jEnd = 0;

			for (int i = 0; i < ar.length; i++) {
				if (cEnd <= ar[i].s) {
					result.append('C');
					cEnd = ar[i].e;
				} else if (jEnd <= ar[i].s) {
					result.append('J');
					jEnd = ar[i].e;
				} else {
					result = new StringBuilder("IMPOSSIBLE");
					break;
				}
			}
			
			System.out.println(String.format("Case #%d: %s", t, result));
		}
	}

}
