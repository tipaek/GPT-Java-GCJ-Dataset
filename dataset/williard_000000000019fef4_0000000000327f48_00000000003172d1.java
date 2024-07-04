import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		int numcases = Integer.parseInt(br.readLine());
		for (int casenum = 1; casenum <= numcases; casenum++) {
			int N, D;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ArrayList<Long> list = new ArrayList<Long>();
			for (int i = 0; i < N; i++)
				list.add(Long.parseLong(st.nextToken()));
			Collections.sort(list);
			TreeMap<Long, Integer> tm = new TreeMap<Long, Integer>();
			boolean exists[] = new boolean[5];
			ArrayList<Long> count_two = new ArrayList<Long>();
			for (long l : list) {
				if (!tm.containsKey(l))
					tm.put(l, 0);
				int tempcount = tm.get(l)+1;
				tm.put(l, tempcount);
				if (tempcount < 4)
					exists[tempcount] = true;
				if (tempcount == 2)
					count_two.add(l);
			}
			if (D == 2) {
				if (exists[2])
					System.out.printf("Case #%d: %d\n", casenum, 0);
				else
					System.out.printf("Case #%d: %d\n", casenum, 1);
			}
			else if (D == 3) {
				if (exists[3])
					System.out.printf("Case #%d: %d\n", casenum, 0);
				else if (exists[2]) {
					boolean greater = false;
					for (long l : count_two) {
						if (tm.higherKey(l) != null)
							greater = true;
					}
					if (greater)
						System.out.printf("Case #%d: %d\n", casenum, 1);
					else {
						if (N >= 3) {
							boolean twice = false;
							for (long l : list)
								if (tm.containsKey(l*2))
									twice = true;
							if (twice)
								System.out.printf("Case #%d: %d\n", casenum, 1);
							else
								System.out.printf("Case #%d: %d\n", casenum, 2);
						}
						else if (N == 2) {
							if (list.get(0)*2 == list.get(1))
								System.out.printf("Case #%d: %d\n", casenum, 1);
							else
								System.out.printf("Case #%d: %d\n", casenum, 2);
						}
						else {
							System.out.printf("Case #%d: %d\n", casenum, 2);
						}
					}
				}
				else {
					if (N >= 3) {
						boolean twice = false;
						for (long l : list)
							if (tm.containsKey(l*2))
								twice = true;
						if (twice)
							System.out.printf("Case #%d: %d\n", casenum, 1);
						else
							System.out.printf("Case #%d: %d\n", casenum, 2);
					}
					else if (N == 2) {
						if (list.get(0)*2 == list.get(1))
							System.out.printf("Case #%d: %d\n", casenum, 1);
						else
							System.out.printf("Case #%d: %d\n", casenum, 2);
					}
					else {
						System.out.printf("Case #%d: %d\n", casenum, 2);
					}
				}
			}
		}
		System.out.print(out);
	}
}