
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseId = 1; caseId <= t; caseId++) {
            int matrixSize = scanner.nextInt();

            int trace = 0;
            int duplicatedRows = 0;
            int duplicatedCols = 0;

            // column index, value
            boolean[][] colIndexValueOccurred = new boolean[matrixSize][matrixSize];
            boolean[] colIndexHasDuplicates = new boolean[matrixSize];

            // j - column index
            // i - row index
            for (int i = 0; i < matrixSize; i++) {

                boolean[] row = new boolean[matrixSize];
                boolean rowDupFound = false;

                // process row
                for (int j = 0; j < matrixSize; j++) {
                    int val = scanner.nextInt();

                    if (!rowDupFound && row[val - 1]) {
                        rowDupFound = true;
                    }
                    row[val - 1] = true;

                    if (!colIndexHasDuplicates[j] && colIndexValueOccurred[j][val - 1]) {
//                        System.out.println("dup! " + j + "," + i + " -> " + (val - 1));
                        colIndexHasDuplicates[j] = true;
                    }
                    colIndexValueOccurred[j][val - 1] = true;

                    if (i == j) {
                        trace += val;
                    }
                }

                // row processed
                if (rowDupFound) {
                    duplicatedRows++;
                }
            }

            // count columns with duplicates
            for (int x = 0; x < matrixSize; x++) {
                if (colIndexHasDuplicates[x]) {
                    duplicatedCols++;
                }
            }
            System.out.println("Case #" + caseId + ": " + trace + " " + duplicatedRows + " " + duplicatedCols);
        }

    }
}