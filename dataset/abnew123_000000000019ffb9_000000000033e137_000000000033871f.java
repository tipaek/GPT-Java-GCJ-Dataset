import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int c = in.nextInt();
			int d = in.nextInt();
			int[] tot_times = new int[c];
			tot_times[0] = 0;
			int[] prev = new int[c];
			int[][] connects = new int[d][2];
			Map<Integer, List<Integer>> connections = new HashMap<>();
			Map<Integer, Integer> latencies = new HashMap<>();
			int[] earlier = new int[c];
			earlier[0] = 0;
			for(int j = 0; j < c; j++) {
				List<Integer> tmp = new ArrayList<>();
				connections.put(j, tmp);
			}
			for (int j = 1; j < earlier.length; j++) {
				earlier[j] = in.nextInt();
			}
			for (int j = 0; j < d; j++) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				connects[j][0] = u;
				connects[j][1] = v;
				connections.get(u).add(v);
				connections.get(v).add(u);
			}
			for(int j = 0; j < prev.length; j++) {
				if(j == 0) {
					prev[j] = -1;
				}
				int max = -1000;
				for(int connection: connections.get(j)) {
					if(earlier[connection] > max) {
						prev[j] = connection;
						max = earlier[connection];
					}
				}
			}
			int time_max = 0;
			for(int j = -1; j >= (-1 * c); j--) {
				boolean flag = false;
				for(int k = 1; k < earlier.length; k++) {
					if(earlier[k] == j) {
						if(!flag) {
							time_max++;
							flag = true;
						}
						latencies.put(1000 * k + prev[k], time_max - tot_times[prev[k]]);
						latencies.put(1000 * prev[k] + k, time_max - tot_times[prev[k]]);
						tot_times[k] = time_max;
					}
				}
			}
			String ans = "";
			for(int[] connect: connects) {
				if(latencies.get(1000 * connect[0] + connect[1]) != null) {
					ans += (latencies.get(1000 * connect[0] + connect[1]) + " ");
				}
				else {
					ans += (1000000 + " ");
				}
			}
			System.out.println("Case #" + i + ": " + ans);
		}
	}
}