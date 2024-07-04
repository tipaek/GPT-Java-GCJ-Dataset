import java.util.*;

public class Solution {
    
    private static int n;
    private static int[][] connected;
    private static int e;
    private static int[] res;
    private static int[] data;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            n = scanner.nextInt();
            e = scanner.nextInt();
            data = new int[n];
            for (int i = 1; i < n; i++) {
                data[i] = scanner.nextInt();
            }

            connected = new int[n][n];
            for (int[] row : connected) {
                Arrays.fill(row, -1);
            }

            res = new int[e];
            Arrays.fill(res, 500000);

            for (int i = 0; i < e; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                connected[u][v] = i;
                connected[v][u] = i;
            }

            List<Integer>[] order = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                order[i] = new ArrayList<>();
            }
            order[0].add(0);
            for (int i = 1; i < n; i++) {
                order[-data[i]].add(i);
            }

            int[] dist = new int[n];
            Arrays.fill(dist, 1000000000);
            dist[0] = 0;
            int prevDistance = 0;
            boolean[] visited = new boolean[n];
            visited[0] = true;

            List<Integer> previousNodes = new ArrayList<>();
            previousNodes.add(0);

            for (int i = 1; i < n; i++) {
                List<Integer> currentNodes = order[i];
                for (Integer currentNode : currentNodes) {
                    for (Integer previousNode : previousNodes) {
                        if (connected[previousNode][currentNode] != -1) {
                            int additionalDistance = prevDistance + (i + 1) - dist[previousNode];
                            res[connected[previousNode][currentNode]] = additionalDistance;
                            dist[currentNode] = prevDistance + (i + 1);
                            break;
                        }
                    }
                }
                previousNodes.addAll(currentNodes);
                prevDistance += (i + 1);
            }

            System.out.print("Case #" + testCase + ":");
            for (int i = 0; i < e; i++) {
                System.out.print(" " + res[i]);
            }
            System.out.println();
        }
    }
}