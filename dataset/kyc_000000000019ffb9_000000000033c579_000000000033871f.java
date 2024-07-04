import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int n = input.nextInt();
            int m = input.nextInt();

            int[] order = new int[n];
            for (int i = 1; i < n; i++)
                order[i] = -input.nextInt();

            Map<Integer, Set<Integer>> graph = new HashMap<>();
            List<Point> edges = new ArrayList<>();
            for (int i = 0; i < n; i++)
                graph.put(i, new HashSet<>());
            for (int i = 0; i < m; i++) {
                int a = input.nextInt() - 1;
                int b = input.nextInt() - 1;
                edges.add(new Point(a, b));
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            List<Point> sorted = new ArrayList<>();
            for (int i = 1; i < n; i++)
                sorted.add(new Point(i, order[i]));
            Collections.sort(sorted, Comparator.comparing(p -> p.y));

            int[] dists = new int[n];
            for (int i = 0; i < n; i++)
                dists[i] = Integer.MAX_VALUE / 3;
            dists[0] = 0;

            int[][] latencies = new int[n][n];
//            System.out.println(sorted);
            for (Point p : sorted) {
                // find edge to p
                int dist = p.y;
loop:
                for (int v : graph.keySet())
                    for (int w : graph.get(v))
                        if (w == p.x && dists[v] < dist) {
                            dists[w] = dist;
                            latencies[v][w] = latencies[w][v] = dist - dists[v];
                            break loop;
                        }
//                pr(latencies);
            }

            System.out.printf("Case #%d:", caseNum);
            for (int i = 0; i < m; i++) {
                int latency = latencies[edges.get(i).x][edges.get(i).y];
                System.out.printf(" %d", latency == 0 ? 999999 : latency);
            }
            System.out.println();
        }
    }
}
