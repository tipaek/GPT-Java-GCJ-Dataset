import java.util.*;

public class Solution {
    public void vestigium() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        List<String> outputs = new ArrayList<>();

        for (int k = 0; k < T; k++) {
            int N = scanner.nextInt(); // Size of matrix
            List<Set<Integer>> columnSets = new ArrayList<>();
            boolean[] corruptedColumns = new boolean[N];
            int diagonalSum = 0;
            int rowCorruptions = 0;
            int columnCorruptions = 0;

            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowCorrupted = false;

                for (int j = 0; j < N; j++) {
                    if (i == 0) {
                        columnSets.add(new HashSet<>());
                    }

                    int value = scanner.nextInt(); // Read entry

                    if (i == j) {
                        diagonalSum += value; // Count diagonal
                    }

                    if (!rowCorrupted && !rowSet.add(value)) {
                        rowCorrupted = true;
                        rowCorruptions++;
                    }

                    if (!corruptedColumns[j] && !columnSets.get(j).add(value)) {
                        corruptedColumns[j] = true;
                        columnCorruptions++;
                    }
                }
            }

            outputs.add("Case #" + (k + 1) + ": " + diagonalSum + " " + rowCorruptions + " " + columnCorruptions);
        }

        for (String output : outputs) {
            System.out.println(output);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().vestigium();
    }
}