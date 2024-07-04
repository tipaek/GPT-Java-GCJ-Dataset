import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static Map<Integer, List<Integer>> graph;
    private static Map<Integer, Integer> color; // 0 for none, 1 for C, 2 for J
    private static int[][] times;

    private static boolean timeOverlap(int start1, int end1, int start2, int end2) {
        return (end1 > start2 && end1 < end2) || (end2 > start1 && end2 < end1)
                || (start1 > start2 && start1 < end2) || (start2 > start1 && start2 < end1);
    }

    private static boolean bfs(int size) {
        color = new HashMap<>();
        boolean[] unsettled = new boolean[size];
        int ptr = 0;

        while (ptr < size) {
            if (!unsettled[ptr]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(ptr);
                color.put(ptr, 0);
                while (!queue.isEmpty()) {
                    int next = queue.poll();
                    int vertexColor = color.get(next);

                    for (Integer neighbor : graph.get(next)) {
                        unsettled[neighbor] = true;

                        if (!color.containsKey(neighbor)) {
                            queue.add(neighbor);
                            color.put(neighbor, (vertexColor + 1) % 2);
                        } else if (color.get(neighbor) == vertexColor) {
                            return false;
                        }
                    }
                }
            }
            ptr++;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scan.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int activities = scan.nextInt();
            times = new int[activities][2];
            graph = new HashMap<>();

            for (int i = 0; i < activities; i++) {
                times[i][0] = scan.nextInt();
                times[i][1] = scan.nextInt();
                graph.put(i, new LinkedList<>());

                for (int j = 0; j < i; j++) {
                    if (timeOverlap(times[j][0], times[j][1], times[i][0], times[i][1])) {
                        graph.get(j).add(i);
                        graph.get(i).add(j);
                    }
                }
            }

            boolean canBeColored = bfs(activities);
            StringBuilder result = new StringBuilder();

            if (canBeColored) {
                for (int i = 0; i < activities; i++) {
                    result.append(color.get(i) == 0 ? "C" : "J");
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s\n", caseNum, result.toString());
        }

        scan.close();
    }
}