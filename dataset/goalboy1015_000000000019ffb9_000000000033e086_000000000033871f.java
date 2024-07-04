import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            int C = sc.nextInt();
            int D = sc.nextInt();
            int[] X = new int[C];
            for (int i = 1; i < X.length; ++i) {
                X[i] = sc.nextInt();
            }
            int[] U = new int[D];
            int[] V = new int[D];
            for (int i = 0; i < D; ++i) {
                U[i] = sc.nextInt() - 1;
                V[i] = sc.nextInt() - 1;
            }

            System.out.println(String.format("Case #%d: %s", tc, solve(X, U, V)));
        }

        sc.close();
    }

    static String solve(int[] X, int[] U, int[] V) {
        int C = X.length;
        int D = U.length;

        List<Integer>[] edgeLists = new List[C];
        for (int i = 0; i < edgeLists.length; ++i) {
            edgeLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < U.length; ++i) {
            edgeLists[U[i]].add(i);
            edgeLists[V[i]].add(i);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((node1, node2) -> Integer.compare(X[node1], X[node2]));

        List<Integer>[] nodeLists = new List[C];
        for (int i = 0; i < nodeLists.length; ++i) {
            nodeLists[i] = new ArrayList<>();
        }

        for (int i = 1; i < X.length; ++i) {
            if (X[i] > 0) {
                pq.offer(i);
            } else {
                nodeLists[-X[i]].add(i);
            }
        }

        int[] distances = new int[C];
        Arrays.fill(distances, -1);
        distances[0] = 0;

        int[] result = new int[D];
        int nextDistance = 0;
        int prevCount = 1;
        for (int i = 1; i < nodeLists.length; ++i) {
            if (nodeLists[i].isEmpty()) {
                continue;
            }

            while (prevCount < i) {
                int head = pq.poll();

                distances[head] = X[head];

                for (int edge : edgeLists[head]) {
                    int other = (U[edge] == head) ? V[edge] : U[edge];

                    if (distances[other] != -1) {
                        result[edge] = Math.max(1, distances[head] - distances[other]);
                    }
                }

                nextDistance = distances[head];
                ++prevCount;
            }

            ++nextDistance;

            for (int node : nodeLists[i]) {
                distances[node] = nextDistance;

                for (int edge : edgeLists[node]) {
                    int other = (U[edge] == node) ? V[edge] : U[edge];

                    if (distances[other] != -1) {
                        result[edge] = Math.max(1, distances[node] - distances[other]);
                    }
                }

                ++prevCount;
            }
        }

        while (!pq.isEmpty()) {
            int head = pq.poll();

            distances[head] = X[head];

            for (int edge : edgeLists[head]) {
                int other = (U[edge] == head) ? V[edge] : U[edge];

                if (distances[other] != -1) {
                    result[edge] = Math.max(1, distances[head] - distances[other]);
                }
            }
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}