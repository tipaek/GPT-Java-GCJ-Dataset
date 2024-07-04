
import java.util.*;

public class Solution {
    private static String getSol(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] intervals = new int[n][2];
        int[] counts = new int[24 * 60];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            for (int time = intervals[i][0]; time < intervals[i][1]; time++) {
                counts[time] += 1;
                if (counts[time] > 2) {
                    return "IMPOSSIBLE";
                }
            }
            if ( i < n - 1) {
                scanner.nextLine();
            }
        }
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (intersect(intervals[i], intervals[j])) {
                    neighbors.get(i).add(j);
                    neighbors.get(j).add(i);
                }
            }
        }
        char[] assignments = new char[n];
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            dfsVisit(i, visited, false, neighbors, assignments);
        }
        return new String(assignments);
    }

    private static void dfsVisit(int node, Set<Integer> visited, boolean toggle, List<List<Integer>> neighbors, char[] assignments) {
        if (toggle) {
            assignments[node] = 'J';
        } else {
            assignments[node] = 'C';
        }
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (int neighbor : neighbors.get(node)) {
            if (visited.contains(neighbor)) {
                continue;
            }
            dfsVisit(neighbor, visited, !toggle, neighbors, assignments);
        }
    }

    private static boolean intersect(int[] interval1, int[] interval2) {
        if (interval1[1] <= interval2[0]) {
            return false;
        }
        if (interval2[1] <= interval1[0]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int c = 1; c <= t; c++) {
            System.out.println("Case #" + c + ": " + getSol(scanner));
            if (c < t) {
                scanner.nextLine();
            }
        }
    }
}
