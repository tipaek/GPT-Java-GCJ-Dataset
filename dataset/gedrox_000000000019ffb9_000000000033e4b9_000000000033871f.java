import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int C = sc.nextInt();
            int D = sc.nextInt();
            int[] order = new int[C - 1];
            ArrayList<Integer>[] byOrder = new ArrayList[C];
            for (int i1 = 0; i1 < C; i1++) {
                byOrder[i1] = new ArrayList<>();
            }
            TreeMap<Integer, ArrayList<Integer>> byLatency = new TreeMap<>();
            int[] latencyRequirement = new int[C];


            for (int i1 = 0; i1 < C - 1; i1++) {
                int ord = sc.nextInt();
                if (ord < 0) {
                    order[i1] = -ord;
                    byOrder[order[i1]].add(i1 + 1);
                } else {
                    if (!byLatency.containsKey(ord)) {
                        byLatency.put(ord, new ArrayList<>());
                    }
                    byLatency.get(ord).add(i1 + 1);
                    latencyRequirement[i1 + 1] = ord;
                }
            }

            int pos = 0;
            Iterator<ArrayList<Integer>> byLatencyIterator = byLatency.values().iterator();
            for (int i2 = 1; i2 < byOrder.length; i2++) {
                if (!byLatencyIterator.hasNext()) {
                    break;
                }
                if (byOrder[i2].isEmpty() && i2 > pos) {
                    byOrder[i2].addAll(byLatencyIterator.next());
                }
                pos += byOrder[i2].size();
            }

            int[][] grid = new int[C][];
            int[] latency = new int[D];
            int[] got = new int[C];
            ArrayList<Integer>[] grid_opt = new ArrayList[C];
            for (int i1 = 1; i1 < C; i1++) {
                got[i1] = -1;
            }

            for (int i1 = 0; i1 < C; i1++) {
                grid[i1] = new int[C];
                grid_opt[i1] = new ArrayList<>();
            }

            for (int i1 = 0; i1 < D; i1++) {
                int c1 = sc.nextInt() - 1;
                int c2 = sc.nextInt() - 1;
                grid[c1][c2] = i1;
                grid[c2][c1] = i1;
                grid_opt[c1].add(c2);
                grid_opt[c2].add(c1);
            }

            int nextGot = 0;

            for (ArrayList<Integer> ns : byOrder) {
                if (ns.isEmpty()) {
                    continue;
                }

                nextGot++;

                for (Integer n : ns) {
                    if (latencyRequirement[n] > 0) {
                        // assert nextGot <= latencyRequirement[n];
                        nextGot = latencyRequirement[n];
                    }
                }

                for (Integer n : ns) {
                    for (Integer near : grid_opt[n]) {
                        if (got[near] >= 0) {
                            int edge_id = grid[n][near];
                            latency[edge_id] = Math.max(1, nextGot - got[near]);
                        }
                    }
                }

                for (Integer n : ns) {
                    got[n] = nextGot;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i1 : latency) {
                sb.append(Math.max(1, i1)).append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);

            System.out.printf("Case #%d: %s%n", i + 1, sb.toString());
        }
    }


}
