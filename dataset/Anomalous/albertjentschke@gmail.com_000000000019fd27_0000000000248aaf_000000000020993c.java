import java.util.*;

public class Solution {
    public void vestigium() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        List<String> outputs = new ArrayList<>();
        for (int k = 0; k < T; k++) {
            int N = scanner.nextInt(); // Size of matrix
            List<Set<Integer>> rows = new ArrayList<>();
            boolean[] corruptedColumns = new boolean[N];
            int diagonalSum = 0;
            int corruptedRows = 0;
            int corruptedColumnsCount = 0;

            for (int i = 0; i < N; i++) {
                Set<Integer> currentRow = new HashSet<>();
                boolean rowCorrupted = false;
                for (int j = 0; j < N; j++) {
                    if (i == 0) {
                        rows.add(new HashSet<>());
                    }
                    int value = scanner.nextInt(); // Read entry

                    if (i == j) {
                        diagonalSum += value; // Count diagonal
                    }

                    if (currentRow.contains(value) && !rowCorrupted) {
                        rowCorrupted = true;
                        corruptedRows++;
                    }
                    currentRow.add(value); // Row operations

                    if (!corruptedColumns[j] && rows.get(j).contains(value)) {
                        corruptedColumns[j] = true;
                        corruptedColumnsCount++;
                    }
                    rows.get(j).add(value); // Column operations
                }
            }
            outputs.add("Case #" + (k + 1) + ": " + diagonalSum + " " + corruptedRows + " " + corruptedColumnsCount);
        }

        for (String output : outputs) {
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        new Solution().vestigium();
    }
}