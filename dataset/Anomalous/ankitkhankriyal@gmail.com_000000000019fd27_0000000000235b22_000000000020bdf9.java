import java.util.*;

class Pair {
    int start, end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public static String getSolution(int[] assignments, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(assignments[i] == -1 ? "C" : "J");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            Pair[] intervals = new Pair[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Pair(start, end);
            }

            int[] assignments = new int[n];
            assignments[0] = 1;
            int minStart = intervals[0].start;
            int maxEnd = intervals[0].end;

            for (int i = 1; i < n; i++) {
                Pair current = intervals[i];
                if (current.end <= minStart || current.start >= maxEnd) {
                    assignments[i] = 1;
                }
            }

            int unassignedIndex = -1;
            for (int i = 0; i < n; i++) {
                if (assignments[i] == 0) {
                    unassignedIndex = i;
                    assignments[unassignedIndex] = -1;
                    break;
                }
            }

            if (unassignedIndex == -1) {
                System.out.println(getSolution(assignments, n));
                continue;
            } else {
                minStart = intervals[unassignedIndex].start;
                maxEnd = intervals[unassignedIndex].end;
                for (int i = unassignedIndex + 1; i < n; i++) {
                    Pair current = intervals[i];
                    if (assignments[i] == 0 && (current.end <= minStart || current.start >= maxEnd)) {
                        assignments[i] = -1;
                    }
                }
            }

            boolean allAssigned = true;
            for (int i = 0; i < n; i++) {
                if (assignments[i] == 0) {
                    allAssigned = false;
                    break;
                }
            }

            if (allAssigned) {
                System.out.println(getSolution(assignments, n));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}