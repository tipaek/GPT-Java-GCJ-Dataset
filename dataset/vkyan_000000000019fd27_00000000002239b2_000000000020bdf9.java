import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int numCases = Integer.parseInt(in.nextLine());
		
		for (int i = 1; i <= numCases; i++) {
			int n = in.nextInt();
			int[][] ranges = new int[n][3];
			
			for (int j = 0; j < n; j++) {
				ranges[j][0] = in.nextInt();
				ranges[j][1] = in.nextInt();
				ranges[j][2] = 0; // cache who took task
			}
			
			System.out.printf("Case #%d: %s", i, scheduleParents(ranges, n));
			if (i != numCases) System.out.print("\n");
		}
		
		in.close();
	}
	
	private static String scheduleParents(int[][] slots, int n) {
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) return a[1]-b[1];
				return a[0]-b[0];
			}
		});
		
		// nlogn
		for (int[] slot: slots) {
			heap.add(slot);
		}

		int lastC = 0;
		int lastJ = 0;
		
		while (!heap.isEmpty()) {
			int[] slot = heap.poll();
			
			if (lastC <= slot[0]) {
				lastC = slot[1];
				slot[2] = 1;
			} else if (lastJ <= slot[0]) {
				lastJ = slot[1];
				slot[2] = 2;
			} else {
				return "IMPOSSIBLE";
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int[] slot: slots) {
			if (slot[2] == 1) { sb.append('C'); }
			else { sb.append('J'); }
		}
		return sb.toString();
	}
}
