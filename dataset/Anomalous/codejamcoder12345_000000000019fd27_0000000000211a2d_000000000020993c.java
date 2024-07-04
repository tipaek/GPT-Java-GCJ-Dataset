import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            HashSet<Integer>[] rowSets = new HashSet[n];
            HashSet<Integer>[] colSets = new HashSet[n];
            boolean[] rowDuplicates = new boolean[n];
            boolean[] colDuplicates = new boolean[n];

            for (int i = 0; i < n; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();

                    if (row == col) {
                        trace += value;
                    }

                    if (!rowSets[row].add(value) && !rowDuplicates[row]) {
                        rowDuplicates[row] = true;
                        duplicateRows++;
                    }

                    if (!colSets[col].add(value) && !colDuplicates[col]) {
                        colDuplicates[col] = true;
                        duplicateCols++;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows, duplicateCols);
        }

        scanner.close();
    }
}