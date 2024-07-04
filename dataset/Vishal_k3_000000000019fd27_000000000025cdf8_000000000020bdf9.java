import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static class timeslot {
		public int start;
		public int end;
		public boolean assignedToC;
		public int position;

		public timeslot(int start, int end, int pos) {
			this.start = start;
			this.end = end;
			this.assignedToC = false;
			this.position = pos;
		}
	}

	static class SortbyStart implements Comparator<timeslot> {
		public int compare(timeslot a, timeslot b) {
			return a.start - b.start;
		}
	}

	public static void main(String[] args) {
		int T, N;
		timeslot[] arr = new timeslot[1002];
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		T = Integer.parseInt(s);
		for (int i = 1; i <= T; i++) {
			s = in.nextLine();
			N = Integer.parseInt(s);
			for (int j = 0; j < N; j++) {
				s = in.nextLine();
				StringTokenizer st = new StringTokenizer(s);
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				arr[j] = new timeslot(num1, num2, j);
			}
			String schedule = getSchedule(arr, N, i);
			System.out.println(schedule);
		}

	}

	private static String getSchedule(timeslot[] arr, int N, int testCaseNumber) {
		char[] ans = new char[1002];
		Arrays.sort(arr, 0, N, new SortbyStart());
		int cFreeTime = -1, jFreeTime = -1;
		boolean notPossible = false;
		for (int i = 0; i < N; i++) {
			if (arr[i].start >= cFreeTime) {
				arr[i].assignedToC = true;
				cFreeTime = arr[i].end;
				ans[arr[i].position] = 'C';
			} else if (arr[i].start >= jFreeTime) {
				jFreeTime = arr[i].end;
				ans[arr[i].position] = 'J';
			} else {
				notPossible = true;
				break;
			}
		}
		String as;
		if(!notPossible) {
			as=String.valueOf(ans);
			as=as.trim();
		}else {
			as = "IMPOSSIBLE";
		}
		StringBuilder sb = new StringBuilder("Case #");
		sb.append(testCaseNumber);
		sb.append(": ");
		sb.append(as);
		return sb.toString();
	}

}
