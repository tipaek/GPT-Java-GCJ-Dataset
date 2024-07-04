import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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
			boolean check = false;
			int assignAct[] = null;
			int C = 0, J = 1;
			char output[] = null;
			List<Interval> l = null;
			for (int k = 0; k < T; k++) {
				check = false;
				assignAct = new int[2];
				
				int N = sc.nextInt();
				output = new char[N];
				
				l = new ArrayList<Interval>();
				for (int i = 0; i < N; i++) {
					int start = sc.nextInt();
					int end =  sc.nextInt();
					if(start < 0 || end > 1440 || end <= start) {
						check = true;
					}
					l.add(new Interval(start, end, i));
				}

				if(N<2 || check) {
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
					
					if(assignAct[C] == 0 || assignAct[C] <= o.start) {
						assignAct[C] = o.end;
						output[o.number] = 'C';
						continue;
					}
					
					if(assignAct[J] == 0 || assignAct[J] <= o.start) {
						assignAct[J] = o.end;
						output[o.number] = 'J';
						continue;
					}
					
					check = true;
					break;
				}

				if(!check) {
					System.out.println("Case #" + (k + 1) + ": "+new String(output));
				}
				else {
					System.out.println("Case #" + (k + 1) + ": IMPOSSIBLE");
				}
			}
			
			sc.close();
		}

	}