import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Reading the matrix and calculating the trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scan.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Check for duplicate elements in each row
            for (int row = 0; row < n; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for duplicate elements in each column
            for (int col = 0; col < n; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}