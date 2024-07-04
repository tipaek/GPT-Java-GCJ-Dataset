import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class pt implements Comparable {
		int tm, index;
		boolean is_start;
		public pt(int tm, int index, boolean is_start) {
			this.tm = tm;
			this.index = index;
			this.is_start = is_start;
		}
		
		public int compareTo(Object o) {
			pt other = (pt) o;
			if (tm < other.tm) {
				return -1;
			} else if (tm > other.tm) {
				return 1;
			} else {
				if (!is_start) return -1;
				else return 1;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int x = 1; x <= T; x++) {
			int N = sc.nextInt();
			List<pt> activities = new ArrayList<pt>();
			for (int i = 0; i < N; i++) {
				int s = sc.nextInt(), e = sc.nextInt();
				activities.add(new pt(s, i, true));
				activities.add(new pt(e, i, false));
			}
			Collections.sort(activities);
			char[] assigned = new char[N];
			boolean cameron = false;
			boolean jamie = false;
			boolean possible = true;
			for (pt p : activities) {
	            if (p.is_start) {
	                if (!cameron) {
	                    assigned[p.index] = 'C';
	                    cameron = true;
	                } else if (!jamie) {
	                    assigned[p.index] = 'J';
	                    jamie = true;
	                } else {
	                    possible = false;
	                    break;
	                }
	            } else {
	                if (assigned[p.index] == 'C') {
	                    cameron = false;
	                } else {
	                    jamie = false;
	                }
	            }
	        }
			System.out.print("Case #" + x + ": ");
			if (!possible) {
				System.out.println("IMPOSSIBLE");
			} else {
				for (int i = 0; i < N; i++) {
					System.out.print(assigned[i]);
				}
				System.out.println();
			}
		}
		
	}

}
