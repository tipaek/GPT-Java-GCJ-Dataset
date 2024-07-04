import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            int[][] matrix = new int[n][n];
            boolean[] colHasDuplicates = new boolean[n];

            for (int row = 0; row < n; row++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowDuplicateFound = false;

                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    if (row == col) {
                        trace += value;
                    }

                    if (rowCheck[value]) {
                        rowDuplicateFound = true;
                    }
                    rowCheck[value] = true;

                    if (colHasDuplicates[col]) {
                        continue;
                    }

                    for (int prevRow = 0; prevRow < row; prevRow++) {
                        if (matrix[prevRow][col] == value) {
                            colHasDuplicates[col] = true;
                            break;
                        }
                    }
                }

                if (rowDuplicateFound) {
                    rowDuplicates++;
                }
            }

            for (boolean hasDuplicate : colHasDuplicates) {
                if (hasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}