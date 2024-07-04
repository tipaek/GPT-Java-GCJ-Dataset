import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowRepeats = countRepeats(matrix, n);
            int[][] transposedMatrix = transposeMatrix(matrix, n);
            int colRepeats = countRepeats(transposedMatrix, n);

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static int countRepeats(int[][] matrix, int n) {
        int repeats = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n) {
                repeats++;
            }
        }
        return repeats;
    }

    private static int[][] transposeMatrix(int[][] matrix, int n) {
        int[][] transposed = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }
}