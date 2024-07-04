import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] parts = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(parts[0]);
                intervals[i][1] = Integer.parseInt(parts[1]);
            }
            System.out.println("Case #" + caseNum + ": " + assignTasks(intervals));
        }
    }

    private static String assignTasks(int[][] intervals) {
        List<int[]> overlapIntervals = new ArrayList<>();
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Map<Integer, String> assignments = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int[] overlap : overlapIntervals) {
                if (start < overlap[1] && end > overlap[0]) {
                    return "IMPOSSIBLE";
                }
            }
            for (int j = 0; j < i; j++) {
                if (start < intervals[j][1] && end > intervals[j][0]) {
                    overlapIntervals.add(new int[]{Math.max(start, intervals[j][0]), Math.min(end, intervals[j][1])});
                    adjacencyList.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    adjacencyList.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }

        for (int i = 0; i < intervals.length; i++) {
            if (!assignments.containsKey(i)) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                assignments.put(i, "C");
                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    for (Integer neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                        if (!assignments.containsKey(neighbor)) {
                            assignments.put(neighbor, assignments.get(current).equals("C") ? "J" : "C");
                            queue.offer(neighbor);
                        } else if (assignments.get(neighbor).equals(assignments.get(current))) {
                            return "IMPOSSIBLE";
                        }
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String value : assignments.values()) {
            result.append(value);
        }
        return result.toString();
    }
}