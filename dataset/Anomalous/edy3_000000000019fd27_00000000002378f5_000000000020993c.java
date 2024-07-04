import java.util.*;

public class Solution {

    private static String solve(List<List<Integer>> matrix) {
        int n = matrix.size();
        int trace = 0, repeatRowCount = 0;
        Set<Integer> repeatedCols = new HashSet<>();
        Map<Integer, Set<Integer>> columnToNumbers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            columnToNumbers.put(i, new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            List<Integer> row = matrix.get(i);
            Set<Integer> rowValues = new HashSet<>();
            boolean rowHasDuplicate = false;

            for (int j = 0; j < n; j++) {
                int value = row.get(j);

                if (i == j) {
                    trace += value;
                }

                if (!rowValues.add(value)) {
                    rowHasDuplicate = true;
                }

                if (!columnToNumbers.get(j).add(value)) {
                    repeatedCols.add(j);
                }
            }

            if (rowHasDuplicate) {
                repeatRowCount++;
            }
        }

        return String.format("%d %d %d", trace, repeatRowCount, repeatedCols.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            List<List<Integer>> matrix = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                List<Integer> row = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    row.add(scanner.nextInt());
                }
                matrix.add(row);
            }

            System.out.println(String.format("Case #%d: %s", i + 1, solve(matrix)));
        }

        scanner.close();
    }
}