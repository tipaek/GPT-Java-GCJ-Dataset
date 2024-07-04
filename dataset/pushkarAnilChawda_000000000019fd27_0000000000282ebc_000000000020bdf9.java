import java.util.*;

public class Solution {

	public static class Interval {
		Integer start;
		Integer end;
		Integer number;

		public Interval(int start, int end, Integer number) {
			this.start = start;
			this.end = end;
			this.number = number;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean invalid = false;
		int CJ[] = null;
		int C = 0, J = 1;
		char result[] = null;
		List<Interval> l = null;
		for (int k = 0; k < T; k++) {
			invalid = false;
			CJ = new int[2];
			int N = sc.nextInt();
			result = new char[N];
			l = new ArrayList<Interval>();
			for (int i = 0; i < N; i++) {
				l.add(new Interval(sc.nextInt(), sc.nextInt(), i));
			}

			if(N<2) {
				System.out.println("Case #" + (k + 1) + ": IMPOSSIBLE");
				continue;
			}

			Collections.sort(l, new Comparator<Interval>() {

				@Override
				public int compare(Interval o1, Interval o2) {
					return o1.end.compareTo(o2.end);
				}

			});
			
			for(Interval o : l) {
				
				if(CJ[C] == 0 || CJ[C] <= o.start) {
					CJ[C] = o.end;
					result[o.number] = 'C';
					continue;
				}
				
				if(CJ[J] == 0 || CJ[J] <= o.start) {
					CJ[J] = o.end;
					result[o.number] = 'J';
					continue;
				}
				
				invalid = true;
				break;
			}

			if(!invalid) {
				System.out.println("Case #" + (k + 1) + ": "+new String(result));
			}
			else {
				System.out.println("Case #" + (k + 1) + ": IMPOSSIBLE");
			}
		}
		
		sc.close();
	}

}