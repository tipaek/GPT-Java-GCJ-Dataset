import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            Set<Integer>[] rowSets = new HashSet[n];
            Set<Integer>[] columnSets = new HashSet[n];
            for (int i = 0; i < n; i++) {
                rowSets[i] = new HashSet<>();
                columnSets[i] = new HashSet<>();
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rowSets[i].add(matrix[i][j]);
                    columnSets[j].add(matrix[i][j]);
                }
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            int duplicateColumns = 0;
            for (int i = 0; i < n; i++) {
                if (rowSets[i].size() != n) {
                    duplicateRows++;
                }
                if (columnSets[i].size() != n) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}