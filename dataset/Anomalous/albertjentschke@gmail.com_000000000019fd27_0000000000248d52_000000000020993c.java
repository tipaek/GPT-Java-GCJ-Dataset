import java.util.*;

public class Solution {
    public void vestigium() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        List<String> outputs = new ArrayList<>();

        for (int k = 0; k < T; k++) {
            int N = scanner.nextInt(); // Size of matrix
            Set<Integer>[] rowSets = new HashSet[N];
            Set<Integer>[] colSets = new HashSet[N];
            boolean[] corruptedColumns = new boolean[N];
            int diagonalSum = 0;
            int corruptedRows = 0;
            int corruptedCols = 0;

            for (int i = 0; i < N; i++) {
                rowSets[i] = new HashSet<>();
                if (i == 0) {
                    for (int j = 0; j < N; j++) {
                        colSets[j] = new HashSet<>();
                    }
                }

                boolean rowCorrupted = false;
                for (int j = 0; j < N; j++) {
                    int value = scanner.nextInt(); // Read entry

                    if (i == j) {
                        diagonalSum += value; // Count diagonal
                    }

                    if (!rowCorrupted && !rowSets[i].add(value)) {
                        rowCorrupted = true;
                        corruptedRows++;
                    }

                    if (!corruptedColumns[j] && !colSets[j].add(value)) {
                        corruptedColumns[j] = true;
                        corruptedCols++;
                    }
                }
            }

            outputs.add("Case #" + (k + 1) + ": " + diagonalSum + " " + corruptedRows + " " + corruptedCols);
        }

        for (String output : outputs) {
            System.out.println(output);
        }
    }
}