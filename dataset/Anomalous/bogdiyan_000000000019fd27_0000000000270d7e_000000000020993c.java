import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            Map<Integer, Set<Integer>> columnSets = new HashMap<>();
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    rowSet.add(value);

                    if (i == j) {
                        trace += value;
                    }

                    columnSets.computeIfAbsent(j, k -> new HashSet<>()).add(value);
                }

                if (rowSet.size() < n) {
                    repeatedRows++;
                }
            }

            for (Set<Integer> colSet : columnSets.values()) {
                if (colSet.size() < n) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
        scanner.close();
    }
}