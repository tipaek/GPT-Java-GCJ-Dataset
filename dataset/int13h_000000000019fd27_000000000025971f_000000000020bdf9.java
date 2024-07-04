import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		for (int i2 = 1; i2 <= t; i2++) {
			int n = sc.nextInt();
			int starts [] = new int [n];
			int ends [] = new int [n];
			for (int i = 0; i < n; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				starts[i] = s;
				ends[i] = e;
			}
			System.out.println("Case #" + i2 + ": " + solution(starts, ends));
		}

		sc.close();
	}

	private static String solution(final int[] starts, final int[] ends) {
		//System.out.println(Arrays.toString(starts));
		//System.out.println(Arrays.toString(ends));
		
		
		Integer[] idx = sortIndexes(starts);
		
		//System.out.println(Arrays.toString(idx));
		int n = starts.length;
		boolean jobs [] = new boolean[n];
		
		int last1 = -1;
		int last2 = -1;
		for (int i = 0; i < idx.length; i++) {
			int index = idx[i];
			boolean c1 = canDo(starts, ends, last1, index);
			boolean c2 = canDo(starts, ends, last2, index);
			
			//System.out.println(index + " " + starts[index] + " " + ends[index] + " " + c1 + " " + c2);
			if (c1) {
				last1 = index;
				jobs[index] = true;
			} else if (c2) {
				last2 = index;
			} else {
				return "IMPOSSIBLE";
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < jobs.length; i++) {
			if (jobs[i]) {
				sb.append("C");
			} else {
				sb.append("J");
			}
		}
		return sb.toString();
	}

	private static boolean canDo(final int[] starts, final int[] ends, int last1, int index) {
		int s1 = starts[index];
		int e1 = ends[index];
		
		boolean c = false;
		if (last1 != -1) {
			int s2 = starts[last1];
			int e2 = ends[last1];
			c = conflict(s2, e2, s1, e1);
		}
		return !c;
	}

	private static boolean conflict(int s1, int e1, int s2, int e2) {
		//System.out.println(s1 + " " + e1 + " " + s2 + " " + e2 );
		return (s2 < e1);
	}

	private static Integer[] sortIndexes(final int[] starts) {
		int n = starts.length;
		
		Integer[] idx = new Integer [n];
		for (int i = 0; i < n; i++) {
			idx[i] = i;
		}

		Arrays.sort(idx, new Comparator<Integer>() {
		    @Override public int compare(final Integer o1, final Integer o2) {
		        return Integer.compare(starts[o1], starts[o2]);
		    }
		});
		return idx;
	}





}
