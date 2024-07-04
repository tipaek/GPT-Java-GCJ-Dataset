import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int c = in.nextInt();
            int d = in.nextInt();
            int[] totTimes = new int[c];
            int[] prev = new int[c];
            int[][] connects = new int[d][2];
            Map<Integer, List<Integer>> connections = new HashMap<>();
            Map<Integer, Integer> latencies = new HashMap<>();
            int[] earlier = new int[c];
            Arrays.fill(earlier, 0);
            
            for (int j = 0; j < c; j++) {
                connections.put(j, new ArrayList<>());
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
            for (int j = 0; j < prev.length; j++) {
                prev[j] = -1;
                int maxTime = Integer.MIN_VALUE;
                for (int connection : connections.get(j)) {
                    if (earlier[connection] > maxTime) {
                        prev[j] = connection;
                        maxTime = earlier[connection];
                    }
                }
            }
            int timeMax = 0;
            for (int j = -1; j >= -c; j--) {
                boolean incremented = false;
                for (int k = 1; k < earlier.length; k++) {
                    if (earlier[k] == j) {
                        if (!incremented) {
                            timeMax++;
                            incremented = true;
                        }
                        int latencyKey1 = 1000 * k + prev[k];
                        int latencyKey2 = 1000 * prev[k] + k;
                        latencies.put(latencyKey1, timeMax - totTimes[prev[k]]);
                        latencies.put(latencyKey2, timeMax - totTimes[prev[k]]);
                        totTimes[k] = timeMax;
                    }
                }
            }
            StringBuilder ans = new StringBuilder();
            for (int[] connect : connects) {
                Integer latency = latencies.get(1000 * connect[0] + connect[1]);
                if (latency != null) {
                    ans.append(latency).append(" ");
                } else {
                    ans.append(1000000).append(" ");
                }
            }
            System.out.println("Case #" + i + ": " + ans.toString().trim());
        }
    }
}