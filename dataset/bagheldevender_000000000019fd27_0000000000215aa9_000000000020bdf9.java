import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			sb.append("Case #" + (t + 1) + ": ");
			int[][] arr = new int[n][2];
			pair[] arr2 = new pair[n];
			int[] arv = new int[n];
			int[] dep = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i][0] = scn.nextInt();
				arr[i][1] = scn.nextInt();
				arv[i] = arr[i][0];
				dep[i] = arr[i][1];
				pair p = new pair(arr[i][0], arr[i][1], i);
				arr2[i] = p;

			}
			Arrays.sort(arr2);
			int v = minPlatforms(arv, dep);
			if(v>2){
				sb.append("IMPOSSIBLE");
			}
			else if (v == 1) {
				for (int i = 0; i < n; i++) {
					sb.append("C");
				}
			} else {
				int pre = arr2[0].end;
				int ass = 0;
				HashMap<Integer, Integer> map = new HashMap<>();
				map.put(arr2[0].ind, 0);
				for (int i = 0; i < arr2.length; i++) {
					int st = arr2[i].str;
					int end = arr2[i].end;
					if (st >= pre) {
						map.put(arr2[i].ind, ass);
					} else {
						map.put(arr2[i].ind, 1 - ass);
						ass = 1 - ass;
					}
					pre = end;
				}
				for (int i = 0; i < n; i++) {
					if (map.get(i) == 0) {
						sb.append("C");
					} else {
						sb.append("J");
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

	public static int minPlatforms(int[] arrival,int[] departure)
	{
		// maintains the count of trains
		int count = 0;
Arrays.sort(arrival);
Arrays.sort(departure);
		// stores minimum platforms needed
		int platforms = 0;

		// take two indices for arrival and departure time
		int i = 0, j = 0;

		// run till train is scheduled to arrive
		while (i < arrival.length)
		{
			// if train is scheduled to arrive next
			if (arrival[i] < departure[j])
			{
				// increase the count of trains and update minimum
				// platforms if required
				platforms = Integer.max(platforms, ++count);

				// move the pointer to next arrival
				i++;
			}

			// if train is scheduled to depart next i.e.
			// (departure[j] < arrival[i]), decrease the count of trains
			// and move pointer j to next departure

			// If two trains are arriving and departing at the same time,
			// i.e. (arrival[i] == departure[j]) depart the train first
			else {
				count--;
				j++;
			}
		}

		return platforms;
	}
	public static class pair implements Comparable<pair> {
		int str;
		int end;
		int ind;

		public pair(int strt, int end, int in) {
			this.str = strt;
			this.end = end;
			this.ind = in;
		}

		@Override
		public int compareTo(pair o) {
			if (this.str != o.str) {
				return this.str - o.str;
			} else {
				return this.end - o.end;
			}
		}

	}
}
