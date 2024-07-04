import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlapsWith(Interval other) {
            return !(end <= other.start || other.end <= start);
        }
    }

    static void assignColors(ArrayList<Integer>[] graph, int[] colors, int node, int color) {
        if (colors[node] == 2) {
            return; // already invalid
        } else if (colors[node] == -1) { // not visited
            colors[node] = color;
            for (int neighbor : graph[node]) {
                assignColors(graph, colors, neighbor, 1 - color);
            }
        } else if (colors[node] != color) { // already visited but color is not consistent
            colors[node] = 2;
        }
    }

    static String solve(Scanner scanner) {
        int numIntervals = scanner.nextInt();
        Interval[] intervals = new Interval[numIntervals];
        
        for (int i = 0; i < numIntervals; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals[i] = new Interval(start, end);
        }
        
        ArrayList<Integer>[] graph = new ArrayList[numIntervals];
        for (int i = 0; i < numIntervals; i++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j < numIntervals; j++) {
                if (i != j && intervals[i].overlapsWith(intervals[j])) {
                    graph[i].add(j);
                }
            }
        }
        
        int[] colors = new int[numIntervals];
        Arrays.fill(colors, -1); // -1: not yet visited, 0: C, 1: J, 2: invalid

        for (int i = 0; i < numIntervals; i++) {
            if (colors[i] == -1) {
                assignColors(graph, colors, i, 0);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int color : colors) {
            if (color == 0) {
                result.append('C');
            } else if (color == 1) {
                result.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String answer = solve(scanner);
            System.out.println("Case #" + t + ": " + answer);
        }
    }
}