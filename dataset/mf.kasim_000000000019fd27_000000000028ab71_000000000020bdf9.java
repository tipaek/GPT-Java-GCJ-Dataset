import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

//		System.out.println("char= " + (int) ('9' - '0'));

		try (Scanner s = new Scanner(System.in)) {

			int T = s.nextInt();
			for (int i = 1; i <= T; i++) {
				int N = s.nextInt();
				List<Period> periodList = new ArrayList<Period>(N);
				for (int j = 1; j <= N; j++) {
					periodList.add(new Period(s.nextInt(), s.nextInt()));
				}
//				System.out.println("perid=" + periodList);
				String result = solve(periodList);
//				System.out.println("perid=" + periodList);
				System.out.println("Case #" + i + ": " + result);
			}
		}
	}

	public static String solve(List<Period> periodList) {
		String result = "";
		int jUtil = 0, cUtil = 0;

		Collections.sort(periodList, new PeriodComparator());

		for (Period p : periodList) {
			if (p.from >= cUtil) {
				cUtil = p.to;
				result += 'C';
			} else if (p.from >= jUtil) {
				jUtil = p.to;
				result += 'J';
			} else {
				result = "IMPOSSIBLE";
				break;
			}
		}

		return result;

	}

	static class Period {

		public Period(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}

		int from;
		int to;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return from + " " + to;
		}
	}

	static class PeriodComparator implements Comparator<Period> {

		@Override
		public int compare(Period o1, Period o2) {

			return o1.from < o2.from ? -1 : o1.from == o2.from ? 0 : 1;
		}

	}

}
