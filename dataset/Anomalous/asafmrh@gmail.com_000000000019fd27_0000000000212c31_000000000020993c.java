import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, n);
            int[] rowSums = new int[n];
            int[] colSums = new int[n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSums[i] += matrix[i][j];
                    colSums[j] += matrix[i][j];
                }
            }

            int expectedSum = calculateSum(n);
            int duplicateRows = countDuplicates(rowSums, expectedSum);
            int duplicateCols = countDuplicates(colSums, expectedSum);

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }

    private static int[][] readMatrix(Scanner scanner, int n) {
        int[][] matrix = new int[n][n];
        scanner.nextLine(); // Consume the newline
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }

    private static int calculateSum(int n) {
        return n * (n + 1) / 2;
    }

    private static int countDuplicates(int[] arr, int expectedSum) {
        int count = 0;
        for (int sum : arr) {
            if (sum != expectedSum) {
                count++;
            }
        }
        return count;
    }
}