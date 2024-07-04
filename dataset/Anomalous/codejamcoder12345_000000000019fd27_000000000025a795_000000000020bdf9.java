import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            char[] assignments = new char[n];
            TreeMap<Integer, List<Integer>> events = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                events.computeIfAbsent(intervals[i][0], k -> new ArrayList<>()).add(i);
                events.computeIfAbsent(intervals[i][1], k -> new ArrayList<>()).add(~i);
            }

            int cameronEnd = 0, jamieEnd = 0;
            boolean possible = true;

            for (Map.Entry<Integer, List<Integer>> event : events.entrySet()) {
                for (int index : event.getValue()) {
                    if (index >= 0) {
                        if (event.getKey() >= cameronEnd) {
                            assignments[index] = 'C';
                            cameronEnd = intervals[index][1];
                        } else if (event.getKey() >= jamieEnd) {
                            assignments[index] = 'J';
                            jamieEnd = intervals[index][1];
                        } else {
                            possible = false;
                            break;
                        }
                    }
                }
                if (!possible) break;
            }

            System.out.print("Case #" + caseNum + ": ");
            if (possible) {
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}