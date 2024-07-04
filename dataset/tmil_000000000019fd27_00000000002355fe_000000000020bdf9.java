import java.io.CharArrayReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nt = sc.nextInt();

        tcLoop:
        for (int tc = 1; tc <= nt; tc++) {
            int n = sc.nextInt();
            int[][] activities = new int[n][];
            for (int i = 0; i < n; i++) {
                activities[i] = new int[] {sc.nextInt(), sc.nextInt()};
            }
            HashSet<Integer>[] edges = new HashSet[n];

            for (int i = 0; i < n; i++) {
                edges[i] = new HashSet<>();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (activities[j][0] > activities[i][0] && activities[j][0] < activities[i][1]) {
                        edges[i].add(j);
                        edges[j].add(i);
                    }
                }
            }
            char[] position = new char[n];
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    position[i] = 'C';
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i);
                    while (!q.isEmpty()) {
                        int curr = q.poll();
                        if (visited[curr]) continue;
                        visited[curr] = true;
                        for (Integer neighbor: edges[curr]) {
                            if (position[neighbor] == position[curr]) {
                                System.out.println("IMPOSSIBLE");
                                continue tcLoop;
                            }
                            position[neighbor] = position[curr] == 'C' ? 'J' : 'C';
                            q.offer(neighbor);
                        }
                    }
                }
            }
            System.out.println(new String(position));
        }
    }
}
