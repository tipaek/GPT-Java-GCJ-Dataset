import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            scanner.nextLine();
            System.out.println(n);

            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int traceIndex = 0, rowIndex = 0, colIndex = 0;

            for (int i = 0; i < n * n; ++i) {
                int value = scanner.nextInt();
                if (i == traceIndex) {
                    trace += value;
                    traceIndex += (n + 1);
                }
                matrix[rowIndex][colIndex] = value;
                System.out.println("row:" + rowIndex + " column:" + colIndex);

                colIndex++;
                if ((i + 1) % n == 0) {
                    rowIndex++;
                    colIndex = 0;
                    if (scanner.hasNextLine()) {
                        scanner.nextLine();
                    }
                }
            }

            boolean[][] duplicates = new boolean[2][n];
            for (int i = 0; i < n; ++i) {
                duplicates[0][i] = false;
                duplicates[1][i] = false;
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    int currentValue = matrix[i][j];
                    for (int k = 0; k < n; ++k) {
                        if (currentValue == matrix[i][k] && j != k && !duplicates[0][i]) {
                            rowDuplicates++;
                            duplicates[0][i] = true;
                        }
                        if (currentValue == matrix[k][j] && k != i && !duplicates[1][j]) {
                            colDuplicates++;
                            duplicates[1][j] = true;
                        }
                        if (duplicates[0][i] && duplicates[1][j]) {
                            break;
                        }
                    }
                    if (rowDuplicates == n && colDuplicates == n) {
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}