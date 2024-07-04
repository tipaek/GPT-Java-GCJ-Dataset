import java.util.*;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int caseNo = 1;
		while (t-- > 0) {
			int n = sc.nextInt();
			boolean isPossible = true;
			List<Pair> cActivities = new ArrayList<>();
			List<Pair> jActivities = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				Pair pair = new Solution().new Pair(sc.nextInt(), sc.nextInt());
				if (canITakeThisActivity(cActivities, pair)) {
					cActivities.add(pair);
					sb.append("C");
				} else if (canITakeThisActivity(jActivities, pair)) {
					jActivities.add(pair);
					sb.append("J");
				} else {
					System.out.println("Case #" + caseNo++ + ": IMPOSSIBLE");
					isPossible = false;
					break;
				}
			}
			if (isPossible)
				System.out.println("Case #" + caseNo++ + ": " + sb.toString());
		}
		//sc.close();
	}

	private static boolean canITakeThisActivity(List<Pair> cActivities, Pair pair) {
		for (Pair activity : cActivities) {
			if (activity.isInBtw(pair)) {
				return false;
			}
		}

		return true;
	}

	public class Pair {

		public int start;
		public int end;

		public Pair(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public boolean isInBtw(Pair pair) {
			return start >= pair.end || pair.start >= end ? false : true;
		}

		@Override
		public String toString() {
			return new StringBuilder("Start :").append(start).append(" end : ").append(end).toString();
		}
	}

}
