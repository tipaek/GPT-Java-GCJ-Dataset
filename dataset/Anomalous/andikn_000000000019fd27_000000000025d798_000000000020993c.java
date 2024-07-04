import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            boolean[] colRepeatFlags = new boolean[n];
            Map<Integer, Set<Integer>> columnSets = new HashMap<>();

            for (int i = 0; i < n; i++) {
                columnSets.put(i, new HashSet<>());
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowRepeatFlag = false;

                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();

                    if (i == j) {
                        trace += value;
                    }

                    // Check for row repeats
                    if (!rowRepeatFlag && !rowSet.add(value)) {
                        rowRepeats++;
                        rowRepeatFlag = true;
                    }

                    // Check for column repeats
                    if (!colRepeatFlags[j] && !columnSets.get(j).add(value)) {
                        colRepeats++;
                        colRepeatFlags[j] = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}