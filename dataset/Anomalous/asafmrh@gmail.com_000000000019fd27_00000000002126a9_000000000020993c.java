import java.util.*;
import java.io.*;

public class Solution {

    public static int calculateSum(int n) {
        return n * (n + 1) / 2;  // Sum of first n natural numbers
    }

    public static int countNonMatching(int[] array, int targetSum) {
        int count = 0;
        for (int value : array) {
            if (value != targetSum) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, n);
            int[] rowSums = new int[n];
            int[] colSums = new int[n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rowSums[i] += matrix[i][j];
                    colSums[j] += matrix[i][j];
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int expectedSum = calculateSum(n);
            int rowDuplicates = countNonMatching(rowSums, expectedSum);
            int colDuplicates = countNonMatching(colSums, expectedSum);

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    public static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        scanner.nextLine();  // Consume the newline

        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }
}