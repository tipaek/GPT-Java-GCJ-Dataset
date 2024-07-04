import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static Map<Integer, List<Integer>> graph;
    static Map<Integer, Integer> colour;
    static int[][] times;

    public static boolean timeOverlap(int start1, int end1, int start2, int end2) {
        return (end1 > start2 && end1 < end2) || (end2 > start1 && end2 < end1);
    }

    public static boolean bfs(int size) {
        colour = new HashMap<>();
        boolean[] unsettled = new boolean[size];
        int ptr = 0;

        while (ptr < size) {
            if (!unsettled[ptr]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(ptr);
                colour.put(ptr, 0);
                while (!queue.isEmpty()) {
                    int next = queue.poll();
                    int vertexColour = colour.get(next);

                    for (Integer neighbor : graph.get(next)) {
                        unsettled[neighbor] = true;

                        if (colour.get(neighbor) == null) {
                            queue.add(neighbor);
                            colour.put(neighbor, (vertexColour + 1) % 2);
                            continue;
                        }

                        if (colour.get(neighbor) == vertexColour) {
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
            int numActivities = scan.nextInt();
            times = new int[numActivities][2];

            graph = new HashMap<>();
            colour = new HashMap<>();

            for (int i = 0; i < numActivities; i++) {
                times[i][0] = scan.nextInt();
                times[i][1] = scan.nextInt();

                graph.put(i, new LinkedList<>());
                colour.put(i, 0);

                for (int j = 0; j < i; j++) {
                    if (timeOverlap(times[j][0], times[j][1], times[i][0], times[i][1])) {
                        graph.get(j).add(i);
                        graph.get(i).add(j);
                    }
                }
            }

            boolean isBipartite = bfs(numActivities);
            StringBuilder result = new StringBuilder();

            if (isBipartite) {
                for (int i = 0; i < numActivities; i++) {
                    result.append(colour.get(i) == 0 ? "C" : "J");
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s\n", caseNum, result.toString());
        }
    }
}