import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		
		for (int test = 1; test <= tests; test++) {
			int num = s.nextInt();
			
			List<Integer[]> intervals = new ArrayList<Integer[]>();
			for (int i = 0; i < num; i++) {
				intervals.add(new Integer[] {s.nextInt(), s.nextInt(), i, 0});
			}
			
			Collections.sort(intervals, new Comparator<Integer[]>() {

				@Override
				public int compare(Integer[] arg0, Integer[] arg1) {
					return arg0[0]-arg1[0];
				}
				
			});
			
			int j = 0;
			int c = 0;
			
			boolean imp = false;
			for (Integer[] interval : intervals) {
				if (j <= interval[0]) {
					j = interval[1];
				} else if (c <= interval[0]){
					c = interval[1];
					interval[3] = 1;
				} else {
					imp = true;
				}
			}
			
			Collections.sort(intervals, new Comparator<Integer[]>() {

				@Override
				public int compare(Integer[] arg0, Integer[] arg1) {
					return arg0[2]-arg1[2];
				}
				
			});
			
			System.out.print("Case #" + test + ": ");
			if (imp) {
				System.out.print("IMPOSSIBLE");
			} else {
				for (Integer[] interval : intervals) {
					if (interval[3] == 0)
						System.out.print("J");
					else
						System.out.print("C");
				}
			}
			
			System.out.println();
		}

	}
}